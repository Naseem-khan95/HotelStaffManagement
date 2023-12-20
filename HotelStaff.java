package com.hotelStaffManagement.model;

import java.util.Objects;

public class HotelStaff 
{
	private int staffId;
	private String Name;
	private String position;
	private String department;
	private String phoneNumber;
	
	public int getStaffId()
	{
		return staffId;
	}

	public void setStaffId(int staffId) 
	{
		this.staffId = staffId;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}

	public String getPsition() 
	{
		return position;
	}

	public void setPsition(String psition) 
	{
		this.position = psition;
	}

	public String getDepartment() 
	{
		return department;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public HotelStaff(String name, String psition, String department, String phoneNumber) 
	{
		super();
		Name = name;
		this.position = psition;
		this.department = department;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() 
	{
		return "HotelStaff [staffId=" + staffId + ", Name=" + Name + ", psition=" + position + ", department="
				+ department + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(Name, department, phoneNumber, position, staffId);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelStaff other = (HotelStaff) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(department, other.department)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(position, other.position)
				&& staffId == other.staffId;
	}
}
