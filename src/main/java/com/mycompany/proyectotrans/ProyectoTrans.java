package com.mycompany.proyectotrans;

import Entidades.Alumno;
import Entidades.AlumnoData;
import java.util.List;

public class ProyectoTrans {

  public static void main(String[] args) {
    AlumnoData alumnoData = new AlumnoData();

    List<Alumno> alumnos;

    alumnos = alumnoData.listarAlumnos();

    System.out.println("Alumnos: " + alumnos);
  }
}
