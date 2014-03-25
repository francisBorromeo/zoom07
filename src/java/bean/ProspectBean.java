/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import model.CoopMember;
import model.CoopOrgUnit;
import model.CoopProsReport;
import model.CoopProspect;
import model.CoopReport;
import model.CoopReportType;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import service.CoopMemberFacadeREST;
import service.CoopOrgUnitFacadeREST;
import service.CoopProsReportFacadeREST;
import service.CoopProspectFacadeREST;
import service.CoopReportFacadeREST;
import service.CoopReportTypeFacadeREST;

/**
 *
 * @author roland
 */
@ManagedBean
@SessionScoped
public class ProspectBean implements Serializable {

	@EJB
	private CoopProspectFacadeREST coopProspectFacadeREST;
	@EJB
	private CoopProsReportFacadeREST coopProsReportFacadeREST;
	@EJB
	private CoopReportFacadeREST coopReportFacadeREST;
	@EJB
	private CoopOrgUnitFacadeREST coopOrgUnitFacadeREST;
	@EJB
	private CoopMemberFacadeREST coopMemberFacadeREST;
	@EJB
	private CoopReportTypeFacadeREST coopReportTypeFacadeREST;
	private CoopMember coopMember;
	private CoopOrgUnit orgUnit;
	private CoopProspect prospect;
	private CoopProsReport prosReport;
	private CoopReport coopReport;
	private CoopReportType coopReportType;
	private List<CoopMember> coopMemberList;
	private List<CoopProspect> prospectList;
	private CoopProspect selectedProspect;
	private List<CoopProspect> filteredProspectList;
	private DataModel<CoopProspect> prospectModel;
	private boolean renderComponent;
	private boolean willing;
	private boolean understanding;
	private boolean motivated;
	private boolean social;
	private boolean norating;
	private int randomNo;

	public void init() {
		prospect = new CoopProspect();
		prosReport = new CoopProsReport();
		coopReport = new CoopReport();
		coopMemberList = coopMemberFacadeREST.findAll();
		prospectList = coopProspectFacadeREST.findAll();
		prospectModel = new ListDataModel<CoopProspect>(prospectList);
		renderComponent = false;
		coopMember = coopMemberFacadeREST.find("1");
		orgUnit = coopOrgUnitFacadeREST.find("PT01");
		coopReportType = coopReportTypeFacadeREST.find("REC");
		coopReport.setMemIdNo(coopMember);
		coopReport.setOuCode(orgUnit);
		coopReport.setReportTypeCode(coopReportType);
	}

	/**
	 * Creates a new instance of ProspectBean
	 */
	public ProspectBean() {
		prospect = new CoopProspect();
	}

	public DataModel<CoopProspect> getProspectModel() {
		if (prospectModel == null) {
			prospectModel = new ListDataModel<CoopProspect>(prospectList);
		}
		return prospectModel;
	}

	public CoopProspect getProspect() {
		return prospect;
	}

	public void clearBean() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prospectBean", null);
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public void editMode() {
		prospect = selectedProspect;
	}

	public void setProspect(CoopProspect prospect) {
		this.prospect = selectedProspect;
	}

	public String save() {
		coopProspectFacadeREST.create(prospect);
		prospect = new CoopProspect();
		return "addProspect?faces-redirect=true";
	}

	public String saveEffort() {
		//coopReportFacadeREST.create(coopReport);
		prosReport.setProsRepRecno(randomizeNo());
		prosReport.setProspectNo(selectedProspect);
		coopReportFacadeREST.create(coopReport);
		prosReport = new CoopProsReport();
		coopReport = new CoopReport();
		return backToMain("/xhtml/addEffort.xhtml");
	}
	
	public String randomizeNo() {
		randomNo = 1 + (int)(Math.random() * ((9999 - 1) + 1));
		return String.valueOf(randomNo);
	}

	public List<CoopProspect> getProspectList() {
		prospectList = coopProspectFacadeREST.findAll();
		return prospectList;
	}

	public void setProspectList(List<CoopProspect> prospectList) {
		this.prospectList = prospectList;
	}

	public void setSelectedProspect(CoopProspect selectedProspect) {
		this.selectedProspect = selectedProspect;
	}

	public boolean renderComponent() {
		if (selectedProspect != null) {
			renderComponent = true;
		}
		return renderComponent;
	}

	public CoopProspect getSelectedProspect() {
		if (selectedProspect == null) {
			selectedProspect = new CoopProspect();
		}
		return selectedProspect;
	}

	public void onRowSelect(SelectEvent event) {
	}

	public void onRowUnselect(UnselectEvent event) {
		selectedProspect = null;
		selectedProspect = new CoopProspect();
	}

	public String saveEdit() {
		editMode();
		coopProspectFacadeREST.edit(prospect);
		prospect = new CoopProspect();
		clearBean();
		return "viewProspect?faces-redirect=true";
	}

	public String remove() {
		coopProspectFacadeREST.remove(selectedProspect);
		prospect = new CoopProspect();
		clearBean();
		return "viewProspect?faces-redirect=true";
	}

	public String goBackToView() {
		selectedProspect = null;
		selectedProspect = new CoopProspect();
		return "viewProspect?faces-redirect=true";
	}

	public String backToMain(String page) {
		selectedProspect = null;
		setNorating(true);
		norating = false;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prospectBean", null);
		return page + "?faces-redirect=true";
	}

	public List<CoopProspect> getFilteredProspectList() {
		return filteredProspectList;
	}

	public void setFilteredProspectList(List<CoopProspect> filteredProspectList) {
		this.filteredProspectList = filteredProspectList;
	}

	public boolean isWilling() {
		return willing;
	}

	public void setWilling(boolean willing) {
		norating = false;
		this.willing = willing;
	}

	public boolean isUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(boolean understanding) {
		norating = false;
		this.understanding = understanding;
	}

	public boolean isMotivated() {
		return motivated;
	}

	public void setMotivated(boolean motivated) {
		norating = false;
		this.motivated = motivated;
	}

	public boolean isSocial() {
		return social;
	}

	public void setSocial(boolean social) {
		norating = false;
		this.social = social;
	}

	public boolean isNorating() {
		return norating;
	}

	public void setNorating(boolean norating) {
		willing = false;
		understanding = false;
		motivated = false;
		social = false;
		this.norating = norating;
	}

	public CoopProsReport getProsReport() {
		return prosReport;
	}

	public CoopReport getCoopReport() {
		return coopReport;
	}
}
