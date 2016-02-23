$(document).ready(function(){
	var counter = 2;
	$('.imgInp').on('change', function() {
		readPath(this);
	});
	
	$("#addButton").click(function () {
		if(counter>10){
			alert("Only 10 questions allowed in one survey");
		    return false;
		}  
		var newTextBoxDiv = $(document.createElement('div'))
			.attr("id", 'TextBoxDiv' + counter);

		newTextBoxDiv.after().html(
		'<label> Contact Person '
		+ counter 
		+ ' : </label>' 
		+ '<input type="file" name="contactImg" id="imgInp">' 
		+ '<br>' 
		+ '<strong>Name</strong> :&nbsp;&nbsp; <input type="textbox" name="contactName" class="input-text-cust form-control" placeholder="Contact Name" >'
		+ '<br><br>');

		newTextBoxDiv.appendTo("#TextBoxesGroup");
		counter++;
	});

	$("#removeButton").click(function () {
		if(counter==1){
			alert("No question to remove");
			return false;
		}   
		counter--;
		$("#TextBoxDiv" + counter).remove();
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
		
		