/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author mis
 */
@Entity
@Table(name = "coop_report_type", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopReportType.findAll", query = "SELECT c FROM CoopReportType c"),
	@NamedQuery(name = "CoopReportType.findByReportTypeCode", query = "SELECT c FROM CoopReportType c WHERE c.reportTypeCode = :reportTypeCode"),
	@NamedQuery(name = "CoopReportType.findByReportType", query = "SELECT c FROM CoopReportType c WHERE c.reportType = :reportType"),
	@NamedQuery(name = "CoopReportType.findByReportDesc", query = "SELECT c FROM CoopReportType c WHERE c.reportDesc = :reportDesc")})
public class CoopReportType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "report_type_code", nullable = false, length = 5)
	private String reportTypeCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "report_type", nullable = false, length = 25)
	private String reportType;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "report_desc", nullable = false, length = 50)
	private String reportDesc;
	@OneToMany(mappedBy = "reportTypeCode")
	private Collection<CoopReport> coopReportCollection;

	public CoopReportType() {
	}

	public CoopReportType(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public CoopReportType(String reportTypeCode, String reportType, String reportDesc) {
		this.reportTypeCode = reportTypeCode;
		this.reportType = reportType;
		this.reportDesc = reportDesc;
	}

	public String getReportTypeCode() {
		return reportTypeCode;
	}

	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportDesc() {
		return reportDesc;
	}

	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}

	@XmlTransient
	public Collection<CoopReport> getCoopReportCollection() {
		return coopReportCollection;
	}

	public void setCoopReportCollection(Collection<CoopReport> coopReportCollection) {
		this.coopReportCollection = coopReportCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (reportTypeCode != null ? reportTypeCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopReportType)) {
			return false;
		}
		CoopReportType other = (CoopReportType) object;
		if ((this.reportTypeCode == null && other.reportTypeCode != null) || (this.reportTypeCode != null && !this.reportTypeCode.equals(other.reportTypeCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopReportType[ reportTypeCode=" + reportTypeCode + " ]";
	}
	
}
