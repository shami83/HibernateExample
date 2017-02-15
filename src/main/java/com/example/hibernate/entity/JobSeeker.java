/**
 * 
 */
package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Shamik Mitra
 *
 */
@Entity
@Table(name = "JOB_SEEKER", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class JobSeeker {

	 @Id
	   @Column(name = "ID", unique = true, nullable = false)
	   private Integer           jobSeekerId;
	   @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	   private String            email;
	   @Column(name = "NAME", unique = false, nullable = false, length = 100)
	   private String            name;
	   
	   @Embedded
	   Address address;

	public Integer getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(Integer jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "JobSeeker [jobSeekerId=" + jobSeekerId + ", email=" + email + ", name=" + name + ", address=" + address + "]";
	}
	   
	   
	   
	   
	   
}
