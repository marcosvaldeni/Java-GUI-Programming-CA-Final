package gui_tech;

import java.util.EventObject;

public class MenuEvent extends EventObject {
	
	private boolean status;

	public MenuEvent(Object souce) {
		super(souce);
	}

	public MenuEvent(Object souce, boolean status) {
		super(souce);
		this.status = status;
	}
	
	
		
	
	
}
