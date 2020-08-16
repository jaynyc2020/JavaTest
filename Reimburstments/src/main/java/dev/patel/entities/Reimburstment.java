package dev.patel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Reimburstment")
public class Reimburstment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private int rId;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "note")
	private String note;
	/*
	//@ManyToOne
	//@JoinColumn(name = "e_id") // it will use that foreign key column to get employee that is associated with that movie
	private Employee employee;
	*/
	@Column(name = "e_id")
	private int empId;
	
	
	public Reimburstment() {
		super();
	}
	
	

	public Reimburstment(int rId, double amount, String status, String note, int empId) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.status = status;
		this.note = note;
		this.empId = empId;
		this.toString();
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getEmpId() {
		return empId;
	}

	public void setempId(int eId) {
		this.empId = eId;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", status=" + status + ", note=" + note
				+ ", employee=" + empId + "]";
	}
	
	
	

}
