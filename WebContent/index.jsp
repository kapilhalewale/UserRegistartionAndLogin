<link rel="stylesheet" type="text/css" href="student.css">
<label onclick="setVisibility('register', 'inline');" style='cursor: pointer;'>Register</label> |
<a href='login.html'>Login In</a> 


<hr  style='border:2px solid orange;'/>

<script language="JavaScript">
      function setVisibility(id, visibility) {
      document.getElementById(id).style.display = visibility;
      }

</script>
<div id="register">
<table border='2' bordercolor='#424242' width='700' class='boxs' height="150">
	<tr>
		<td height='20'bgcolor='#424242' align='right'>
			<table width='697' border='0'>
				<tr>
					<td width='200' align='left' style='color:white;font-family:Segoe UI Light;'>Add Student</td>
					<td align='right'><input type='image' class='hk' src="img/cl.png" height='20'width='20'onclick="setVisibility('register', 'none');"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
	<td bgcolor='white'>  
		<form name="myform" action="Controller" onsubmit="return validate()" method='post'>
			<table cellpadding='10' border='0' align='center' width='600'>
			<tr><td height='15'></td></tr>
			<tr>
			    <td class='label' align='right'>First Name :</td>
			    <td><input type="text" title="Enter First Name" required name="fname" maxlength='30' pattern="[A-Za-z]{10,3}"></td>
			
			    <td class='label' align='right'>Last Name :</td>
			    <td><input type="mobile" title="Enter Last Name" required name="lname" maxlength='30' pattern="[A-Za-z]{10,3}"></td>
			</tr>
			<tr>
			    <td class='label' align='right'>Email Address :</td>
			    <td><input type="text" title="Enter Current Email" required name="email"></td>
			
			    <td class='label' align='right'>Mobile Number :</td>
			    <td><input type="mobile" title="Enter Mobile Number" required name="mobile"pattern="[0-9]{10,}" maxlength='11'></td>
			</tr>
			<tr>
			    <td class='label' align='right'>Date Of Birth :</td>
			    <td><input type="date" title="Enter Current Email" required name="dob"></td>
			
			    <td class='label' align='right'>Age :</td>
			    <td>
                      <select name='age' style='width:70px;border:1px solid orange;'>
	                      <option valuee=''>Select</option>
							<% for (int i=16; i<125; i++) { %>
						  <option value="<%= i %>"><%= i %> year <% } %>
                       </select>			    
				</td>
			</tr>			
			<tr>
			    <td class='label' align='right'>State :</td>
			    <td><input type="text" title="Enter your city" required name="state" pattern="[A-Za-z]{10,3}"></td>
			
			    <td class='label' align='right'>Country :</td>
			    <td><input type="text" title="Enter Country" placeholder='Ex- India' required name="country"pattern="[A-Za-z]{10,3}" maxlength='35' ></td>
			</tr>
			 <tr>
			    <td></td>
			    <td colspan='2'><input type="submit" value="Add" name='action'class='buttun' style='background-color:#424242' >
			    &nbsp;<input type="reset" value="Reset"class='buttun'style='background-color:#424242' >
			    &nbsp;<input type="button" value="Cancel"class='buttun'style='background-color:#424242' onclick="setVisibility('register', 'none');" >
			    </td>
			</tr> 
			</table>  
		</form>
	</td>
	</tr>
</table>
</div>