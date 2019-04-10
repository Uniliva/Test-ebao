package br.com.uniliva.ebao.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.uniliva.ebao.enums.Status;


public class BillDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createDate;
	private double amount;
	private Date dueDate;
	private Long idAdjustment;
	private Status status;
	private Date adjustmentDate;


	public BillDto() {}
	
	public BillDto(Long id, Date createDate, double amount, Date dueDate) {
		this.id = id;
		this.createDate = createDate;
		this.amount = amount;
		this.dueDate = dueDate;
	}
	
	public  BillDto addAdjustment( Long idAdjustment, Status status, Date adjustmentDate) {	
		this.idAdjustment = idAdjustment;
		this.status = status;
		this.adjustmentDate = adjustmentDate;
		return this;
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
	
	

	public Long getIdAdjustment() {
		return idAdjustment;
	}

	public void setIdAdjustment(Long idAdjustment) {
		this.idAdjustment = idAdjustment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idAdjustment == null) ? 0 : idAdjustment.hashCode());
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
		BillDto other = (BillDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAdjustment == null) {
			if (other.idAdjustment != null)
				return false;
		} else if (!idAdjustment.equals(other.idAdjustment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", createDate=" + createDate + ", amount=" + amount + ", dueDate=" + dueDate
				+ ", idAdjustment=" + idAdjustment + ", status=" + status + ", adjustmentDate=" + adjustmentDate + "]";
	}

	
	
}