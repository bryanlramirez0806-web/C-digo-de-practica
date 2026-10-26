package polizas.Marcas;

import polizas.General.Conexion;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MarcasVista extends JPanel {
    protected JButton btn1, btn_a;
    protected JTextField txt1;
    protected JLabel lbl1, lbl2;
    protected JTable tabla;
    protected MarcasTM marcasModelo;
    protected String[] columnas = {"Id", "Nombre"};
    protected JComboBox cmbMarcas;

    public MarcasVista() {
        setLayout(null);
        this.lbl1 = new JLabel("Welcome to Marcas Admin.");
        lbl1.setBounds(350, 5, 150, 30);

        lbl2 = new JLabel("Ingresa tu nombre: ");
        lbl2.setBounds(50, 40, 150, 30);

        this.txt1 = new JTextField("Marca");
        this.txt1.setBounds(170, 40, 250, 30);

        cmbMarcas = new JComboBox();
        cmbMarcas.setBounds(500, 40, 250, 30);
        add(cmbMarcas);

        this.btn1 = new JButton("Consultar");
        this.btn1.setBounds(150, 90, 100, 30);

        this.btn_a = new JButton("Agregar");
        this.btn_a.setBounds(250, 90, 100, 30);
        this.add(btn_a);

        marcasModelo = new MarcasTM();
        tabla = new JTable(marcasModelo);
        marcasModelo.fireTableDataChanged();
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(200, 150, 800, 500);

        this.add(sc, BorderLayout.CENTER);
        this.add(lbl1);
        this.add(lbl2);
        this.add(txt1);
        this.add(btn1);
    }

    public void actualizarVista(List<Marcas> lista) {
        marcasModelo.vaciarlista();
        marcasModelo.fireTableDataChanged();
        marcasModelo.llenar(lista);

        cmbMarcas.removeAllItems();
        for (Marcas m : lista) {
            cmbMarcas.addItem(m);
        }
    }
}