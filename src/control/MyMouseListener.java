package control;

import datas.Duree;
import ihm.FrameLecteurCD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyMouseListener implements ActionListener {

    private final FrameLecteurCD frameLecteurCD;

    private final Duree duree;

    public MyMouseListener(FrameLecteurCD myFrameLecteurCD) {
        this.frameLecteurCD = myFrameLecteurCD;
        this.duree = new Duree(0);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == frameLecteurCD.getBtnChargerCD()) {

            if (!this.frameLecteurCD.getLecteurCD().estCharge()) {

                JFileChooser fileChooser = new JFileChooser(new File("."));

                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File fichierAudio = fileChooser.getSelectedFile();
                    String nomFichierAudio = fichierAudio.toString();
                    this.frameLecteurCD.getLecteurCD().chargerUnCD(nomFichierAudio);

                    this.frameLecteurCD.setBtnChargerCD();

                    String nombrePlages = String.valueOf(this.frameLecteurCD.getLecteurCD().getNombrePlages());
                    String tempsTotal = this.frameLecteurCD.getLecteurCD().getTempsTotal();
                    String titreCD = this.frameLecteurCD.getLecteurCD().getCD().getLeTitreCD();
                    String interpreteCD = this.frameLecteurCD.getLecteurCD().getCD().getlInterpreteCD();

                    this.frameLecteurCD.setTxtNbPlages(nombrePlages);
                    this.frameLecteurCD.setTxtTempsTotal(tempsTotal);

                    this.frameLecteurCD.setImgPochetteCD(titreCD + "_" + interpreteCD + ".jpg");
                    this.frameLecteurCD.setTxtAlbum(titreCD + " - " + interpreteCD);
                }

            } else {

                dechargementCD();
            }
        }
        if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {

            if (event.getSource() == frameLecteurCD.getChrono()) {

                this.duree.ajoute(new Duree(1000));

                if (duree.getLeTemps() < frameLecteurCD.getLecteurCD().getPlageCourante().getLaDuree().getLeTemps()) {
                    int indexPlage = frameLecteurCD.getLecteurCD().getIndexCourant();
                    frameLecteurCD.setTxtChronometre(duree.enTexte('C') + " / " + frameLecteurCD.getLecteurCD().getCD().getUnePlage(indexPlage).getLaDuree().enTexte('C'));

                } else {

                    this.frameLecteurCD.getLecteurCD().next();
                    setPlageInformations();
                    stopChronoAndResetTextfield();
                    this.frameLecteurCD.getChrono().start();

                }
            }

            if (event.getSource() == frameLecteurCD.getBtnPlay()) {

                this.frameLecteurCD.getLecteurCD().play();
                setPlageInformations();
                this.frameLecteurCD.getChrono().start();

            }

            if (event.getSource() == frameLecteurCD.getBtnStop()) {

                this.frameLecteurCD.getLecteurCD().stop();
                resetPlageInformations();
                stopChronoAndResetTextfield();

            }

            if (event.getSource() == frameLecteurCD.getBtnNext()) {

                this.frameLecteurCD.getLecteurCD().next();
                setPlageInformations();
                stopChronoAndResetTextfield();
                this.frameLecteurCD.getChrono().start();

            }

            if (event.getSource() == frameLecteurCD.getBtnPrevious()) {

                this.frameLecteurCD.getLecteurCD().previous();
                setPlageInformations();
                stopChronoAndResetTextfield();
                this.frameLecteurCD.getChrono().start();

            }

            if (event.getSource() == frameLecteurCD.getBtnPause()) {
                this.frameLecteurCD.getChrono().stop();
            }
        }

    }

    private void setPlageInformations() {
        int indexPlage = this.frameLecteurCD.getLecteurCD().getIndexCourant();
        this.frameLecteurCD.setTxtPlageCourante(String.valueOf(indexPlage));
        this.frameLecteurCD.setTxtInfoPlageCourante(this.frameLecteurCD.getLecteurCD().getCD().getUnePlage(indexPlage).toString());
        this.frameLecteurCD.setTxtDureePlageCourante(this.frameLecteurCD.getLecteurCD().getCD().getUnePlage(indexPlage).getLaDuree().enTexte('H'));
    }

    private void resetPlageInformations() {
        this.frameLecteurCD.setTxtPlageCourante(null);
        this.frameLecteurCD.setTxtInfoPlageCourante(null);
        this.frameLecteurCD.setTxtDureePlageCourante(null);
    }

    private void stopChronoAndResetTextfield() {
        this.frameLecteurCD.getChrono().stop();
        this.frameLecteurCD.setTxtChronometre(null);
        this.duree.setLeTemps(0);
    }

    private void dechargementCD() {
        this.frameLecteurCD.getLecteurCD().setDecharger();
        this.frameLecteurCD.setBtnChargerCD();
        this.frameLecteurCD.setTxtNbPlages(null);
        this.frameLecteurCD.setTxtTempsTotal(null);
        resetPlageInformations();
        this.frameLecteurCD.setImgPochetteCD(null);
        this.frameLecteurCD.setTxtAlbum(null);
        stopChronoAndResetTextfield();
    }
}