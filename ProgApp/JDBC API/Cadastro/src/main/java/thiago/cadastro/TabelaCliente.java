package thiago.cadastro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TabelaCliente extends JPanel {
    private boolean DEBUG = false;
    public TabelaCliente() {
        super(new GridLayout(1, 0));
        
        
        final JTable clientes = new JTable(new TabelaClienteModel());
        clientes.setPreferredScrollableViewportSize(new Dimension(400, 100));
        clientes.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(clientes);
        this.add(scrollPane);
    }
    
    class TabelaClienteModel extends AbstractTableModel {
        String[] columnNames = {
            "id",
            "nome",
            "sexo",
            "telefone"
        };
                
                
        Object[][] data = {
            {new Integer(0), "Thiago", "M", "1234-5678"},
            {new Integer(1), "Maria", "F", "9876-5432"}
        };
        
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tabela clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TabelaCliente tb = new TabelaCliente();
        tb.setOpaque(true);
        frame.setContentPane(tb);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(TabelaCliente::createAndShowGUI);
    }
}
