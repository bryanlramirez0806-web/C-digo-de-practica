package polizas.General;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

public class Bienvenida extends JFrame {
    protected JMenuBar mb;
    protected JMenu mA, mBD;
    protected JMenuItem home;
    protected JMenuItem m_a, m_b_o, mensaje, marcas, personas;
    protected CardLayout cl;
    protected JPanel pi, ps, pd, pc;

    public Bienvenida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBackground(Color.yellow);
        this.menu();

        // Panel izquierdo
        pi = new JPanel();
        pi.setBackground(new Color(30, 30, 30));
        JLabel lblIzq = new JLabel("Panel izquierdo");
        lblIzq.setForeground(Color.white);      
        pi.add(lblIzq);
        pi.setPreferredSize(new Dimension(200, getHeight()));

        // Panel Superior 
        ps = new JPanel();
        ps.setBackground(new Color(20, 40, 80)); 
        JLabel titulo = new JLabel("Sistema de Gestión...");
        titulo.setForeground(Color.white);
        Font fuente = new Font("Arial", Font.BOLD, 18);
        titulo.setFont(fuente);
        ps.add(titulo);

        cl = new CardLayout();
        pc = new JPanel(cl);
        pc.setBackground(new Color(40, 40, 40)); 
        
        JLabel lblWelcome = new JLabel("Welcome to Java ...");
        lblWelcome.setForeground(Color.white);  
        pc.add(lblWelcome, "home");
        
        pc.add(new Mensaje(), "mensaje");

        // Panel derecho
        pd = new JPanel();
        pd.setBackground(new Color(30, 30, 30)); 
        JLabel lblDer = new JLabel("Panel derecho");
        lblDer.setForeground(Color.white);       
        pd.add(lblDer);
        pd.setPreferredSize(new Dimension(200, getHeight()));
        
        this.setLayout(new BorderLayout());
        this.add(pi, BorderLayout.WEST);
        this.add(pd, BorderLayout.EAST);
        this.add(ps, BorderLayout.NORTH);
        this.add(pc, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void menu() {
        this.mb = new JMenuBar();
        this.setJMenuBar(mb);
        this.mA = new JMenu("Archivo");
        home = new JMenuItem("Home");
        this.mA.add(home);
        this.mensaje = new JMenuItem("Mensaje");
        this.mA.add(mensaje);

        this.mBD = new JMenu("Base de Datos");
        marcas = new JMenuItem("Marcas");
        mBD.add(marcas);

        this.mb.add(mA);
        this.mb.add(mBD);
    }
}