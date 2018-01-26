package gui_admin;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import connections.CloseTicketConnection;
import connections.CreateUser;
import connections.LoginConnection;
import connections.UpdateUser;
import gui_login.LoginEvent;
import gui_login.LoginListener;
import gui_login.LoginPanel;
import model.User;

public class AdminFrame extends JFrame {

	private CreateUser createUser;
	private UserCreate userCreate;
	private UserUpdate userUpdate;
	private UpdateUser updateUser;
	private CloseTicketConnection closeTicketConnection;
	private TablePanel tablePanel;
	private JTabbedPane tabpane;
	private JSplitPane splitePane;
	private User user;

	public AdminFrame() {
		super("Control Ticketing System");
		
		userCreate = new UserCreate();
		userUpdate = new UserUpdate();
		tablePanel = new TablePanel();
		tablePanel.setUserUpdate(userUpdate);
		tabpane = new JTabbedPane();
		splitePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabpane, tablePanel);

		splitePane.setOneTouchExpandable(true);

		tabpane.addTab("Add New User", userCreate);
		tabpane.addTab("Update User", userUpdate);
		
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int action = JOptionPane.showConfirmDialog(AdminFrame.this, "Are you sure you want to exit?", "Control Ticketing System", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(action == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});
		
		this.add(splitePane, BorderLayout.CENTER);


		userUpdate.setUpdateUserListener(new UpdateUserListener() {
			public void updateTicketEventOccurred(UpdateUserEvent e) {

				updateUser = new UpdateUser(e.getId(), e.getName(), e.getUsername(), e.getPass(), e.getType());
				tablePanel.refresh();
			}
		});

		userCreate.setCreateTicketListener(new CreateUserListener() {
			public void createEventOccurred(CreateUserEvent e) {

				createUser = new CreateUser(e.getName(), e.getUsername(), e.getPass(), e.getType());
				tablePanel.refresh();

			}
		});

		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
