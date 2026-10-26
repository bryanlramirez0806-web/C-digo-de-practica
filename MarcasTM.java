package polizas.Marcas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MarcasTM extends AbstractTableModel {
    protected List<Marcas> marcaslista;
    protected String[] encabezados = {"id", "nombre"};

    public MarcasTM() {
        marcaslista = new ArrayList<>();
        this.setColumnNames(encabezados);
    }

    @Override
    public String getColumnName(int cantidad) {
        return encabezados[cantidad];
    }

    public void setColumnNames(String[] nuevosNombres) {
        if (nuevosNombres.length == encabezados.length) {
            this.encabezados = nuevosNombres;
            fireTableStructureChanged();
        } else {
            throw new IllegalArgumentException("Valide los campos");
        }
    }

    public void vaciarlista() {
        marcaslista.clear();
    }

    @Override
    public int getRowCount() {
        return marcaslista.size();
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex > -1) {
            Marcas m = marcaslista.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return m.getId();
                case 1:
                    return m.getNombre();
                default:
                    return null;
            }
        }
        return null;
    }

    public void addMarca(Marcas m) {
        marcaslista.add(m);
        fireTableRowsInserted(marcaslista.size() - 1, marcaslista.size() - 1);
    }

    public void updateMarca(int fila, Marcas nueva) {
        marcaslista.set(fila, nueva);
        fireTableRowsUpdated(fila, fila);
    }

    public Marcas getMarca(int fila) {
        return marcaslista.get(fila);
    }

    public void removeMarca(int fila) {
        marcaslista.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }

    void llenar(List<Marcas> lista) {
        this.marcaslista = lista;
    }
}