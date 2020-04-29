package biblioteca.repository.repo;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.util.Validator;
import biblioteca.view.Consola;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BigBangTest {

    private CartiRepoTest cartiRepoTest= new CartiRepoTest();

    @Test
    public void testF01(){
        cartiRepoTest.adaugaCarte_BVA_test01Valid();
    }
    @Test
    public void testF02(){
        cartiRepoTest.cautaCarte();
    }
    @Test
    public void testF03(){
        cartiRepoTest.getCartiOrdonateDinAnul();
    }

    @Test
    public void printTest() throws Exception {

        CartiRepo cartiRepo = new CartiRepo();
        BibliotecaCtrl bibliotecaCtrl = new BibliotecaCtrl(cartiRepo);
        Consola consola = new Consola(bibliotecaCtrl);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        consola.printMenu(); // I will assume items is already initialized properly.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String expectedOutput  = "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Evidenta cartilor dintr-o biblioteca\n" +
                "     1. Adaugarea unei noi carti\n" +
                "     2. Cautarea cartilor scrise de un anumit autor\n" +
                "     3. Afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori\n" +
                "     4. Afisarea toturor cartilor\n" +
                "     0. Exit\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void bigBangTest(){
        testF01();
        testF02();
        testF03();
        try {
            printTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}