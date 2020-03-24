package biblioteca.repository.repo;

import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CartiRepoTest {
    public void setUp() {
        List<Carte> carti = new ArrayList<Carte>();
        carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
        carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
        carti.add(Carte.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
        carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
        carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));
    }

    //F01
    @Test
    public void adaugaCarte() {
        int lowerBoundry = 1500;
        int upperBoundry = 2020;
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();
        Carte c = new Carte();
        c.setTitlu("Intampinarea");
        c.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c.setAnAparitie("1948");
        c.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        if (Integer.parseInt(c.getAnAparitie()) < lowerBoundry && Integer.parseInt(c.getAnAparitie()) > upperBoundry) {
            throw new AssertionError();
        }

        cr.adaugaCarte(c);
        listaCarti = cr.getCarti();

        for (Carte carte : listaCarti) {
            System.out.println(carte);
        }
    }

    //F02
    @Test
    public void cautaCarte() {
    }

    //F03
    @Test
    public void getCartiOrdonateDinAnul() {
    }
}