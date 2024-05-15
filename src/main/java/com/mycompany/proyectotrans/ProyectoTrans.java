package com.mycompany.proyectotrans;

import Entidades.Inscripcion;
import Entidades.InscripcionData;
import java.util.ArrayList;
import java.util.List;

public class ProyectoTrans {

  public static void main(String[] args) {
// LISTAR TODAS LAS INSCRIPCIONES
    List<Inscripcion> inscripciones = new ArrayList<>();
    InscripcionData inscripcionData = new InscripcionData();
    inscripciones = inscripcionData.obtenerInscripciones();
    System.out.println(inscripciones);
//
// DAR DE BAJA UNA MATERIA
//      materiaData.eliminarMateria(3);
// MODIFICAR MATERIA
//      Materia materiaBuscadaPorId = materiaData.buscarMateriaPorId(3);
//      materiaBuscadaPorId.setAnioMateria(2);
//      materiaData.modificarMateria(materiaBuscadaPorId);
// BUSCAR MATERIA
//      Materia materiaBuscadaPorId = materiaData.buscarMateriaPorId(3);
//      System.out.println(materiaBuscadaPorId);
// AGREGAR MATERIA
//      materiaData.guardarMateria(laboratorio);
// INSERTAR ALUMNO
//      Alumno alumnoNuevo = new Alumno(41336432, "Fernandez", "Fernando", LocalDate.of(2000, Month.MARCH, 21), true);
//      alumnoData.guardarAlumno(alumnoNuevo);
//
// MODIFICAR ALUMNO
//      Alumno alumnoBuscado = alumnoData.buscarAlumno(2);
//      alumnoBuscado.setEstado(false);
//      alumnoData.modificarAlumno(alumnoBuscado);
//
// LISTAR TODOS LOS ALUMNOS
//      List<Alumno> alumnos;
//      alumnos = alumnoData.listarAlumnos();
//      System.out.println("Alumnos: " + alumnos);
//
// BUSCAR POR ID
//      Alumno alumnoBuscadoPorId = alumnoData.buscarAlumno(2);
//      System.out.println(alumnoBuscadoPorId);
//
// BUSCAR POR DNI
//      Alumno alumnoBuscadoPorDni = alumnoData.buscarAlumnoPorDni(41336432);
//      System.out.println(alumnoBuscadoPorDni);
//
// ELIMINAR ALUMNO
//      alumnoData.eliminarAlumno(5);
  }
}
