package polizas.Marcas;

import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;

public class MarcasControl {
    private MarcasVista mv;
    private MarcasModelo mm;
    private List<Marcas> lista; 

    public MarcasControl(MarcasVista marcasVista) {
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        marcasEventos();
    }

    public void marcasEventos() {
        
        //Control de Consultar
        mv.btn1.addActionListener(e -> {
            lista = mm.read();
            mv.actualizarVista(lista);
        });
        
        //Control de Agregar
        mv.btn_a.addActionListener(e -> {
            String nombreMarca = mv.txt1.getText();

            if (nombreMarca.trim().isEmpty() || nombreMarca.equals("Marca")) {
                JOptionPane.showMessageDialog(mv, "Por favor, ingresa un nombre válido para la marca.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Object marca = new Marcas(0, nombreMarca);
            int resultado = mm.create(marca);

            if (resultado > 0) {
                JOptionPane.showMessageDialog(mv, "¡Marca agregada correctamente!");
                mv.actualizarVista(mm.read());
            } else {
                JOptionPane.showMessageDialog(mv, "No se pudo agregar la marca.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        //Control de Actualizar
        mv.btnact.addActionListener(e -> {
            try {
                int id = Integer.parseInt(mv.txt2.getText()); 
                String nombre = mv.txt1.getText();           
                Marcas marca = new Marcas(id, nombre);
                
                int resultado = mm.update(marca);
                JOptionPane.showMessageDialog(mv, resultado > 0 ? "Actualizado correctamente" : "No se pudo actualizar");
                mv.actualizarVista(mm.read());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mv, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        //Control de eliminar
        mv.btneli.addActionListener(e -> {
            try {
                int id = Integer.parseInt(mv.txt2.getText());
                Marcas marca = new Marcas(id, "");
                
                int resultado = mm.delete(marca);
                JOptionPane.showMessageDialog(mv, resultado > 0 ? "Eliminado correctamente" : "No se pudo eliminar");
                mv.actualizarVista(mm.read()); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mv, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        //Control de la tabla 
        mv.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int fila = mv.tabla.getSelectedRow();
                if (fila != -1) {
                    System.out.println("Registro: " + mv.marcasModelo.getValueAt(fila, 0));
                    mv.txt1.setText((String) mv.marcasModelo.getValueAt(fila, 1));
                }
            }
        });

        mv.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                int fila = mv.tabla.getSelectedRow();
                if (fila != -1) {
                    System.out.println("Registro Fila: " + fila + " Valor: " + mv.tabla.getValueAt(fila, 1));
                }
            }
        });

        mv.cmbMarcas.addActionListener(e -> {
            Marcas m = (Marcas) mv.cmbMarcas.getSelectedItem(); 
        });
    }
}