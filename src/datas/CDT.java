package datas;

public class CDT {

    public static void main(String[] args) {
        //testConstructeur1();
        testConstructeur2();
        //testGetNbrePlages();
        //testGetDureeTotale();
        //testGetUnePlage();
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

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Initialisation avec des paramètres vide");
        System.out.println("Création d'un CD('Didine mix', '')");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        CD cd2 = new CD("Didine mix", "");

    }

    private static void testConstructeur2() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur2()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Le fichier.txt contient une première ligne TitreCD + AuteurCD et une ou plusieurs ligne TitrePlage Auteur 0 Min Sec ");
        System.out.println("Initialisation de l'objet : new Cd(ws/LeFich.txt)");

        CD cd1 = new CD("ws/LeFich.txt");

        System.out.println("Verification du titreCD");

        if (cd1.getLeTitreCD().equals("La fête est finie")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Verification de l'interpreteCD");

        if (cd1.getlInterpreteCD().equals("Orelsan")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

    }

    private static void testGetNbrePlages() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getNbrePlages()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', 'Sandou'");

        CD cd1 = new CD("Didine mix", "Sandou");

        System.out.println("Appel de la méthode getNbreDePlages()");
        System.out.println("Le cd doit comporter 5 plages avec le constructeur n°1");
        if (cd1.getNbrePlages() == 5) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        //todo test avec constructeur 2

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Appel de la méthode sur un CD avec paramètre vide, crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', '')");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        CD cd2 = new CD("Didine mix", "");

        System.out.println("Appel de la méthode getNbrePlages() sur CD");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        cd2.getNbrePlages();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        //todo test avec constructeur 2

    }

    private static void testGetDureeTotale() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getDureeTotale()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', 'Sandou'");

        CD cd1 = new CD("Didine mix", "Sandou");

        System.out.println("Appel de la méthode getDureeTotale()");
        long dureeTotale = new Duree(0, 2, 30).getLeTemps();
        dureeTotale += new Duree(0, 3, 45).getLeTemps();
        dureeTotale += new Duree(0, 1, 34).getLeTemps();
        dureeTotale += new Duree(0, 4, 12).getLeTemps();
        dureeTotale += new Duree(0, 5, 54).getLeTemps();
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        if (cd1.getDureeTotale().getLeTemps() == dureeTotale) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Appel de la méthode sur un CD avec paramètre vide, crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', '')");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        CD cd2 = new CD("Didine mix", "");

        System.out.println("Appel de la méthode getDureeTotale() sur CD");
        System.out.println("Ce test doit retourner 'Temps incorrect & CD incorrect' -->");

        cd2.getDureeTotale();


    }

    private static void testGetUnePlage() {
        //todo
    }


}
