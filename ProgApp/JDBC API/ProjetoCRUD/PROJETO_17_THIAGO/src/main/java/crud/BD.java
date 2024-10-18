package crud;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BD {
    public static String DRIVER = "mysql";
    public static String ADDRESS = "localhost";
    public static String PORT = "3306";
    public static String DB_NAME = "papelaria";
    public static String USER = "root";
    public static String USER_PWD = "";
    
    public static Connection getConnection() {
        final String connStr = String.format("jdbc:%s://%s:%s/%s", DRIVER, ADDRESS, PORT, DB_NAME);
        try {
            Connection conn = DriverManager.getConnection(connStr, USER, USER_PWD);
            return conn;
        } catch (SQLException e) {
            System.out.println("Banco de dados inacessível.");
        }
        return null;
    }
    
    
    static public class Caderno {
        public static String TABLE = "caderno";
        
        public static int insert(crud.Caderno... cadernos) {
            String INSERT_TEMPLATE = "(?, ?, ?, ?)";
            String INSERT_STRING;
            
            if (cadernos == null) {
                return 0;
            }
            
            if (cadernos.length == 1) {
                INSERT_STRING = "VALUE " + INSERT_TEMPLATE;
            } else {
                StringBuilder str = new StringBuilder("VALUES ");
                int i;
                for (i = 0; i < cadernos.length; i++) {
                    if (cadernos[i] != null) {
                        str.append(INSERT_TEMPLATE);
                    }
                    
                    if (i + 1 < cadernos.length && cadernos[i+1] != null) {
                        str.append(", ");
                    }
                }
                INSERT_STRING = str.toString();
            }
            
            try {
                Connection conn = BD.getConnection();
                PreparedStatement insert = conn.prepareStatement(String.format("INSERT INTO %s(modelo, paginas, gramatura, ativo) %s", TABLE, INSERT_STRING));
                int i=1;
                for(crud.Caderno c : cadernos) {
                    if (c != null) {
                        insert.setString(i++, c.modelo);
                        insert.setInt(i++, c.paginas);
                        insert.setString(i++, c.gramatura);
                        insert.setBoolean(i++, c.ativo);
                    }
                }
                if (i != 1) {
                    int r = insert.executeUpdate();
                    return r;
                } else {
                    return 0;
                }
            } catch (SQLException e) {
                System.out.println("Insert falhou!");
            }
            return -1;
        }
        
        public static int update(crud.Caderno c) {
            if (c == null || c.id == -1) {
                return 0;
            }
            
            try {
                Connection conn = BD.getConnection();
                PreparedStatement update = conn.prepareStatement(String.format("UPDATE %s set modelo = ?, paginas = ?, gramatura = ?, ativo = ? WHERE id = ?", TABLE));
                update.setString(1, c.modelo);
                update.setInt(2, c.paginas);
                update.setString(3, c.gramatura);
                update.setBoolean(4, c.ativo);
                update.setInt(5, c.id);
                
                return update.executeUpdate();
            } catch (SQLException e) {
                System.out.print("Erro de update!");
            }
            return -1;
        }
        
        public static int delete(crud.Caderno c) {
            if (c == null || c.id == -1) {
                return 0;
            }
            
            try {
                Connection conn = BD.getConnection();
                PreparedStatement update = conn.prepareStatement(String.format("DELETE FROM %s WHERE id = ?", TABLE));
                update.setInt(1, c.id);
                
                return update.executeUpdate();
            } catch (SQLException e) {
                System.out.print("Erro de delete!");
            }
            return -1;
        }
        
        public static crud.Caderno[] selectAll() {
            try {
                Connection conn = BD.getConnection();
                PreparedStatement select = conn.prepareStatement(String.format("SELECT id, modelo, paginas, gramatura, ativo FROM %s", TABLE));
                
                return parse(select.executeQuery());
            } catch (SQLException e) {
                System.out.print("Erro de select!");
            } catch (IllegalArgumentsException exs) {
                JOptionPane.showMessageDialog(null, "Caderno inválido recebido pelo banco!");
            } 
            return null;
        }
        
        public static crud.Caderno selectById(int id) {
            if (id < 1) {
                return null;
            }
            
            try {
                Connection conn = BD.getConnection();
                PreparedStatement select = conn.prepareStatement(String.format("SELECT id, modelo, paginas, gramatura, ativo FROM %s WHERE id = ?", TABLE));
                
                select.setInt(1, id);
                
                crud.Caderno[] cadernos = parse(select.executeQuery());
                
                if (cadernos != null) {
                    return cadernos[0];
                }
                
                return null;
            } catch (SQLException e) {
                System.out.print("Erro de select!");
            } catch (IllegalArgumentsException exs) {
                JOptionPane.showMessageDialog(null, "Caderno inválido recebido pelo banco!");
            } 
            return null;
        }
        
        public static crud.Caderno[] parse(ResultSet rs) throws IllegalArgumentsException {
            ArrayList<crud.Caderno> cList = new ArrayList<crud.Caderno>();
            try {
                while(rs.next()) {
                    crud.Caderno c;
                    String modelo;
                    int id, paginas;
                    boolean ativo;
                    Gramatura gramatura = null;
                    
                    id = rs.getInt("id");
                    modelo = rs.getString("modelo");
                    paginas = rs.getInt("paginas");
                    String gramaturaStr = rs.getString("gramatura");
                    
                    Gramatura[] values = Gramatura.values();
                    for (int i=0; i < values.length; i++) {
                        if (gramaturaStr.equals(values[i].valor)) {
                            gramatura = values[i];
                        }
                    }
                    
                    ativo = rs.getBoolean("ativo");
                    c = new crud.Caderno(id, modelo, paginas, gramatura, ativo);
                    cList.add(c);
                }
            } catch (SQLException e) {
                System.out.print("Erro de parse!");
            }
            
            if (cList.size() != 0) {
                crud.Caderno[] cadernos = new crud.Caderno[cList.size()];
                cList.toArray(cadernos);
                
                return cadernos;
            }
            
            return null;
        }
    }
}
