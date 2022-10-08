package datas;

public class CDT {

    public static void main(String[] args) {
        //testConstructeur1();
        //testConstructeur2();
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
        System.out.println("Initialisation de l'objet : new Cd(LeFich.txt)");

        CD cd1 = new CD("LeFich.txt");

        System.out.println("Verification du titreCD");

        if (cd1.getLeTitreCD().equals("La fete est finie")) {
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

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Initialisation avec un fichier mal écrit");
        System.out.println("Création d'un CD('LeFichEmpty.txt')");
        System.out.println("Ce test doit retourner 'Le fichier fournit est incorrect, Auteur et titre manquant' -->");

        CD cd2 = new CD("LeFichEmpty.txt");

    }

    private static void testGetNbrePlages() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getNbrePlages()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°1");
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

        System.out.println("Cas normal 2 : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°2");
        System.out.println("Création du Cd('LeFich.txt')");

        CD cd2 = new CD("LeFich.txt");

        System.out.println("Appel de la méthode getNbreDePlages()");

        System.out.println("Le fichier doit comporter 6 plages");
        if (cd2.getNbrePlages() == 6) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }


        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Appel de la méthode sur un CD avec paramètre vide, crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', '')");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        CD cd3 = new CD("Didine mix", "");

        System.out.println("Appel de la méthode getNbrePlages() sur CD");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        cd3.getNbrePlages();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Appel de la méthode sur un CD crée avec un fichier texte mal écrit");
        System.out.println("Création du CD('LeFichEmpty.txt')");
        System.out.println("Ce test doit retourner 'Le fichier fournit est incorrect, Auteur et titre manquant' -->");

        CD cd4 = new CD("LeFichEmpty.txt");

        System.out.println("Appel de la méthode getNbrePlages() sur CD");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        cd4.getNbrePlages();

    }

    private static void testGetDureeTotale() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getDureeTotale()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°1");
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

        System.out.println("Cas normal 2 : Appel de la méthode sur un CD 'normal' crée avec le constructeur n°2");
        System.out.println("Création du Cd('LeFich.txt')");

        CD cd2 = new CD("LeFich.txt");

        System.out.println("Pour le test, le fichier à des duree en heure ou en mins ou juste en sec");

        long tempsTotal = new Duree(0, 4, 2).getLeTemps();
        tempsTotal += new Duree(0, 3, 4).getLeTemps();
        tempsTotal += new Duree(0, 2, 44).getLeTemps();
        tempsTotal += new Duree(0, 2, 29).getLeTemps();
        tempsTotal += new Duree(0, 0, 45).getLeTemps();
        tempsTotal += new Duree(1, 10, 15).getLeTemps();

        System.out.println("Appel de la méthode getDureeTotale() : Temps du fichier -> " + tempsTotal);
        System.out.println("Ce test doit retourner 'Temps incorrect' -->");

        if (cd2.getDureeTotale().getLeTemps() == tempsTotal) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 1 : Appel de la méthode sur un CD avec paramètre vide, crée avec le constructeur n°1");
        System.out.println("Création du CD('Didine Mix', '')");
        System.out.println("Ce test doit retourner 'CD incorrect' -->");

        CD cd3 = new CD("Didine mix", "");

        System.out.println("Appel de la méthode getDureeTotale() sur CD");
        System.out.println("Ce test doit retourner 'Temps incorrect & CD incorrect' -->");

        cd3.getDureeTotale();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur 2 : Appel de la méthode sur un CD crée avec un fichier texte mal écrit");
        System.out.println("Création du CD('LeFichEmpty.txt')");
        System.out.println("Ce test doit retourner 'Le fichier fournit est incorrect, Auteur et titre manquant' -->");

        CD cd4 = new CD("LeFichEmpty.txt");

        System.out.println("Appel de la méthode getNbrePlages() sur CD");
        System.out.println("Ce test doit retourner 'Temps incorrect & CD incorrect' -->");

        cd4.getDureeTotale();

    }

    private static void testGetUnePlage() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode getUnePlage()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Initialisation avec des paramètres non vide");
        System.out.println("Création d'un CD('Didine mix', 'Sandou')");

        CD cd1 = new CD("Didine mix", "Sandou");

        System.out.println("Appel de la méthode getUnePlage(1)");
        System.out.println("La plage doit être : 'Money Tree - Kendrick Lamar - 150.0 sec'");

        if (cd1.getUnePlage(1).toString().equals("Money Tree - Kendrick Lamar - 150.0 sec")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal : Initialisation avec 'LeFich.txt'");
        System.out.println("Création d'un CD('LeFich.txt')");

        CD cd2 = new CD("LeFich.txt");

        System.out.println("Appel de la méthode getUnePlage(3)");
        System.out.println("La plage doit être : 'Orelsan - Basique - 164.0 sec'");

        if (cd2.getUnePlage(3).toString().equals("Orelsan - Basique - 164.0 sec")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : getUnePlage(index > lesPlages.size())");
        System.out.println("Création d'un CD('LeFichEmpty.txt')");
        System.out.println("Ce test doit retourner 'Le fichier fournit est incorrect, Auteur et titre manquant' -->");

        CD cd3 = new CD("LeFichEmpty.txt");

        System.out.println("Appel de la méthode getUnePlage(1)");
        System.out.println("Ce test doit retourner 'La plage n'existe pas' -->");

        cd3.getUnePlage(1);
    }
}
