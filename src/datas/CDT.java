package datas;

public class CDT {

    public static void main(String[] args) {
        testConstructeur1();
        testConstructeur2();
        testGetNbrePlages();
        testGetDureeTotale();
        testGetUnePlage();
    }

    private static void testConstructeur1() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur1()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Initialisation avec des paramètres non vide");
        System.out.println("Création d'un CD('Didine mix', 'Sandou')");

        CD cd1 = new CD("Didine mix", "Sandou");

        System.out.println("Verification du titreCD");

        if (cd1.getLeTitreCD().equals("Didine mix")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Verification de l'interpreteCD");

        if (cd1.getlInterpreteCD().equals("Sandou")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Verification des plages CD");



    }

    private static void testConstructeur2() {
        //todo
    }

    private static void testGetNbrePlages() {
        //todo
    }

    private static void testGetDureeTotale() {
        //todo
    }

    private static void testGetUnePlage() {
        //todo
    }


}
