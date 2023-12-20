package com.hotelStaffController;

import java.util.Scanner;

import com.hotelStaffManagement.DaoImpl.HotelStaffDaoImpl;
import com.hotelStaffManagement.DaoImpl.HotelStaffView;
import com.hotelStaffManagement.model.HotelStaff;

public class HotelStaffManagementSystem
{
    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	HotelStaffDaoImpl hsd=new HotelStaffDaoImpl();
        HotelStaffDaoImpl hotelStaffDao = new HotelStaffDaoImpl();
        HotelStaffView hotelStaffView = new HotelStaffView();
        HotelStaffController hotelStaffController = new HotelStaffController(hotelStaffDao, hotelStaffView);
        int choice;
        final String user="naseem9136";
        final String pass="naseem@123";
        System.out.print("Enter UserName :");
        String userName=sc.nextLine();
        System.out.print("Enter Password :");
        String password=sc.nextLine();
        System.out.println();
        if(user.equals(userName) && pass.equals(password))
        {
        	System.out.println("Login successfully\n--------------------------------------");
        	
        	System.out.println();
        	while(true) 
        	{
	        	System.out.println("1.Add New Staff Member :");
	        	System.out.println("2.View All Staff Member :");
	        	System.out.println("3.Find Staff Member by ID : :");
	        	System.out.println("4.Remove Staff Member by ID :");
	        	System.out.println("5.Exit");
	        	System.out.println("Enter your chice :");
	        	choice=sc.nextInt();
        		switch(choice)
        		{
		        	case 1:
		        	{
		        		 HotelStaff newStaff = hotelStaffView.takeUserInputForNewStaff();
		                 hotelStaffController.registerHotelStaff(newStaff);
		                 hsd.save(newStaff);
		                 hotelStaffController.viewAllStaff();
		                 
		                 System.out.println("----------------------------------");
		                 break;
		        	}
		        	case 2:
		        	{
		        		System.out.println("All Member Details Are Below :");
		        		hotelStaffController.viewAllStaff();
		        		System.out.println("--------------------------------------");
		        		break;
		        	}
		        	case 3:
		        	{
		        		System.out.println("Enter ID to Find Staff Member :");
		                int id=sc.nextInt();
		        		System.out.println(hsd.findById(id));
		        		break;
		        	}
		        	 case 4:
		                    System.out.println("Enter ID To Delete Member :");
		                    int deleteId = sc.nextInt();
		                    hotelStaffController.deleteStaff(deleteId);
		                    break;
		                case 5:
		                    System.out.println("Exiting...");
		                    System.exit(0);
        		}
        	}
            // hotelStaffController.registerHotelStaff(newStaff);
             
//             System.out.println("Enter department to search Staff member :");
//             String department=sc.nextLine();
//             sc.next();
//             System.out.println(hsd.findStaffByDepartment(department));
        }
        else
		{
			System.out.println("Invalid UserName or Password !");
		}
    }
}