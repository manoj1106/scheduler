$(function(){
	validateLogin();
});

var validateLogin = function() {
	$('#loginButton').off('click').on('click',function(event){
		event.preventDefault();
		var username = $('#username').val();
		var password = $('#password').val();
		if(schedulerutil.isNotBlank(username) && schedulerutil.isNotBlank(password)) {
			$('#loginForm').submit();
		} else {
			alert("Please provide username and password");
		}
	});
}