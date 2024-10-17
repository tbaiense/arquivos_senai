package crud;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JTable;

public class JPanel_Table_Caderno extends JPanel {
    private JTable table;
    private CadernoTableModel model;
    
    public JPanel_Table_Caderno() {
        super(new GridLayout(1, 0));
        
        CadernoTableModel model = new CadernoTableModel();
        this.model = model;
        
        JTable table = new JTable(model);
        this.table = table;
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        this.add(scrollPane);
    }
    
    public JPanel_Table_Caderno(Caderno... cadernos) {
        this();
        this.getTableModel().fillRows(cadernos);
    }
    
    public CadernoTableModel getTableModel() {
        return this.model;
    }
    
    public JTable getJTable() {
        return this.table;
    }
    
    public static final void test() {
        JFrame frame = new JFrame("Teste de tabela de caderno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel_Table_Caderno jpnl_table = new JPanel_Table_Caderno(BD.Caderno.selectAll());
        jpnl_table.setOpaque(true);
        
        frame.setContentPane(jpnl_table);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            test();
        });
    }
}
