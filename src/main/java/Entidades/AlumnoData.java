package Entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlumnoData {

  private final Connection connection;

  public AlumnoData() {
    DBConnection instance = DBConnection.getInstance();
    this.connection = instance.getConnection();
  }

  public List<Alumno> listarAlumnos() {
    List<Alumno> alumnos = new ArrayList<>();
    try {
      String sql = "SELECT * FROM alumnos WHERE estado = 1;";
      Statement st = this.connection.createStatement();
      ResultSet rs = st.executeQuery(sql);

      while (rs.next()) {
        int idAlumno = rs.getInt("id_Alumno");
        int dni = rs.getInt("dni");
        String apellido = rs.getString("apellido");
        String nombre = rs.getString("nombre");
        LocalDate fechaNac = rs.getDate("fecha_Nacimiento").toLocalDate();

        Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, true);

        alumnos.add(alumno);
      }

    } catch (SQLException ex) {
      System.err.println("Error en SQL");
    }
    return alumnos;
  }
}
