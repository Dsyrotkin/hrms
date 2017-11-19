package com.hrms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Table;


@Entity
@Table(name="PROJECT")
public class Project implements Serializable {
	
	private static final long serialVersionUID = 290121368112074618L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	@NotNull
	private String name;
	
	@Column(name = "DESCRIPTION")
	@NotEmpty
	private String description;
	
	@Column(name = "START_DATE")
	//@Date(pattern="MM/DD/YYYY")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@ManyToOne
	private Department department;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
