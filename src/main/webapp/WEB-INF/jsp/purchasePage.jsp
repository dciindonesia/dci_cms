<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
	<div class="page-header">
		<h3>Welcome ${username}</h3>

	</div>
<p>You have Logged In</p>
<p>
	To start order please check a checkmark below and press green button. <br> 
	Click Tab for packaging. <br>
	Happy Shopping. <br>
</p>
<hr />

<c:url value="/main/searching.do" var="searched" />
 	<form:form action="${searched}" method="POST">
		
 		<div class="input-prepend input-append">
 		
 			<span class="add-on">
	 			<a data-dismiss="search-query" href="">
		        	<i class="icon-remove"></i>
		    	</a>
	    	</span>
	    	
	    	<input type="text" name="searchs" placeholder="Search&hellip;" />

	    	<span class="add-on">
	      		<button type="submit" value="Submit"><i class="icon-search"></i></button>        
	    	</span>
 		
 		</div>
            
    </form:form>

<c:url value="/main/purc.do" var="buyProc" />
<form:form action="${buyProc}" method="POST" commandName="itis">

 <div class="hero-unit">
 	<div class="pull-right">
 		<p>
 			Please click if finished Order &gt;&gt;  &nbsp;
 			<button class="btn btn-success btn-large" type="submit">PROCESS</button>
 		</p>
 	</div>
 </div>
<hr />

  <div class="tabbable" id="demo-tab"> <!-- Only required for left/right tabs -->
    <!-- Tab Definitions-->               
    <ul class="nav nav-tabs" id="getStartedTab">
      <li class="active"><a href="#simple" data-toggle="tab">25 KG</a></li>
      <li><a href="#mapping" data-toggle="tab">1 KG</a></li>
      <li><a href="#data" data-toggle="tab">Others</a></li>
       </ul>  

    <!-- Tab Content-->
    <div class="tab-content">                  
      <div class="tab-pane active" id="simple">
        <h2>Flour 25 Kg Package</h2>
        <p>
          This the <code>hot item</code> get order right now.
        </p>
	
<table class="table">
	<caption><strong>L I S T &nbsp;   O F  &nbsp;  I T E M</strong></caption>
	<thead>
		<tr>
			<th>#</th>
			<th>No</th>
			<th>Product</th>
			<th>..</th>
		</tr>
		<tr>
			<td colspan="5"><center>...</center></td>
		</tr>
		
	</thead>
	<tbody>
		
		<c:if test="${empty KG25}">
			<tr>
				<td colspan="5">No Results 25 KG found</td>
			</tr>
		</c:if>
		
		<c:if test="${! empty KG25}">
			
			<c:forEach var="KG25" items="${KG25}" begin="1" varStatus="loop">
				<tr>
				<td>${loop.count}</td>
				<td><form:checkbox path="idList" value="${KG25.key}" /></td>
				<td>${KG25.value}</td>
				</tr>
			</c:forEach>
			
		</c:if>
		
	</tbody>
	<tfoot>
		<tr>
			<th colspan="5">
				<hr />
				 END OF : 25 KG <blockquote><p class="pull-right"><a href="#">Back to Top</a></p></blockquote>
 			</th>
		</tr>
	</tfoot>
</table>

</div>

<div class="tab-pane" id="mapping">
        <h2>Flour 1 Kg Package</h2>
        <p>
          This the <code>smallest package</code> and get it order now.
        </p>
        
        <table class="table">
	<caption><strong>L I S T &nbsp;   O F  &nbsp;  I T E M</strong></caption>
	<thead>
		<tr>
			<th>#</th>
			<th>No</th>
			<th>Product</th>
			<th>..</th>
		</tr>
		<tr>
			<td colspan="5"><center>...</center></td>
		</tr>
		
	</thead>
	<tbody>
		
		<c:if test="${empty KG1}">
			<tr>
				<td colspan="5">No Results 1 KG found</td>
			</tr>
		</c:if>
		
		<c:if test="${! empty KG1}">
			
			<c:forEach var="KG1" items="${KG1}" begin="1" varStatus="loop">
				<tr>
				<td>${loop.count}</td>
				<td><form:checkbox path="idList" value="${KG1.key}" /></td>
				<td>${KG1.value}</td>
				</tr>
			</c:forEach>
		</c:if>
		
	</tbody>
	<tfoot>
		<tr>
			<th colspan="5">

				 END OF : 1 KG &nbsp; <blockquote><p class="pull-right"><a href="#">Back to Top</a></p></blockquote>
 			</th>
		</tr>
	</tfoot>
</table>
 </div> 
 
 
 <div class="tab-pane" id="data">
        <h2>Flour other Package</h2>
        <p>
          This is <code>custom flour</code> and this specialized from PT. Sriboga FlourMill.
        </p>
        
        <table class="table">
	<caption><strong>L I S T &nbsp;   O F  &nbsp;  I T E M</strong></caption>
	<thead>
		<tr>
			<th>#</th>
			<th>No</th>
			<th>Product</th>
			<th>..</th>
		</tr>
		<tr>
			<td colspan="5"><center>...</center></td>
		</tr>
		
	</thead>
	<tbody>
		
		<c:if test="${empty KG50}">
			<tr>
				<td colspan="5">No Results found for other</td>
			</tr>
		</c:if>
		
		<c:if test="${! empty KG50}">
			
			<c:forEach var="KG50" items="${KG50}" begin="1" varStatus="loop">
				<tr>
				<td>${loop.count}</td>
				<td><form:checkbox path="idList" value="${KG50.key}" /></td>
				<td>${KG50.value}</td>
				</tr>
			</c:forEach>
			
		</c:if>
		
	</tbody>
	<tfoot>
		<tr>
			<th colspan="5">
				<hr />
				 END OF OTHER &nbsp; <blockquote><p class="pull-right"><a href="#">Back to Top</a></p></blockquote>
 			</th>
		</tr>
	</tfoot>
</table>

        </div>
 
</div>

</div> 
<hr />

<div class="hero-unit">
				<div class="pull-right"><p>Please click if finished Order &gt;&gt;  &nbsp;<button class="btn btn-success btn-large" type="submit">PROCESS</button></p></div>
				</div>

</form:form>

<script type="text/javascript">

function reply_click(clicked_id) {
	var chk = "c" + clicked_id
    alert(chk);
    document.getElementById(clicked_id).setAttribute("disabled", "disabled")
    document.getElementById(chk).setAttribute("checked", "checked")
}

function toggleCheckBoxes() {
	var searchIDs = $('input:checked').map(function(){
		return $(this).val();
	});
	console.log(searchIDs.get());
};

$(document).ready(function () {
	/*
	$('button').click(function(){
		$('button').attr("disabled", true);
		
	});
	*/
});
	</script>