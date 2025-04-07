$(document).ready(function(){
	alert("vivek");
	$("#registerlink").click(function(){
		alert("vivek");
		$.ajax({
				url: '/FarmerSell/registrationPage',
				type: 'GET',
				async: false,
				success: function() {
						setTimeout(function() {
							$(".alert-danger").hide();
						}, 10000);
				},
				cache: false,
				contentType: false,
				processData: false
			});
	});
});