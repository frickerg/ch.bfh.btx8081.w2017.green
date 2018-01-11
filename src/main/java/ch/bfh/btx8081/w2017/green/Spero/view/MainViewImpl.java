package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * The class MainViewImpl shows the main view of the Spero-application
 * @author besio1
 */
public class MainViewImpl extends ButtonProvider {
	private Label title;
	public TextField tags;
	public TextArea diaryText;
	public TextField diaryTitle;
	private HorizontalLayout superButtonBox;

	/**
	 * Constructs the main view
	 */
	public MainViewImpl() {

		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		VerticalLayout titleBarBox = new VerticalLayout();
		titleBarBox.addStyleName("titleBarBox");
		title = new Label("Spero");
		title.addStyleName("title");
		titleBarBox.addComponent(title);
		layout.addComponent(titleBarBox);
		

		HorizontalLayout menuAndContent = new HorizontalLayout();
		menuAndContent.setSizeFull();
		menuAndContent.setMargin(true);
		menuAndContent.setSpacing(true);
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout();
		menuBox.setSizeFull();
		menuBox.setMargin(true);
		menuBox.setSpacing(true);
		menuAndContent.addComponent(menuBox);
		
		MenuBar barmenu = new MenuBar();
		barmenu.setAutoOpen(true);
		barmenu.setStyleName("barmenu");

		
		MenuItem mainView = barmenu.addItem("Hauptseite", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.MAIN_VIEW));
		MenuItem reportView = barmenu.addItem("Report", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.REPORT_VIEW));
		MenuItem settingsView = barmenu.addItem("Einstellungen", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.SETTINGS_VIEW));
		MenuItem sosView = barmenu.addItem("SOS", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.SOS_VIEW));
		MenuItem diaryView = barmenu.addItem("Tagebuch", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.DIARY_VIEW));
		MenuItem changePinView = barmenu.addItem("PIN wechseln", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.CHANGE_PIN_VIEW));
		MenuItem reminderView = barmenu.addItem("Erinnerung", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.REMINDER_VIEW));
		MenuItem forgetPasswordView = barmenu.addItem("Passwort vergessen", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.FORGET_PASSWORD_VIEW));
		MenuItem definitionDepressionView = barmenu.addItem("Definitionen", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.DEFINITION_DEPRESSION_VIEW));
		MenuItem medicationInformationView = barmenu.addItem("Infos zu Medikamenten", new ThemeResource("menuicons/info.png"),
				MenuItem -> this.navigateTo(Views.MEDICATION_INFORMATION_VIEW));
		menuBox.addComponent(barmenu);
		menuBox.setComponentAlignment(barmenu, Alignment.MIDDLE_LEFT);
		
		
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		HorizontalLayout moodButtonsBox = new HorizontalLayout();
		moodButtonsBox.setSizeFull();
		moodButtonsBox.setMargin(true);
		moodButtonsBox.setSpacing(true);

		moodButtonsBox.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		content.addComponent(moodButtonsBox);

		HorizontalLayout diaryTitleBox = new HorizontalLayout();
		diaryTitleBox.setSizeFull();
		diaryTitleBox.setMargin(true);
		diaryTitleBox.setSpacing(true);
		diaryTitle = new TextField();
		diaryTitle.setPlaceholder("Titel");
		diaryTitle.setSizeFull();
		//diaryTitle.addStyleName("diaryTitlelabel");
		diaryTitleBox.addComponent(diaryTitle);
		content.addComponent(diaryTitleBox);

		HorizontalLayout diaryTextBox = new HorizontalLayout();
		diaryTextBox.setSizeFull();
		diaryTextBox.setMargin(true);
		diaryTextBox.setSpacing(true);
		diaryText = new TextArea();
		diaryText.setPlaceholder("Text");
		diaryText.setSizeFull();
		diaryText.addStyleName("diaryText");
		diaryTextBox.addComponent(diaryText);
		content.addComponent(diaryTextBox);
		
		HorizontalLayout tagsBox = new HorizontalLayout();
		tagsBox.setSizeFull();
		tagsBox.setMargin(true);
		tagsBox.setSpacing(true);
		tags = new TextField();
		tags.setPlaceholder("tags");
		tags.setSizeFull();
		tags.addStyleName("tags");
		tagsBox.addComponent(tags);
		content.addComponent(tagsBox);
		

		HorizontalLayout confirmButtonBox = new HorizontalLayout();
		confirmButtonBox.setSizeFull();
		confirmButtonBox.setMargin(true);
		confirmButtonBox.setSpacing(true);
		confirmButtonBox.addComponents(confirmButton);
		content.addComponent(confirmButtonBox);

		superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		superButtonBox.addComponents(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
		}
	
	
	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
	}
	
	private void navigateTo(String view) {
		UI.getCurrent().getNavigator().navigateTo(view);
}
}
