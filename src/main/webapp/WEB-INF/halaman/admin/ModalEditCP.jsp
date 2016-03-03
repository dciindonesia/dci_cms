<!DOCTYPE html>
<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html lang="en">
    <head>
    	<script type="text/javascript">
    		$(document).ready(function(){
    			$('.imgInp').on('change', function() {
					readPath(this);
				});
    		});
    		function readPath(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function (e) {
						$('#imgResult').attr('src', e.target.result);
					}
					reader.readAsDataURL(input.files[0]);
				}
			}
    	</script>
    </head>
    <body>
        <div class="modal-content" style='max-width:300px;left:500px;'>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><p>Company Logo<span class="glyphicon glyphicon-stats"></span></p></h4>
            </div>
            
            <form role="form" action="editCPs?companyId=${companyId}" method="GET">
	            <div class="modal-body">
	                <input type="hidden" name="companyId" class="hidden" value="${companyId}"/>
	                    <div class="form-group">
	                    	<input id="logoImg" type="file" name="getImg" class="imgInp" />
	                        <img id="imgResult" src="${logoPath}" width="100px" height="100px" alt="" />
	                    </div>
	                
	            </div>
	            
	            <div class="modal-footer">
	                <button type="submit" class="btn btn-success">Save</button>
	            </div>
            </form>
            
        </div>
    </body>
</html>