package thiago.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

public class Receber {
    public static Cliente lastCliente() {
        int id;
        String nome, sexo, telefone;
        
        Connection conn;
        conn = BD.getConnection();
        
        if (conn == null) {
            return null;
        }
        PreparedStatement select;
        try {
            select = conn.prepareStatement(
                "SELECT id, nome, sexo, telefone FROM cliente ORDER BY id DESC LIMIT 1"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao buscar cliente", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        ResultSet rs;
        Cliente cl;
        try {
            rs = select.executeQuery();
            rs.next();
            
            id = rs.getInt(1);
            nome = rs.getString(2);
            sexo = rs.getString(3);
            telefone = rs.getString(4);
            
            select.close();
            conn.close();
            
            cl = new Cliente(nome, sexo, telefone);
            cl.setId(id);
            
            return cl;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao receber cliente", JOptionPane.ERROR_MESSAGE);  
        }
        
        return null;
    }

    public static Cliente cliente(int id) {
        try {
            Connection conn = BD.getConnection();
            PreparedStatement query = conn.prepareStatement("SELECT id, nome, sexo, telefone FROM cliente WHERE id = ?");
            query.setString(1, String.valueOf(id).trim());
            
            ResultSet rs = query.executeQuery();
            String nome, telefone, sexo;
            
            rs.next();
            id = rs.getInt(1);
            nome = rs.getString(2);
            sexo = rs.getString(3);
            telefone = rs.getString(4);
            
            Cliente cl = new Cliente(nome, sexo, telefone);
            cl.setId(id);
            
            query.close();
            conn.close();
            return cl;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
