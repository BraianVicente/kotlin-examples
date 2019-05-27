package test.java.fiuba.clasekotlin;

import fiuba.tdl.kotlin.example.basics.Horario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions ;

public class HorarioTest {

	private Horario primerTurnoManana = new Horario(8 ,10) ;
    private Horario segundTurnoManana = new Horario(10,12) ;
    private Horario tercerTurnoManana = new Horario(12,14) ;

    private Horario primerTurnoTarde = new Horario(13,15) ;
    private Horario segundTurnoTarde = new Horario(15,17) ;
    private Horario tercerTurnoTarde = new Horario(17,19) ;

    private Horario primerTurnoNoche = new Horario(18,20) ;
    private Horario segundTurnoNoche = new Horario(20,22) ;
    private Horario tercerTurnoNoche = new Horario(21,23) ;



	@Test
    public void testPrimerTurnoMananaCompatibleConSegundoTurnoManana() {

        Assertions.assertTrue(primerTurnoManana.horariosCompatibles(segundTurnoManana));
    }

    @Test
    public void testTercerTurnoMananaIncompatiblePrimerTurnoTarde() {

        Assertions.assertFalse(tercerTurnoManana.horariosCompatibles(primerTurnoTarde));
    }

    @Test
    public void testSegundTurnoTardeCompatibleSegundTurnoManana() {

        Assertions.assertTrue(segundTurnoTarde.horariosCompatibles(segundTurnoManana));
    }


    @Test
    public void testSegundTurnoTardeCompatiblePrimerTurnoTarde() {

        Assertions.assertTrue(segundTurnoTarde.horariosCompatibles(primerTurnoTarde));
    }

    @Test
    public void testPrimerTurnoNocheCompatibleTercerTurnoTarde() {

        Assertions.assertFalse(primerTurnoNoche.horariosCompatibles(tercerTurnoTarde));
    }

    @Test
    public void testSegundTurnoNocheCompatibleTercerTurnoNoche() {

        Assertions.assertFalse(segundTurnoNoche.horariosCompatibles(tercerTurnoNoche));
    }

    @Test
    public void testTercerTurnoNocheCompatibleSegundTurnoNoche() {

        Assertions.assertFalse(tercerTurnoNoche.horariosCompatibles(segundTurnoNoche));
    }


}
