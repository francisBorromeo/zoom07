/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_member", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopMember.findAll", query = "SELECT c FROM CoopMember c"),
	@NamedQuery(name = "CoopMember.findByMemIdNo", query = "SELECT c FROM CoopMember c WHERE c.memIdNo = :memIdNo"),
	@NamedQuery(name = "CoopMember.findByLastName", query = "SELECT c FROM CoopMember c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "CoopMember.findByFirstName", query = "SELECT c FROM CoopMember c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "CoopMember.findByMiddleName", query = "SELECT c FROM CoopMember c WHERE c.middleName = :middleName"),
	@NamedQuery(name = "CoopMember.findByNickname", query = "SELECT c FROM CoopMember c WHERE c.nickname = :nickname"),
	@NamedQuery(name = "CoopMember.findByGender", query = "SELECT c FROM CoopMember c WHERE c.gender = :gender"),
	@NamedQuery(name = "CoopMember.findByBirthdate", query = "SELECT c FROM CoopMember c WHERE c.birthdate = :birthdate"),
	@NamedQuery(name = "CoopMember.findByBirthplace", query = "SELECT c FROM CoopMember c WHERE c.birthplace = :birthplace"),
	@NamedQuery(name = "CoopMember.findByResidenceType", query = "SELECT c FROM CoopMember c WHERE c.residenceType = :residenceType"),
	@NamedQuery(name = "CoopMember.findByStreet", query = "SELECT c FROM CoopMember c WHERE c.street = :street"),
	@NamedQuery(name = "CoopMember.findByBarangay", query = "SELECT c FROM CoopMember c WHERE c.barangay = :barangay"),
	@NamedQuery(name = "CoopMember.findByCityMun", query = "SELECT c FROM CoopMember c WHERE c.cityMun = :cityMun"),
	@NamedQuery(name = "CoopMember.findByRegion", query = "SELECT c FROM CoopMember c WHERE c.region = :region"),
	@NamedQuery(name = "CoopMember.findByProvince", query = "SELECT c FROM CoopMember c WHERE c.province = :province"),
	@NamedQuery(name = "CoopMember.findByCivilStatus", query = "SELECT c FROM CoopMember c WHERE c.civilStatus = :civilStatus"),
	@NamedQuery(name = "CoopMember.findByContactNumber", query = "SELECT c FROM CoopMember c WHERE c.contactNumber = :contactNumber"),
	@NamedQuery(name = "CoopMember.findByEmail", query = "SELECT c FROM CoopMember c WHERE c.email = :email"),
	@NamedQuery(name = "CoopMember.findByHeight", query = "SELECT c FROM CoopMember c WHERE c.height = :height"),
	@NamedQuery(name = "CoopMember.findByWeight", query = "SELECT c FROM CoopMember c WHERE c.weight = :weight"),
	@NamedQuery(name = "CoopMember.findByScAcctno", query = "SELECT c FROM CoopMember c WHERE c.scAcctno = :scAcctno"),
	@NamedQuery(name = "CoopMember.findByMemNo", query = "SELECT c FROM CoopMember c WHERE c.memNo = :memNo"),
	@NamedQuery(name = "CoopMember.findByMemDate", query = "SELECT c FROM CoopMember c WHERE c.memDate = :memDate"),
	@NamedQuery(name = "CoopMember.findByMemStatus", query = "SELECT c FROM CoopMember c WHERE c.memStatus = :memStatus"),
	@NamedQuery(name = "CoopMember.findByStatusDate", query = "SELECT c FROM CoopMember c WHERE c.statusDate = :statusDate"),
	@NamedQuery(name = "CoopMember.findByMemStatRem", query = "SELECT c FROM CoopMember c WHERE c.memStatRem = :memStatRem"),
	@NamedQuery(name = "CoopMember.findByTaxIdNo", query = "SELECT c FROM CoopMember c WHERE c.taxIdNo = :taxIdNo"),
	@NamedQuery(name = "CoopMember.findByNationality", query = "SELECT c FROM CoopMember c WHERE c.nationality = :nationality"),
	@NamedQuery(name = "CoopMember.findByZipCode", query = "SELECT c FROM CoopMember c WHERE c.zipCode = :zipCode"),
	@NamedQuery(name = "CoopMember.findByOccupation", query = "SELECT c FROM CoopMember c WHERE c.occupation = :occupation"),
	@NamedQuery(name = "CoopMember.findByReligion", query = "SELECT c FROM CoopMember c WHERE c.religion = :religion"),
	@NamedQuery(name = "CoopMember.findByPPrefix", query = "SELECT c FROM CoopMember c WHERE c.pPrefix = :pPrefix"),
	@NamedQuery(name = "CoopMember.findBySuffix", query = "SELECT c FROM CoopMember c WHERE c.suffix = :suffix"),
	@NamedQuery(name = "CoopMember.findByPersonStatus", query = "SELECT c FROM CoopMember c WHERE c.personStatus = :personStatus"),
	@NamedQuery(name = "CoopMember.findByBlood", query = "SELECT c FROM CoopMember c WHERE c.blood = :blood"),
	@NamedQuery(name = "CoopMember.findByNotifyName", query = "SELECT c FROM CoopMember c WHERE c.notifyName = :notifyName"),
	@NamedQuery(name = "CoopMember.findByNotifyAddress", query = "SELECT c FROM CoopMember c WHERE c.notifyAddress = :notifyAddress"),
	@NamedQuery(name = "CoopMember.findByNotifyPhone", query = "SELECT c FROM CoopMember c WHERE c.notifyPhone = :notifyPhone"),
	@NamedQuery(name = "CoopMember.findByNotifyRelation", query = "SELECT c FROM CoopMember c WHERE c.notifyRelation = :notifyRelation"),
	@NamedQuery(name = "CoopMember.findByOwnedBusiness", query = "SELECT c FROM CoopMember c WHERE c.ownedBusiness = :ownedBusiness")})
