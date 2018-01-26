package gui_login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPanel extends JPanel{

	private JLabel loginLabel;
	private JLabel passLabel;
	private JTextField loginField;
	private JPasswordField passField;
	private JButton loginBtn;
	private JButton cancelBtn;
	private LoginListener loginListener;
	
	public LoginPanel() {
			
		loginLabel = new JLabel("Login: ");
		passLabel = new JLabel("Password: ");
		loginField = new JTextField(10);
		passField = new JPasswordField(10);
		
		loginBtn = new JButton("Login");
		
		cancelBtn = new JButton("Cancel");
		
		loginBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkSpaces(loginField.getText()) && checkSpaces(passField.getText())) {
					
					String pass = passField.getText();
					String login = loginField.getText();
					
					LoginEvent ev = new LoginEvent(this, login, pass);
					
					if(loginListener != null) {
						loginListener.loginEventOccurred(ev);
					}
					
					passField.setText("");
					
				}else {
					JOptionPane.showConfirmDialog(LoginPanel.this, "Some field could be empty, please check yours dates.", "Empty Fields", JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		cancelBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Login Area:");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		// Next ROW................
		
		gc.weightx = 1;
		gc.weighty = 1.25;
		
		gc.gridx = 0;
		gc.gridy = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		add(loginLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(loginField, gc);
		
		// Next ROW................
		
		gc.weightx = 1;
		gc.weighty = 1.25;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(passLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passField, gc);
		
		// Next ROW................
		
		gc.weightx = 1;
		gc.weighty = 0.25;
		
		gc.gridy++;
		
		gc.gridx = 0;

		gc.anchor = GridBagConstraints.BASELINE;
		add(loginBtn, gc);
		
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.BASELINE;
		add(cancelBtn, gc);
		
		// Next ROW................
		
	}
	
	public void setLoginListener(LoginListener listener) {
		this.loginListener = listener;
	}
	
	public boolean checkSpaces(String str) {
		
		boolean check;
		
		int letterCount = 0;
		int spaceCount = 0;
		for (char c : str.toCharArray()) {
		    if (c == ' ') {
		         spaceCount++;
		    }else {
		    	letterCount++;
		    }
		}
		
		if(spaceCount >= letterCount) {
			check = false;
		}else {
			check = true;
		}
	
		return check;
	}

}
