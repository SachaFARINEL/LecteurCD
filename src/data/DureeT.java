package data;

public class DureeT {

    public static void main(String[] args) {
        testConstruct1();
        testConstruct2();
        testConstruct3();
        testAjoute();
        testCompareA();
        testEnTexte();
        testGetLeTemps();
        System.out.println("test");
    }

    private static void testConstruct1() {
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur() 1");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Millisecondes > 0 : ");
        System.out.println("Initialisation d'une Durée à 2000millisecondes");

        Duree duree1 = new Duree(2000);

        if (duree1.getLeTemps() == 2000) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Millisecondes < 0");
        System.out.println("Initialisation d'une Durée à -2000millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree2 = new Duree(-2000);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite :  Millisecondes = 0");
        System.out.println("Initialisation d'une Durée à 0millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree3 = new Duree(0);

    }

    private static void testConstruct2() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur() 2");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Temps > 0 et heures, minutes, secondes non nulles : ");
        System.out.println("Initialisation d'une Durée à 10heures 5minutes et 2secondes");
        Duree duree = new Duree(10, 5, 2);
        int conversion = 10 * 3600000 + 5 * 60000 + 2 * 1000;
        if (duree.getLeTemps() == conversion) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : Temps > 0 et plusieurs données nulles : ");
        System.out.println("Initialisation d'une Durée à 10heures");
        Duree duree1 = new Duree(10, 0, 0);
        int conversion1 = 10 * 3600000;
        if (duree1.getLeTemps() == conversion1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Temps < 0");
        System.out.println("Initialisation d'une Durée à 10heures, 5minutes et -2secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree2 = new Duree(10, 5, -2);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Minutes ou secondes > 60");
        System.out.println("Initialisation d'une Durée à 10heures, 62minutes et 2secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree3 = new Duree(10, 62, 2);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite :  Temps = 0");
        System.out.println("Initialisation d'une Durée à 0heures, 0minutes et 0secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree4 = new Duree(0, 0, 0);
    }

    private static void testConstruct3() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur() 3");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Durée en millisecondes > 0 : ");
        System.out.println("Initialisation d'une Durée à 2000millisecondes");

        Duree duree = new Duree(2000);

        System.out.println("Initialisation d'une Durée avec la durée précédente");

        Duree duree1 = new Duree(duree);

        System.out.println("Vérification des temps des deux Durées");

        if (duree.getLeTemps() == duree1.getLeTemps()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : Temps > 0 et heures, minutes, secondes non nulles : ");
        System.out.println("Initialisation d'une Durée à 10heures 5minutes et 2secondes");

        Duree duree2 = new Duree(10, 5, 2);

        System.out.println("Initialisation d'une Durée avec la durée précédente");

        Duree duree3 = new Duree(duree2);

        System.out.println("Vérification des temps des deux Durées");

        if (duree2.getLeTemps() == duree3.getLeTemps()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 3 : Temps > 0 et plusieurs données nulles : ");
        System.out.println("Initialisation d'une Durée à 10heures");

        Duree duree4 = new Duree(10, 0, 0);

        System.out.println("Initialisation d'une Durée avec la durée précédente");

        Duree duree5 = new Duree(duree4);

        System.out.println("Vérification des temps des deux Durées");

        if (duree4.getLeTemps() == duree5.getLeTemps()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Millisecondes < 0");
        System.out.println("Initialisation d'une Durée à -2000millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree6 = new Duree(-2000);

        System.out.println("Initialisation d'une Durée avec la durée précédente");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree7 = new Duree(duree6);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Temps < 0");
        System.out.println("Initialisation d'une Durée à 10heures, 5minutes et -2secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree8 = new Duree(10, 5, -2);

        System.out.println("Initialisation d'une Durée avec la durée précédente");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree9 = new Duree(duree8);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite 1 :  Millisecondes = 0");
        System.out.println("Initialisation d'une Durée à 0millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree10 = new Duree(0);

        System.out.println("Initialisation d'une Durée avec la durée précédente");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree11 = new Duree(duree10);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite :  Temps = 0");
        System.out.println("Initialisation d'une Durée à 0heures, 0minutes et 0secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        Duree duree12 = new Duree(0, 0, 0);

        System.out.println("Initialisation d'une Durée avec la durée précédente");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree13 = new Duree(duree12);
    }

    private static void testAjoute() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test méthode ajoute() : ");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Ajout de deux durées en millisecondes > 0: ");
        System.out.println("Initialisation d'une Durée à 2000millisecondes");

        Duree duree1 = new Duree(2000);

        System.out.println("Initialisation d'une deuxième Durée à 10000millisecondes");

        Duree duree2 = new Duree(10000);

        System.out.println("Ajout de la durée 2 à la durée 1");

        duree1.ajoute(duree2);

        System.out.println("Test si la durée 1 est maintenant égale à 12 000");

        if (duree1.getLeTemps() == 12000) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : Ajout de deux durées heures, minutes et secondes > 0: ");
        System.out.println("Initialisation d'une Durée à 1heure, 5minutes et 10 secondes");

        Duree duree3 = new Duree(1, 5, 10);

        System.out.println("Initialisation d'une deuxième Durée à 2heure, 10minutes et 20 secondes");

        Duree duree4 = new Duree(2, 10, 20);

        System.out.println("Ajout de la durée 2 à la durée 1");

        duree3.ajoute(duree4);

        int conversion = (1 + 2) * 3600000 + (5 + 10) * 60000 + (10 + 20) * 1000;

        System.out.println("Test si la durée 1 est maintenant égale à " + conversion);

        if (duree3.getLeTemps() == conversion) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 3 : Ajout d'une durées heures, minutes et secondes > 0 à une durée en millisecondes > 0: ");
        System.out.println("Initialisation d'une Durée à 1heure, 5minutes et 10 secondes");

        Duree duree5 = new Duree(1, 5, 10);

        System.out.println("Initialisation d'une deuxième Durée à 2000 millisecondes");

        Duree duree6 = new Duree(2000);

        System.out.println("Ajout de la durée 2 à la durée 1");

        duree5.ajoute(duree6);

        int conversion1 = 3600000 + 5 * 60000 + 10 * 1000 + 2000;

        if (duree5.getLeTemps() == conversion1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 4 : Ajout d'une durée en millisecondes > 0 à un durées en heures, minutes et secondes > 0 : ");
        System.out.println("Initialisation d'une deuxième Durée à 2000 millisecondes");

        Duree duree7 = new Duree(1, 5, 10);

        System.out.println("Initialisation d'une Durée à 1heure, 5minutes et 10 secondes");


        Duree duree8 = new Duree(2000);

        System.out.println("Ajout de la durée 2 à la durée 1");

        duree8.ajoute(duree7);

        if (duree5.getLeTemps() == conversion1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Ajout d'une durée en Millisecondes < 0 à une durée en millisecondes > 0 : ");
        System.out.println("Initialisation d'une Durée à 2000millisecondes");


        Duree duree9 = new Duree(2000);

        System.out.println("Initialisation d'une Durée à -2000millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree10 = new Duree(-2000);

        System.out.println("Ajout de la durée 2 à la durée 1");

        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        duree9.ajoute(duree10);

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Ajout d'une durée (heures, miutes, secondes) < 0 à une durée en millisecondes > 0 : ");
        System.out.println("Initialisation d'une Durée à 1heure");


        Duree duree11 = new Duree(1, 0, 0);

        System.out.println("Initialisation d'une Durée à - 1heure");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree12 = new Duree(-1, 0, 0);

        System.out.println("Ajout de la durée 2 à la durée 1");

        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        duree11.ajoute(duree12);


    }

    private static void testCompareA() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode compareA()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : autreDuree > actuelleDuree : ");
        System.out.println("Initialisation d'une Durée à 1milliseconde");

        Duree duree1 = new Duree(1);

        System.out.println("Initialisation d'une autre Durée à 2millisecondes");

        Duree duree2 = new Duree(2);

        System.out.println("Test si duree 1 > duree 2");

        if (duree1.compareA(duree2) == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : autreDuree < actuelleDuree : ");
        System.out.println("Initialisation d'une Durée à 2milliseconde");

        Duree duree3 = new Duree(2);

        System.out.println("Initialisation d'une autre Durée à 1millisecondes");

        Duree duree4 = new Duree(1);

        System.out.println("Test si duree 1 < duree 2");

        if (duree3.compareA(duree4) == -1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 3 : autreDuree = actuelleDuree : ");
        System.out.println("Initialisation d'une Durée à 2milliseconde");

        Duree duree5 = new Duree(2);

        System.out.println("Initialisation d'une autre Durée à 2millisecondes");

        Duree duree6 = new Duree(2);

        System.out.println("Test si duree 1 = duree 2");

        if (duree5.compareA(duree6) == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : autreDuree < 0 : ");
        System.out.println("Initialisation d'une Durée à 2milliseconde");

        Duree duree7 = new Duree(2);

        System.out.println("Initialisation d'une autre Durée à -2millisecondes");

        Duree duree8 = new Duree(-2);

        System.out.println("Appel de la méthode compareA()");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");
        duree7.compareA(duree8);

    }

    private static void testEnTexte() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode enTexte()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normaux : la Duree > 0");

        System.out.println("Initialisation d'une durée de 26heures, 15 minutes et 25 secondes");

        Duree duree1 = new Duree(26, 15, 25);

        System.out.println("Appel de la méthode enTexte('J') (JJJ HH)");
        System.out.println("Le retour de cette méthode doit être : '1 jours 2 h'");

        if (duree1.enTexte('J').equals("1 jours 2 h")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println(">-<");
        System.out.println("");

        System.out.println("Appel de la méthode enTexte('H') (HHH:MM:SS)");
        System.out.println("Le retour de cette méthode doit être : '26:15:25'");

        if (duree1.enTexte('H').equals("26:15:25")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println(">-<");
        System.out.println("");

        System.out.println("Initialisation d'une durée de 94525005 millisecondes");
        Duree duree2 = new Duree(94525005);
        System.out.println("Appel de la méthode enTexte('S') (SSS.MMM sec)");
        System.out.println("Le retour de cette méthode doit être : '94525.5 sec'");
        if (duree2.enTexte('S').equals("94525.5 sec")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println(">-<");
        System.out.println("");

        System.out.println("Appel de la méthode enTexte('M') (MMMMMM millisec)");
        System.out.println("Le retour de cette méthode doit être : '94525005 millisec'");
        if (duree2.enTexte('M').equals("94525005 millisec")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : leTemps < 0 : ");
        System.out.println("Initialisation d'une Durée à -2milliseconde");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree3 = new Duree(-2);

        System.out.println("Appel de la méthode enTexte('M') (MMMMMM millisec)");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        duree3.enTexte('M');

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : le paramètre de la méthode enTexte() n'existe pas");
        System.out.println("Appel de la méthode enTexte('X')");
        System.out.println("Ce test doit retourner 'Paramètre incorrect' -->");

        duree2.enTexte('X');

    }

    private static void testGetLeTemps() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getLeTemps()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Duree initialisé > 0 en millisecondes ");
        System.out.println("Initialisation d'une Durée à 2milliseconde");

        Duree duree1 = new Duree(2);

        System.out.println("Appel de la méthode getLeTemps() sur cette Duree");

        if (duree1.getLeTemps() == 2) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : Duree initialisé > 0 en heures, minutes et secondes");
        System.out.println("Initialisation d'une Durée à 1heure, 22 minutes et 3 secondes");

        Duree duree2 = new Duree(1, 22, 3);

        System.out.println("Appel de la méthode getLeTemps() sur cette Duree");

        if (duree2.getLeTemps() == ((60 * 60 * 1000) + (22 * 60 * 1000) + (3 * 1000))) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Duree initialisé < 0 en millisecondes");
        System.out.println("Initialisation d'une Durée à -2millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree3 = new Duree(-2);

        System.out.println("Appel de la méthode getLeTemps() sur cette Duree");

        if (duree3.getLeTemps() == 0) {
            System.out.println("--> Test OK, la durée est incorrecte");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Duree initialisé < 0 en heures, minutes et secondes");
        System.out.println("Initialisation d'une Durée à 1heure, -22minutes et 3 secondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree4 = new Duree(1, -22, 3);

        System.out.println("Appel de la méthode getLeTemps() sur cette Duree");

        if (duree4.getLeTemps() == 0) {
            System.out.println("--> Test OK, la durée est incorrecte");
        } else {
            System.out.println("--> Echec du test !");
        }
    }
}

