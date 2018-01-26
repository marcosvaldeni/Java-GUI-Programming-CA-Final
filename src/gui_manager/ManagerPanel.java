package gui_manager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import connections.Manager;

public class ManagerPanel extends JPanel{
	
	private Manager manager;
	private int cost;
		
	public ManagerPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setMaximumSize(dim);
		
		manager = new Manager();
		cost = manager.getTicketsTotal()*50;
		
		
		Border innerBorder = BorderFactory.createTitledBorder("Manager View:");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		this.components();

	}
	
	public void components() {
		
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
		add(new JLabel("Total of Tickets:  "), gc);
				
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel(String.valueOf(manager.getTicketsTotal())), gc);	
		
		//////////// Next row ///////////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Total of Tickets Opened:  "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel(String.valueOf(manager.getTicketsOpened())), gc);
						
		//////////// Next row ///////////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Total of Tickets Closed:  "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel(String.valueOf(manager.getTicketsClosed())), gc);
						
		//////////// Next row ///////////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Total of Tech Users:  "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel(String.valueOf(manager.getTechUser())), gc);	
		
		//////////// Next row ///////////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Total Cost So Far:  "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel("€ "+manager.getTicketsTotal()*50), gc);	
		
		//////////// Next row ///////////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel(""), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel(), gc);	
		
		
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