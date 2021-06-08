$(document).ready(function(){

	$("#b-authorisation").click(async function(){
		let login = document.getElementById("login-item").value;
		let password = document.getElementById("password-item").value;
		$.ajax({
			url: "http://localhost:8080/author/authorisation/" + login + "/" + password,
			type: "GET",
			dataType: "json",
			success: function (response){  
				setCookie("user-id", response, "100");
				window.location.replace("index.html");
			},
			error: function(response) {
				if (response.status == 400) {
				alert("Неверный логин или пароль");
				} else {
				alert("Кажется, вы еще не зарегистрировались!");
				}
			}
		});
	});
	
});