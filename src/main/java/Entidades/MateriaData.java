package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaData {

  private final Connection connection;

  public MateriaData() {
    DBConnection instance = DBConnection.getInstance();
    this.connection = instance.getConnection();
  }

  public void guardarMateria(Materia materia) {
    try {
      String sql = "INSERT INTO materias(nombre,año,estado) VALUES(?,?,?)";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, materia.getNombre());
      ps.setInt(2, materia.getAnioMateria());
      ps.setBoolean(3, materia.isActivo());

      ps.execute();

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }

  public Materia buscarMateriaPorId(int id) {
    Materia materia = null;
    try {
      String sql = "SELECT * FROM materias WHERE id_Materia = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int idMateria = rs.getInt("id_Materia");
        String name = rs.getString("nombre");
        int anio = rs.getInt("año");
        boolean estado = rs.getBoolean("estado");

        materia = new Materia(idMateria, name, anio, estado);
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
    return materia;

  }

  public void modificarMateria(Materia materia) {
    try {
      String sql = "UPDATE materias SET nombre = ?, año = ?, estado = ? WHERE id_Materia = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, materia.getNombre());
      ps.setInt(2, materia.getAnioMateria());
      ps.setBoolean(3, materia.isActivo());
      ps.setInt(4, materia.getIdMateria());

      int modificado = ps.executeUpdate();

      if (modificado == 1) {
        System.out.println("Se modifico exitosamente");
      } else {
        System.out.println("No se encontro la materia");
      }
      ps.close();

    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);

    }
  }

  public void eliminarMateria(int id) {
    try {
      String sql = "UPDATE materias SET estado = 0 WHERE id_Materia = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);

      int baja = ps.executeUpdate();
      if (baja == 1) {
        System.out.println("Materia dada de baja");
      } else {
        System.out.println("La materia no existe");
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }

  public void altaMateria(int id) {
    try {
      String sql = "UPDATE materias SET estado = 1 WHERE id_Materia = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);

      int baja = ps.executeUpdate();
      if (baja == 1) {
        System.out.println("Materia dada de alta");
      } else {
        System.out.println("La materia no existe");
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }

  public List<Materia> listarMateria() {
    List<Materia> materias = new ArrayList<>();
    try {
      String sql = "SELECT * FROM materias WHERE estado = 1;";
      Statement st = this.connection.createStatement();
      ResultSet rs = st.executeQuery(sql);

      while (rs.next()) {
        int idMateria = rs.getInt("id_Materia");
        String nombre = rs.getString("nombre");
        int anio = rs.getInt("año");

        Materia materia = new Materia(idMateria, nombre, anio, true);

        materias.add(materia);
      }

      st.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
    return materias;
  }

// CUIDADO CON ESTE MÉTODO!!!
// DEVUELVE UNA LISTA DE MATERIAS CURSADAS POR UN ALUMNO.
// TOMA COMO "CURSADAS" AQUELLAS INSCRIPCIONES CUYA NOTA ES MAYOR QUE CERO, YA
// QUE CUANDO SE REALIZA UNA INSCRIPCIÓN (EL ALUMNO AÚN NO LA CURSA) SE INSERTA
// CON NOTA = (CERO).
  public List<Materia> obtenerMateriasCursadas(int id) {
    List<Materia> materias = new ArrayList<>();
    try {
      String sql = "SELECT m.id_Materia, m.nombre, m.año, m.estado FROM materias m JOIN inscripciones i ON(i.id_Materia = m.id_Materia) WHERE i.id_Alumno = ? AND i.nota > 0;";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);

      ps.executeUpdate();
      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
    return materias;
  }
}
