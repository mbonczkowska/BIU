package podst;

import javax.servlet.annotation.WebServlet;

import java.util.Date;

import java.text.SimpleDateFormat;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.HorizontalLayout;
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
	 

	 
     middle.addComponent(nNote);  

	 middle.addComponent(ok);
	middle.setSizeUndefined(); 

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
		
       
}
}
