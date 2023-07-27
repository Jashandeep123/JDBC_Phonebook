package com.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Connect.dbConnect;
import com.Dao.PhoneDao;
import com.Entity.phoneEntity;

public class PhoneMain {
	
	
	
	public static void insertData() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone id : ");
		int id=sc.nextInt();
		System.out.println("Enter the name : ");
		String name=sc.next();
		System.out.println("Enter the contact number : ");
		String contact=sc.next();
		
		phoneEntity e=new phoneEntity();
		
		e.setId(id);
		e.setName(name);
		e.setPhone(contact);
		
		PhoneDao dao=new PhoneDao(dbConnect.getCon());
		boolean f=dao.insert(e);
		
		if (f=true) {
			System.out.println("Data inserted successfully.");
		}
		else {
			System.out.println("Something went wrong.");		
		}
	}

	public static void updateData() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone id : ");
		int id=sc.nextInt();
		System.out.println("Enter the name : ");
		String name=sc.next();
		System.out.println("Enter the contact number : ");
		String contact=sc.next();
		
		phoneEntity e=new phoneEntity();
		
		e.setId(id);
		e.setName(name);
		e.setPhone(contact);
		
		PhoneDao dao=new PhoneDao(dbConnect.getCon());
		boolean f=dao.update(e);
		
		if (f=true) {
			System.out.println("Data updated successfully.");
		}
		else {
			System.out.println("Something went wrong.");		
		}
	}
	
	public static void deleteData() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone id : ");
		int id=sc.nextInt();
		
		PhoneDao dao=new PhoneDao(dbConnect.getCon());
		
		boolean f=dao.delete(id);
		
		if(f=true) {
			System.out.println(" Record deleted successfully.");
		}
		else {
			System.out.println("Something went wrong.");
		}
	}
	
	public static void infoData() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone id : ");
		int id=sc.nextInt();
		
		PhoneDao dao=new PhoneDao(dbConnect.getCon());
		
		phoneEntity e = dao.info(id);
		
		System.out.println("ID : "+e.getId());
		System.out.println("Name : "+e.getName());
		System.out.println("Phone No. : "+e.getPhone());
	}
	
	public static void allData() throws SQLException {
		PhoneDao dao=new PhoneDao(dbConnect.getCon());
		
		List<phoneEntity> lst=dao.allData();
		
		for (phoneEntity e :lst) {
			System.out.println("Id : "+e.getId());
			System.out.println("Name : "+e.getName());
			System.out.println("Phone No. : "+e.getPhone());
			System.out.println("-----------------------------------");
		}
	}
	
	public static void main(String[] args) throws SQLException{
		
		Scanner sc=new Scanner(System.in);
		int ch = 0;
		while(ch!=6) {
			System.out.println("---------------*****---------------");
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. VIEW RECORD");
			System.out.println("5. VIEW ALL DATA");
			System.out.println("6. Exit");
			System.out.println("Enter your choice (1-6) - ");
			ch =sc.nextInt();
			System.out.println("---------------*****---------------");
			
			switch(ch){
				case 1:
					insertData();
					break;
				case 2:
					updateData();
					break;
				case 3:
					deleteData();
					break;
				case 4:
					infoData();
					break;
				case 5:
					allData();
					break;
				case 6:
					System.out.println("Exiting !!!");
					break;
				default:
					System.out.println("Invalid input");
			}
				
		}	
		
	}

}
