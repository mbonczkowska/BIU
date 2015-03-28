package podst;
import javax.servlet.annotation.WebServlet;

import java.util.Date;

import java.text.SimpleDateFormat;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import com.vaadin.data.validator.AbstractValidator;


import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.CssLayout;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import com.vaadin.shared.ui.label.ContentMode;
import java.util.Locale;
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
    public static class Servlet extends VaadinServlet {
    }
    
    public static final String TITLE = "Vaadin Demo App";

    public static final String LOGIN_VIEW = "Login";
    public static final String MAIN_VIEW = "";

    private boolean userLoggedIn = false;
    private String username;
    
    //private Navigator navigator = new Navigator(this,this);
    //private LoginView loginView = new LoginView();
   // private MainView mainView = new MainView();
	
	
	 final class PasswordValidator extends
			AbstractValidator<String> {

		public PasswordValidator() {
			super("The password provided is not valid");
		}
		
		@Override
		protected boolean isValidValue(String value) {
			//
			// Password must be at least 8 characters long and contain at least
			// one number
			//
			if (value != null
					&& (value.length() > 8 || !value.matches(".*\\d.*"))) {
				return false;
			}
			return true;
		}

		@Override
		public Class<String> getType() {
			return String.class;
		}
    }
	
    @Override
    protected void init(VaadinRequest request) {
    
	
	//Panel all = new Panel("");
	//all.setSizeFull();
    VerticalLayout title = new VerticalLayout();
   // all.addComponent(title);
	title.setMargin(true);

   // title.setSizeFull(); 
    setContent(title);   // add title
    title.addComponent(new Label("My blog"));
	
        
    // Layout inside layout
    HorizontalLayout content = new HorizontalLayout();

    title.addComponent(content);
    // Left side

    
    VerticalLayout left = new VerticalLayout();
    content.addComponent(left);
	left.setMargin(true);
	
    FormLayout loginLayout = new FormLayout();
	final TextField usernameField = new TextField("Username");
	usernameField.setRequired(true);
	usernameField.setInputPrompt("Your username (eg. admin)");
	usernameField.setInvalidAllowed(false);
    final PasswordField passwordField = new PasswordField("Password");
	passwordField.addValidator(new PasswordValidator());
	passwordField.setRequired(true);
	final Label feedbackLabel = new Label();
	Button loginButton = new Button("Login");
	
	
	
    
	 
	 loginLayout.addComponent(feedbackLabel);
	 loginLayout.addComponent(usernameField);
	 loginLayout.addComponent(passwordField);
	 loginLayout.addComponent(loginButton);
	 left.addComponent(loginLayout);
	
    final InlineDateField date = new InlineDateField();
    date.setLocale(new Locale("pl", "PL"));
    left.addComponent(date);

        
        
    // Middle
    final VerticalLayout middle = new VerticalLayout();
    content.addComponent(middle);
	middle.setMargin(true);
   
	
    final RichTextArea nNote = new RichTextArea("New note");
	nNote.setValue("Add new note here.");
	Button ok = new Button("OK");
	final Label feedback = new Label((String) nNote.getValue()); 

	 ok.addClickListener(new Button.ClickListener() {
	       public void buttonClick(ClickEvent event) {
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	      Date nowDate = new Date();
	     
		  middle.addComponent(new Label(dateFormat.format(nowDate)));
		  middle.addComponent(new Label(nNote.getValue(),ContentMode.HTML));
		  date.setValue(new java.util.Date());
		 // date.setTime(new Date());
		  }
	 });
	 

 nNote.setWidth("-1px");
     middle.addComponent(nNote);  
     nNote.setVisible(false);
	 middle.addComponent(ok);
	 ok.setVisible(false);
	middle.setWidth("700px"); 


    

	
	
	
	title.setExpandRatio(content, 1); // Expand to fill

        
    // Right
    final VerticalLayout right = new VerticalLayout();
    content.addComponent(right);
    right.setMargin(true);   

        
    final Panel about = new Panel("About Me");
    right.addComponent(about);
    final Label lab = new Label("Hello. My name is...");
    about.setWidth("300px");

    about.setContent(lab);
    final TextArea editor = new TextArea();
    Button butt = new Button("Edit");
    right.addComponent(butt);
    butt.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                right.addComponent(editor);
    editor.setPropertyDataSource(lab);
    editor.setImmediate(true);
}
});
		
	loginButton.addClickListener(new Button.ClickListener() {
	       public void buttonClick(ClickEvent event) {

		if (!usernameField.isValid() || !passwordField.isValid()) {
			usernameField.focus();
			feedbackLabel.setValue("Incorect login or password");
			return;
		}


		String username = usernameField.getValue();
		String password = passwordField.getValue();
        
		
		boolean isValid = username.equals("admin")
				&& password.equals("pass0");

		if (isValid) {
			// Store the current user in the service session
			getSession().setAttribute("user", username);
            feedbackLabel.setValue("LoggedIn");
			


		} else {

			passwordField.setValue(null);
			passwordField.focus();
		}
    	}
	});	
       
}
}
