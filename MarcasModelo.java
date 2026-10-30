package polizas.Marcas;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import polizas.General.Conexion;
import polizas.General.DAO;

public class MarcasModelo extends Conexion implements DAO {

    MarcasModelo() {
        super();
    }

    //Metodo de Consulta
    @Override
    public List read() {
        List<Marcas> lista = new ArrayList<>();
        try {
            this.conectar();
            ps = cnx.prepareStatement("SELECT * FROM marca");
            rs = ps.executeQuery();
            lista.clear();
            while (rs.next()) {
                lista.add(new Marcas(rs.getInt("idMarca"), rs.getString("nombreMarca")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return lista;
    }

    //Metodo de Agregar
    @Override
    public int create(Object obj) {
        try {
            this.conectar();
            Marcas marcas = (Marcas) obj; 
            ps = cnx.prepareStatement("INSERT INTO marca (nombreMarca) VALUES (?)");
            ps.setString(1, marcas.getNombre());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) { 
                    cnx.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return 0;
    }

    //Metodo de Actualizar
    @Override
    public int update(Object obj) {
        try {
            this.conectar();
            Marcas marcas = (Marcas) obj;
            ps = cnx.prepareStatement("UPDATE marca SET nombreMarca = ? WHERE idMarca = ?");
            ps.setString(1, marcas.getNombre());
            ps.setInt(2, marcas.getId()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return 0;
    }

    //Metodo de eliminar
    @Override
    public int delete(Object obj) {
        try {
            this.conectar();
            Marcas marcas = (Marcas) obj;
            ps = cnx.prepareStatement("DELETE FROM marca WHERE idMarca = ?");
            ps.setInt(1, marcas.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return 0;
    }
}