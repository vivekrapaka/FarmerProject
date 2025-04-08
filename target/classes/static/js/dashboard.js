$(document).ready(function(){
	$("#registration-form").on("submit",function(e){
		e.preventDefault();
		
		const userData = {
			firstName: $("#firstName").val(),
			lastName: $("#lastName").val(),
		     userName: $("#username").val(),
		     email: $("#email").val(),
		     password: $("#password").val()
		   };
		   
		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(userData),
			url: "/FarmerSell/register",
			success: function(result) {
				alert(result);
				window.location.href = "/FarmerSell/registrationPage";
			}
		})
		
	})
	
	$("#login-form").on("submit",function(e){
			e.preventDefault();
			
			const userData = {
			     userName: $("#username").val(),
			     password: $("#password").val()
			   };
			   
			$.ajax({
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(userData),
				url: "/FarmerSell/login",
				success: function(result) {
					alert(result);
					if(result == "invalid crediationals"){
						window.location.href = "/FarmerSell/loginPage";
						
					}else{
						window.location.href = "/FarmerSell/registrationPage";
					}
					
				
					
				}
			})
			
		})
});