package gui_admin;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Ticket;

public class UserCreate extends JPanel{
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel typeLabel;
	private JTextField typeField;
	private JLabel passLabel;
	private JTextField passField;
	private JButton saveBtn;
	private JButton cancelBtn;
	private CreateUserListener createTicketListener;
	private JComboBox empCombo;
		
	public UserCreate() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setMinimumSize(dim);
		
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(10);
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(10);
		typeLabel = new JLabel("Type: ");
		typeField = new JTextField(10);
		passLabel = new JLabel("Password: ");
		passField = new JTextField(10);
		saveBtn = new JButton("Save");
		cancelBtn = new JButton("Cancel");
		empCombo = new JComboBox();
		
		// Set up combo box
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("Admin");
		empModel.addElement("Manager");
		empModel.addElement("Tech");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(2);
		
		saveBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkSpaces(nameField.getText()) && checkSpaces(usernameField.getText()) && checkSpaces(passField.getText())) {
					
					String name = nameField.getText();
					String username = usernameField.getText();
					String pass = passField.getText();
					int type = empCombo.getSelectedIndex()+1;
					
					CreateUserEvent ev = new CreateUserEvent(this, name, username, pass, type);
					
					if(createTicketListener != null) {
						createTicketListener.createEventOccurred(ev);
					}
					clearFields();
					
				}else {
					JOptionPane.showConfirmDialog(UserCreate.this, "Some field could be empty, please check yours dates.", "Empty Fields", JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add new user:");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//////////// Next row ///////////////////////////////////////
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);

		//////////// Next row ///////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(usernameLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(usernameField, gc);

		//////////// Next row ///////////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(typeLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc);

		//////////// Next row ///////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(passLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passField, gc);

		//////////// Next row ///////////////////////////////////////


		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.BASELINE;
		gc.insets = new Insets(0, 0, 0, 5);
		add(saveBtn, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.BASELINE;
		gc.insets = new Insets(0, 0, 0, 0);
		add(cancelBtn, gc);

		//////////// Next row ///////////////////////////////////////
	}
	public void setCreateTicketListener(CreateUserListener listener) {
		this.createTicketListener = listener;
	}
	
	public void clearFields() {
		nameField.setText("");
		usernameField.setText("");
		passField.setText("");
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