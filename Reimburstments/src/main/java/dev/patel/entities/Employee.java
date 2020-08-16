package dev.patel.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="e_id")
	private int eId;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "username")
	@NotNull
	private String username;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	//@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	//List<Reimbursement> reimbursement = new ArrayList();
	

	public Employee() {
		super();
	}

	public Employee(int eId, String name, String username, String password) {
		super();
		this.eId = eId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public List<Reimbursement> getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(List<Reimbursement> reimbursement) {
		this.reimbursement = reimbursement;
	}
*/
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + "]";
	}
	
	
	
	

}
