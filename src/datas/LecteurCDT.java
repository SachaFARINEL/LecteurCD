package datas;

public class LecteurCDT {

    public static void main(String[] args) {
        testConstructeur();
        testGetTempsTotal();
        testGetNombrePlages();
        testGetIndexCourant();
        testGetPlageCourante();
        testEstCharge();
        testGetCD();
        testSetDecharger();
        testChargerUnCD();
        testChargerUnCDFICHIER();
        testStop();
        testPlay();
        testNext();
        testPrevious();
    }

    private static void testConstructeur() {
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test du constructeur()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Initialisation du Lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Le lecteurCD ne doit pas être chargé");

        if (!lecteurCD.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Le lecteur CD ne doit pas avoir de CD courant");

        if (lecteurCD.getCD() == null) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Le lecteur CD doit avoir un indexPlage à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testGetTempsTotal() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la fonction getTempsTotal()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Le CD est chargé");
        System.out.println("Création d'un lecteurCD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Appel de la méthode chargerUnCD() sur le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la fonction getTempsTotal()");

        Duree duree = new Duree(0, 2, 30);
        Duree duree2 = new Duree(0, 3, 45);
        Duree duree3 = new Duree(0, 1, 34);
        Duree duree4 = new Duree(0, 4, 12);
        Duree duree5 = new Duree(0, 5, 54);
        duree.ajoute(duree2);
        duree.ajoute(duree3);
        duree.ajoute(duree4);
        duree.ajoute(duree5);

        System.out.println("Le temps total doit être égal à " + duree.enTexte('H'));
        if (lecteurCD.getTempsTotal().equals(duree.enTexte('H'))) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");

        System.out.println("déchargement du CD");

        lecteurCD.setDecharger();

        System.out.println("Appel de la fonction getTempsTotal()");
        System.out.println("Ce test doit produire : --> 'Le lecteur n'est pas chargé'");

        lecteurCD.getTempsTotal();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : Le lecteur est chargé avec un CD vide");
        System.out.println("Appel de la méthode chargerUnCD(LeFichEmpty) sur le lecteur CD");
        System.out.println("Ce test doit produire : --> 'Le fichier fournit est incorrect, Auteur et titre manquant'");

        lecteurCD.chargerUnCD("testCD/LeFichEmpty.txt");

        System.out.println("Appel de la fonction getTempsTotal()");
        System.out.println("Ce test doit produire : --> 'CD incorrect & Temps incorrect'");

        lecteurCD.getTempsTotal();
    }

    private static void testGetNombrePlages() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la fonction getNombrePlages()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Le CD est chargé");
        System.out.println("Création d'un lecteurCD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Appel de la méthode chargerUnCD() sur le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la fonction getNombrePlages()");
        System.out.println("Test : Le lecteurCD1 doit avoir 5 plages");
        if (lecteurCD.getNombrePlages() == 5) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Le CD n'est pas chargé");
        System.out.println("Déchargement du CD");

        lecteurCD.setDecharger();

        System.out.println("Appel de la fonction getNombrePlages()");
        System.out.println("Le test doit retourner -1");
        System.out.println("Ce test doit produire : --> 'Le lecteur n'est pas chargé'");

        if (lecteurCD.getNombrePlages() == -1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }


        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : Le lecteur est chargé avec un CD vide");
        System.out.println("Appel de la méthode chargerUnCD(LeFichEmpty) sur le lecteur CD");
        System.out.println("Ce test doit produire : --> 'Le fichier fournit est incorrect, Auteur et titre manquant'");

        lecteurCD.chargerUnCD("testCD/LeFichEmpty.txt");

        System.out.println("Appel de la fonction getNombrePlages()");
        System.out.println("Ce test doit produire : --> 'CD incorrect'");
        System.out.println("La valeur du test doit être 0");

        if (lecteurCD.getNombrePlages() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testGetIndexCourant() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la fonction getIndexCourant()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal 1 : Le CD vient d'être chargé");
        System.out.println("Création d'un lecteurCD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Appel de la méthode chargerUnCD() sur le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la fonction getIndexCourant()");
        System.out.println("Le test doit retourner 0 (le CD n'est pas lancé)");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 2 : getIndexCourant() après avoir lancé le CD");
        System.out.println("Lancement du lecteurCD");

        lecteurCD.play();

        System.out.println("Test : appel de la fonction getIndexCourant() sur la première plage");
        System.out.println("Le test doit retourner 1");

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 3 : Appel de la fonction getIndexCourant() après avoir changé de plage");
        System.out.println("Plage suivante");

        lecteurCD.next();

        System.out.println("Test : l'indexCourant doit être égal à 2");

        if (lecteurCD.getIndexCourant() == 2) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas normal 4 : Appel de la fonction getIndexCourant() après avoir changé de plage");
        System.out.println("Plage précédente");

        lecteurCD.previous();

        System.out.println("Test : l'indexCourant doit être égal à 1");

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");
        System.out.println("Déchargement du CD");

        lecteurCD.setDecharger();

        System.out.println("Appel de la fonction getIndexCourant()");
        System.out.println("Ce test doit produire : --> 'Le lecteur n'est pas chargé'");

        lecteurCD.getIndexCourant();

        System.out.println("L'index courant doit être à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testGetPlageCourante() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la fonction getPlageCourante()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : CD chargé, LecteurCD lancé");
        System.out.println("Création du lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement du LecteurCD");

        lecteurCD.chargerUnCD();

        System.out.println("Lancement du CD");

        lecteurCD.play();

        System.out.println("Appel de la fonction getPlaceCourante()");
        System.out.println("Le retour du test doit être égal à : Money Tree - Kendrick Lamar - 150.0 sec");

        if (lecteurCD.getPlageCourante().toString().equals("Money Tree - Kendrick Lamar - 150.0 sec")) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Le CD n'est pas chargé");
        System.out.println("Déchargement du CD");

        lecteurCD.setDecharger();

        System.out.println("Appel de la fonction getPlaceCourante()");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.getPlageCourante();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : Le CD n'est pas lancé");
        System.out.println("Chargement du CD");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la fonction getPlaceCourante()");
        System.out.println("Le test doit renvoyer : --> Le CD n'est pas lancé");

        lecteurCD.getPlageCourante();
    }

    private static void testEstCharge() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode estCharge()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Création d'un lecteur CD");
        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Appel de la méthode estCharge() sur un lecteur vide");
        System.out.println("Le test doit retourner faux");

        if (!lecteurCD.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode estCharge() sur un lecteur non vide");
        System.out.println("Le test doit retourner vrai");

        if (lecteurCD.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testGetCD() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la fonction getCD()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Appelle de la fonction sur un LecteurCD plein");
        System.out.println("Création d'un lecteur CD");
        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode getCD() sur un lecteur non vide");

        if (lecteurCD.getCD() != null) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : le Lecteur CD est vide");
        System.out.println("déchargement du lecteur cd");

        lecteurCD.setDecharger();

        System.out.println("Appel de la méthode getCD() sur un lecteur vide");
        System.out.println("Le test doit retourner null");

        if (lecteurCD.getCD() == null) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testSetDecharger() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode setDecharger()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Appelle de la fonction sur un LecteurCD plein");
        System.out.println("Création d'un lecteur CD");
        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode setDecharger() sur un lecteur non vide");

        lecteurCD.setDecharger();

        System.out.println("Test si estCharge est false");

        if (!lecteurCD.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");
        System.out.println("Déchargement du CD");

        lecteurCD.setDecharger();

        System.out.println("Appel de la méthode setDecharger() sur un lecteur vide");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.setDecharger();
    }

    private static void testChargerUnCD() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode chargerUnCD()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Aucun CD n'est chargé");
        System.out.println("Création d'un lecteurCD");

        LecteurCD lecteurCD1 = new LecteurCD();

        System.out.println("Appel de la méthode chargerUnCD() sur le lecteur");

        lecteurCD1.chargerUnCD();

        System.out.println("Test si le lecteur CD est chargé");

        if (lecteurCD1.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Un CD est déjà chargé");

        System.out.println("Appel de la méthode chargerUnCD() sur le lecteurCD déjà chargé précédemment");
        System.out.println("Ce test doit retourner 'Le lecteur est déjà chargé' -->");

        lecteurCD1.chargerUnCD();
    }

    private static void testChargerUnCDFICHIER() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode chargerUnCD(LeFich)");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Aucun CD n'est chargé");
        System.out.println("Création d'un lecteurCD");

        LecteurCD lecteurCD1 = new LecteurCD();

        System.out.println("Appel de la méthode chargerUnCD(testCD/LeFich.txt) sur le lecteur");

        lecteurCD1.chargerUnCD("testCD/LeFich.txt");

        System.out.println("Test si le lecteur CD est chargé");

        if (lecteurCD1.estCharge()) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Un CD est déjà chargé");

        System.out.println("Appel de la méthode chargerUnCD(LeFich) sur le lecteurCD déjà chargé précédemment");
        System.out.println("Ce test doit retourner 'Le lecteur est déjà chargé' -->");

        lecteurCD1.chargerUnCD("testCD/LeFich.txt");
    }

    private static void testStop() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode stop()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Un CD est chargé, le cd a démarré");
        System.out.println("Création d'un lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode start()");

        lecteurCD.play();

        System.out.println("Appel de la méthode next() deux fois");

        lecteurCD.next();
        lecteurCD.next();

        System.out.println("l'indexCourant est égal à " + lecteurCD.getIndexCourant());

        System.out.println("Appel de la méthode stop()");
        lecteurCD.stop();

        System.out.println("Test : l'indexCourant doit être égal à 1");

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Le lecteur CD est vide");
        System.out.println("Déchargement du LecteurCD");
        lecteurCD.setDecharger();
        System.out.println("Appel de la méthode stop()");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.stop();

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : le CD n'a pas été lancé");
        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode stop()");
        System.out.println("Le test doit renvoyer : --> Le CD n'a pas été lancé");
        lecteurCD.stop();
    }

