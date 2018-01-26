package gui_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import connections.TicketDetailTableConnection;
import connections.UserDetailTableConnection;
import model.Ticket;
import model.User;

public class DetailTablePanel extends JPanel {

	private JPanel northPanel;
	private JPanel southPanel;

	private JTable ticketDetailtable;
	private JTable usertDetailtable;
	private JScrollPane ticketDetailScrol;
	private JScrollPane userDetailScrol;
	private TicketClosedTableModel ticketDetailTableModel;
	private UserDetailTableModel userDetailTableModel;
	private JPopupMenu popup;
	private JPopupMenu userPopup;
	private Ticket ticket;//deletar
	private User user;//Deletar
	private JSplitPane splitePane;
	private JTabbedPane tabpane;


	public DetailTablePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setMinimumSize(dim);


		northPanel = new JPanel();
		southPanel = new JPanel();
		tabpane = new JTabbedPane();
		
		//tabpane.addTab("Tickets Opened", );

		splitePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,northPanel,southPanel);

		// --------------Tickets Details Table---------------------
		this.north();
		//--
		
		// --------------User Details Table---------------------
		this.south();
		//--
		
		northPanel.setLayout(new BorderLayout());
		northPanel.add(ticketDetailScrol, BorderLayout.CENTER);

		southPanel.setLayout(new BorderLayout());
		southPanel.add(userDetailScrol, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		
		splitePane.setResizeWeight(0.5);

		add(splitePane, BorderLayout.CENTER);

	}

	public void northSecond() {
		
		ticketDetailTableModel = new TicketClosedTableModel();
		ticketDetailtable = new JTable(ticketDetailTableModel);
		ticketDetailScrol = new JScrollPane(ticketDetailtable);
		popup = new JPopupMenu();

		JMenuItem openInfo = new JMenuItem("Info");
		popup.add(openInfo);

		ticketDetailtable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = ticketDetailtable.rowAtPoint(e.getPoint());

				ticketDetailtable.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(ticketDetailtable, e.getX(), e.getY());
				}
			}
		});

		new TicketDetailTableConnection();
		ticketDetailTableModel.setDados(TicketDetailTableConnection.getDados());
	}
	
	public void north() {
		
		ticketDetailTableModel = new TicketClosedTableModel();
		ticketDetailtable = new JTable(ticketDetailTableModel);
		ticketDetailScrol = new JScrollPane(ticketDetailtable);
		popup = new JPopupMenu();

		JMenuItem openInfo = new JMenuItem("Info");
		popup.add(openInfo);

		ticketDetailtable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = ticketDetailtable.rowAtPoint(e.getPoint());

				ticketDetailtable.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(ticketDetailtable, e.getX(), e.getY());
				}
			}
		});

		new TicketDetailTableConnection();
		ticketDetailTableModel.setDados(TicketDetailTableConnection.getDados());
	}

	public void south() {
		
		userDetailTableModel = new UserDetailTableModel();
		usertDetailtable = new JTable(userDetailTableModel);
		userDetailScrol = new JScrollPane(usertDetailtable);
		userPopup = new JPopupMenu();

		JMenuItem userOpenInfo = new JMenuItem("Info");
		userPopup.add(userOpenInfo);

		usertDetailtable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = usertDetailtable.rowAtPoint(e.getPoint());

				usertDetailtable.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					userPopup.show(usertDetailtable, e.getX(), e.getY());
				}
			}
		});

		new UserDetailTableConnection();
		userDetailTableModel.setDados(UserDetailTableConnection.getDados());
		
	}

	public void refresh() {
		userDetailTableModel.clear();
		new TicketDetailTableConnection();
		userDetailTableModel.setDados(UserDetailTableConnection.getDados());
		userDetailTableModel.fireTableDataChanged();
	}

	public void addRow(User p) {
		userDetailTableModel.addRow(p);
	}

}