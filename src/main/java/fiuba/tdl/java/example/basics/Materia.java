package fiuba.tdl.java.example.basics ;

import fiuba.tdl.kotlin.example.basics.Horario ;

public class Materia {
    public static String nombre;
    public static String codigo;
    public static String profesorEncargado;
    public static Horario horario;

    public Materia(String nombre, String codigo, String profesorEncargado, Horario horario){
        this.nombre = nombre ;
        this.codigo = codigo ;
        this.profesorEncargado = profesorEncargado ;
        this.horario = horario ;
    }


    public boolean equals(Materia otraMateria){
        return ( (otraMateria.getNombre().equals(nombre)) &&
                    otraMateria.getCodigo().equals(codigo) &&
                        otraMateria.getProferosEncargado().equals(profesorEncargado) &&
                        (otraMateria.getHorario().equals(horario))) ;

    }

    private Horario getHorario() { return horario; }

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
