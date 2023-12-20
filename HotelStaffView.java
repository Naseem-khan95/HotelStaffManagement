package com.hotelStaffManagement.DaoImpl;

import java.util.List;
import java.util.Scanner;

import com.hotelStaffManagement.model.HotelStaff;

public class HotelStaffView 
{
	Scanner scanner=new Scanner(System.in);
	public HotelStaff takeUserInputForNewStaff() 
	{
        System.out.println("Enter New Hotel Staff Details:");

        System.out.print("Name: ");
        String staffName = scanner.nextLine();

        System.out.print("Position: ");
        String position = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        return new HotelStaff(staffName, position, department, phoneNumber);
	}
    public void displayStaffDetails(HotelStaff hotelStaff) {
        System.out.println("Hotel Staff Details:");
        System.out.println("Staff ID: " + hotelStaff.getStaffId());
        System.out.println("Name: " + hotelStaff.getName());
        System.out.println("Position: " + hotelStaff.getPsition());
        System.out.println("Department: " + hotelStaff.getDepartment());
        System.out.println("Phone Number: " + hotelStaff.getPhoneNumber());
        System.out.println();
    }

    public void displayAllStaff(List<HotelStaff> hotelStaffList)
    {
        //System.out.println("All Hotel Staff:");
        for (HotelStaff staff : hotelStaffList) {
            displayStaffDetails(staff);
        }
    }
}