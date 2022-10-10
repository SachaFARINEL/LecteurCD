package control;

import ihm.FrameLecteurCD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMouseListener implements ActionListener {

    private final FrameLecteurCD frameLecteurCD;

    public MyMouseListener(FrameLecteurCD myFrameLecteurCD) {
        this.frameLecteurCD = myFrameLecteurCD;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == frameLecteurCD.getBtnChargerCD()) {
            if (!this.frameLecteurCD.getLecteurCD().estCharge()) {
                //todo Faire un FileReader
                this.frameLecteurCD.getLecteurCD().chargerUnCD("ws/LeFich.txt");
                this.frameLecteurCD.setBtnChargerCD();

                this.frameLecteurCD.setTxtNbPlages(String.valueOf(this.frameLecteurCD.getLecteurCD().getNombrePlages()));
                this.frameLecteurCD.setTxtTempsTotal(this.frameLecteurCD.getLecteurCD().getTempsTotal());

                this.frameLecteurCD.setImgPochetteCD(this.frameLecteurCD.getLecteurCD().getCD().getlInterpreteCD() + ".jpg");
            } else {
                this.frameLecteurCD.getLecteurCD().setDecharger();
                this.frameLecteurCD.setBtnChargerCD();

                this.frameLecteurCD.setTxtNbPlages(null);
                this.frameLecteurCD.setTxtTempsTotal(null);

                resetPlageInformations();

                this.frameLecteurCD.setImgPochetteCD(null);

            }
        }

        if (event.getSource() == frameLecteurCD.getBtnPlay()) {
            if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {
                this.frameLecteurCD.getLecteurCD().play();

                setPlageInformations();
            }
        }

        if (event.getSource() == frameLecteurCD.getBtnStop()) {
            if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {
                this.frameLecteurCD.getLecteurCD().stop();

                resetPlageInformations();
            }
        }

        if (event.getSource() == frameLecteurCD.getBtnNext()) {
            if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {
                this.frameLecteurCD.getLecteurCD().next();
                setPlageInformations();
            }
        }

        if (event.getSource() == frameLecteurCD.getBtnPrevious()) {
            if (this.frameLecteurCD.getLecteurCD().estCharge() && this.frameLecteurCD.getLecteurCD().getCD() != null) {
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
}

