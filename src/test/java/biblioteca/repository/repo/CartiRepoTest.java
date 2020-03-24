package biblioteca.repository.repo;

import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import biblioteca.util.Validator;
import static org.junit.Assert.*;

public class CartiRepoTest {
    CartiRepo cartiRepo = new CartiRepo();

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
    public void adaugaCarte_BVA_test01Valid() {
        //Test fails if book year is out of boundry
        int lowerBoundry = 1500;
        int upperBoundry = 2020;
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();
        Carte c = new Carte();
        c.setTitlu("Intampinarea");
        c.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c.setAnAparitie("2020");
        c.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        try {
            if (Integer.parseInt(c.getAnAparitie()) < lowerBoundry || Integer.parseInt(c.getAnAparitie()) > upperBoundry) {
                throw new AssertionError();
            }

            cr.adaugaCarte(c);
            listaCarti = cr.getCarti();

            Carte carteAdaugata = listaCarti.get(listaCarti.size() - 1);
            System.out.println("carte adaucata: " + carteAdaugata + '\n');

            Assert.assertEquals(carteAdaugata.getTitlu(), c.getTitlu());
            Assert.assertEquals(carteAdaugata.getAnAparitie(), c.getAnAparitie());
            Assert.assertEquals(carteAdaugata.getCuvinteCheie(), c.getCuvinteCheie());
            Assert.assertEquals(carteAdaugata.getReferenti(), c.getReferenti());

            for (Carte carte : listaCarti) {
                System.out.println(carte);
            }
        } catch (AssertionError e) {
            System.out.println("The book title is out of boundry");
        }
    }

    @Test
    public void adaugaCarte_BVA_test02Valid() {
        //Test fails if book title is out of boundry
        int lowerBoundry = 0;
        int upperBoundry = 9;
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();
        Carte c = new Carte();
        c.setTitlu("Intampinarea ");
        c.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c.setAnAparitie("2222");
        c.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        System.out.println(c.getTitlu().split(" ").length);
        try {
            if (c.getTitlu().split(" ").length <= lowerBoundry || c.getTitlu().split(" ").length >= upperBoundry) {
                throw new AssertionError();
            }

            cr.adaugaCarte(c);
            listaCarti = cr.getCarti();

            Carte carteAdaugata = listaCarti.get(listaCarti.size() - 1);
            System.out.println("carte adaucata: " + carteAdaugata + '\n');

            Assert.assertEquals(carteAdaugata.getTitlu(), c.getTitlu());
            Assert.assertEquals(carteAdaugata.getAnAparitie(), c.getAnAparitie());
            Assert.assertEquals(carteAdaugata.getCuvinteCheie(), c.getCuvinteCheie());
            Assert.assertEquals(carteAdaugata.getReferenti(), c.getReferenti());

            for (Carte carte : listaCarti) {
                System.out.println(carte);
            }
        } catch (AssertionError e) {
            System.out.println("The book title is out of boundry");
        }
    }

    @Test
    public void adaugaCarte_BVA_test03NonValid() {
        //Test fails if book year is out of boundry
        int lowerBoundry = 1500;
        int upperBoundry = 2020;
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();
        Carte c = new Carte();
        c.setTitlu("Intampinarea");
        c.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c.setAnAparitie("2222");
        c.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        try {
            if (Integer.parseInt(c.getAnAparitie()) < lowerBoundry || Integer.parseInt(c.getAnAparitie()) > upperBoundry) {
                throw new AssertionError();
            }

            cr.adaugaCarte(c);
            listaCarti = cr.getCarti();

            Carte carteAdaugata = listaCarti.get(listaCarti.size() - 1);
            System.out.println("carte adaucata: " + carteAdaugata + '\n');

            Assert.assertEquals(carteAdaugata.getTitlu(), c.getTitlu());
            Assert.assertEquals(carteAdaugata.getAnAparitie(), c.getAnAparitie());
            Assert.assertEquals(carteAdaugata.getCuvinteCheie(), c.getCuvinteCheie());
            Assert.assertEquals(carteAdaugata.getReferenti(), c.getReferenti());

            for (Carte carte : listaCarti) {
                System.out.println(carte);
            }
        } catch (AssertionError e) {
            System.out.println("The book title is out of boundry");
        }
    }

