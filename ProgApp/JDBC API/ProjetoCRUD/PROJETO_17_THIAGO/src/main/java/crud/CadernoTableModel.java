package crud;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CadernoTableModel extends AbstractTableModel {
    
    private final String[] COLUMNS = {"id", "modelo", "paginas", "gramatura", "ativo"};
    private final ArrayList<Caderno> data = new ArrayList<Caderno>();
    
    public CadernoTableModel() {}
    
    public CadernoTableModel(Caderno... cadernos) {
        fillRows(cadernos);
    }
    
    public void fillRows(Caderno... cadernos) {
        this.clearRows();
        
        if (cadernos != null) {
            for(Caderno c : cadernos) {
                if (c != null) {
                    data.add(c);
                }
            }
        }
        
        fireTableDataChanged();
    }
    
    public void clearRows() {
        data.clear();
    }
    
    public int getColumnCount() {
        return COLUMNS.length;
    }
    
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col) {
        if (col < 0) {
            throw new IllegalArgumentException();
        }
        
        if (col >= getColumnCount()) {
            return null;
        }
        
        return COLUMNS[col];
    }
    
    public Class<?> getColumnClass(int col) {
        if (col < 0) {
            throw new IllegalArgumentException();
        }
        
        return switch(col) {
            case 0, 2 -> Integer.class;
            case 1, 3 -> String.class;
            case 4 -> Boolean.class;
            default -> String.class;
        };
    }
    
    public Object getValueAt(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
        if (row >= getRowCount() || col >= getColumnCount()) {
            return null;
        }
        
        return switch(col) { // Faz boxing automaticamente! int --> Integer :)
            case 0 -> data.get(row).id;
            case 1 -> data.get(row).modelo;
            case 2 -> data.get(row).paginas;
            case 3 -> data.get(row).gramatura;
            case 4 -> data.get(row).ativo;
            default -> null;
        };
    }
    
    public void addRow(Caderno c) {
        if (c == null) {
            return;
        }
        
        int r = data.size();
        data.add(c);
        super.fireTableRowsInserted(r, r);
    }
    
    public void refresh() {
        fillRows(BD.Caderno.selectAll());
    }
}
