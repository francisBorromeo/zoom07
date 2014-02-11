/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_repver", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsRepver.findAll", query = "SELECT c FROM CoopProsRepver c"),
	@NamedQuery(name = "CoopProsRepver.findByRepVerLogno", query = "SELECT c FROM CoopProsRepver c WHERE c.repVerLogno = :repVerLogno"),
	@NamedQuery(name = "CoopProsRepver.findByVerDate", query = "SELECT c FROM CoopProsRepver c WHERE c.verDate = :verDate"),
	@NamedQuery(name = "CoopProsRepver.findByReportDtl", query = "SELECT c FROM CoopProsRepver c WHERE c.reportDtl = :reportDtl"),
	@NamedQuery(name = "CoopProsRepver.findByUserId", query = "SELECT c FROM CoopProsRepver c WHERE c.userId = :userId")})
public class CoopProsRepver implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "rep_ver_logno", nullable = false, length = 4)
	private String repVerLogno;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ver_date", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date verDate;
	@Size(max = 2147483647)
    @Column(name = "report_dtl", length = 2147483647)
	private String reportDtl;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "user_id", nullable = false, length = 8)
	private String userId;
	@JoinColumn(name = "pros_rep_recno", referencedColumnName = "pros_rep_recno")
    @ManyToOne
	private CoopProsReport prosRepRecno;

	public CoopProsRepver() {
	}

	public CoopProsRepver(String repVerLogno) {
		this.repVerLogno = repVerLogno;
	}

	public CoopProsRepver(String repVerLogno, Date verDate, String userId) {
		this.repVerLogno = repVerLogno;
		this.verDate = verDate;
		this.userId = userId;
	}

	public String getRepVerLogno() {
		return repVerLogno;
	}

	public void setRepVerLogno(String repVerLogno) {
		this.repVerLogno = repVerLogno;
	}

	public Date getVerDate() {
		return verDate;
	}

	public void setVerDate(Date verDate) {
		this.verDate = verDate;
	}

	public String getReportDtl() {
		return reportDtl;
	}

	public void setReportDtl(String reportDtl) {
		this.reportDtl = reportDtl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public CoopProsReport getProsRepRecno() {
		return prosRepRecno;
	}

	public void setProsRepRecno(CoopProsReport prosRepRecno) {
		this.prosRepRecno = prosRepRecno;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (repVerLogno != null ? repVerLogno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsRepver)) {
			return false;
		}
		CoopProsRepver other = (CoopProsRepver) object;
		if ((this.repVerLogno == null && other.repVerLogno != null) || (this.repVerLogno != null && !this.repVerLogno.equals(other.repVerLogno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsRepver[ repVerLogno=" + repVerLogno + " ]";
	}
	
}
