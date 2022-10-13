package datas;

/**
 * Cette classe définit une durée temporelle. Elle permet la manipulation d'intervalles de temps. Une durée s'exprime en millisecondes.
 *
 * @author FARINEL Sacha
 */
public class Duree {

    /**
     * La durée s'exprime en millisecondes.
     */
    private long leTemps;

    /**
     * Constructeur avec initialisation en millisecondes.
     *
     * @param millisecondes la durée exprimée en millisecondes
     */
    public Duree(long millisecondes) {
        if (millisecondes >= 0) {
            this.leTemps = millisecondes;
        } else {
            System.out.println("Temps incorrect");
        }
    }

    /**
     * Constructeur à partir des données heures, minutes, secondes.
     *
     * @param heures   nbre d'heures.
     * @param minutes  nbre de minutes.
     * @param secondes nbre de secondes.
     */
    public Duree(int heures, int minutes, int secondes) {
        if (heures >= 0 && minutes >= 0 && minutes <= 60 && secondes >= 0 && secondes <= 60) {
            long conversion = heures * 3600000L + minutes * 60000L + secondes * 1000L;
            if (conversion > 0) {
                this.leTemps = conversion;
            } else {
                System.out.println("Temps incorrect");
            }
        } else {
            System.out.println("Temps incorrect");
        }
    }

    /**
     * Construction par recopie d'une Duree passée en paramètre.
     *
     * @param autreDuree la durée à recopier.
     */
    public Duree(Duree autreDuree) {
        if (autreDuree.getLeTemps() > 0) {
            this.leTemps = autreDuree.getLeTemps();
        } else {
            System.out.println("Temps incorrect");
        }
    }

    /**
     * Modificateur qui ajoute une durée à la durée courante.
     *
     * @param autreDuree durée à rajouter.
     */
    public void ajoute(Duree autreDuree) {
        if (autreDuree.getLeTemps() != 0) {
            this.leTemps += autreDuree.getLeTemps();
        } else {
            System.out.println("Temps incorrect");
        }
    }

    /**
     * Accesseur qui effectue une comparaison entre la durée courante et une autre durée.
     *
     * @param autreDuree durée à comparer à la durée courante.
     * @return un entier qui prend les valeurs suivantes :
     * <ul>
     *     <li>-1 : si la durée courante est + petite que autreDuree.</li>
     *     <li>0 : si la durée courante est égale à autreDuree.</li>
     *     <li>1 : si la durée courante est + grande que autreDuree.</li>
     * </ul>
     */
    public int compareA(Duree autreDuree) {
        long autreTemps = autreDuree.getLeTemps();
        int ret = 0;
        if (autreTemps != 0) {
            if (this.leTemps > autreTemps) {
                ret = -1;
            } else if (this.leTemps < autreTemps) {
                ret = 1;
            }
        } else {
            System.out.println("Temps incorrect");
        }
        return ret;
    }

    /**
     * Méthode privée qui effectue un découpage de la durée courante en intervalles (jours, heures, minutes, secondes, millisecondes).
     * La durée courante (leTemps) est analysée pour fabriquer un tableau d'entiers (taille 5) dont chaque élément à la signification suivante :
     * <ul>
     *     <li>ret[0] contient le nbre de jours.</li>
     *     <li>ret[1] contient le nbre d'heures (&lt; 24h).</li>
     *     <li>ret[2] contient le nbre de minutes (&lt; 60min).</li>
     *     <li>ret[3] contient le nbre de secondes (&lt; 60sec).</li>
     *     <li>ret[4] contient le nbre de millisecondes (&lt; 1000millisec).</li>
     * </ul>
     *
     * @return un tableau d'entiers.
     */
    private int[] enJHMS() {
        int[] ret = null;
        if (this.leTemps >= 0) {
            ret = new int[5];
            int jour = (int) (this.leTemps / 86400000);
            int reste = (int) (this.leTemps % 86400000);
            int heure = reste / 3600000;
            reste %= 3600000;
            int minute = reste / 60000;
            reste %= 60000;
            int seconde = reste / 1000;
            reste %= 1000;
            int milliseconde = reste;
            ret[0] = jour;
            ret[1] = heure;
            ret[2] = minute;
            ret[3] = seconde;
            ret[4] = milliseconde;
        }
        return ret;
    }

    /**
     * Acceseur qui renvoie sous la forme d'une chaîne de caractères la durée courante.
     *
     * @param mode décide de la forme données à la chaîne de caractère.
     *             La forme de la chaine de caractères dépend du "mode" (caractère passé en paramètre) choisi :
     *             <ul>
     *             <li>si mode == 'J' -> chaîne de caractère de la forme "JJJ jours HH h".</li>
     *             <li>si mode == 'H' -> chaîne de caractère de la forme "HHH:MM:SS".</li>
     *             <li>si mode == 'S' -> chaîne de caractère de la forme "SSS.MMM sec".</li>
     *             <li>si mode == 'M' -> chaîne de caractère de la forme "MMMMMM millisec".</li>
     *             </ul>
     * @return la durée sous la forme d'une chaîne de caractères.
     * La méthode utilise la méthode privée enJHMS() pour extraire dans un tableau d'entiers séparement le nombre de jours,
     * le nombre d'heures, le nombre de minutes, le nombre de secondes et le nombre de millisecondes qui contient la durée courante (leTemps).
     */
    public String enTexte(char mode) {
        String duree = "";
        int[] temps = enJHMS();
        if (temps != null) {
            int jour = temps[0];
            int heure = temps[1];
            int heureTotal = (jour * 24) + heure;
            int minute = temps[2];
            int minuteTotal = (jour * 24 * 60) + (heure * 60) + minute;
            int seconde = temps[3];
            int secondeTotal = (jour * 24 * 60 * 60) + (heure * 60 * 60) + (minute * 60) + seconde;
            int milliseconde = temps[4];
            int millisecondeTotal = (jour * 24 * 60 * 60 * 1000) + (heure * 60 * 60 * 1000) + (minute * 60 * 1000) + (seconde * 1000) + milliseconde;

            String formatHeure = "";
            if (heureTotal < 10) {
                formatHeure = "0";
            }
            String formatMinute = "";
            if (minute < 10) {
                formatMinute = "0";
            }
            String formatSeconde = "";
            if (seconde < 10) {
                formatSeconde = "0";
            }

            switch (mode) {
                case 'J' -> duree = jour + " jours " + heure + " h";
                case 'H' ->
                        duree = formatHeure + heureTotal + ":" + formatMinute + minute + ":" + formatSeconde + seconde;
                case 'S' -> duree = secondeTotal + "." + milliseconde + " sec";
                case 'M' -> duree = millisecondeTotal + " millisec";
                case 'C' -> duree = formatMinute + minuteTotal + ":" + formatSeconde + seconde;
                default -> System.out.println("Paramètre incorrect");
            }

        } else {
            System.out.println("Temps incorrect");
        }

        return duree;
    }

    /**
     * Accesseur qui retourne la valeur de la durée courante en millisecondes.
     *
     * @return la durée en millisecondes.
     */
    public long getLeTemps() {
        return this.leTemps;
    }

    public void setLeTemps(long duree) {
        this.leTemps = duree;
    }

}