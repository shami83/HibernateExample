/**
 * 
 */
package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

/**
 * @author Shamik Mitra
 *
 */
@Entity
@Table(name = "COMPANY", uniqueConstraints = { @UniqueConstraint(columnNames = "COMPANY_ID") })
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)  
//@DiscriminatorColumn(name = "COMPANY_TYPE", discriminatorType = DiscriminatorType.STRING)// Single Table
//@DiscriminatorValue(value = "COMPANY")// Single Table
public class Company {

	@Id
	@Column(name = "COMPANY_ID", unique = true, nullable = false)
	private Long companyId;
	@Column(name = "COMPANY_NAME", unique = true, nullable = false)
	private String name;
	@Column(name = "COMPANY_STRENGTH", nullable = false)
	private Long companyStrength;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCompanyStrength() {
		return companyStrength;
	}

	public void setCompanyStrength(Long companyStrength) {
		this.companyStrength = companyStrength;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", companyStrength=" + companyStrength + "]";
	}

}
