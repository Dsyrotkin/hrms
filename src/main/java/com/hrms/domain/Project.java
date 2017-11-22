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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.hrms.validator.DeptNameIsExist;
import com.hrms.validator.ProjectNameIsExist;

import javax.persistence.Table;


@Entity
@Table(name="PROJECT")
//@ProjectNameIsExist
public class Project implements Serializable {
	
	private static final long serialVersionUID = 290121368112074618L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	@NotNull
	@NotBlank
	private String name;
	
	@Column(name = "DESCRIPTION")
	@NotEmpty
	private String description;
	
	@Column(name = "CODE")
	@NotEmpty
	@Digits(integer=10, fraction=0)
	//@projectCodeFormat
	private String code;
	
	@Column(name = "START_DATE")
	@DateTimeFormat(pattern="mm-dd-yy")
	private Date startDate;
	
	@Column(name = "END_DATE")
	@DateTimeFormat(pattern="mm-dd-yy")
	private Date endDate;
	
	@ManyToOne
	@NotNull
	//@JoinTable(name="department_project")
	private Department department;
	
	@OneToMany
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
