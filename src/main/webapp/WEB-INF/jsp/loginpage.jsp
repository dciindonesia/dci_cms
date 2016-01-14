<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
	<style type="text/css">

      .form-signin {
        max-width: 100%;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
    </style>

<p>
  To Start order you must be logged in.<br>
  If your company doesn't have account to this site, please contact Us.<br>
  And if you don't have Flour that you want to order please contact Us.<br>
  We will be greatfull to help you.<br>
  Thank You for your time to take order Sriboga FlourMill Product with this
  site.
</p>

<hr>

<c:url value="/j_spring_security_check" var="loginCheck" />
<form:form action="${loginCheck}" method="post" class="form-horizontal">
<form:errors path="*" class="alert alert-block alert-error collapse" element="div"/>

<div class="control-group">
	<div class="controls">
	<h2><code>Please sign in</code></h2>
	</div>
</div>

<div class="control-group">
	<label class="control-label">User Name</label>
	<div class="controls">
	<input id="j_username" name="j_username" type="text" placeholder="Username"/>
	</div>
</div>

<div class="control-group">
	<label class="control-label">Password</label>
	<div class="controls">
		<input id="j_password" name="j_password" type="password" placeholder="Password"/>
	</div>
</div>

<div class="control-group">
	<div class="controls">
	<label class="checkbox">
         <input type="checkbox" value="remember-me" /> Remember me
    </label>
    <br />
    <br />
    <button class="btn" type="submit">Sign in</button>
    					
	</div>
</div>

</form:form>

<div class="addres">
  
<p>
  <code>OFFICE :</code><br>
  PT. Sriboga Flour Mill<br>
   Plaza Daniprisma Lt.2 & 3,<br> 
   Jl. Sultan Hasanudin No 47-48.<br>
   Kebayoran Baru,<br>
   Jakarta Selatan 12160 - Indonesia<br>
   Telp. (62-21) 725 0240<br>
   Fax. (62-21) 7206008, 72793039<br>
   Email : info@sriboga-flourmill.com<br> 
</p>
<p>   
  <code>FACTORY :</code><br>
   Jl. Deli No. 10 & 23 Tanjung Emas<br>
   Semarang 50174 - Indonesia<br>
   Telp. (62-24) 3558373<br>
   Fax. (62-24) 3553800<br>
   <br> 
  Customer Care 0-800-140-1109<br>
  <br>
</p>

</div>