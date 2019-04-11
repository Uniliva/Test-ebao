package br.com.uniliva.ebao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import br.com.uniliva.ebao.enums.Status;

@Entity(name = "TBL_ADJUSTMENT")
@Repository
public class Adjustment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADJUSTMENT_ID")
	private Long id;

	@JoinColumn(name = "BILL_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Bill bill;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_TIME")
	private Date createDate;
	
	
	
	public Adjustment(Bill bill, Status status, Date createDate) {
		this.bill = bill;
		this.status = status;
		this.createDate = createDate;
	}

	public Adjustment(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adjustment other = (Adjustment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adjustment [id=" + id + ", bill=" + bill + ", status=" + status + ", createDate=" + createDate + "]";
	}
	
	

	

}
