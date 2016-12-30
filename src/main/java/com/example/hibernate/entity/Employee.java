package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"), @UniqueConstraint(columnNames = "EMAIL")})
public class Employee 
{
   @Id
   @Column(name = "ID", unique = true, nullable = false)
   private Integer           empId;
   @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
   private String            email;
   @Column(name = "NAME", unique = false, nullable = false, length = 100)
   private String            name;
  
   public Integer getEmpId()
   {
      return empId;
   }
 
   public void setEmpId(Integer empId)
   {
      this.empId = empId;
   }
 
   public String getEmail()
   {
      return email;
   }
 
   public void setEmail(String email)
   {
      this.email = email;
   }
 
   public String getName()
   {
      return name;
   }
 
   public void setName(String name)
   {
      this.name = name;
   }

@Override
public String toString() {
	return "Employee [empId=" + empId + ", email=" + email + ", name=" + name + "]";
}
   
   
   
 
  
}
