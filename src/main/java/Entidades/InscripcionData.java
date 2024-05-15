package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InscripcionData {

  private final Connection connection;
  private AlumnoData alumnoData;
  private MateriaData materiaData;

  public InscripcionData() {
    DBConnection instance = DBConnection.getInstance();
    this.connection = instance.getConnection();
    this.alumnoData = new AlumnoData();
    this.materiaData = new MateriaData();
  }

  public void guardarInscripcion(Inscripcion inscripcion) {
    try {
      String sql = "INSERT INTO inscripciones(nota, id_Alumno, id_Materia) VALUES(?, ?; ?);";
      PreparedStatement ps = this.connection.prepareStatement(sql);
      ps.setDouble(1, inscripcion.getNota());
      ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
      ps.setInt(3, inscripcion.getMateria().getIdMateria());
      ps.execute();

      connection.close();
    } catch (SQLException ex) {
      System.err.println("Error MySQL");
      System.err.println(ex);
    }
  }

  public List<Inscripcion> obtenerInscripciones() {
    List<Inscripcion> inscripciones = new ArrayList<>();

    try {
      String sql = "SELECT * FROM inscripciones";
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery(sql);

      while (rs.next()) {
        int idInscripcion = rs.getInt("id_Inscripto");

        int nota = rs.getInt("nota");

        int idAlumno = rs.getInt("id_Alumno");
        Alumno alumno = this.alumnoData.buscarAlumno(idAlumno);

        int idMateria = rs.getInt("id_Materia");
        Materia materia = this.materiaData.buscarMateriaPorId(idMateria);

        Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota);

        inscripciones.add(inscripcion);
      }

      st.close();
    } catch (SQLException ex) {
      System.err.println("Error MySQL");
      System.err.println(ex);
    }
    return inscripciones;
  }
}
