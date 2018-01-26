package gui_admin;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.User;

public class TableModel extends AbstractTableModel{

    private List<User> data = new ArrayList<>();
    private String[] col = {"id","Name","Username","Type"};

    @Override
    public String getColumnName(int column) {
        return col[column]; 
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
    	return false;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return data.get(linha).getId();
            case 1:
                return data.get(linha).getName();
            case 2:
                return data.get(linha).getLogin();
            case 3: 
            	
            	String type = "";
            	switch(data.get(linha).getType()) {
            	case 1:
            		type = "Admin";
            		break;
            	case 2:
            		type = "Manager";
            		break;
            	case 3:
            		type = "Tech";
            		break;
            	}
            	
                return type;
        }
        
        return null;
        
    }
        
    public void setDados(List<User> dados) {
		this.data = dados;
	}

	public void addRow(User p){
        this.data.add(p);
        this.fireTableDataChanged();
    }
    
    
    public User getUser(int row) {
    	return data.get(row);
    }
    
    public void clear() {
    	data.clear();
    }
    
    public int getRowId(int row) {
    	return data.get(row).getId();
    }
    

        
}