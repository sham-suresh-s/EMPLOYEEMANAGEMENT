package com.tnsif.mini_project;
import java.sql.*;
import java.util.*;
public class Operations {
	public static Scanner sc = new Scanner(System.in);
	public static Connection con;
	static
	{
		sc = new Scanner(System.in);
		try {
			 con = Database_connection.getConnection();
			
		}
		catch(Exception e) {
			 System.err.println("SQLException occurred while connecting to the database:");
			 System.err.println(e.getMessage());
			 
		     // Print the stack trace (optional)
			 
		     System.err.println("Stack trace:");
		     e.printStackTrace();
			
		}
	}
	
	//Inserting operation
	
	public static int insert() throws SQLException{
		Connection con = Database_connection.getConnection();
		String emp_name , designation;
		Long mob_no;
		int id,salary;
		
		System.out.print("Employee Id : ");
		id =sc.nextInt();
		sc.nextLine();
		System.out.print("Employee Name : ");
		emp_name = sc.nextLine();
		System.out.print("Mobile Number :");
		mob_no = sc.nextLong();
		sc.nextLine();
		System.out.print("Designation : ");
		designation = sc.nextLine();
		System.out.print("Salary : ");
		salary = sc.nextInt();
		
		//Insert values into database 
		
		String query = "INSERT INTO emp(id,emp_name,mob_no,designation,salary) VALUES(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, emp_name);
		pst.setLong(3, mob_no);
		pst.setString(4, designation);
		pst.setInt(5, salary);
		int rows_affected = pst.executeUpdate();
		return rows_affected;
		
		
	}
	
	//Deletion operation
	
	public static int delete() throws SQLException{
		
	    System.out.println("ENTER EMPLOYEE ID TO DELETE : ");
	    int id = sc.nextInt();//enter the employee id which id want to delete 
	    String query = "DELETE FROM emp WHERE id = ?";
	    PreparedStatement pst = con.prepareStatement(query);
	    pst.setInt(1, id);
	    
	    int rows_affected = pst.executeUpdate();
	    return rows_affected;
	}
	
	//show operation
	
	public static void show() throws SQLException {
        
        System.out.println("1. ALL EMPLOYEES");
        System.out.println("2. SPECIFIC EMPOYEE BASED ON ID");
        int choice = sc.nextInt();
        
        //Show all employee details
        
        if (choice == 1) {
            String query = "SELECT * FROM emp";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            //checks whether the database is empty 
            
            if (!rs.isBeforeFirst()) {
                System.out.println("No employees found in the database.");
            } else {
                while (rs.next()) {
                    int id = rs.getInt("emp_id");
                    String emp_name = rs.getString("emp_name");
                    Long mob_no = rs.getLong("mob_no");
                    String designation = rs.getString("designation");
                    int salary = rs.getInt("salary");
                    
                    System.out.println("Employee ID: " + id);
                    System.out.println("Employee Name: " + emp_name);
                    System.out.println("MOBILE NUMBER: " + mob_no);
                    System.out.println("Designation: " + designation);
                    System.out.println("Salary: " + salary);
                    System.out.println("--------------------");
                }
                
            }
            
        } else if (choice == 2) {
            System.out.println("Enter Employee ID:");
            int id = sc.nextInt();
            
            String query = "SELECT * FROM emp WHERE emp_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) { 
                System.out.println("Employee with ID " + id + " not found.");
            } else {
                if (rs.next()) {
                    String emp_name = rs.getString("emp_name");
                    Long mob_no = rs.getLong("email");
                    String designation = rs.getString("designation");
                    int salary = rs.getInt("salary");
                    
                    System.out.println("Employee ID: " + id);
                    System.out.println("Employee Name: " + emp_name);
                    System.out.println("Email: " + mob_no);
                    System.out.println("Designation: " + designation);
                    System.out.println("Salary: " + salary);
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
	public static int update() throws SQLException {
		Connection con = Database_connection.getConnection();
	    System.out.println("Updating Employee Details.....");
	    String checkQuery = "SELECT COUNT(*) AS count FROM emp";
	    PreparedStatement checkPst = con.prepareStatement(checkQuery);
	    ResultSet rsCheck = checkPst.executeQuery();
	    
	    if (rsCheck.next() && rsCheck.getInt("count") == 0) {
	        System.out.println("The database is empty. No employees to update.");
	        return 0;
	    }
	    else {
	    System.out.println("Enter Employee ID to update:");
	    int id = sc.nextInt();
	    
	    System.out.println("Enter Updated Employee Name:");
	    String emp_name = sc.nextLine(); 
	    emp_name = sc.nextLine(); 
	    
	    System.out.println("Enter Updated Email: ");
	    Long mob_no = sc.nextLong();
	    
	    System.out.println("Enter Updated Designation:");
	    String designation = sc.nextLine();
	    
	    System.out.println("Enter Updated Salary:");
	    int salary = sc.nextInt();
	    
	    String query = "UPDATE emp SET emp_name = ?, mob_no = ?, designation = ?, salary = ? WHERE emp_id = ?";
	    PreparedStatement pst = con.prepareStatement(query);
	    pst.setInt(1, id);
	    pst.setString(2, emp_name);
	    pst.setLong(3, mob_no);
	    pst.setString(4, designation);
	    pst.setInt(5, salary);
	    	    
	    int rows_affected = pst.executeUpdate();
	    return rows_affected;
	    }
	    }
}