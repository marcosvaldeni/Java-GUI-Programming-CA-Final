package gui_tech;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connections.DeleteTickets;
import connections.ReadTicketsClosed;
import model.Ticket;

public class ClosedTablePanel extends JPanel{
	
	private JTable table;
	private JScrollPane Scrol;
	private ClosedTableModel tableModel;
	private Ticket ticket;
	private TicketUpdate ticketUpdate;
	
	public ClosedTablePanel() {
		
		tableModel = new ClosedTableModel();
		table = new JTable(tableModel);
		Scrol = new JScrollPane(table);
		ticket = new Ticket();
					

		
		setLayout(new BorderLayout());
						
		new ReadTicketsClosed();
		tableModel.setDados(ReadTicketsClosed.getDados());

		add(Scrol, BorderLayout.CENTER);
		
	}
	
	public void refresh() {
		tableModel.clear();
		new ReadTicketsClosed();
		tableModel.setDados(ReadTicketsClosed.getDados());
		tableModel.fireTableDataChanged();
	}
	
	public void addRow(Ticket p) {
		tableModel.addRow(p);
	}

	public void setTicketUpdate(TicketUpdate ticketUpdate) {
		this.ticketUpdate = ticketUpdate;
	}

}