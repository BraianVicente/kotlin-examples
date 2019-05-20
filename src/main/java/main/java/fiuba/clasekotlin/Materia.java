package main.java.fiuba.clasekotlin;

import main.kotlin.fiuba.clasekotlin.Horario ;

public class Materia {
    private static String nombre;
    private static String codigo;
    private static String profesorEncargado;
    private static Horario horario;

    public Materia(String nombre, String codigo, String profesorEncargado, Horario horario){
        this.nombre = nombre ;
        this.codigo = codigo ;
        this.profesorEncargado = profesorEncargado ;
        this.horario = horario ;
    }


    public boolean equals(Materia otraMateria){
        return (nombre.equals(otraMateria.getNombre()) &&
                    codigo.equals(otraMateria.getCodigo()) &&
                        profesorEncargado.equals(otraMateria.getProferosEncargado()) ) ;

    }

    private String getProferosEncargado() {
        return profesorEncargado;
    }

    private String getCodigo() {
        return codigo ;
    }

    private String getNombre() {
        return nombre;
    }
}
