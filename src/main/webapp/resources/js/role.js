
	function addRoleUser(role_id,role_name){
		
		var username = $('#input_' + role_name).val();
		var userRoleData = {"username" : username, "roleName" : role_name};
		$('#alert_' + role_name).hide();
		$('#success_' + role_name).hide();
		$.ajax({
			url: '/hrms/admin/role/addUserRole?' + $("#csrf").attr("name") + '=' + $("#csrf").val(),
			type: 'POST',
			data: JSON.stringify(userRoleData),
			contentType: 'application/json',
			dataType: "json",
			success: function(response){
				$('#success_' + role_name).html("Role has been successfully given the user.");
				$('#success_' + role_name).show();
				$('#list_' + role_name).append('<a id="'+ username + role_name +'" href="#" class="list-group-item">'+ username
						+'<span class="pull-right">' +
						'<span id="buttondelete_'+ username + role_name +'" class="btn btn-xs btn-danger">' +
						'<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
						'</span>' +
						'</span>' 
	           + '</a>');
				
				$("#buttondelete_"+ username + role_name).click(function(){
					deleteRoleUser(username,role_name)
				});
			},
			error: function(errorObject){				
				if (errorObject.responseJSON.errorType == "ValidationError") {
					$('#alert_' + role_name).html("");

					var errorList = errorObject.responseJSON.errors;
					$('#alert_' + role_name).append('<p>');
					$.each(errorList, function(i, error) {
						$('#alert_' + role_name).append(error.message + '<br>');
					});
					$('#alert_' + role_name).append('</p>');
					$('#alert_' + role_name).show();
				} else {
					alert(errorObject.responseJSON.errors(0)); // "non" Validation
					// Error
				}
			
			}
		});
	}
	
	function deleteRoleUserConfirmed(username,role_name){
		var roleData = {"id" : null, "name" : role_name};
		$('#alert_' + role_name).hide();
		$('#success_' + role_name).hide();
		$.ajax({
			url: '/hrms/admin/role/delete/' + username  + '?' + $("#csrf").attr("name") + '=' + $("#csrf").val(),
			type: 'POST',
			data: JSON.stringify(roleData),
			contentType: 'application/json',
			dataType: "json",
			success: function(response){
				$('#success_' + role_name).html("User role has been deleted");
				$('#success_' + role_name).show();
				$('#'+ username + role_name).remove();
			},
			error: function(response){				
					$('#alert_' + role_name).html("Error occured while deleting.");
					$('#alert_' + role_name).show();
			}
		});
	}
	
	function deleteRoleUser(username,role_name){
		
		  $( function() {
			    $( "#user-dialog-confirm" ).dialog({
			      resizable: false,
			      height: "auto",
			      width: 400,
			      modal: true,
			      buttons: {
			        "Delete": function() {
			          $( this ).dialog( "close" );
			          deleteRoleUserConfirmed(username,role_name);
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });
			  } );
		
	}
	
	
	function deleteRoleConfirmed(role_name){
		var roleData = {"id" : null, "name": role_name};
		$('#alert_' + role_name).hide();
		$('#success_' + role_name).hide();
		$.ajax({
			url: '/hrms/admin/role/deleteRole?' + $("#csrf").attr("name") + '=' + $("#csrf").val(),
			type: 'POST',
			data: JSON.stringify(roleData),
			contentType: 'application/json',
			dataType: "json",
			success: function(response){
				$('#success_' + role_name).html("Role has been deleted");
				$('#success_' + role_name).show();
				$('#tabtitle_' + role_name).remove();
			},
			error: function(response){				
					$('#alert_' + role_name).html("Delete all user roles before delete role.");
					$('#alert_' + role_name).show();
			}
		});
	}
	
	function deleteRole(role_name){
		  $( function() {
			    $( "#role-dialog-confirm" ).dialog({
			      resizable: false,
			      height: "auto",
			      width: 400,
			      modal: true,
			      buttons: {
			        "Delete": function() {
			          $( this ).dialog( "close" );
			          deleteRoleConfirmed(role_name);
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });
			  } );
	}
	
$(document).ready(function() {
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var target = $(e.target).attr("href"); // activated tab
		  getUsersByRoleName(target.split("tab_").pop());
		});


	// Get product object from Server...
	function getUsersByRoleName(rolename) {
		$.ajax({
			url: '/hrms/admin/role/' + rolename,
			type: 'GET',
			async:false,
			dataType: "json",
			contentType: "application/json",
			success: function (response) {
				displayUsers(response,rolename);
			},
			error: function(){} 
		});
	}
	   
	function displayUsers(users,rolename) {
		$('#list_' + rolename).html("");
		$('#alert_' + rolename).hide();
		$('#success_' + rolename).hide();
		
		$.each(users, function( index, value ) {
			//var username = ;
			$('#list_' + rolename).append('<a id="'+ value.username + rolename +'" href="#" class="list-group-item">'+ value.username
					+ '<span class="pull-right">' +
					'<span id="buttondelete_'+ value.username + rolename +'" class="btn btn-xs btn-danger">' +
					'<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
					'</span>' +
					'</span>' 
           + '</a>');
			
			$("#buttondelete_"+value.username + rolename).click(function(){
				deleteRoleUser(value.username,rolename)
			});
			
			});
//		$('#list_' + rolename).attr("style", "display: block")
	} 
});