package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripciones;";
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

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripciones WHERE id_Alumno = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idInscripcion = rs.getInt("id_Inscripto");
                int nota = rs.getInt("nota");
                int idMateria = rs.getInt("id_Materia");
                Materia materia = materiaData.buscarMateriaPorId(idMateria);
                Alumno alumno = alumnoData.buscarAlumno(id);

                Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota);
                inscripciones.add(inscripcion);
            }

            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }

        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materiasCursadas = new ArrayList<>();
        try {
            // String sql = "SELECT * FROM inscripciones JOIN materias ON(inscripciones.id_Materia = materias.id_Materia) WHERE id_Alumno = ?;";
            String sql = "SELECT id_Materia, nombre, año, estado FROM materias WHERE id_Materia IN(SELECT id_Materia FROM inscripciones WHERE id_Alumno = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idMateria = rs.getInt("id_Materia");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("año");
                boolean estado = rs.getBoolean("estado");

                Materia materia = new Materia(idMateria, nombre, idMateria, estado);
                materiasCursadas.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }
        return materiasCursadas;
    }

    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materiasNoCursadas = new ArrayList<>();
        try {
            String sql = "SELECT id_Materia, nombre, año, estado FROM materias WHERE id_Materia NOT IN(SELECT id_Materia FROM inscripciones WHERE id_Alumno = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idMateria = rs.getInt("id_Materia");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("año");
                boolean estado = rs.getBoolean("estado");

                Materia materia = new Materia(idMateria, nombre, idMateria, estado);
                materiasNoCursadas.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }
        return materiasNoCursadas;
    }

    public List<Alumno> obtenerAlumnosPorMateria(int id) {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT id_Alumno, dni, nombre, apellido, fecha_Nacimiento, estado FROM alumnos WHERE id_Alumno IN(SELECT id_Alumno FROM inscripciones WHERE id_Materia = ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("id_Alumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                LocalDate fechaNac = rs.getDate("fecha_Nacimiento").toLocalDate();
                boolean estado = rs.getBoolean("estado");

                Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, estado);
                alumnos.add(alumno);
            }

            ps.close();

        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }
        return alumnos;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            String sql = "UPDATE inscripciones SET nota = ? WHERE id_Alumno = ? AND id_Materia = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            boolean exito = ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.err.println("Error MySQL");
            System.err.println(ex);
        }

    }
}
