package ihm;

import datas.LecteurCD;

import javax.swing.*;

public class FrameLecteurCD extends JFrame {

    private JButton btnChargerCD = new JButton("Charger CD");
    private JButton btnStop = new JButton("STOP");
    private JButton btnPlay = new JButton("PLAY");
    private JButton btnNext = new JButton("NEXT");
    private JButton btnPrevious = new JButton("PREVIOUS");

    private JTextField txtTempsTotal = new JTextField("");
    private JTextField txtNbPlages = new JTextField("");
    private JTextField txtPlageCourante = new JTextField("");
    private JTextField txtInfoPlageCourante = new JTextField("");
    private JTextField txtDureePlageCourante = new JTextField("");

    private JLabel labTempsTotal = new JLabel("Temps total");
    private JLabel labNbPlages = new JLabel("Nombre de plages");

    private LecteurCD lecteurCD;

}
