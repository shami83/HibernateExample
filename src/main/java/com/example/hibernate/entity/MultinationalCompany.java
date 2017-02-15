/**
 * 
 */
package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Shamik Mitra
 *
 */
@Entity
@Table(name="MULTINATIONAL_COMPANY") 
//@DiscriminatorValue("MULTINATIONAL") //for Single Table Hierarchy 
@PrimaryKeyJoinColumn(name="COMPANY_ID")//Joined Subclass  
public class MultinationalCompany extends Company {

	@Column(name = "COUNTRY")
	private String headOfficeCountry;

	public String getHeadOfficeCountry() {
		return headOfficeCountry;
	}

	public void setHeadOfficeCountry(String headOfficeCountry) {
		this.headOfficeCountry = headOfficeCountry;
	}

	@Override
	public String toString() {
		return super.toString()+ " MultinationalCompany [headOfficeCountry=" + headOfficeCountry + "]";
	}
}
