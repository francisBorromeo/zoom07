/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import model.CoopProsReport;
import model.CoopProspect;
import model.CoopReport;
import service.CoopProsReportFacadeREST;
import service.CoopProspectFacadeREST;
import service.CoopReportFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class EffortBean implements Serializable {
	@EJB
	private CoopProsReportFacadeREST effortFacade;
	@EJB
	private CoopReportFacadeREST reportFacade;	
	private CoopProsReport effort;
	private CoopProsReport selectedEffort;
	private CoopReport coopReport;
	private List<CoopProspect> prospectList;
	private List<CoopProsReport> effortList;
	private DataModel<CoopProsReport> effortModel;
	
	@PostConstruct
	public void initEffort() {
		effort = new CoopProsReport();
		coopReport = new CoopReport();
		
	}
	
	public EffortBean() {
	}
	
}
