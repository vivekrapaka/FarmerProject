$(document).ready(function(){
	alert("hi")
	$("#registration-form").on("submit",function(e){
		e.preventDefault();
		
		const userData = {
			firstName: $("#firstName").val(),
			lastName: $("#lastName").val(),
		     username: $("#username").val(),
		     email: $("#email").val(),
		     password: $("#password").val()
		   };
		   
		$ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(userData),
			url: "/register",
			success: function(result) {
				bootbox.alert({
					size: "small",
					title: "ALERT",
					message: result.msg,
					callback: function() {
						window.location = ("/FarmerSell/loginPage");
					}
				})
			}
		})
		
	})
});