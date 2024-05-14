package Entidades;

import java.util.Objects;

public class Materia {

  private int idMateria;
  private String nombre;
  private int anioMateria;
  private boolean activo;

  public Materia() {
  }

  public Materia(String nombre, int anioMateria, boolean activo) {
    this.nombre = nombre;
    this.anioMateria = anioMateria;
    this.activo = activo;
  }

  public Materia(int idMateria, String nombre, int anioMateria, boolean activo) {
    this.idMateria = idMateria;
    this.nombre = nombre;
    this.anioMateria = anioMateria;
    this.activo = activo;
  }

  public int getIdMateria() {
    return idMateria;
  }

  public void setIdMateria(int idMateria) {
    this.idMateria = idMateria;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getAnioMateria() {
    return anioMateria;
  }

  public void setAnioMateria(int anioMateria) {
    this.anioMateria = anioMateria;
  }

  public boolean isActivo() {
    return activo;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
  }

  @Override
  public String toString() {
    return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", anioMateria=" + anioMateria + ", activo=" + activo + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Materia other = (Materia) obj;
    return Objects.equals(this.nombre, other.nombre);
  }
}
