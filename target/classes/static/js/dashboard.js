$(document).ready(function() {
	$("#registration-form").on("submit", function(e) {
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
				if(result == "User Already Register"){
					Swal.fire({
									icon: 'failure',
									title: 'oops',
									text: result,
									showConfirmButton: true
								}).then(() => {
									window.location.href = "/FarmerSell/registrationPage";
								});
				}else{
				Swal.fire({
					icon: 'success',
					title: 'success',
					text: result,
					showConfirmButton: true
				}).then(() => {
					window.location.href = "/FarmerSell/registrationPage";
				});
			}
			}
		})

	})

	$("#login-form").on("submit", function(e) {
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
				if (result == "invalid crediationals") {
				Swal.fire({
					icon: 'error',
					title: 'Oops...',
					text: result,
					confirmButtonText: 'Try Again',
					showConfirmButton: true
				}).then(() => {
					window.location.href = "/FarmerSell/loginPage";
				});
				} else {
					Swal.fire({
						icon: 'success',
						title: 'Success',
						text: result,
						showConfirmButton: true
					}).then(() => {
						window.location.href = "/FarmerSell/dashboard";
					});
				}



			}
		})

	})
});