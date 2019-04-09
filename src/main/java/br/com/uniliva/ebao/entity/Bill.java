package br.com.uniliva.ebao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.uniliva.ebao.dto.BillDto;

@Entity(name= "TBL_Bill")
public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOLETO_ID")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_TIME")
	private Date createDate;
	@Column(name = "AMOUNT")
	private double amount;
	@Temporal(TemporalType.DATE)
	@Column(name = "DUE_DATE")
	private Date dueDate;

	public Bill(Date createDate, double amount, Date dueDate) {
		this.createDate = createDate;
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public Bill() {}
	
	public BillDto toBillDTO(){
		return new BillDto(this.id, this.createDate, this.amount, this.dueDate);		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", createDate=" + createDate + ", amount=" + amount + ", dueDate=" + dueDate + "]";
	}

	
	
}
