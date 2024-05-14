package com.mycompany.proyectotrans;

import Entidades.Alumno;
import Entidades.AlumnoData;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ProyectoTrans {

    public static void main(String[] args) {
        AlumnoData alumnoData = new AlumnoData();

        //INSERTAR ALUMNO
//        Alumno alumno = new Alumno(41336432, "Fernandez", "Fernando", LocalDate.of(2000, Month.MARCH, 21), true);
//        alumnoData.guardarAlumno(alumno);
//LISTAR TODOS LOS ALUMNOS
//        List<Alumno> alumnos;
//        alumnos = alumnoData.listarAlumnos();
//        System.out.println("Alumnos: " + alumnos);
//BUSCAR POR ID
        Alumno alumnoBuscado = alumnoData.buscarAlumno(2);
        System.out.println(alumnoBuscado);

    }
}
