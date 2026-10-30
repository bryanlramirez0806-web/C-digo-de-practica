package polizas.Marcas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MarcasVista extends JPanel {
    protected JButton btn1, btn_a, btneli, btnact;
    protected JTextField txt1, txt2;
    protected JLabel lbl1, lbl2, lbl3;
    protected JTable tabla;
    protected MarcasTM marcasModelo;
    protected String[] columnas = {"Id", "Nombre"};
    protected JComboBox cmbMarcas;

    public MarcasVista() {
        setLayout(null);
        setBackground(new Color(40, 40, 40)); 

        this.lbl1 = new JLabel("Welcome to Marcas Admin.");
        lbl1.setForeground(Color.white);      
        lbl1.setBounds(350, 5, 150, 30);

        lbl2 = new JLabel("Ingresa tu nombre: ");
        lbl2.setForeground(Color.white);       
        lbl2.setBounds(50, 40, 150, 30);

        lbl3 = new JLabel("Ingresa tu id: ");
        lbl3.setForeground(Color.white);      
        lbl3.setBounds(50, 70, 150, 30);

        this.txt1 = new JTextField("Marca");
        this.txt1.setBounds(170, 40, 250, 30);
        
        this.txt2 = new JTextField("Id");
        this.txt2.setBounds(170, 70, 250, 30);

        cmbMarcas = new JComboBox();
        cmbMarcas.setBounds(500, 40, 250, 30);
        add(cmbMarcas);

        this.btn1 = new JButton("Consultar");
        this.btn1.setBounds(150, 110, 100, 30);

        this.btn_a = new JButton("Agregar");
        this.btn_a.setBounds(250, 110, 100, 30);
        
        this.btneli = new JButton("Eliminar");
        this.btneli.setBounds(350, 110, 100, 30);
        
        this.btnact = new JButton("Actualizar");
        this.btnact.setBounds(450, 110, 100, 30);

        marcasModelo = new MarcasTM();
        tabla = new JTable(marcasModelo);
        marcasModelo.fireTableDataChanged();
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(200, 150, 800, 500);

        this.add(sc, BorderLayout.CENTER);
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.add(txt1);
        this.add(txt2);
        this.add(btn1);
        this.add(btn_a);
        this.add(btneli);
        this.add(btnact);
    }

    public void actualizarVista(List<Marcas> lista) {
    marcasModelo.vaciarlista();
    marcasModelo.llenar(lista);
    marcasModelo.fireTableDataChanged(); 

    cmbMarcas.removeAllItems();
        for (Marcas m : lista) {
            cmbMarcas.addItem(m);
        }
    }
}