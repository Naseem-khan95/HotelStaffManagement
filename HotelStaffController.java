package com.hotelStaffController;

import java.util.List;

import com.hotelStaffManagement.Dao.HotelStaffDao;
import com.hotelStaffManagement.DaoImpl.HotelStaffView;
import com.hotelStaffManagement.model.HotelStaff;

public class HotelStaffController {
    private HotelStaffDao hotelStaffDao;
    private HotelStaffView hotelStaffView;

    public HotelStaffController(HotelStaffDao hotelStaffDao, HotelStaffView hotelStaffView)
    {
        this.hotelStaffDao = hotelStaffDao;
        this.hotelStaffView = hotelStaffView;
    }

    public void registerHotelStaff(HotelStaff hotelStaff) 
    {
        hotelStaffDao.save(hotelStaff);
        System.err.println("Member Save Successfully :");
    }

    public void viewStaffDetails(int staffId) 
    {
    	System.out.println("Staff ");
        HotelStaff staff = hotelStaffDao.findById(staffId);
        hotelStaffView.displayStaffDetails(staff);
    }

    public void viewAllStaff() 
    {
        List<HotelStaff> staffList = hotelStaffDao.findAll();
        hotelStaffView.displayAllStaff(staffList);
    }

    public void viewStaffByDepartment(String department)
    {
        List<HotelStaff> staffByDepartment = hotelStaffDao.findStaffByDepartment(department);
        hotelStaffView.displayAllStaff(staffByDepartment);
    }

    public void deleteStaff(int staffId)
    {
        hotelStaffDao.delete(staffId);
        System.out.println("Member Deleted Successfully :");
        System.out.println("-----------------------------------------");
    }
}

