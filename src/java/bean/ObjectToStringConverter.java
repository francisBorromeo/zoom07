/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

//import coop.beans.EJB;
import model.CoopProspect;
import service.CoopProspectFacadeREST;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author mis
 */
//@FacesConverter(forClass=CoopProspect.class, value="objStrConv")
@Named(value="objStrConv")
@ViewScoped
public class ObjectToStringConverter implements Converter {
	
	private @EJB service.CoopProspectFacadeREST coopProspectFacadeREST;
			//= EJB.lookup(CoopProspectFacadeREST.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//throw new UnsupportedOperationException("Not supported yet.");
		String prospectNo = String.valueOf(value);
		CoopProspect coopProspect = coopProspectFacadeREST.find(Integer.SIZE);
		return coopProspect;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//throw new UnsupportedOperationException("Not supported yet.");
		CoopProspect coopProspect = (CoopProspect) value;
		String idAsString = String.valueOf(coopProspect.getProspectNo());
		return idAsString;
	}
	
}
