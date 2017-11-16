package com.hrms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
	
	private long id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Department department;
	private List<Position> positions = new ArrayList<>();
	
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

	public List<Position> getPositions() {
		return positions;
	}

	public void addPosition(Position position) {
		positions.add(position);
	}
	
	

}
