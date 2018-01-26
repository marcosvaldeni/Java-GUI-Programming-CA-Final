package gui_tech;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ticket;

public class TableModel extends AbstractTableModel{

    private List<Ticket> data = new ArrayList<>();
    private String[] col = {"Ticket","Client ID","Description","Priority","Opened"};

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
                return data.get(linha).getClientId();
            case 2:
                return data.get(linha).getDescription();
            case 3: 
                return data.get(linha).getSev();
            case 4: 
      		  Date date = new Date(data.get(linha).getOpened() * 1000L);
    		  DateFormat format = new SimpleDateFormat("HH:mm - dd/MM/yy");
    		  String formatted = format.format(date);
                return formatted;
        }
        
        return null;
        
    }
        
    public void setDados(List<Ticket> dados) {
		this.data = dados;
	}

	public void addRow(Ticket p){
        this.data.add(p);
        this.fireTableDataChanged();
    }
    
    
    public Ticket getTicket(int row) {
    	return data.get(row);
    }
    
    public void clear() {
    	data.clear();
    }
    
    public int getRowId(int row) {
    	return data.get(row).getId();
    }
    

        
}