package gui_login;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connections.LoginConnection;
import gui_admin.AdminFrame;
import gui_manager.ManagerFrame;
import gui_tech.TechFrame;
import model.User;

public class LoginFrame extends JFrame {

	private LoginPanel loginPanel;
	private User user;
	private LoginConnection loginConnection;

	public LoginFrame() {
		super("Control Ticketing System");

		loginPanel = new LoginPanel();

		setLayout(new BorderLayout());

		add(loginPanel);

		loginPanel.setLoginListener(new LoginListener() {
			public void loginEventOccurred(LoginEvent e) {

				loginConnection = new LoginConnection(e.getLogin(), e.getPass());
				user = loginConnection.getUser();
				
				switch(user.getType()) {
				case 1:
					
					new AdminFrame();
					dispose();
					
					break;
				case 2:
					
					new ManagerFrame();
					dispose();
					
					break;
				case 3:
					
					new TechFrame();
					dispose();
					
					break;
				default:
					
					JOptionPane.showConfirmDialog(LoginFrame.this, "Access denied.", "Error!",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					
					break;
				}
				
			}
		});

		this.pack();
		this.setSize(394, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
