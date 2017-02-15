/**
 * 
 */
package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Shamik Mitra
 *
 */
@Embeddable
public class Address {
	
	 @Column(name = "ADDRESS_LINE", length = 100)
	   private String  address;
	   @Column(name = "ZIP",  length = 100)
	   private String            zip;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", zip=" + zip + "]";
	}
	   
	   
	   

}
