package com.hrms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
@Entity
@Table(name = "IMAGES")
public class Image implements Serializable{
	
	private static final long serialVersionUID = -5030859560463308314L;

	@Id
    @GeneratedValue
    @Column(name = "IMAGE_ID")
    private long id;
	
	@Column(name = "IMAGE_NAME")
    private String fileName;
	
	@Transient
    private byte[] data;
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
}