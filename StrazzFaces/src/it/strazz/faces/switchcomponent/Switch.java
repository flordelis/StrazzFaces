package it.strazz.faces.switchcomponent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;

@FacesComponent(value = Switch.COMPONENT_TYPE)
@ResourceDependencies({
		@ResourceDependency(library = "drinks", name = "Drinks.js"),
		@ResourceDependency(library = "drinks", name = "Switch.js"),
		@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "primefaces.js"),
		@ResourceDependency(library = "strazzfaces", name = "switch.js") })
public class Switch extends UIInput implements Widget, ClientBehaviorHolder {
	public static final String COMPONENT_TYPE = "it.strazz.faces.Switch";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";

	private static final Collection<String> EVENT_NAMES = Collections
			.unmodifiableCollection(Arrays.asList("blur", "change", "click",
					"valueChange", "dblclick", "focus", "keydown", "keypress",
					"keyup", "mousedown", "mousemove", "mouseout", "mouseover",
					"mouseup", "select"));

	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	public String getDefaultEventName() {
		return "valueChange";
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if (userWidgetVar != null)
			return userWidgetVar;
		else
			return "widget_"
					+ getClientId(context).replaceAll(
							"-|" + UINamingContainer.getSeparatorChar(context),
							"_");
	}
}