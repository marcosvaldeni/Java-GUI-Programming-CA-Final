import javax.swing.SwingUtilities;

import gui_login.LoginFrame;
import gui_manager.ManagerFrame;
import gui_tech.TechFrame;
import gui_admin.AdminFrame;

public class App {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TechFrame();
			}
		});
	} 
}
