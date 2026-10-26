package polizas;

import polizas.General.Bienvenida;
import javax.swing.SwingUtilities;
import polizas.General.Controlador;

class Inicio {
    private Controlador controlador;
    private Bienvenida vista;

    public Inicio() {
        vista = new Bienvenida();
        controlador = new Controlador(vista);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inicio::new);
    }
}