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
@Table(name = "coop_org_unit")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopOrgUnit.findAll", query = "SELECT c FROM CoopOrgUnit c"),
	@NamedQuery(name = "CoopOrgUnit.findByOuCode", query = "SELECT c FROM CoopOrgUnit c WHERE c.ouCode = :ouCode"),
	@NamedQuery(name = "CoopOrgUnit.findByOuName", query = "SELECT c FROM CoopOrgUnit c WHERE c.ouName = :ouName"),
	@NamedQuery(name = "CoopOrgUnit.findByManagedBy", query = "SELECT c FROM CoopOrgUnit c WHERE c.managedBy = :managedBy"),
	@NamedQuery(name = "CoopOrgUnit.findByDateCreated", query = "SELECT c FROM CoopOrgUnit c WHERE c.dateCreated = :dateCreated"),
	@NamedQuery(name = "CoopOrgUnit.findByDateDissolved", query = "SELECT c FROM CoopOrgUnit c WHERE c.dateDissolved = :dateDissolved")})
public class CoopOrgUnit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ou_code")
	private String ouCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ou_name")
	private String ouName;
	@Size(max = 12)
    @Column(name = "managed_by")
	private String managedBy;
	@Column(name = "date_created")
    @Temporal(TemporalType.DATE)
	private Date dateCreated;
	@Column(name = "date_dissolved")
    @Temporal(TemporalType.DATE)
	private Date dateDissolved;
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

	public String getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDissolved() {
		return dateDissolved;
	}

	public void setDateDissolved(Date dateDissolved) {
		this.dateDissolved = dateDissolved;
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
	
}
