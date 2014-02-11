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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_log", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsLog.findAll", query = "SELECT c FROM CoopProsLog c"),
	@NamedQuery(name = "CoopProsLog.findByChLogno", query = "SELECT c FROM CoopProsLog c WHERE c.chLogno = :chLogno"),
	@NamedQuery(name = "CoopProsLog.findByChangeLogDate", query = "SELECT c FROM CoopProsLog c WHERE c.changeLogDate = :changeLogDate"),
	@NamedQuery(name = "CoopProsLog.findByFieldChange", query = "SELECT c FROM CoopProsLog c WHERE c.fieldChange = :fieldChange"),
	@NamedQuery(name = "CoopProsLog.findByOldValue", query = "SELECT c FROM CoopProsLog c WHERE c.oldValue = :oldValue"),
	@NamedQuery(name = "CoopProsLog.findByNewValue", query = "SELECT c FROM CoopProsLog c WHERE c.newValue = :newValue")})
public class CoopProsLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ch_logno", nullable = false)
	private Integer chLogno;
	@Column(name = "change_log_date")
    @Temporal(TemporalType.DATE)
	private Date changeLogDate;
	@Size(max = 40)
    @Column(name = "field_change", length = 40)
	private String fieldChange;
	@Size(max = 40)
    @Column(name = "old_value", length = 40)
	private String oldValue;
	@Size(max = 40)
    @Column(name = "new_value", length = 40)
	private String newValue;
	@JoinColumn(name = "prospect_no", referencedColumnName = "prospect_no")
    @ManyToOne
	private CoopProspect prospectNo;
	@JoinColumn(name = "user_id", referencedColumnName = "mem_id_no")
    @ManyToOne
	private CoopMember userId;

	public CoopProsLog() {
	}

	public CoopProsLog(Integer chLogno) {
		this.chLogno = chLogno;
	}

	public Integer getChLogno() {
		return chLogno;
	}

	public void setChLogno(Integer chLogno) {
		this.chLogno = chLogno;
	}

	public Date getChangeLogDate() {
		return changeLogDate;
	}

	public void setChangeLogDate(Date changeLogDate) {
		this.changeLogDate = changeLogDate;
	}

	public String getFieldChange() {
		return fieldChange;
	}

	public void setFieldChange(String fieldChange) {
		this.fieldChange = fieldChange;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public CoopProspect getProspectNo() {
		return prospectNo;
	}

	public void setProspectNo(CoopProspect prospectNo) {
		this.prospectNo = prospectNo;
	}

	public CoopMember getUserId() {
		return userId;
	}

	public void setUserId(CoopMember userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (chLogno != null ? chLogno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsLog)) {
			return false;
		}
		CoopProsLog other = (CoopProsLog) object;
		if ((this.chLogno == null && other.chLogno != null) || (this.chLogno != null && !this.chLogno.equals(other.chLogno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsLog[ chLogno=" + chLogno + " ]";
	}
	
}
