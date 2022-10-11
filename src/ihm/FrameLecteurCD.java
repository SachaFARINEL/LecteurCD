package ihm;

import control.MyMouseListener;
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
    private JButton btnStop = new JButton(new ImageIcon("ressources/stop.png"));
    private JButton btnPlay = new JButton(new ImageIcon("ressources/play.png"));
    private JButton btnNext = new JButton(new ImageIcon("ressources/next.png"));
    private JButton btnPrevious = new JButton(new ImageIcon("ressources/previous.png"));

    private JTextField txtTempsTotal = new JTextField("");
    private JTextField txtNbPlages = new JTextField("");
    private JTextField txtPlageCourante = new JTextField("");
    private JTextField txtInfoPlageCourante = new JTextField("");
    private JTextField txtDureePlageCourante = new JTextField("");

    private JLabel labTempsTotal = new JLabel("Temps total");
    private JLabel labNbPlages = new JLabel("Nombre de plages");
    private JLabel labPochetteCD;
    private ImageIcon imgPochetteCD;

    private LecteurCD lecteurCD;


    public FrameLecteurCD(String titre) throws IOException {
        super(titre);
        this.lecteurCD = new LecteurCD();
        miseEnPlace();
    }

    private void miseEnPlace() throws IOException {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("ressources/cd.png")));
        this.setLayout(new GridLayout(2, 1));
        this.add(pochetteView());
        this.add(controlsView());
        addListeners();
    }

    private void addListeners() {
        this.btnChargerCD.addActionListener(new MyMouseListener(this));
        this.btnPlay.addActionListener(new MyMouseListener(this));
        this.btnStop.addActionListener(new MyMouseListener(this));
        this.btnNext.addActionListener(new MyMouseListener(this));
        this.btnPrevious.addActionListener(new MyMouseListener(this));
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
        //todo  Minuteur
        return panel;
    }

    private JPanel chargementCD() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 50, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        panel.add(this.btnChargerCD);
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
        panel.setLayout(new GridLayout(1, 4, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panel.add(this.btnStop);
        panel.add(this.btnPlay);
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

    public JButton getBtnNext() {
        return this.btnNext;
    }

    public JButton getBtnPrevious() {
        return this.btnPrevious;
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
        if (this.getLecteurCD().estCharge()) {
            ImageIcon pochetteCD = new ImageIcon("ressources/" + pathPochette);
            ImageIcon imgPochetteCDResize = new ImageIcon(pochetteCD.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
            this.labPochetteCD.setIcon(imgPochetteCDResize);
        } else {
            this.imgPochetteCD = new ImageIcon("ressources/loading.jpg");
            ImageIcon icon = new ImageIcon(this.imgPochetteCD.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
            this.labPochetteCD.setIcon(icon);
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FrameLecteurCD frameLecteurCD = new FrameLecteurCD("Mon lecteur CD");
        frameLecteurCD.setVisible(true);
    }
}
