package ihm;

import control.MyMouseListener;
import datas.LecteurCD;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FrameLecteurCD extends JFrame {

    private final JButton btnChargerCD = new JButton("Charger le CD - OFF");
    private final JButton btnStop = new JButton(new ImageIcon("ressources/stop.png"));
    private final JButton btnPlay = new JButton(new ImageIcon("ressources/play.png"));
    private final JButton btnNext = new JButton(new ImageIcon("ressources/next.png"));
    private final JButton btnPrevious = new JButton(new ImageIcon("ressources/previous.png"));
    private final JButton btnPause = new JButton(new ImageIcon("ressources/pause.png"));

    private final JTextField txtTempsTotal = new JTextField("");
    private final JTextField txtNbPlages = new JTextField("");
    private final JTextField txtPlageCourante = new JTextField("");
    private final JTextField txtInfoPlageCourante = new JTextField("");
    private final JTextField txtDureePlageCourante = new JTextField("");
    private final JTextField txtChronometre = new JTextField("");
    private final JTextField txtAlbum = new JTextField("");

    private final JLabel labTempsTotal = new JLabel("Temps total");
    private final JLabel labNbPlages = new JLabel("Nombre de plages");
    private JLabel labPochetteCD;


    private ImageIcon imgPochetteCD;
    private LecteurCD lecteurCD;
    private javax.swing.Timer chrono;


    public FrameLecteurCD(String titre) throws IOException {
        super(titre);
        this.lecteurCD = new LecteurCD();
        miseEnPlaceDuDecor();
        addListeners();
    }

    private void miseEnPlaceDuDecor() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("ressources/cd.png")));
        this.setLayout(new GridLayout(2, 1));
        this.add(pochetteView());
        this.add(controlsView());
    }

    private void addListeners() {
        MyMouseListener myMouseListener = new MyMouseListener(this);
        this.btnChargerCD.addActionListener(myMouseListener);
        this.btnPlay.addActionListener(myMouseListener);
        this.btnStop.addActionListener(myMouseListener);
        this.btnPause.addActionListener(myMouseListener);
        this.btnNext.addActionListener(myMouseListener);
        this.btnPrevious.addActionListener(myMouseListener);
        this.chrono = new Timer(1000, myMouseListener);
    }

    private JPanel controlsView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(chargementCD());
        panel.add(CDInformation());
        panel.add(plageInformation());
        panel.add(menulecteur());
        return panel;
    }

    private JPanel pochetteView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        this.imgPochetteCD = new ImageIcon("ressources/loading.jpg");
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        ImageIcon imgPochetteCDResize = new ImageIcon(this.imgPochetteCD.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
        this.labPochetteCD = new JLabel(imgPochetteCDResize);
        panel.add(this.labPochetteCD);
        return panel;
    }

    private JPanel chargementCD() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        panel.add(chronometre());
        panel.add(chargerAlbum());

        return panel;
    }

    private JPanel chronometre() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
        this.txtChronometre.setEditable(false);
        this.txtChronometre.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.txtChronometre);
        return panel;
    }

    private JPanel chargerAlbum() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(this.btnChargerCD);
        this.txtAlbum.setEditable(false);
        this.txtAlbum.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.txtAlbum);
        return panel;
    }

    private JPanel CDInformation() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        this.labTempsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.labTempsTotal);
        this.txtTempsTotal.setEditable(false);
        this.txtTempsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.txtTempsTotal);

        this.labNbPlages.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.labNbPlages);
        this.txtNbPlages.setEditable(false);
        this.txtNbPlages.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.txtNbPlages);

        return panel;
    }

    private JPanel plageInformation() {
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
        panel.setLayout(new GridLayout(1, 5, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panel.add(this.btnStop);
        panel.add(this.btnPlay);
        panel.add(this.btnPause);
        panel.add(this.btnNext);
        panel.add(this.btnPrevious);
        return panel;
    }

    public LecteurCD getLecteurCD() {
        return this.lecteurCD;
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

    public JButton getBtnPause() {
        return this.btnPause;
    }

    public JButton getBtnNext() {
        return this.btnNext;
    }

    public JButton getBtnPrevious() {
        return this.btnPrevious;
    }

    public Timer getChrono() {
        return this.chrono;
    }

    public void setBtnChargerCD() {
        if (this.lecteurCD.estCharge()) {
            this.btnChargerCD.setText("Retirer le CD");
        } else {
            this.btnChargerCD.setText("Charger le CD");
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

    public void setImgPochetteCD(String pathPochette) {
        int width = 400;

        if (this.getLecteurCD().estCharge()) {
            this.imgPochetteCD = new ImageIcon("ressources/" + pathPochette);
        } else {
            this.imgPochetteCD = new ImageIcon("ressources/loading.jpg");
            width = 600;
        }

        ImageIcon imgPochetteCDResize = new ImageIcon(this.imgPochetteCD.getImage().getScaledInstance(width, 400, Image.SCALE_DEFAULT));
        this.labPochetteCD.setIcon(imgPochetteCDResize);
    }

    public void setTxtChronometre(String tempsRestant) {
        this.txtChronometre.setText(tempsRestant);
    }

    public void setTxtAlbum(String informationsAlbum) {
        this.txtAlbum.setText(informationsAlbum);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FrameLecteurCD frameLecteurCD = new FrameLecteurCD("Mon lecteur CD");
        frameLecteurCD.setVisible(true);
    }
}
