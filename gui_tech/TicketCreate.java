package gui_tech;

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

public class TicketCreate extends JPanel {

	private JLabel clientLabel;
	private JTextField clientField;
	private JLabel descriptionLabel;
	private JTextField descriptionField;
	private JLabel priorityLabel;
	private JButton okBtn;
	private CreateTicketListener createTicketListener;
	private JComboBox empCombo;

	public TicketCreate() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setMinimumSize(dim);

		clientLabel = new JLabel("Client: ");
		clientField = new JTextField(10);
		descriptionLabel = new JLabel("Description: ");
		descriptionField = new JTextField(10);
		priorityLabel = new JLabel("Priority:  ");
		okBtn = new JButton("OK");
		empCombo = new JComboBox();

		// Set up combo box
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("Normal");
		empModel.addElement("Longterm");
		empModel.addElement("Urgent");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);

		okBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				if (checkSpaces(clientField.getText()) && checkSpaces(descriptionField.getText())) {

					if (checkNumber(clientField.getText())) {

						int client = Integer.parseInt(clientField.getText());
						String description = descriptionField.getText();
						String priority = (String) empCombo.getSelectedItem();

						CreateTicketEvent ev = new CreateTicketEvent(this, client, description, priority);

						if (createTicketListener != null) {
							createTicketListener.createEventOccurred(ev);
						}
						clearFields();

					} else {
						JOptionPane.showConfirmDialog(TicketCreate.this,
								"Field Client must be filled ONLY with numbers!", "Diferent type",
								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showConfirmDialog(TicketCreate.this,
							"Some field could be empty, please check your dates.", "Empty Fields",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Ticket:");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
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
		add(clientLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(clientField, gc);

		// Next ROW................
		gc.weightx = 1;
		gc.weighty = 1.25;

		gc.gridy++;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(descriptionLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(descriptionField, gc);

		// Next ROW................
		gc.weightx = 1;
		gc.weighty = 1.25;

		gc.gridy++;

		gc.gridx = 0;

		gc.anchor = GridBagConstraints.LINE_END;
		add(priorityLabel, gc);

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.LINE_START;
		add(empCombo, gc);

		// Next ROW................
		gc.weightx = 1;
		gc.weighty = 0.25;

		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

		// Next ROW................
	}

	public void setCreateTicketListener(CreateTicketListener listener) {
		this.createTicketListener = listener;
	}

	public void clearFields() {
		descriptionField.setText("");
		clientField.setText("");
	}

	public boolean checkSpaces(String str) {

		boolean check;

		int letterCount = 0;
		int spaceCount = 0;
		for (char c : str.toCharArray()) {
			if (c == ' ') {
				spaceCount++;
			} else {
				letterCount++;
			}
		}

		if (spaceCount >= letterCount) {
			check = false;
		} else {
			check = true;
		}

		return check;
	}

	public boolean checkNumber(String str) {

		boolean check;

		if (str.matches("[0-9]+")) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

}