package datas;

import java.util.ArrayList;

/**
 * Un CD est un ensemble de plages musicales. Le CD est caractérisé par un titre, un interprète (ou des interprètes s'il s'agit d'un groupe).
 * Lors de sa création, le CD est vierge. En le gravant, il sera rempli progressivement de morceaux (plages).
 */
public class CD {
    /**
     * Le titre du CD
     */
    private java.lang.String leTitreCD;

    /**
     * Interprète(s) du CD
     */
    private java.lang.String lInterpreteCD;

    /**
     * Le tableau contenant toutes les plages du CD
     */
    private java.util.ArrayList<Plage> lesPlages = new ArrayList<>();

    /**
     * Construction d'un CD.
     * Cette construction se fait en 2 temps :
     * <ul>
     *     <li>d'abord il y a création d'un CD vierge</li>
     *     <li>ensuite il sera gravé (ajout de plages) par appel de la méthode privé "graverCD()"</li>
     * </ul>
     *
     * @param leTitreCD     le titre du CD
     * @param lInterpreteCD le(les) interprètes du CD
     */
    public CD(String leTitreCD, String lInterpreteCD) {
        if (!leTitreCD.isEmpty() && !lInterpreteCD.isEmpty()) {
            this.leTitreCD = leTitreCD;
            this.lInterpreteCD = lInterpreteCD;
            graverCD();
        } else {
            System.out.println("CD incorrect");
        }
    }

    /**
     * Construction d'un CD.
     * Cette construction se fait à partir d'un fichier texte qui cointient toutes les informations :
     * <ul>
     *     <li>le titre et l'interprète du CD</li>
     *     <li>les différentes plages au format TitrePlage / InterprètePlage / X min. / Y sec.</li>
     * </ul>
     * La méthode privé "graverCD(String leFich)" effectue la lecture du fichier texte
     *
     * @param leFich le nom du fichier à lire
     */
    public CD(String leFich) {
        graverCD(leFich);
    }

    /**
     * Accesseur qui renvoie le nombre de plages gravées sur le CD.
     *
     * @return le nombre total de plages
     */
    public int getNbrePlages() {
        int nbPlages = 0;
        if (!lesPlages.isEmpty()) {
            nbPlages = lesPlages.size();
        } else {
            System.out.println("CD incorrect");
        }
        return nbPlages;
    }

    /**
     * Accesseur qui renvoie le titre du CD
     *
     * @return le titre du CD
     */
    public String getLeTitreCD() {
        return this.leTitreCD;
    }

    /**
     * Accesseur qui renvoie le(les) interprètes du CD
     *
     * @return le(les) interprètes
     */
    public String getlInterpreteCD() {
        return this.lInterpreteCD;
    }

    /**
     * Accesseur qui calcule et renvoie la durée totale du CD
     *
     * @return la durée totale
     */
    public Duree getDureeTotale() {
        Duree dureeTotale = new Duree(0);
        if (!this.lesPlages.isEmpty()) {
            for (Plage plage : lesPlages) {
                dureeTotale.ajoute(plage.getLaDuree());
            }
        } else {
            System.out.println("CD incorrect");
        }
        return dureeTotale;
    }

    /**
     * Accesseur qui renvoie la plage n°index du CD.
     * !! La première plage du CD est à l'index = 1
     *
     * @param index le numéro de la plage à renvoyer
     * @return la plage qui se trouve à l'emplacement (index-1) dans le tableau des plages
     */
    public Plage getUnePlage(int index) {
        return this.lesPlages.get(index - 1);
    }

    /**
     * Méthode privée qui grave le CD. Un certain nombre de plages sont ajoutées au CD. Dans cette version simplifiée, les plages sont créees et
     * ajoutées "à la main" au CD
     */
    private void graverCD() {
        Plage plage1 = new Plage(new Duree(0, 2, 30), "Money Tree", "Kendrick Lamar");
        Plage plage2 = new Plage(new Duree(0, 3, 45), "Flou", "Angèle");
        Plage plage3 = new Plage(new Duree(0, 1, 34), "Paradis", "Orelsan");
        Plage plage4 = new Plage(new Duree(0, 4, 12), "Toxic", "Britney Spears");
        Plage plage5 = new Plage(new Duree(0, 5, 54), "Break my soul", "Beyoncé");

        this.lesPlages.add(plage1);
        this.lesPlages.add(plage2);
        this.lesPlages.add(plage3);
        this.lesPlages.add(plage4);
        this.lesPlages.add(plage5);

    }

    /**
     * Méthode privé qui grave le CD à partir d'un fichier. On donne un titre et un interprète au CD de même qu'une liste de plage. Les
     * informations sont lues à partir d'un fichier texte
     *
     * @param leFich le nom du fichier du texte à lire
     */
    private void graverCD(String leFich) {
        //todo
    }

}
