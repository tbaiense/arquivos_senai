package thiago.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Cadastro {

    public static void cliente(String nome, String sexo, String telefone) {
        if (nome == null || sexo == null || telefone == null) {
            throw new NullPointerException();
        }
        nome = nome.trim();
        sexo = sexo.trim().substring(0, 1).toUpperCase();
        telefone = telefone.trim();
        
        Connection conn;
        conn = BD.getConnection();
        if (conn == null) {
            return;
        }
        PreparedStatement insert;
        try {
            insert = conn.prepareStatement(
                "INSERT INTO cliente(nome, sexo, telefone) VALUES (?, ?, ?)"
            );
            
            if (insert == null) {
                return;
            }
            
            insert.setString(1, nome);
            insert.setString(2, sexo);
            insert.setString(3, telefone);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha ao preparar Statement", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            insert.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha ao inserir cliente", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro do cliente", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            insert.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha ao fechar o Statement", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha ao fechar a conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}
