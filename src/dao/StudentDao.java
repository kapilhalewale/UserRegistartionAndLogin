/*
   Developed By    : Kapil Kumar 
   Designed Date   : 19 Oct 2015
   Purpose Of File : StudentDao Class to add, select, drop and edit the student 
   
 */

/** 
create table if not exists myStudent(
id int(5),firstName varchar(30),lastName varchar(30),
dob varchar(12), age int(3), userName varchar(12), password varchar(12),
state varchar(35),country varchar(25),mobile varchar(11),email varchar(35), PRIMARY KEY (id));

 **/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.ConnectionProvider;
import model.Student;


public class StudentDao {
	static Connection con = ConnectionProvider.getCon();
	static PreparedStatement statement;
	static ResultSet result;
	static int status = 0;
	
	
	// Method to Add Student into mySql Database
		public static  int addStudent(Student student) {
		
			try {		
					statement=con.prepareStatement("insert into myStudent values(?,?,?,?,?,?,?,?,?,?,?)");
					statement.setInt(1, student.getId());
					statement.setString(2, student.getFirstName());
					statement.setString(3, student.getLastName());
					statement.setString(4, student.getDob());
					statement.setInt(5, student.getAge());
					statement.setString(6, student.getUsername());
					statement.setString(7, student.getPassword());
					statement.setString(8, student.getState());
					statement.setString(9, student.getCountry());
					statement.setString(10, student.getMobile());
					statement.setString(11, student.getEmail());
				
					status= statement.executeUpdate();		
				} catch (SQLException e) {
				  e.printStackTrace();
				}
			return status;
		}
		
		// Method for getting all the student data from database
		public static List<Student> getAllStudent() {
			List<Student> studentList = new ArrayList<Student>();

			try {
				statement = con
						.prepareStatement("select * from myStudent");
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setFirstName(rs.getString("firstName"));
					student.setLastName(rs.getString("lastName"));
					student.setDob(rs.getString("dob"));
					student.setMobile(rs.getString("mobile"));
					student.setEmail(rs.getString("email"));
					student.setState(rs.getString("state"));
					student.setCountry(rs.getString("country"));
					student.setUsername(rs.getString("username"));
					student.setPassword(rs.getString("password"));						
					studentList.add(student);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return studentList;
		}		
		
		// Method for getting  student by id
		public static Student getStudentById(String username) {
			Student student = new Student();
			try {
				statement = con.prepareStatement("select * from myStudent where userName=?");
				statement.setString(1, username);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					student.setId(rs.getInt("id"));
					student.setFirstName(rs.getString("firstName"));
					student.setLastName(rs.getString("lastName"));
					student.setDob(rs.getString("dob"));
					student.setMobile(rs.getString("mobile"));
					student.setEmail(rs.getString("email"));
					student.setState(rs.getString("state"));
					student.setCountry(rs.getString("country"));
					student.setUsername(rs.getString("username"));
					student.setPassword(rs.getString("password"));						
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}				
		// Method for getting  student by id
		public static Student check(String userid) {
			Student student = new Student();
			try {
				statement = con.prepareStatement("select firstName, userName, password from myStudent where userName=?");
				statement.setString(1, userid);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					student.setFirstName(rs.getString("firstName"));
					student.setUsername(rs.getString("userName"));
					student.setPassword(rs.getString("password"));	
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}	
		// Method to drop student
		public static int drop(int id){
			int dropStatus=0;
			 try {
				statement = con.prepareStatement("delete from mystudent where id=?");
				 statement.setInt(1, id);
				 dropStatus = statement.executeUpdate();

			 } catch (SQLException e) {
					e.printStackTrace();
				}
			return dropStatus;
		}		
}
