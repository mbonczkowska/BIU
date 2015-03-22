package podst;

import javax.servlet.annotation.WebServlet;

import java.util.Date;

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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.HorizontalLayout;
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
    
		
    /*	final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
        settitle(layout);
	    final Label label = new Label("Hello Vaadin user");
         layout.addComponent(label);
		 
		  Panel panel = new Panel("Panel Containing a Label");
		 panel.setWidth("200px"); // Defined width.
         layout.addComponent(panel);
        
		 
		Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
               label.setCaption("The time is " + new Date());
            }
        });
        layout.addComponent(button);
 
        Table table = new Table("Shoes price list");
 
		  table.addContainerProperty("Brand", String.class, null);
		  table.addContainerProperty("Colour", String.class, null);
		  table.addContainerProperty("Price", Integer.class, null);
		  /* Add a few items in the table. */
    /*	  table.addItem(new Object[] {"A10 Timberland","Grey",100}, new Integer(1));
		  table.addItem(new Object[] {"Harmont & Blain","Black",85}, new Integer(2));
		  table.addItem(new Object[] {"Roy Rogers","Blue",50}, new Integer(3));
		  table.addItem(new Object[] {"IceBerg","Grey",150}, new Integer(4));
		
		layout.addComponent(table);
		
       final Panel pa = new Panel("Panel Containing a Label");
        layout.addComponent(pa);
         final Label lab = new Label("Hello Vaadin user");
pa.setWidth("300px");

pa.setContent(lab);
    final TextArea editor = new TextArea();
    Button butt = new Button("Click Me");
    layout.addComponent(butt);
        butt.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(editor);
                editor.setPropertyDataSource(lab);
                editor.setImmediate(true);
            }
        });
        
        */
 
    VerticalLayout title = new VerticalLayout();
    title.setMargin(true);

    title.setSizeFull(); 
    setContent(title);   // add title
    title.addComponent(new Label("My blog"));
        
    // Layout inside layout
    HorizontalLayout content = new HorizontalLayout();
    // content.setSizeFull(); // Use all available space
	content.setMargin(true);
    title.addComponent(content);
    // Left side
    VerticalLayout left = new VerticalLayout();
    content.addComponent(left);
    InlineDateField date = new InlineDateField();
    date.setLocale(new Locale("pl", "PL"));
    left.addComponent(date);
        
        
    // Middle
    VerticalLayout middle = new VerticalLayout();
    content.addComponent(middle);
    Button tab = new Button();
    tab.setSizeFull();
    middle.addComponent(tab);
    // middle.setExpandRatio(tab, 1); // Expand to fill
       
       
    title.setExpandRatio(content, 1); // Expand to fill
        
    // Right
    final VerticalLayout right = new VerticalLayout();
    content.addComponent(right);
       

        
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
