package thiago.cadastro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TabelaCliente extends JPanel {
    final TabelaClienteModel modelo;
    
    public TabelaCliente() {
        this(new TabelaClienteModel());
    }
    
    public TabelaCliente(TabelaClienteModel modelo) {
        super(new GridLayout(1, 0));
        this.modelo = modelo;
        final JTable clientes = new JTable(modelo);
        clientes.setPreferredScrollableViewportSize(new Dimension(400, 100));
        clientes.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(clientes);
        this.add(scrollPane);
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tabela clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TabelaCliente tb = new TabelaCliente(new TabelaClienteModel());
        tb.setOpaque(true);
        frame.setContentPane(tb);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(TabelaCliente::createAndShowGUI);
    }
}
