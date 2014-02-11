/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_org_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopOrgUnit.findAll", query = "SELECT c FROM CoopOrgUnit c"),
    @NamedQuery(name = "CoopOrgUnit.findByOuCode", query = "SELECT c FROM CoopOrgUnit c WHERE c.ouCode = :ouCode"),
    @NamedQuery(name = "CoopOrgUnit.findByOuName", query = "SELECT c FROM CoopOrgUnit c WHERE c.ouName = :ouName"),
    @NamedQuery(name = "CoopOrgUnit.findByManages", query = "SELECT c FROM CoopOrgUnit c WHERE c.manages = :manages"),
    @NamedQuery(name = "CoopOrgUnit.findByManagedBy", query = "SELECT c FROM CoopOrgUnit c WHERE c.managedBy = :managedBy")})
public class CoopOrgUnit implements Serializable {
	@OneToMany(mappedBy = "ouCode")
	private Collection<CoopApplicant> coopApplicantCollection;
	@OneToMany(mappedBy = "ouCode")
	private Collection<CoopMember> coopMemberCollection;
	@OneToMany(mappedBy = "ouCode")
	private Collection<CoopReport> coopReportCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ou_code")
    private String ouCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ou_name")
    private String ouName;
    @Size(max = 25)
    @Column(name = "manages")
    private String manages;
    @Size(max = 6)
    @Column(name = "managed_by")
    private String managedBy;
    @OneToMany(mappedBy = "ouCode")
    private Collection<CoopProspect> coopProspectCollection;

    public CoopOrgUnit() {
    }

    public CoopOrgUnit(String ouCode) {
        this.ouCode = ouCode;
    }

    public CoopOrgUnit(String ouCode, String ouName) {
        this.ouCode = ouCode;
        this.ouName = ouName;
    }

    public String getOuCode() {
        return ouCode;
    }

    public void setOuCode(String ouCode) {
        this.ouCode = ouCode;
    }

    public String getOuName() {
        return ouName;
    }

    public void setOuName(String ouName) {
        this.ouName = ouName;
    }

    public String getManages() {
        return manages;
    }

    public void setManages(String manages) {
        this.manages = manages;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }

    @XmlTransient
    public Collection<CoopProspect> getCoopProspectCollection() {
        return coopProspectCollection;
    }

    public void setCoopProspectCollection(Collection<CoopProspect> coopProspectCollection) {
        this.coopProspectCollection = coopProspectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ouCode != null ? ouCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopOrgUnit)) {
            return false;
        }
        CoopOrgUnit other = (CoopOrgUnit) object;
        if ((this.ouCode == null && other.ouCode != null) || (this.ouCode != null && !this.ouCode.equals(other.ouCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopOrgUnit[ ouCode=" + ouCode + " ]";
    }

	@XmlTransient
	public Collection<CoopApplicant> getCoopApplicantCollection() {
		return coopApplicantCollection;
	}

	public void setCoopApplicantCollection(Collection<CoopApplicant> coopApplicantCollection) {
		this.coopApplicantCollection = coopApplicantCollection;
	}

	@XmlTransient
	public Collection<CoopMember> getCoopMemberCollection() {
		return coopMemberCollection;
	}

	public void setCoopMemberCollection(Collection<CoopMember> coopMemberCollection) {
		this.coopMemberCollection = coopMemberCollection;
	}

	@XmlTransient
	public Collection<CoopReport> getCoopReportCollection() {
		return coopReportCollection;
	}

	public void setCoopReportCollection(Collection<CoopReport> coopReportCollection) {
		this.coopReportCollection = coopReportCollection;
	}
    
}
