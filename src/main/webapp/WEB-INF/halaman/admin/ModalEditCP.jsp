<!DOCTYPE html>
<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html lang="en">
    <head></head>
    <body>
        <div class="modal-content" style='max-width:300px;left:500px;'>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><p>Company Logo<span class="glyphicon glyphicon-stats"></span></p></h4>
            </div>
            
            <form role="form" action="editCP" method="POST">
	            <div class="modal-body">
	                
	                    <div class="form-group">
	                        <input id='getImg' type="file" name="logoImg" class="imgInp form-control" />
	                        <img id="imgResult" src="/resources/img/noimage.png" width="100px" height="100px" alt="" />
	                    </div>
	                
	            </div>
	            
	            <div class="modal-footer">
	                <button type="submit" class="btn btn-success">Save</button>
	            </div>
            </form>
            
        </div>
    </body>
</html>