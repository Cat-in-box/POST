$(document).ready(function(){

	$("#b-registration").click(async function () {

        if (document.getElementById('password').value != document.getElementById('password-again').value) {
            alert("Пароли не совпадают")
        } else if (document.getElementById('login').value != "" && document.getElementById('password').value != "") {

            let varData = {
                "login": document.getElementById('login').value,
                "password": document.getElementById('password').value,
                "nickname": document.getElementById('nick').value,
            };
            let response = await fetch("http://localhost:8080/author/create", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify(varData)
            }, {mode: 'cors'}).then(function (response) {

                if (response.status === 409) {
                    alert("Пользователь с таким логином уже существует!")
                } else if (response.status === 400) {
                    alert("Введены некорректные данные")
                } else if (response.status === 200) {
                    alert("Успешно!")
                    authorisation();                    
                } else {
                    alert("Пролучили код " + response.status)
                }

            }).catch(function (error) {
                console.log("Что-то пошло не так", error);
            });
        };
    });

    function authorisation(){
		let login = document.getElementById("login").value;
		let password = document.getElementById("password").value;
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
	};
	
});
