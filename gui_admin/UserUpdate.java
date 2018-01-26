package gui_admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.time.Instant;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.User;

public class UserUpdate extends JPanel {

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
	private UpdateUserListener updateUserListener;
	private int user_id;
	private JComboBox empCombo;

	public UserUpdate() {
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

		this.setTurn(false);

		saveBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				String name = nameField.getText();
				String username = usernameField.getText();
				int type = empCombo.getSelectedIndex()+1;
				String pass = passField.getText();

				UpdateUserEvent ev = new UpdateUserEvent(this, user_id, name, username, pass, type);

				if (updateUserListener != null) {
					updateUserListener.updateTicketEventOccurred(ev);
				}

				nameField.setText("");
				typeField.setText("");
				passField.setText("");
				usernameField.setText("");
				setTurn(false);
			}
		});

		cancelBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				typeField.setText("");
				passField.setText("");
				usernameField.setText("");
				setTurn(false);
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("User:");
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

	public void setUpdateUserListener(UpdateUserListener listener) {
		this.updateUserListener = listener;
	}

	public void setUser(User user) {
		this.setUser_id(user.getId());
		nameField.setText(user.getName());
		empCombo.setSelectedIndex(user.getType()-1);
		usernameField.setText(user.getLogin());
		passField.setText(user.getPass());
	}

	public void setTurn(boolean enable) {
		nameField.setEnabled(enable);
		typeField.setEnabled(enable);
		passField.setEnabled(enable);
		saveBtn.setEnabled(enable);
		cancelBtn.setEnabled(enable);
		usernameField.setEnabled(enable);
		empCombo.setEnabled(enable);
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}