 
var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function deleteSubmit(deptId){
   	var dataToSend = JSON.stringify({id:deptId});
   	var url = contextRoot+'/deleteDep/'+deptId

   	 $.ajax({
		type: 'POST',
		url: contextRoot+'/deleteDep/'+deptId,
		dataType: "json",           // Accept header
 		//data:dataToSend,
 		//contentType: 'application/json',   // Sends - Content-type
		success: function(dataObj){
			alert(dataObj.succces)
			$('#result').html("");
			$('#errors').html("");
 			$("#result").append( '<H3 align="center"> The Recored Has Been Deleted Successfully <H3>');                
	 	    $('#result').show();
	 	    
	 	    $('#'+deptId).remove();
		},
 
		error: function(errorObject ){	
//			alert(errorObject.responseJSON);
			
			if (errorObject.responseJSON.succces == "false") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	 	 	        $("#errors").append( errorObject.responseJSON.message +'</p>');
	 	 	        $('#result').show();
			}else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}

 
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


 