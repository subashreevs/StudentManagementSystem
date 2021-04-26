function myReset(){
    document.getElementById("loginform").reset();
}

function checkCreds(){
    var user = document.getElementById("username").value;
    var pass = document.getElementById("password").value;

    if(user === "admin" && pass === "admin123"){
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        window.open("homepage.html");
    }
    else{
        alert("Invalid credentials. Please re-enter");
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        document.getElementById("username").focus();
    }
}

