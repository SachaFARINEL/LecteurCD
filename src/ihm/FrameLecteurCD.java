package ihm;

import datas.LecteurCD;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FrameLecteurCD extends JFrame {

    private JButton btnChargerCD = new JButton("Charger le CD - OFF");
    private JButton btnStop = new JButton(new ImageIcon("ws/ressources/stop.png"));
    private JButton btnPlay = new JButton(new ImageIcon("ws/ressources/play.png"));
    private JButton btnNext = new JButton(new ImageIcon("ws/ressources/next.png"));
    private JButton btnPrevious = new JButton(new ImageIcon("ws/ressources/previous.png"));

    private JTextField txtTempsTotal = new JTextField("");
    private JTextField txtNbPlages = new JTextField("");
    private JTextField txtPlageCourante = new JTextField("");
    private JTextField txtInfoPlageCourante = new JTextField("");
    private JTextField txtDureePlageCourante = new JTextField("");

    private JLabel labTempsTotal = new JLabel("Temps total");
    private JLabel labNbPlages = new JLabel("Nombre de plages");

    private LecteurCD lecteurCD;

    public FrameLecteurCD(String titre) throws IOException {
        super(titre);
        this.lecteurCD = new LecteurCD();
        miseEnPlace();
    }

    private void miseEnPlace() throws IOException {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("ws/ressources/cd.png")));
        this.setLayout(new GridLayout(2, 1));
        this.add(pochetteView());
        this.add(controlsView());
    }

    private JPanel controlsView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(plageInformation());
        panel.add(CDInformation());
        panel.add(menulecteur());
        return panel;
    }

    private JPanel pochetteView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        return panel;
    }

    private JPanel plageInformation() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(this.btnChargerCD);
        panel.add(new JLabel());

        this.labTempsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.labTempsTotal);
        this.txtTempsTotal.setEditable(false);
        panel.add(this.txtTempsTotal);

        this.labNbPlages.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.labNbPlages);
        this.txtNbPlages.setEditable(false);
        panel.add(this.txtNbPlages);

        return panel;
    }

    private JPanel CDInformation() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(this.txtPlageCourante, BorderLayout.WEST);
        panel.add(this.txtInfoPlageCourante, BorderLayout.CENTER);
        panel.add(this.txtDureePlageCourante, BorderLayout.EAST);

        this.txtPlageCourante.setPreferredSize(new Dimension(100, 100));
        this.txtDureePlageCourante.setPreferredSize(new Dimension(100, 100));

        this.txtPlageCourante.setHorizontalAlignment(SwingConstants.CENTER);
        this.txtDureePlageCourante.setHorizontalAlignment(SwingConstants.CENTER);
        this.txtInfoPlageCourante.setHorizontalAlignment(SwingConstants.CENTER);

        this.txtPlageCourante.setEditable(false);
        this.txtDureePlageCourante.setEditable(false);
        this.txtInfoPlageCourante.setEditable(false);

        return panel;
    }

    private JPanel menulecteur() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));
        panel.add(this.btnStop);
        panel.add(this.btnPlay);
        panel.add(this.btnNext);
        panel.add(this.btnPrevious);

        return panel;
    }

    public JButton getBtnChargerCD() {
        return this.btnChargerCD;
    }

    public JButton getBtnStop() {
        return this.btnStop;
    }

    public JButton getBtnPlay() {
        return this.btnPlay;
    }

    public JButton getBtnNext() {
        return this.btnNext;
    }

    public JButton getBtnPrevious() {
        return this.btnPrevious;
    }

    public void setBtnChargerCD() {
        if (this.lecteurCD.estCharge()) {
            this.btnChargerCD.setText("Retirer le CD - ON");
        } else {
            this.btnChargerCD.setText("Charger le CD - OFF");
        }
    }

    public void setTxtTempsTotal(String tempsTotal) {
        this.txtTempsTotal.setText(tempsTotal);
    }

    public void setTxtNbPlages(String nbPlages) {
        this.txtNbPlages.setText(nbPlages);
    }

    public void setTxtPlageCourante(String plageCourante) {
        this.txtPlageCourante.setText(plageCourante);
    }

    public void setTxtInfoPlageCourante(String infoPlageCourante) {
        this.txtInfoPlageCourante.setText(infoPlageCourante);
    }

    public void setTxtDureePlageCourante(String dureePlageCourante) {
        this.txtDureePlageCourante.setText(dureePlageCourante);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FrameLecteurCD frameLecteurCD = new FrameLecteurCD("Mon lecteur CD");
        frameLecteurCD.setVisible(true);
    }
}
