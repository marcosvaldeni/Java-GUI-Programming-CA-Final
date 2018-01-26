package gui_manager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ticket;

public class TicketClosedTableModel extends AbstractTableModel {

	private long start;
	private long end;
	private long time;
	private List<Ticket> data = new ArrayList<>();
	private String[] col = { "Ticket", "Opened", "Closed", "Time" };

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

		switch (coluna) {
		case 0:
			return data.get(linha).getId();
		case 1:
			this.start = data.get(linha).getOpened();
			Date dateOpened = new Date(this.start * 1000L);
			DateFormat formatOpened = new SimpleDateFormat("HH:mm - dd/MM/yy");
			String formattedOpened = formatOpened.format(dateOpened);
			return formattedOpened;
		case 2:
			this.end = data.get(linha).getClosed();
			Date dateClosed = new Date(this.end * 1000L);
			DateFormat formatClosed = new SimpleDateFormat("HH:mm - dd/MM/yy");
			String formattedClosed = formatClosed.format(dateClosed);
			return formattedClosed;
		case 3:
			this.time = this.end - this.start ;
			Date dateTime = new Date(this.time * 1000L);
			DateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
			String formattedTime = formatTime.format(dateTime);
			return formattedTime;
		}

		return null;

	}

	public void setDados(List<Ticket> dados) {
		this.data = dados;
	}

	public void addRow(Ticket p) {
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