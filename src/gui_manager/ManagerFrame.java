package gui_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import gui_admin.AdminFrame;


public class ManagerFrame extends JFrame {

	private ManagerPanel managerPanel;
	private DetailTablePanel detailTablePanel;
	private JSplitPane splitePane;

	public ManagerFrame() {
		super("Control Ticketing System");
		
		detailTablePanel = new DetailTablePanel();
		managerPanel = new ManagerPanel();
		splitePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, managerPanel, detailTablePanel);

		splitePane.setOneTouchExpandable(true);

		
		setLayout(new BorderLayout());
		
		this.add(splitePane, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int action = JOptionPane.showConfirmDialog(ManagerFrame.this, "Are you sure you want to exit?", "Control Ticketing System", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(action == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});

		
		setMinimumSize(new Dimension(800, 500));
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