    private static void testPlay() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode play()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : Un CD est chargé et l'indexPlage est = 0");
        System.out.println("Création d'un lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode play()");

        lecteurCD.play();

        System.out.println("Test si l'index courant est égal à 1");

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");
        System.out.println("déchargement du cd");

        lecteurCD.setDecharger();

        System.out.println("Appel de la méthode play()");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.play();

        System.out.println("Vérification que l'index est toujours égal à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

    }

    private static void testNext() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode next()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : CD chargé, lancé et pistes restantes");

        System.out.println("Création d'un lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode play()");

        lecteurCD.play();

        System.out.println("Appel de la méthode next()");
        lecteurCD.next();
        System.out.println("Test si l'indexPlage est égal à 2");

        if (lecteurCD.getIndexCourant() == 2) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");
        System.out.println("déchargement du cd");

        lecteurCD.setDecharger();

        System.out.println("Appel de la méthode next()");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.next();

        System.out.println("Vérification que l'index est toujours égal à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : le CD n'a pas démarré");
        System.out.println("Chargement du CD");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode next()");
        System.out.println("Le test doit renvoyer : --> Le CD n'est pas lancé");

        lecteurCD.next();

        System.out.println("Vérification que l'index est toujours égal à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite 2 : Nous sommes sur la dernière piste");
        System.out.println("Le CD possède " + lecteurCD.getNombrePlages() + " plages");
        System.out.println("Lancement du lecteur");

