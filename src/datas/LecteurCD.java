package datas;

/**
 * La classe lecteurCD simule de manière simplifiée les fonctionnalités d'un lecteur CDk à savoir :
 * <ul>
 *     <li>Le chargement d'un CD dans le lecteur</li>
 *     <li>La lecture du CD depuis le début (touche PLAY)</li>
 *     <li>L'arrêt de la lecture (touche STOP)</li>
 *     <li>Le passage au morceau suivant (touche NEXT)</li>
 *     <li>Le passage au morceau précédent (touche PREVIOUS)</li>
 * </ul>
 */
public class LecteurCD {

    /**
     * Le lecteur renferme-t-il un CD ?
     */
    private boolean estCharge;

    /**
     * Le CD courant (qui se trouve dans le lecteur)
     */
    private CD leCdCourant;

    /**
     * L'index de la plage courante (1 <= index <= nbrePlages ou zéro si aucun CD chargé)
     */
    private int indexPlage;

    /**
     * Construction d'un lecteur de CD. A l'issue de la construction, il n'y a aucun CD dans le lecteur (leCdCourant=null).
     * Le chargement d'un CD se fait à l'aide de la méthode "chargerUnCD()"
     */
    public LecteurCD() {
        //todo
        //chargerUnCD();
    }

    /**
     * Accesseur qui renvoie le nombre de plages que contient le CD
     *
     * @return le temps total du CD
     */
    public String getTempsTotal() {
        //todo
        return null;
    }

    /**
     * Accesseur qui renvoie le nombre de plages que contient le CD
     *
     * @return le nombre de plages (-1 si aucun CD chargé)
     */
    public int getNombrePlages() {
        //todo
        return 0;
    }

    /**
     * Accesseur qui renvoie l'index de la plage du CD en cours de lecture. Cet index est compris entre 1 et nbrePlages
     *
     * @return l'index de la plage courante (zéro si aucun CD chargé)
     */
    public int getIndexCourant() {
        //todo
        return 0;
    }

    /**
     * Accesseur qui renvoie la plage en cours de lecture.
     *
     * @return la plage courante (null si aucun CD chargé)
     */
    public Plage getPlageCourante() {
        //todo
        return null;
    }

    /**
     * Accesseur qui renvoie vrai si le lecteur contient un CD
     *
     * @return vrai si il y a un CD dans le lecteur
     */
    public boolean estCharge() {
        //todo
        return false;
    }

    /**
     * Accesseur qui renvoie le CD chargé dans le lecteur ou null si aucun CD chargé
     *
     * @return le CD courant ou null si aucun CD dans le lecteur
     */
    public CD getCD() {
        //todo
        return null;
    }

    /**
     * Modification qui force le lecture à se décharger du CD qu'il contient. Le booléen estCharge devient faux et leCdCourant devient null
     */
    public void setDecharger() {
        //todo
    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur. Pour simplifier, il s'agira toujours du même CD pour cette version de la
     * méthode. La méthode doit construire le CD et mettre le booléen à vrai.
     */
    public void chargerUnCd() {
        //todo
    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur. Pour cette version, le CD est construit à partir d'un fichier texte.
     *
     * @param leFich le nom du fichier texte à lire
     */
    public void chargerUnCD(String leFich) {
        //todo
    }

    /**
     * Modificateur qui simule la touche STOP. Cela a pour conséquence de simplement remettre l'index des plages sur 1. (Et éventuellement
     * d'arrêter le timer de lecture de plages en cours). Il ne se passe rien si aucun CD est chargé
     */
    public void stop() {
        //todo
    }

    /**
     * Modificateur qui simule la touche PLAY. Cela a pour conséquence de simplement remettre l'index des plages sur 1.(Et éventuellement de
     * démarrer le timer de lecture de la 1ère plage). Il ne se passe rien si aucun CD chargé
     */
    public void play() {
        //todo
    }

    /**
     * Modificateur qui simule la touche NEXT. Cela a pour conséquence de simplement incrémenter l'index des plages. (Et éventuellement de démarrer
     * le timer de lecture de la plage suivante). Il ne se passe rien si aucun CD chargé
     */
    public void next() {
        //todo
    }

    /**
     * Modificateur qui simule la touche PREVIOUS. Cela a pour conséquence de simplement décrémenter l'index des plages. (Et éventuellement de
     * démarrer le timer de lecture de la plage précédente). Il ne se passe rien si aucun CD chargé
     */
    public void previous() {
        //todo
    }


}
