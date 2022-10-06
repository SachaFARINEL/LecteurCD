package datas;

public class PlageT {

    public static void main(String[] args) {
        testConstructeur();
        testGetFicheComplete();
        testToString();
    }

    private static void testConstructeur() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Duree > 0 et String non vide");
        System.out.println("Initialisation d'une Duree (1, 2, 3)");

        Duree duree1 = new Duree(1, 2, 3);

        System.out.println("Initialisation d'une Plage (Duree, 'Titre', 'Auteur')");
        Plage plage1 = new Plage(duree1, "Titre", "Auteur");

        System.out.println("Test de la durée");

        if (plage1.getLaDuree().getLeTemps() == duree1.getLeTemps()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Test du titre");

        if (plage1.getLeTitre().equals("Titre")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Test de l'interprète");

        if (plage1.getlInterprete().equals("Auteur")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Duree < 0 et String non vide");
        System.out.println("Initialisation d'une Duree négative à -2millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree2 = new Duree(-2);

        System.out.println("Initialisation d'une Plage avec la Duree précédente");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Plage plage2 = new Plage(duree2, "Titre", "Auteur");

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Duree > 0 et String vide");
        System.out.println("Initialisation d'une Duree à 2millisecondes");

        Duree duree3 = new Duree(2);

        System.out.println("Initialisation d'une Plage avec la Duree précédente");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Plage plage3 = new Plage(duree3, "", "Auteur");

    }

    private static void testGetFicheComplete() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getFicheComplete()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Duree > 0 et String non nulles");
        System.out.println("Initialisation d'une Duree à 1heure, 2minutes et 3secondes");

        Duree duree1 = new Duree(1, 2, 3);

        System.out.println("Initialisation d'une Plage avec la Duree précédente, 'Titre', 'Auteur'");

        Plage plage1 = new Plage(duree1, "Titre", "Auteur");
        String Newligne = System.getProperty("line.separator");
        String phraseATester = "Description de la plage de musique : " + Newligne + "\tTitre : Titre" + Newligne + "\tInterprète : Auteur" + Newligne + "\tDurée : 1:2:3";

        System.out.println("Test de la méthode getFicheComplete sur la Plage précédente");

        if (plage1.getFicheComplete().equals(phraseATester)) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Duree < 0 et String non vide");
        System.out.println("Initialisation d'une Duree négative à -2millisecondes");
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        Duree duree2 = new Duree(-2);

        System.out.println("Initialisation d'une Plage avec la Duree précédente");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Plage plage2 = new Plage(duree2, "Titre", "Auteur");

        System.out.println("Appel de la méthode getFicheComplete() sur la Plage");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        plage2.getFicheComplete();


        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Duree > 0 et String vide");
        System.out.println("Initialisation d'une Duree à 2millisecondes");

        Duree duree3 = new Duree(2);

        System.out.println("Initialisation d'une Plage avec la Duree précédente");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Plage plage3 = new Plage(duree3, "", "Auteur");

        System.out.println("Appel de la méthode getFicheComplete() sur la Plage");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        plage3.getFicheComplete();

    }

    private static void testToString() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode toString()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Duree > 0 et String non nulles");
        System.out.println("Initialisation d'une Duree à 20000millisecondes");

        Duree duree1 = new Duree(20000);

        System.out.println("Initialisation d'une Plage avec la Duree précédente");

        Plage plage1 = new Plage(duree1, "Titre", "Auteur");

        System.out.println("Appel de la méthode toString sur l'objet Plage");

        String str = "Titre - Auteur - 20.0 sec";
        if (plage1.toString().equals(str)) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Duree < 0 et String nulles");
        System.out.println("Initialisation d'une Duree à -20000millisecondes");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Duree duree2 = new Duree(-20000);

        System.out.println("Initialisation d'une Plage avec la Duree précédente, et deux String vide");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        Plage plage2 = new Plage(duree2, "", "");

        System.out.println("Appel de la méthode toString() sur cette plage");
        System.out.println("Ce test doit retourner 'Plage incorrecte' -->");

        System.out.println(plage2.toString());


    }
}
