<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>

	<p class="lead">
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid eos cupiditate alias error saepe eius qui omnis maiores quasi unde! Cum, enim, illo porro debitis eos iure officia dolore rerum.
			Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas, soluta, deleniti expedita praesentium perspiciatis dignissimos velit accusantium! Facilis, repudiandae, sit, nesciunt eum quibusdam vero sint optio possimus voluptas nobis vel!
	</p>
	<hr>
	<c:url var="saveUrl" value="/main/common.do" />
	<form:form action="${saveUrl}" method="POST" modelAttribute="listI">
<table>
<thead>
<tr>
 
<th>#</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th>Item Name</th>
<th>Price</th>
<th></th>
<th>Qty</th>
<th></th>
 
</tr>
</thead>
<tbody>
<c:forEach items="${listI.listInvent}" var="item" varStatus="status">
<tr>
 
<td>${status.count}</td>
<td><input type="hidden" name="listInvent[${status.index}].itemTransId" value="${item.itemTransId}"/></td>
<!--<td><input type="hidden" name="listInvent[${status.index}].dateTrans" value="${item.dateTrans}"/></td> -->
<td><input type="hidden" name="listInvent[${status.index}].accountNum" value="${item.accountNum}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].prNum" value="${item.prNum}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].itemId" value="${item.itemId}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].itemName" value="${item.itemName}"/></td>
<td>${item.itemName}</td>
<td><fmt:formatNumber value="${item.price}" type="number" maxFractionDigits="3" /></td>
<td><input type="hidden" name="listInvent[${status.index}].price" value="${item.price}"/></td>
<td><input name="listInvent[${status.index}].qty" value="${item.qty}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].amount" value="${item.amount}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].dataAreaId" value="${item.dataAreaId}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].recVersion" value="${item.recVersion}"/></td>
<td><input type="hidden" name="listInvent[${status.index}].recId" value="${item.recId}"/></td>


</tr>
 
</c:forEach>
</tbody>
<tfoot>
<tr>
<th colspan="8">
<p>Please click if finished Order &gt;&gt;  &nbsp;<button class="btn btn-success btn-large" type="submit">PROCESS</button></p>
</th>
</tr>
<tr>
	<th colspan="8">
		<a href="/Sriboga/report/pdfhtml.do">Export to PDF</a>
	</th>
</tr>
</tfoot>

</table>

</form:form>

<script type="text/javascript">
	(function(){
		
		$('p.lead').hover(function() {
			console.log($(this));
		}, function() {
			console.log('aniamiton out!');
		});
	
	})();
</script>