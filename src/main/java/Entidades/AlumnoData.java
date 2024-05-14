package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

      st.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
    return alumnos;
  }

  public Alumno buscarAlumno(int id) {
    Alumno alumno = null;

    try {
      String sql = "SELECT * FROM alumnos WHERE estado = 1 AND id_Alumno = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int idAlumno = rs.getInt("id_Alumno");
        int dni = rs.getInt("dni");
        String apellido = rs.getString("apellido");
        String nombre = rs.getString("nombre");
        LocalDate fechaNac = rs.getDate("fecha_Nacimiento").toLocalDate();

        alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, true);
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
    return alumno;
  }

  public Alumno buscarAlumnoPorDni(int document) {
    Alumno alumno = null;

    try {
      String sql = "SELECT * FROM alumnos WHERE estado = 1 AND dni = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, document);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int idAlumno = rs.getInt("id_Alumno");
        int dni = rs.getInt("dni");
        String apellido = rs.getString("apellido");
        String nombre = rs.getString("nombre");
        LocalDate fechaNac = rs.getDate("fecha_Nacimiento").toLocalDate();

        alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, true);
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
    }
    return alumno;
  }

  public void guardarAlumno(Alumno alumno) {
    try {
      String sql = "INSERT INTO alumnos(dni,apellido,nombre,fecha_Nacimiento,estado) VALUES(?,?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, alumno.getDni());
      ps.setString(2, alumno.getApellido());
      ps.setString(3, alumno.getNombre());
      ps.setString(4, alumno.getFechaNac().toString());
      ps.setBoolean(5, alumno.isEstado());

      ps.execute();
      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }

  public void modificarAlumno(Alumno alumno) {
    try {
      String sql = "UPDATE alumnos SET dni = ? , apellido = ?, nombre = ?, fecha_Nacimiento = ?, estado = ? WHERE id_Alumno = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, alumno.getDni());
      ps.setString(2, alumno.getApellido());
      ps.setString(3, alumno.getNombre());
      ps.setString(4, alumno.getFechaNac().toString());
      ps.setBoolean(5, alumno.isEstado());
      ps.setInt(6, alumno.getIdAlumno());

      int exito = ps.executeUpdate();

      if (exito == 1) {
        System.out.println("Modificado Exitosamente.");
      } else {
        System.out.println("El alumno no existe.");
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }

  public void eliminarAlumno(int id) {
    try {
      String sql = "UPDATE alumnos SET estado = 0 WHERE id_Alumno = ? ";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);

      int fila = ps.executeUpdate();

      if (fila == 1) {
        System.out.println("Eliminado Exitosamente.");
      } else {
        System.out.println("El alumno no existe.");
      }

      ps.close();
    } catch (SQLException ex) {
      System.err.println("Error en SQL");
      System.out.println(ex);
    }
  }
}
