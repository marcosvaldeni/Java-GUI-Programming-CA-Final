package gui_tech;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.time.Instant;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Ticket;

public class TicketUpdate extends JPanel {

	private JLabel clientLabel;
	private JTextField clientField;
	private JLabel descriptionLabel;
	private JTextField descriptionField;
	private JLabel priorityLabel;
	private JButton saveBtn;
	private JButton cancelBtn;
	private JButton closeBtn;
	private UpdateTicketListener updateTicketListener;
	private CloseTicketListener closeTicketListener;
	private int ticket_id;
	private JComboBox empCombo;

	public TicketUpdate() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setMinimumSize(dim);

		clientLabel = new JLabel("Client: ");
		clientField = new JTextField(10);
		descriptionLabel = new JLabel("Description: ");
		descriptionField = new JTextField(10);
		priorityLabel = new JLabel("Priority: ");
		saveBtn = new JButton("Save");
		cancelBtn = new JButton("Cancel");
		closeBtn = new JButton("Quit");
		empCombo = new JComboBox();

		// Set up combo box
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("Normal");
		empModel.addElement("Longterm");
		empModel.addElement("Urgent");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);

		this.setTurn(false);

		saveBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				if (checkSpaces(clientField.getText()) && checkSpaces(descriptionField.getText())) {

					if (checkNumber(clientField.getText())) {


						int client = Integer.parseInt(clientField.getText());
						String description = descriptionField.getText();
						String priority = (String) empCombo.getSelectedItem();

						UpdateTicketEvent ev = new UpdateTicketEvent(this, ticket_id, client, description, priority);

						if (updateTicketListener != null) {
							updateTicketListener.updateTicketEventOccurred(ev);
						}

						descriptionField.setText("");
						clientField.setText("");
						setTurn(false);


					} else {
						JOptionPane.showConfirmDialog(TicketUpdate.this,
								"Field Client must be filled ONLY with numbers!", "Diferent type",
								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showConfirmDialog(TicketUpdate.this,
							"Some field could be empty, please check your dates.", "Empty Fields",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}


			}
		});

		closeBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				CloseTicketEvent ev = new CloseTicketEvent(this, ticket_id);

				if (closeTicketListener != null) {
					closeTicketListener.closeTicketEventOccurred(ev);
				}

				descriptionField.setText("");
				clientField.setText("");
				setTurn(false);
			}
		});

		cancelBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				descriptionField.setText("");
				clientField.setText("");
				setTurn(false);
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Ticket:");
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
		gc.weighty = 1.25;

		gc.gridy++;

		gc.gridx = 0;

		gc.anchor = GridBagConstraints.BASELINE;
		add(saveBtn, gc);

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.BASELINE;
		add(cancelBtn, gc);

		// Next ROW................

		gc.weightx = 1;
		gc.weighty = 0.25;

		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(closeBtn, gc);

		// Next ROW................
	}

	public void setUpdateTicketListener(UpdateTicketListener listener) {
		this.updateTicketListener = listener;
	}

	public void setCloseTicketListener(CloseTicketListener listener) {
		this.closeTicketListener = listener;
	}

	public void setTicket(Ticket ticket) {
		this.setTicket_id(ticket.getId());
		clientField.setText(String.valueOf(ticket.getId()));
		descriptionField.setText(ticket.getDescription());

		switch (ticket.getSev()) {
		case "Normal":
			empCombo.setSelectedIndex(0);
			break;
		case "Longterm":
			empCombo.setSelectedIndex(1);
			break;
		case "Urgent":
			empCombo.setSelectedIndex(2);
			break;
		}
	}

	public void setTurn(boolean enable) {
		clientField.setEnabled(enable);
		descriptionField.setEnabled(enable);
		empCombo.setEnabled(enable);
		saveBtn.setEnabled(enable);
		cancelBtn.setEnabled(enable);
		closeBtn.setEnabled(enable);
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
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