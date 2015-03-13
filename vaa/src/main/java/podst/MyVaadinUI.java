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
import com.vaadin.ui.VerticalLayout;

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
       /* final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);*/
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
        setContent(layout);
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
		  table.addItem(new Object[] {"A10 Timberland","Grey",100}, new Integer(1));
		  table.addItem(new Object[] {"Harmont & Blain","Black",85}, new Integer(2));
		  table.addItem(new Object[] {"Roy Rogers","Blue",50}, new Integer(3));
		  table.addItem(new Object[] {"IceBerg","Grey",150}, new Integer(4));
		
		layout.addComponent(table);
		
		
    }

}































