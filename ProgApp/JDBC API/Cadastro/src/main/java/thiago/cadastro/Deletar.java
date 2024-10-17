package thiago.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author t.baiense
 */
public class Deletar {
    public static void cliente(Cliente cliente) {
        try {
            Connection conn = BD.getConnection();
            PreparedStatement delete = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            delete.setInt(1, cliente.getId());
            delete.executeUpdate();
            delete.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
}
