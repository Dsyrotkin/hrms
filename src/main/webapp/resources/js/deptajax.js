 
var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function deleteSubmit(deptId){
   	var dataToSend = JSON.stringify({id:deptId});
   	var url = contextRoot+'/deleteDep/'+deptId

   	 $.ajax({
		type: 'POST',
		url: contextRoot+'/deleteDep/'+deptId + '?' + $("#csrf").attr("name") + '=' + $("#csrf").val(), 
		dataType: "json",           // Accept header
 		//data:dataToSend,
 		//contentType: 'application/json',   // Sends - Content-type
		success: function(dataObj){
			//alert(dataObj.succces)
			$('#result').html("");
			$('#errors').html("");
 			$("#result").append( '<div class="alert alert-success"> <p>The Recored Has Been Deleted Successfully</p></div>');                
	 	    $('#result').show();
	 	    
	 	    $('#'+deptId).remove();
		},
 
		error: function(errorObject ){	
//			alert(errorObject.status);
//			alert(errorObject)
			//alert(errorObject.responseJSON.succces);
			if(errorObject.status == 401 || errorObject.status == 403){
				$('#result').html("");
				$('#errors').html("");
	 			$("#result").append( '<div class="alert alert-danger"> <p> There is no permission for the user to delete </p></div>');                
		 	    $('#result').show();
			}else  if (!errorObject.responseJSON.succces ) {
				
				$('#result').html("");
				$('#errors').html("");
	 			$("#result").append( '<div class="alert alert-danger"> <p> '+errorObject.responseJSON.message +'</p></div>');                
		 	    $('#result').show();
		 	    
		 	    
				
			}else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}


function changeAction(actionName) {
	document.getElementById("deptForm").action = actionName;
}

function confirmDelete(deptId){
	//alert( $( "#dialog-confirm" ))
	
	  $( function() {
		    $( "#dialog-confirm" ).dialog({
		      resizable: false,
		      height: "auto",
		      width: 400,
		      modal: true,
		      buttons: {
		        "Delete": function() {
		          $( this ).dialog( "close" );
		          deleteSubmit(deptId);
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		  } );
	
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


 