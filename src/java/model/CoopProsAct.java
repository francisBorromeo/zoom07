/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_act", catalog = "sdcc", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsAct.findAll", query = "SELECT c FROM CoopProsAct c"),
	@NamedQuery(name = "CoopProsAct.findByProsActRecno", query = "SELECT c FROM CoopProsAct c WHERE c.prosActRecno = :prosActRecno")})
public class CoopProsAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_act_recno", nullable = false)
	private Integer prosActRecno;
	@JoinColumn(name = "prospect_no", referencedColumnName = "prospect_no")
    @ManyToOne
	private CoopProspect prospectNo;
	@JoinColumn(name = "act_recno", referencedColumnName = "act_recno")
    @ManyToOne
	private CoopActivity actRecno;

	public CoopProsAct() {
	}

	public CoopProsAct(Integer prosActRecno) {
		this.prosActRecno = prosActRecno;
	}

	public Integer getProsActRecno() {
		return prosActRecno;
	}

	public void setProsActRecno(Integer prosActRecno) {
		this.prosActRecno = prosActRecno;
	}

	public CoopProspect getProspectNo() {
		return prospectNo;
	}

	public void setProspectNo(CoopProspect prospectNo) {
		this.prospectNo = prospectNo;
	}

	public CoopActivity getActRecno() {
		return actRecno;
	}

	public void setActRecno(CoopActivity actRecno) {
		this.actRecno = actRecno;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prosActRecno != null ? prosActRecno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsAct)) {
			return false;
		}
		CoopProsAct other = (CoopProsAct) object;
		if ((this.prosActRecno == null && other.prosActRecno != null) || (this.prosActRecno != null && !this.prosActRecno.equals(other.prosActRecno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsAct[ prosActRecno=" + prosActRecno + " ]";
	}
	
}
