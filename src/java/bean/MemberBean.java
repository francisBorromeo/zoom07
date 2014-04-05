package bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopApplicant;
import model.CoopMember;
import model.CoopOrgUnit;
import service.CoopApplicantFacadeREST;
import service.CoopMemberFacadeREST;
import service.CoopOrgUnitFacadeREST;

@ManagedBean
@SessionScoped
public class MemberBean {
	@EJB private CoopMemberFacadeREST memberFacade;
	@EJB private CoopApplicantFacadeREST applicantFacade;
	@EJB private CoopOrgUnitFacadeREST orgUnitFacade;
	private CoopMember member;
	private CoopApplicant applicant;
	private CoopOrgUnit orgUnit;
	private List<CoopMember> memberList;
	private List<CoopApplicant> applicantList;
	private List<CoopOrgUnit> ouList;
	private DataModel<CoopMember> memberModel;
	private DataModel<CoopOrgUnit> ouModel;
	private DataModel<CoopApplicant> applicantModel;

	public void init() {
		member = new CoopMember();
		applicant = new CoopApplicant();
		memberList = memberFacade.findAll();
		applicantList = applicantFacade.findAll();
		ouList = orgUnitFacade.findStrings("ou_code", "PT%");
		memberModel = new ListDataModel<CoopMember>(memberList);
		applicantModel = new ListDataModel<CoopApplicant>(applicantList);
		ouModel = new ListDataModel<CoopOrgUnit>(ouList);
	}
	
	public String saveMemRec() {
		memberFacade.create(member);
		member = new CoopMember();
		return "/xhtml/member/addMember.xhtml?faces-redirect=true";
	}
	
	public CoopMember getMember() {
		return member;
	}

	public void setMember(CoopMember member) {
		this.member = member;
	}
	
	public List<CoopOrgUnit> ptOnly(){
		return ouList;
	}

	public CoopApplicant getApplicant() {
		return applicant;
	}

	public void setApplicant(CoopApplicant applicant) {
		this.applicant = applicant;
	}

	public CoopOrgUnit getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(CoopOrgUnit orgUnit) {
		this.orgUnit = orgUnit;
	}

	public MemberBean() {
	}	
}
