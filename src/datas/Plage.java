package datas;

/**
 * Cette classe définit une plage de musique appartenant à un CD. Une plage a une durée et peut se jouer.
 * Elle est caractérisée par un titre (titre du morceau) et un(des) interprète(s)(chanteurs, musiciens, ...) du morceau de musique
 */
public class Plage {
    /**
     * Titre du morceau de musique
     */
    private java.lang.String leTitre;

    /**
     * Interprète(s) du morceau de musique
     */
    private java.lang.String lInterprete;

    /**
     * Durée du morceau
     */
    private Duree laDuree;

    /**
     * Construction d'une plage correspondant à un morceau de musique
     *
     * @param laDuree     durée de la plage (!! type Duree)
     * @param leTitre     titre du morceau de musique
     * @param lInterprete l'interprète (les interprètes) du morceau
     */
    public Plage(Duree laDuree, String leTitre, String lInterprete) {
        if (laDuree.getLeTemps() > 0 && !leTitre.isEmpty() && !lInterprete.isEmpty()) {
            this.leTitre = leTitre;
            this.lInterprete = lInterprete;
            this.laDuree = laDuree;
        } else {
            System.out.println("Plage incorrecte");
        }

    }

    /**
     * Acceseur qui renvoie la durée
     *
     * @return la durée (!! type Duree)
     */
    public Duree getLaDuree() {
        return this.laDuree;
    }

    /**
     * Accesseur qui renvoie le titre du morceau
     *
     * @return le titre
     */
    public String getLeTitre() {
        return this.leTitre;
    }

    /**
     * Accesseur qui renvoie l'interprète (les interprètes) du morceau.
     *
     * @return l'interprète
     */
    public String getlInterprete() {
        return this.lInterprete;
    }

    /**
     * Accesseur qui renvoie un texte décrivant complètement la plage sous forme suivante :
     * <ul>
     *     <li>Description de la plage de musique :</li>
     *     <li>Titre : ...</li>
     *     <li>Interprète : ...</li>
     *     <li>Durée : HHH:MM:SS</li>
     * </ul>
     *
     * @return le texte qui décrit la plage
     */
    public String getFicheComplete() {
        String ret = "";
        if (this.laDuree == null && this.leTitre != null && this.lInterprete != null) {
            String Newligne = System.getProperty("line.separator");
            ret = "Description de la plage de musique : " + Newligne;
            ret += "\tTitre : " + this.leTitre + Newligne;
            ret += "\tInterprète : " + this.lInterprete + Newligne;
            ret += "\tDurée : " + this.laDuree.enTexte('H');
        } else {
            System.out.println("Plage incorrecte");
        }
        return ret;
    }

    /**
     * Accesseur qui renvoie un résumé textuel de la plage sous la forme :
     * titre - interprète - durée (SSS.MMM sec)
     *
     * @return la ligne de texte qui décrit la plage
     */
    @Override
    public String toString() {
        String ret = "";
        if (this.laDuree == null && this.leTitre != null && this.lInterprete != null) {
            ret = this.leTitre + " - " + this.lInterprete + " - " + this.laDuree.enTexte('S');
        } else {
            System.out.println("Plage incorrecte");
        }
        return ret;
    }
}
