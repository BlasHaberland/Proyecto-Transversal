package Entidades;

public class Inscripcion {

  private int idInscripcion;
  private Alumno alumno;
  private Materia masteria;
  private double nota;

  public Inscripcion() {
  }

  public Inscripcion(Alumno alumno, Materia masteria, double nota) {
    this.alumno = alumno;
    this.masteria = masteria;
    this.nota = nota;
  }

  public Inscripcion(int idInscripcion, Alumno alumno, Materia masteria, double nota) {
    this.idInscripcion = idInscripcion;
    this.alumno = alumno;
    this.masteria = masteria;
    this.nota = nota;
  }

  public int getIdInscripcion() {
    return idInscripcion;
  }

  public void setIdInscripcion(int idInscripcion) {
    this.idInscripcion = idInscripcion;
  }

  public Alumno getAlumno() {
    return alumno;
  }

  public void setAlumno(Alumno alumno) {
    this.alumno = alumno;
  }

  public Materia getMasteria() {
    return masteria;
  }

  public void setMasteria(Materia masteria) {
    this.masteria = masteria;
  }

  public double getNota() {
    return nota;
  }

  public void setNota(double nota) {
    this.nota = nota;
  }

  @Override
  public String toString() {
    return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", masteria=" + masteria + ", nota=" + nota + '}';
  }
}