        lecteurCD.play();

        System.out.println("Appel de la méthode next() 4 fois pour arriver à la dernière plage");

        lecteurCD.next();
        lecteurCD.next();
        lecteurCD.next();
        lecteurCD.next();

        System.out.println("indexCourant = " + lecteurCD.getIndexCourant());
        System.out.println("Test : la méthode next() doit rameneer l'indexCourant à 1");

        lecteurCD.next();

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }

    private static void testPrevious() {
        System.out.println("");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("Test de la méthode previous()");
        System.out.println("><><><><><><><><><><><><><><><><><><");
        System.out.println("");

        System.out.println("Cas normal : CD chargé, lancé et indexPlages > 1");

        System.out.println("Création d'un lecteur CD");

        LecteurCD lecteurCD = new LecteurCD();

        System.out.println("Chargement d'un CD dans le lecteur");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode play()");

        lecteurCD.play();

        System.out.println("Appel de la méthode next()");
        lecteurCD.next();

        System.out.println("indexCourant est égal à " + lecteurCD.getIndexCourant());
        System.out.println("Appel de la méthode previous()");

        lecteurCD.previous();

        System.out.println("Test : l'indexCourant doit être égal à 1");

        if (lecteurCD.getIndexCourant() == 1) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas d'erreur : Aucun CD n'est chargé");
        System.out.println("déchargement du cd");

        lecteurCD.setDecharger();

        System.out.println("Appel de la méthode previous()");
        System.out.println("Le test doit renvoyer : --> Le lecteur n'est pas chargé");

        lecteurCD.previous();

        System.out.println("Vérification que l'index est toujours égal à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite : le CD n'a pas démarré");
        System.out.println("Chargement du CD");

        lecteurCD.chargerUnCD();

        System.out.println("Appel de la méthode previous()");
        System.out.println("Le test doit renvoyer : --> Le CD n'est pas lancé");

        lecteurCD.previous();

        System.out.println("Vérification que l'index est toujours égal à 0");

        if (lecteurCD.getIndexCourant() == 0) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }

        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        System.out.println("Cas limite 2 : Nous sommes sur la première piste");
        System.out.println("Le CD possède " + lecteurCD.getNombrePlages() + " plages");
        System.out.println("Lancement du lecteur");

        lecteurCD.play();

        System.out.println("Appel de la méthode previous() sur la première plage");

        lecteurCD.previous();

        System.out.println("Test : la méthode previous() doit ramener l'indexCourant à 5");

        if (lecteurCD.getIndexCourant() == 5) {
            System.out.println("--> Test OK");
        } else {
            System.out.println("--> Echec du test !");
        }
    }
}
