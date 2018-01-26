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
import connections.ReadTickets;
import model.Ticket;

public class TablePanel extends JPanel{
	
	private JTable table;
	private JScrollPane Scrol;
	private TableModel produtoTableModel;
	private JPopupMenu popup;
	private Ticket ticket;
	private TicketUpdate ticketUpdate;
	private DeleteTickets deleteTicket;
	
	public TablePanel() {
		
		produtoTableModel = new TableModel();
		table = new JTable(produtoTableModel);
		Scrol = new JScrollPane(table);
		popup = new JPopupMenu();
		ticket = new Ticket();
		
		
		JMenuItem openInfo = new JMenuItem("Info");
		JMenuItem deleteT = new JMenuItem("Delete Ticket");
		popup.add(openInfo);
		popup.add(deleteT);
		
		table.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
			
			public void mouseClicked(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				if(e.getClickCount() == 2) {

					ticket = produtoTableModel.getTicket(row);
					ticketUpdate.setTicket(ticket);
					ticketUpdate.setTurn(true);
				}
			}
			
		});
		
		deleteT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
												
				int row = table.getSelectedRow();
				
				int action = JOptionPane.showConfirmDialog(TablePanel.this, "Do you really want to delete ticket id: "+ produtoTableModel.getRowId(row) + "?", null, JOptionPane.YES_NO_OPTION);
				
				if(action == JOptionPane.YES_OPTION) {
					deleteTicket = new DeleteTickets(produtoTableModel.getRowId(row));
					refresh();
				}
				
			}
		});
		
		setLayout(new BorderLayout());
						
		new ReadTickets();
		produtoTableModel.setDados(ReadTickets.getDados());

		add(Scrol, BorderLayout.CENTER);
		
	}
	
	public void refresh() {
		produtoTableModel.clear();
		new ReadTickets();
		produtoTableModel.setDados(ReadTickets.getDados());
		produtoTableModel.fireTableDataChanged();
	}
	
	public void addRow(Ticket p) {
		produtoTableModel.addRow(p);
	}

	public void setTicketUpdate(TicketUpdate ticketUpdate) {
		this.ticketUpdate = ticketUpdate;
	}

}