package gui_tech;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import connections.CloseTicketConnection;
import connections.CreateTickets;
import connections.LoginConnection;
import connections.UpdateTickets;
import gui_admin.AdminFrame;
import gui_login.LoginEvent;
import gui_login.LoginListener;
import gui_login.LoginPanel;
import model.User;

public class TechFrame extends JFrame {

	private CreateTickets createTicket;
	private TicketCreate ticketCreate;
	private TicketUpdate ticketUpdate;
	private UpdateTickets updateTickets;
	private CloseTicketConnection closeTicketConnection;
	private TablePanel tablePanel;
	private ClosedTablePanel closedTablePanel;
	private JTabbedPane tabpane;
	private JTabbedPane tabpaneII;
	private JSplitPane splitePane;
	private User user;

	public TechFrame() {
		super("Control Ticketing System");
		
		ticketCreate = new TicketCreate();
		ticketUpdate = new TicketUpdate();
		tablePanel = new TablePanel();
		closedTablePanel = new ClosedTablePanel();
		tablePanel.setTicketUpdate(ticketUpdate);
		tabpane = new JTabbedPane();
		tabpaneII = new JTabbedPane();
		
		splitePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabpane, tabpaneII);

		splitePane.setOneTouchExpandable(true);

		tabpane.addTab("Add New Ticket", ticketCreate);
		tabpane.addTab("Edit Ticket", ticketUpdate);
		
		tabpaneII.addTab("Opened Tickets", tablePanel);
		tabpaneII.addTab("Closed Tickets", closedTablePanel);
		
		setLayout(new BorderLayout());
		
		this.add(splitePane, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int action = JOptionPane.showConfirmDialog(TechFrame.this, "Are you sure you want to exit?", "Control Ticketing System", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(action == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});
	

		ticketUpdate.setCloseTicketListener(new CloseTicketListener() {
			public void closeTicketEventOccurred(CloseTicketEvent e) {

				closeTicketConnection = new CloseTicketConnection(e.getTicket_id());
				tablePanel.refresh();
				closedTablePanel.refresh();
			}
		});

		ticketUpdate.setUpdateTicketListener(new UpdateTicketListener() {
			public void updateTicketEventOccurred(UpdateTicketEvent e) {

				updateTickets = new UpdateTickets(e.getId(), e.getClient(), e.getDescription(), e.getService());
				tablePanel.refresh();

			}
		});

		ticketCreate.setCreateTicketListener(new CreateTicketListener() {
			public void createEventOccurred(CreateTicketEvent e) {

				createTicket = new CreateTickets(e.getClient(), e.getDescription(), e.getService());
				tablePanel.refresh();

			}
		});

		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
