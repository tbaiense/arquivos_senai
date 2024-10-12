package thiago.cadastro;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TabelaClienteModel extends AbstractTableModel {
        String[] columnNames;
        final int colCount;
        ArrayList<Cliente> clientes;
        
        public TabelaClienteModel() {
            columnNames = new String[] {
                "id",
                "nome",
                "sexo",
                "telefone"
            };
            
            colCount = 4;
            clientes = new ArrayList<Cliente>();
        }
        
        public int getColumnCount() {
            return colCount;
        }

        public int getRowCount() {
            return clientes.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            if (col == 0)
                return clientes.get(row).getId();
            else if (col == 1)
                return clientes.get(row).nome;
            else if (col == 2)
                return clientes.get(row).sexo;
            else if (col == 3)
                return clientes.get(row).telefone;
            else
                return null;
        }
        
        public boolean isCellEditable(int row, int col) {
            return false;
        }
        
        public Class<?> getColumnClass(int col) {
            if (col == 0)
                return Integer.class;
            else
                return String.class;
        }
        
        public void addRow(Cliente cliente) {
            clientes.add(cliente);
            fireTableDataChanged();
        }
    }
