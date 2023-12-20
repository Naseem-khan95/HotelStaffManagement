package com.hotelStaffManagement.Dao;
import java.util.List;

import com.hotelStaffManagement.model.HotelStaff;

public interface HotelStaffDao
{
	public void save(HotelStaff hotelStaff);
	public HotelStaff findById(int id);
	List<HotelStaff> findAll();
	List<HotelStaff> findStaffByDepartment(String department);
	public void delete(int id);	
}
