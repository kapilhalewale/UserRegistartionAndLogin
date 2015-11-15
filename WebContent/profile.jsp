<%@page import="dao.StudentDao"%>
<%@page import="model.Student, java.util.Iterator, java.util.List, java.util.Random"%>

<link rel="stylesheet" type="text/css" href="student.css">
<%if(session.getAttribute("user")!=null){ %>
<label id='punch'>Welcome Mr- <%=session.getAttribute("user") %></label>,
<label id='logout' onclick="location.href='logout.jsp'">Logout</label>  
<hr  style='border:2px solid orange;'/>
<h2>Insynk Software Solution</h2>
<table border="0" width="90%" align='center'>
	<tr>
		<td width="30%" valign='top'>
		<br>
		<% 
		String register = (String)session.getAttribute("register");
		String user = (String)session.getAttribute("user");
		String userId = (String)session.getAttribute("userId");
		 %>
		<%if(register.equalsIgnoreCase("yes")){ %>
		<div style='border:2px solid orange;width:320'>
			<table border='0'bgcolor="lavender"width='320' style='font-size:14px; font-family:calibri'cellpadding='6'>
				<tr>
					<td colspan='2'>Please note down these login details for further user</td>
				<tr>	
					<td align='right' width="50%">User Name :</td><td><%=session.getAttribute("username") %></td>
				</tr>
				<tr>
					<td align='right'>Password :</td><td><%=session.getAttribute("password") %></td>
				</tr>

			</table>
			</div>
			<% }else{ %>
			<table bgcolor="white" style='font-size:14px; font-family:calibri'cellpadding='6'>
			<% 
				Student stu = StudentDao.getStudentById(userId);
			%>
				<tr>
					<td>Name</td><td> : <%= stu.getFirstName() %>&nbsp;<%= stu.getLastName() %></td>
				</tr>
				<tr>
					<td>Mobile</td><td> : <%= stu.getMobile() %></td>
				</tr>		
				<tr>
					<td>Date Of Birth</td><td> : <%= stu.getDob() %></td>
				</tr>				
				<tr>
					<td>Email</td><td> : <%= stu.getEmail() %></td>
				</tr>						
				
				<tr>
					<td>Address</td><td> : <%= stu.getState() %> &nbsp; <%= stu.getCountry() %></td>
				</tr>
			</table>
			<% } %>
		</td>
		<td width="60%" valign='top' align='center'>
			<% 	List<Student> list = StudentDao.getAllStudent(); %>
			<span style='font-family:calibri'>Registered Students <%=list.size() %></span>
			<table border='1'cellpadding='4' width='600'style='font-family:calibri; font-size:14px;' align="center">
				<tr align='center' style='text-transform:uppercase;' bgcolor='silver'>
					<td></td><td>Student Name</td><td>DOB</td><td>Mobile</td>
					<td>Email</td><td>Address</td>
				</tr>
				<%
				Iterator it = list.iterator();
				Student student = null;
				while(it.hasNext()){
				student = (Student) it.next();
				%>
	
				<tr align='center' class='header'>
					<td style='border-bottom:1px dotted black'>
						<a href='Controller?action=drop&&id=<%=student.getId() %>'>
						<img src='img/trash.png'>
						</a>	
					</td>
					<td style='border-bottom:1px dotted black'>
					<%= student.getFirstName() %>&nbsp;<%= student.getLastName() %></a></td>
					<td style='border-bottom:1px dotted black'><%= student.getDob() %></td>
					<td style='border-bottom:1px dotted black'><%= student.getMobile() %></td>
					<td style='border-bottom:1px dotted black'><%= student.getEmail() %></td>
					<td style='border-bottom:1px dotted black'><%= student.getState() %>&nbsp;<%= student.getCountry() %></td>
				</tr>
				<% } %>
			</table>
				
		</td>
</table>
<%
	
}else{
	request.getRequestDispatcher("index.jsp").include(request, response);
	out.print("<br><font color='green'>Session Expired Please login again</font>");					

}
%>