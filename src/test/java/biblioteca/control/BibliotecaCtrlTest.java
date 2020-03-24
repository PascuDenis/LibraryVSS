package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repo.CartiRepo;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {
    //F01
    @Test
    public void adaugaCarte_BVA_test1() {
        String lowerBoundry = "1500";
        String upperBoundry = "2020";
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();
        BibliotecaCtrl bc = new BibliotecaCtrl(cr);
        Carte c = new Carte();
        c.setTitlu("Intampinarea");
        c.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c.setAnAparitie("1948");
        c.setCuvinteCheie(Arrays.asList("Litera;", "mateiu"));

        try {
            bc.adaugaCarte(c);
            listaCarti = bc.getCarti();
            for (Carte carte : listaCarti){
                System.out.println(carte);
            }
        } catch (Exception e) {
            e.printStackTrace();
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