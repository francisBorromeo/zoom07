/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CoopApplicant;
import model.CoopMember;
import model.CoopOrgUnit;
import service.CoopApplicantFacadeREST;
import service.CoopMemberFacadeREST;
import service.CoopOrgUnitFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class MemberBean {
	@EJB private CoopMemberFacadeREST memberFacade;
	@EJB private CoopApplicantFacadeREST applicantFacade;
	@EJB private CoopOrgUnitFacadeREST orgUnitFacade;
	private CoopMember member;
	private CoopApplicant applicant;
	private CoopOrgUnit orgUnit;

	public MemberBean() {
	}	
}
