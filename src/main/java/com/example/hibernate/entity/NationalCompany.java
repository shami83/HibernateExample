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
@Table(name="NATIONAL_COMPANY")  
//@DiscriminatorValue("NATIONAL")  //for Single Table Hierarchy 
@PrimaryKeyJoinColumn(name="COMPANY_ID")//Joined Subclass  
public class NationalCompany extends Company{
	
	 @Column(name = "STATE")
	private String headOfficeState;

	public String getHeadOfficeState() {
		return headOfficeState;
	}

	public void setHeadOfficeState(String headOfficeState) {
		this.headOfficeState = headOfficeState;
	}

	@Override
	public String toString() {
		return super.toString()+ " NatonalCompany [headOfficeState=" + headOfficeState + "]";
	}

}
