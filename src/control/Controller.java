package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;

import model.Student;



public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	    HttpSession  session= request.getSession();
		if(request.getParameter("action")!=null){
			String action= request.getParameter("action");	
			if(action.equalsIgnoreCase("add")){
				// Generating random id
				Random r  = new Random();
				int id = r.nextInt(100);
		
				// Giving one random user name and password;
				String username=request.getParameter("fname");
				String password=request.getParameter("fname")+id;	

				Student student = new Student();
				student.setFirstName(request.getParameter("fname"));
				student.setLastName(request.getParameter("lname"));
				student.setDob(request.getParameter("dob"));				
				student.setAge(Integer.parseInt(request.getParameter("age")));
				student.setState(request.getParameter("state"));				
				student.setCountry(request.getParameter("country"));				
				student.setMobile(request.getParameter("mobile"));				
				student.setEmail(request.getParameter("email"));				
				student.setId(id);
				student.setUsername(username);
				student.setPassword(password);
				int status = StudentDao.addStudent(student);
				if(status!=0){
				System.out.println("Student Data Added");

			    session.setAttribute("user", request.getParameter("fname"));
			    session.setAttribute("username", username);
			    session.setAttribute("password", password);
			    session.setAttribute("register", "yes");
				response.sendRedirect("profile.jsp");

				}else{
				System.out.println("Student Data Not Added");			
				}
			}//action if	
		if(action.equalsIgnoreCase("login")){
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			
			Student check = StudentDao.check(userid);
			if(userid.equalsIgnoreCase(check.getUsername())){
				
				if(pwd.equalsIgnoreCase(check.getPassword())){
				    session.setAttribute("user", check.getFirstName());
				    session.setAttribute("userId", check.getUsername());
				    session.setAttribute("register", "no");

					response.sendRedirect("profile.jsp");
					
				}else{
					request.getRequestDispatcher("login.html").include(request, response);
					pw.print("<br><font color='red'>Invalid password</font>");					
				}
				
			}else{
				request.getRequestDispatcher("login.html").include(request, response);
				pw.print("<br><font color='red'>Invalid User ID</font>");					
			}
		}
		if(action.equalsIgnoreCase("drop")){
			
			StudentDao.drop(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("profile.jsp");
		}
	}// Checking request null if close here
		
	}
}
