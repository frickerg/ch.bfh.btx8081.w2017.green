package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.DefDepressionView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class DefDepressionPresenter implements SperoViewListener{
	
private DefDepressionView view;
	
	public DefDepressionPresenter(DefDepressionView view) {
		this.view = view;
		view.addListener(this);
	}
// test
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "menuButton":
			view.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		case "sosButton":
			view.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		case "chatButton":
			view.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
	}
	}

}