public class CoopMember implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mem_id_no", nullable = false, length = 10)
	private String memIdNo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name", nullable = false, length = 25)
	private String firstName;
	@Size(max = 20)
    @Column(name = "middle_name", length = 20)
	private String middleName;
	@Size(max = 15)
    @Column(name = "nickname", length = 15)
	private String nickname;
	@Basic(optional = false)
    @NotNull
    @Column(name = "gender", nullable = false)
	private char gender;
	@Basic(optional = false)
    @NotNull
    @Column(name = "birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date birthdate;
	@Size(max = 20)
    @Column(name = "birthplace", length = 20)
	private String birthplace;
	@Basic(optional = false)
    @NotNull
    @Column(name = "residence_type", nullable = false)
	private char residenceType;
	@Size(max = 60)
    @Column(name = "street", length = 60)
	private String street;
	@Size(max = 50)
    @Column(name = "barangay", length = 50)
	private String barangay;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city_mun", nullable = false, length = 50)
	private String cityMun;
	@Size(max = 50)
    @Column(name = "region", length = 50)
	private String region;
	@Size(max = 50)
    @Column(name = "province", length = 50)
	private String province;
	@Basic(optional = false)
    @NotNull
    @Column(name = "civil_status", nullable = false)
	private char civilStatus;
	@Size(max = 12)
    @Column(name = "contact_number", length = 12)
	private String contactNumber;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Size(max = 30)
    @Column(name = "email", length = 30)
	private String email;
	@Size(max = 3)
    @Column(name = "height", length = 3)
	private String height;
	@Size(max = 3)
    @Column(name = "weight", length = 3)
	private String weight;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sc_acctno", nullable = false, length = 8)
	private String scAcctno;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mem_no", nullable = false, length = 10)
	private String memNo;
	@Basic(optional = false)
    @NotNull
    @Column(name = "mem_date", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date memDate;
	@Basic(optional = false)
    @NotNull
    @Column(name = "mem_status", nullable = false)
	private char memStatus;
	@Basic(optional = false)
    @NotNull
    @Column(name = "status_date", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date statusDate;
	@Size(max = 2147483647)
    @Column(name = "mem_stat_rem", length = 2147483647)
	private String memStatRem;
	@Size(max = 11)
    @Column(name = "tax_id_no", length = 11)
	private String taxIdNo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nationality", nullable = false, length = 8)
	private String nationality;
	@Size(max = 4)
    @Column(name = "zip_code", length = 4)
	private String zipCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "occupation", nullable = false, length = 20)
	private String occupation;
	@Size(max = 14)
    @Column(name = "religion", length = 14)
	private String religion;
	@Size(max = 8)
    @Column(name = "p_prefix", length = 8)
	private String pPrefix;
	@Size(max = 5)
    @Column(name = "suffix", length = 5)
	private String suffix;
	@Column(name = "person_status")
	private Boolean personStatus;
	@Size(max = 2)
    @Column(name = "blood", length = 2)
	private String blood;
	@Size(max = 45)
    @Column(name = "notify_name", length = 45)
	private String notifyName;
	@Size(max = 60)
    @Column(name = "notify_address", length = 60)
	private String notifyAddress;
	@Size(max = 11)
    @Column(name = "notify_phone", length = 11)
	private String notifyPhone;
	@Size(max = 15)
    @Column(name = "notify_relation", length = 15)
	private String notifyRelation;
	@Basic(optional = false)
    @NotNull
    @Column(name = "owned_business", nullable = false)
	private boolean ownedBusiness;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit ouCode;
	@JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
	private CoopApplicant applicantNo;
	@OneToMany(mappedBy = "memIdNo")
	private Collection<CoopReport> coopReportCollection;
	@OneToMany(mappedBy = "userId")
	private Collection<CoopProsLog> coopProsLogCollection;

	public CoopMember() {
	}

	public CoopMember(String memIdNo) {
		this.memIdNo = memIdNo;
	}

	public CoopMember(String memIdNo, String lastName, String firstName, char gender, Date birthdate, char residenceType, String cityMun, char civilStatus, String scAcctno, String memNo, Date memDate, char memStatus, Date statusDate, String nationality, String occupation, boolean ownedBusiness) {
		this.memIdNo = memIdNo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.residenceType = residenceType;
		this.cityMun = cityMun;
		this.civilStatus = civilStatus;
		this.scAcctno = scAcctno;
		this.memNo = memNo;
		this.memDate = memDate;
		this.memStatus = memStatus;
		this.statusDate = statusDate;
		this.nationality = nationality;
		this.occupation = occupation;
		this.ownedBusiness = ownedBusiness;
	}

	public String getMemIdNo() {
		return memIdNo;
	}

	public void setMemIdNo(String memIdNo) {
		this.memIdNo = memIdNo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public char getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(char residenceType) {
		this.residenceType = residenceType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCityMun() {
		return cityMun;
	}

	public void setCityMun(String cityMun) {
		this.cityMun = cityMun;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public char getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(char civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getScAcctno() {
		return scAcctno;
	}

	public void setScAcctno(String scAcctno) {
		this.scAcctno = scAcctno;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	public char getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(char memStatus) {
		this.memStatus = memStatus;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getMemStatRem() {
		return memStatRem;
	}

	public void setMemStatRem(String memStatRem) {
		this.memStatRem = memStatRem;
	}

	public String getTaxIdNo() {
		return taxIdNo;
	}

	public void setTaxIdNo(String taxIdNo) {
		this.taxIdNo = taxIdNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getPPrefix() {
		return pPrefix;
	}

	public void setPPrefix(String pPrefix) {
		this.pPrefix = pPrefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Boolean getPersonStatus() {
		return personStatus;
	}

	public void setPersonStatus(Boolean personStatus) {
		this.personStatus = personStatus;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getNotifyName() {
		return notifyName;
	}

	public void setNotifyName(String notifyName) {
		this.notifyName = notifyName;
	}

	public String getNotifyAddress() {
		return notifyAddress;
	}

	public void setNotifyAddress(String notifyAddress) {
		this.notifyAddress = notifyAddress;
	}

	public String getNotifyPhone() {
		return notifyPhone;
	}

	public void setNotifyPhone(String notifyPhone) {
		this.notifyPhone = notifyPhone;
	}

	public String getNotifyRelation() {
		return notifyRelation;
	}

	public void setNotifyRelation(String notifyRelation) {
		this.notifyRelation = notifyRelation;
	}

	public boolean getOwnedBusiness() {
		return ownedBusiness;
	}

	public void setOwnedBusiness(boolean ownedBusiness) {
		this.ownedBusiness = ownedBusiness;
	}

	public CoopOrgUnit getOuCode() {
		return ouCode;
	}

	public void setOuCode(CoopOrgUnit ouCode) {
		this.ouCode = ouCode;
	}

	public CoopApplicant getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(CoopApplicant applicantNo) {
		this.applicantNo = applicantNo;
	}

	@XmlTransient
	public Collection<CoopReport> getCoopReportCollection() {
		return coopReportCollection;
	}

	public void setCoopReportCollection(Collection<CoopReport> coopReportCollection) {
		this.coopReportCollection = coopReportCollection;
	}

	@XmlTransient
	public Collection<CoopProsLog> getCoopProsLogCollection() {
		return coopProsLogCollection;
	}

	public void setCoopProsLogCollection(Collection<CoopProsLog> coopProsLogCollection) {
		this.coopProsLogCollection = coopProsLogCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (memIdNo != null ? memIdNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopMember)) {
			return false;
		}
		CoopMember other = (CoopMember) object;
		if ((this.memIdNo == null && other.memIdNo != null) || (this.memIdNo != null && !this.memIdNo.equals(other.memIdNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopMember[ memIdNo=" + memIdNo + " ]";
	}
	
}
