package control;

import datas.Duree;
import ihm.FrameLecteurCD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class MyMouseListener implements ActionListener {

    private final FrameLecteurCD frameLecteurCD;

    public MyMouseListener(FrameLecteurCD myFrameLecteurCD) {
        this.frameLecteurCD = myFrameLecteurCD;
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
                }
                this.frameLecteurCD.setBtnChargerCD();
                this.frameLecteurCD.setTxtNbPlages(String.valueOf(this.frameLecteurCD.getLecteurCD().getNombrePlages()));
                this.frameLecteurCD.setTxtTempsTotal(this.frameLecteurCD.getLecteurCD().getTempsTotal());
                String titreCD = this.frameLecteurCD.getLecteurCD().getCD().getLeTitreCD();
                String interpreteCD = this.frameLecteurCD.getLecteurCD().getCD().getlInterpreteCD();
                this.frameLecteurCD.setImgPochetteCD(titreCD + "_" + interpreteCD + ".jpg");
            } else {
                this.frameLecteurCD.getLecteurCD().setDecharger();
                this.frameLecteurCD.setBtnChargerCD();
                this.frameLecteurCD.setTxtNbPlages(null);
                this.frameLecteurCD.setTxtTempsTotal(null);
                resetPlageInformations();
                this.frameLecteurCD.setImgPochetteCD(null);

            }
        }
        if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {

            if (event.getSource() == frameLecteurCD.getBtnPlay()) {
                this.frameLecteurCD.getLecteurCD().play();
                setPlageInformations();
                manageChronometre();
            }

            if (event.getSource() == frameLecteurCD.getBtnStop()) {
                this.frameLecteurCD.getLecteurCD().stop();
                resetPlageInformations();
            }

            if (event.getSource() == frameLecteurCD.getBtnNext()) {
                this.frameLecteurCD.getLecteurCD().next();
                setPlageInformations();
            }

            if (event.getSource() == frameLecteurCD.getBtnPrevious()) {
                this.frameLecteurCD.getLecteurCD().previous();
                setPlageInformations();
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

    private void manageChronometre() {
        int indexPlage = frameLecteurCD.getLecteurCD().getIndexCourant();
        if (indexPlage > 0) {
            Timer chrono = new Timer();
            chrono.schedule(new TimerTask() {
                long time = 0;

                @Override
                public void run() {
                    Duree duree = new Duree(time);

                    frameLecteurCD.setChronometre(duree.enTexte('C') + " / " + frameLecteurCD.getLecteurCD().getCD().getUnePlage(indexPlage).getLaDuree().enTexte('C'));
                    if (time >= frameLecteurCD.getLecteurCD().getCD().getUnePlage(indexPlage).getLaDuree().getLeTemps()) {
                        cancel();
                        frameLecteurCD.setChronometre(null);
                        frameLecteurCD.getLecteurCD().next();
                        setPlageInformations();
                        manageChronometre();
                    }

                    time += 1000;
                }
            }, 1000, 1000);

        }
    }

    private void manageChrono() {
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long time = 0;
            }
        });
    }

}