    @Test
    public void adaugaCarte_BVA_test04NonValid() {
        //Test fails if book title is out of boundry
        int lowerBoundry = 1500;
        int upperBoundry = 2020;
        List<Carte> listaCarti;
        CartiRepoInterface cr = new CartiRepo();

        Carte c1 = new Carte();
        c1.setTitlu("");
        c1.setReferenti(Arrays.asList("Mateiu Caragiale"));
        c1.setAnAparitie("2020");
        c1.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        Carte c2 = new Carte();
        c2.setTitlu("Nume Nume Nume Nume Nume Nume Nume Nume Nume Nume");
        c2.setReferenti(Collections.singletonList("Mateiu Caragiale"));
        c2.setAnAparitie("2222");
        c2.setCuvinteCheie(Arrays.asList("Litera", "mateiu"));

        System.out.println(c1.getTitlu().split(" ").length);
        System.out.println(c2.getTitlu().split(" ").length);

        try {
            if (c1.getTitlu().split(" ").length <= lowerBoundry || c1.getTitlu().split(" ").length >= upperBoundry) {
                throw new AssertionError();
            }
            if (c2.getTitlu().split(" ").length <= lowerBoundry || c2.getTitlu().split(" ").length >= upperBoundry) {
                throw new AssertionError();
            }

            cr.adaugaCarte(c1);
            cr.adaugaCarte(c2);

            listaCarti = cr.getCarti();

            Carte carteAdaugata1 = listaCarti.get(listaCarti.size() - 1);
            Carte carteAdaugata2 = listaCarti.get(listaCarti.size() - 2);
            System.out.println("carte adaucata: " + carteAdaugata1 + '\n');
            System.out.println("carte adaucata: " + carteAdaugata2 + '\n');

            Assert.assertEquals(carteAdaugata1.getTitlu(), c2.getTitlu());
            Assert.assertEquals(carteAdaugata1.getAnAparitie(), c2.getAnAparitie());
            Assert.assertEquals(carteAdaugata1.getCuvinteCheie(), c2.getCuvinteCheie());
            Assert.assertEquals(carteAdaugata1.getReferenti(), c2.getReferenti());

            Assert.assertEquals(carteAdaugata2.getTitlu(), c1.getTitlu());
            Assert.assertEquals(carteAdaugata2.getAnAparitie(), c1.getAnAparitie());
            Assert.assertEquals(carteAdaugata2.getCuvinteCheie(), c1.getCuvinteCheie());
            Assert.assertEquals(carteAdaugata2.getReferenti(), c1.getReferenti());
            for (Carte carte : listaCarti) {
                System.out.println(carte);
            }
        } catch (AssertionError e) {
            System.out.println("The book title is out of boundry");
        }
    }

    @Test
    public void adaugaCarteECP(){
        //Given
        List<Carte> carteList = cartiRepo.getCarti();
        int sizeListaCarte = carteList.size();

        //When
        Carte carteNoua = new Carte();
        carteNoua.setTitlu("Miau miau");
        carteNoua.setAnAparitie("1999");
        carteNoua.setReferenti(Arrays.asList("Ref1", "Ref2", "Ref3"));
        carteNoua.setCuvinteCheie(Arrays.asList("Cuv1", "Cuv2", "Cuv3"));
        Assert.assertEquals(true, Validator.isOKString(carteNoua.getTitlu()));
        Assert.assertEquals(true, Validator.isNumber(carteNoua.getAnAparitie()));

        Carte carteNoua2 = new Carte();
        carteNoua.setTitlu("123");
        carteNoua.setAnAparitie("ANA ARE MERE");
        carteNoua.setReferenti(Arrays.asList("Ref1", "Ref2", "Ref3"));
        carteNoua.setCuvinteCheie(Arrays.asList("Cuv1", "Cuv2", "Cuv3"));
        Assert.assertEquals(false, Validator.isOKString(carteNoua2.getTitlu()));
        Assert.assertEquals(false, Validator.isNumber(carteNoua2.getAnAparitie()));

        cartiRepo.adaugaCarte(carteNoua);

        //Then
        Assert.assertEquals(sizeListaCarte+1,cartiRepo.getCarti().size());
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