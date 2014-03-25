/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_report", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsReport.findAll", query = "SELECT c FROM CoopProsReport c"),
	@NamedQuery(name = "CoopProsReport.findByWillingnessRating", query = "SELECT c FROM CoopProsReport c WHERE c.willingnessRating = :willingnessRating"),
	@NamedQuery(name = "CoopProsReport.findByUnderstandingRating", query = "SELECT c FROM CoopProsReport c WHERE c.understandingRating = :understandingRating"),
	@NamedQuery(name = "CoopProsReport.findByInspirationRating", query = "SELECT c FROM CoopProsReport c WHERE c.inspirationRating = :inspirationRating"),
	@NamedQuery(name = "CoopProsReport.findBySocialRating", query = "SELECT c FROM CoopProsReport c WHERE c.socialRating = :socialRating"),
	@NamedQuery(name = "CoopProsReport.findByProsRepRecno", query = "SELECT c FROM CoopProsReport c WHERE c.prosRepRecno = :prosRepRecno")})
public class CoopProsReport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "willingness_rating")
	private Integer willingnessRating;
	@Column(name = "understanding_rating")
	private Integer understandingRating;
	@Column(name = "inspiration_rating")
	private Integer inspirationRating;
	@Column(name = "social_rating")
	private Integer socialRating;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "pros_rep_recno", nullable = false, length = 4)
	private String prosRepRecno;
	@JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne(cascade = CascadeType.PERSIST)
	private CoopReport reportNum;
	@JoinColumn(name = "prospect_no", referencedColumnName = "prospect_no")
    @ManyToOne
	private CoopProspect prospectNo;
	@OneToMany(mappedBy = "prosRepRecno")
	private Collection<CoopProsRepver> coopProsRepverCollection;

	public CoopProsReport() {
	}

	public CoopProsReport(String prosRepRecno) {
		this.prosRepRecno = prosRepRecno;
	}

	public Integer getWillingnessRating() {
		return willingnessRating;
	}

	public void setWillingnessRating(Integer willingnessRating) {
		this.willingnessRating = willingnessRating;
	}

	public Integer getUnderstandingRating() {
		return understandingRating;
	}

	public void setUnderstandingRating(Integer understandingRating) {
		this.understandingRating = understandingRating;
	}

	public Integer getInspirationRating() {
		return inspirationRating;
	}

	public void setInspirationRating(Integer inspirationRating) {
		this.inspirationRating = inspirationRating;
	}

	public Integer getSocialRating() {
		return socialRating;
	}

	public void setSocialRating(Integer socialRating) {
		this.socialRating = socialRating;
	}

	public String getProsRepRecno() {
		return prosRepRecno;
	}

	public void setProsRepRecno(String prosRepRecno) {
		this.prosRepRecno = prosRepRecno;
	}

	public CoopReport getReportNum() {
		return reportNum;
	}

	public void setReportNum(CoopReport reportNum) {
		this.reportNum = reportNum;
	}

	public CoopProspect getProspectNo() {
		return prospectNo;
	}

	public void setProspectNo(CoopProspect prospectNo) {
		this.prospectNo = prospectNo;
	}

	@XmlTransient
	public Collection<CoopProsRepver> getCoopProsRepverCollection() {
		return coopProsRepverCollection;
	}

	public void setCoopProsRepverCollection(Collection<CoopProsRepver> coopProsRepverCollection) {
		this.coopProsRepverCollection = coopProsRepverCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prosRepRecno != null ? prosRepRecno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsReport)) {
			return false;
		}
		CoopProsReport other = (CoopProsReport) object;
		if ((this.prosRepRecno == null && other.prosRepRecno != null) || (this.prosRepRecno != null && !this.prosRepRecno.equals(other.prosRepRecno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsReport[ prosRepRecno=" + prosRepRecno + " ]";
	}
	
}
