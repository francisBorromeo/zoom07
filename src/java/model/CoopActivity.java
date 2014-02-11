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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "coop_activity", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopActivity.findAll", query = "SELECT c FROM CoopActivity c"),
	@NamedQuery(name = "CoopActivity.findByActRecno", query = "SELECT c FROM CoopActivity c WHERE c.actRecno = :actRecno"),
	@NamedQuery(name = "CoopActivity.findByActName", query = "SELECT c FROM CoopActivity c WHERE c.actName = :actName"),
	@NamedQuery(name = "CoopActivity.findByActObj", query = "SELECT c FROM CoopActivity c WHERE c.actObj = :actObj"),
	@NamedQuery(name = "CoopActivity.findByActDateFrom", query = "SELECT c FROM CoopActivity c WHERE c.actDateFrom = :actDateFrom"),
	@NamedQuery(name = "CoopActivity.findByActDateTo", query = "SELECT c FROM CoopActivity c WHERE c.actDateTo = :actDateTo"),
	@NamedQuery(name = "CoopActivity.findByActDetails", query = "SELECT c FROM CoopActivity c WHERE c.actDetails = :actDetails"),
	@NamedQuery(name = "CoopActivity.findByActLocation", query = "SELECT c FROM CoopActivity c WHERE c.actLocation = :actLocation")})
public class CoopActivity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_recno", nullable = false)
	private Integer actRecno;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_name", nullable = false, length = 30)
	private String actName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_obj", nullable = false, length = 30)
	private String actObj;
	@Basic(optional = false)
    @NotNull
    @Column(name = "act_date_from", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date actDateFrom;
	@Column(name = "act_date_to")
    @Temporal(TemporalType.DATE)
	private Date actDateTo;
	@Size(max = 2147483647)
    @Column(name = "act_details", length = 2147483647)
	private String actDetails;
	@Size(max = 30)
    @Column(name = "act_location", length = 30)
	private String actLocation;
	@OneToMany(mappedBy = "actRecno")
	private Collection<CoopProsAct> coopProsActCollection;
	@JoinColumn(name = "act_type_code", referencedColumnName = "act_type_code")
    @ManyToOne
	private CoopActivityType actTypeCode;

	public CoopActivity() {
	}

	public CoopActivity(Integer actRecno) {
		this.actRecno = actRecno;
	}

	public CoopActivity(Integer actRecno, String actName, String actObj, Date actDateFrom) {
		this.actRecno = actRecno;
		this.actName = actName;
		this.actObj = actObj;
		this.actDateFrom = actDateFrom;
	}

	public Integer getActRecno() {
		return actRecno;
	}

	public void setActRecno(Integer actRecno) {
		this.actRecno = actRecno;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActObj() {
		return actObj;
	}

	public void setActObj(String actObj) {
		this.actObj = actObj;
	}

	public Date getActDateFrom() {
		return actDateFrom;
	}

	public void setActDateFrom(Date actDateFrom) {
		this.actDateFrom = actDateFrom;
	}

	public Date getActDateTo() {
		return actDateTo;
	}

	public void setActDateTo(Date actDateTo) {
		this.actDateTo = actDateTo;
	}

	public String getActDetails() {
		return actDetails;
	}

	public void setActDetails(String actDetails) {
		this.actDetails = actDetails;
	}

	public String getActLocation() {
		return actLocation;
	}

	public void setActLocation(String actLocation) {
		this.actLocation = actLocation;
	}

	@XmlTransient
	public Collection<CoopProsAct> getCoopProsActCollection() {
		return coopProsActCollection;
	}

	public void setCoopProsActCollection(Collection<CoopProsAct> coopProsActCollection) {
		this.coopProsActCollection = coopProsActCollection;
	}

	public CoopActivityType getActTypeCode() {
		return actTypeCode;
	}

	public void setActTypeCode(CoopActivityType actTypeCode) {
		this.actTypeCode = actTypeCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (actRecno != null ? actRecno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopActivity)) {
			return false;
		}
		CoopActivity other = (CoopActivity) object;
		if ((this.actRecno == null && other.actRecno != null) || (this.actRecno != null && !this.actRecno.equals(other.actRecno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopActivity[ actRecno=" + actRecno + " ]";
	}
	
}
