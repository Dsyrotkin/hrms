
	function addRole(role_id,role_name){
		var roleData = {"id" : role_id, "name" : role_name};
		var username = $('#input_' + role_name).val();
		$.ajax({
			url: '/hrms/admin/role/add/' + username,
			type: 'POST',
			data: JSON.stringify(roleData),
			contentType: 'application/json',
			dataType: "json",
			success: function(response){
				alert("Role Successfully added");
				$('#list_' + role_name).append('<a href="#" class="list-group-item">'+ response.username +'</a>');
			},
			error: function(){						
				alert('Error while request..');
			}
		});
	}
	
$(document).ready(function() {
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var target = $(e.target).attr("href"); // activated tab
		  getUsersByRoleName(target.split("tab_").pop());
		});


	 // Click on Product [row]  in cart
	$("#cart_table").find("tr").click(function() {  
		var productId=  $(this).find("td:first").html();
		
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
		for(var i = 0 ; i < users.length; i++)
			{
			$('#list_' + rolename).append('<a href="#" class="list-group-item">'+ users[i].username +'</a>');
			}
		
//		$('#list_' + rolename).attr("style", "display: block")
	} 
});