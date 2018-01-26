package gui_admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connections.DeleteUser;
//import connections.DeleteUser;
import connections.ReadUser;
import model.User;

public class TablePanel extends JPanel{
	
	private JTable table;
	private JScrollPane Scrol;
	private TableModel produtoTableModel;
	private JPopupMenu popup;
	private User user;
	private UserUpdate userUpdate;
	private DeleteUser deleteUser;
	
	public TablePanel() {
		
		produtoTableModel = new TableModel();
		table = new JTable(produtoTableModel);
		Scrol = new JScrollPane(table);
		popup = new JPopupMenu();
		user = new User();
		
		JMenuItem refreshh = new JMenuItem("Refresh");
		JMenuItem deleteT = new JMenuItem("Delete User");
		popup.add(refreshh);
		popup.add(deleteT);
		
		table.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}

			
			public void mouseClicked(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				if(e.getClickCount() == 2) {

					user = produtoTableModel.getUser(row);
					userUpdate.setUser(user);
					userUpdate.setTurn(true);
				}
			}
			
		});
		
		deleteT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
												
				int row = table.getSelectedRow();
				
				int action = JOptionPane.showConfirmDialog(TablePanel.this, "Do you really want to delete ticket id: "+ produtoTableModel.getRowId(row) + "?", null, JOptionPane.YES_NO_OPTION);
				
				if(action == JOptionPane.YES_OPTION) {
					deleteUser = new DeleteUser(produtoTableModel.getRowId(row));
					refresh();
				}
				
			}
		});
		
		refreshh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			refresh();
		
			}
		});
		
		setLayout(new BorderLayout());
						
		new ReadUser();
		produtoTableModel.setDados(ReadUser.getDados());

		add(Scrol, BorderLayout.CENTER);
		
	}
	
	public void refresh() {
		produtoTableModel.clear();
		new ReadUser();
		produtoTableModel.setDados(ReadUser.getDados());
		produtoTableModel.fireTableDataChanged();
	}
	
	public void addRow(User p) {
		produtoTableModel.addRow(p);
	}

	public void setUserUpdate(UserUpdate userUpdate) {
		this.userUpdate = userUpdate;
	}

}