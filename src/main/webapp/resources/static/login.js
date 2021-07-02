let option="login";
let username="";
let firstname="";
let lastname="";
let email="";
let password="";

document.querySelector('#submitButton').addEventListener('click',submit);

function load_login(){
    if(sessionStorage.getItem("username")!=null && sessionStorage.getItem("username")!="null"){
        window.location.replace("https://"+location.hostname+"/home");
        return;
    }
    document.getElementById("body").style.display="block";
}

function register(){
    let elements = document.querySelectorAll('.register');
    document.getElementById("register_button").className="button_after";
    document.getElementById("login_button").className="button_before";
    document.getElementById("form").className="register_form";
    for(let i=0; i<elements.length;i++){
        elements[i].style.display="block";
    }
    option="register";
}

function login(){
    let elements = document.querySelectorAll('.register');
    document.getElementById("login_button").className="button_after";
    document.getElementById("register_button").className="button_before";
    document.getElementById("form").className="login_form";
    for(let i=0; i<elements.length;i++){
        elements[i].style.display="none";
    }
    option="login";
}

function loginRequest(){
    const response = new Promise((resolve, reject) => {
        xhr = new XMLHttpRequest();

        xhr.open("POST","https://"+location.hostname+"/login");
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
        xhr.setRequestHeader('Content-Type','application/json');
        
        xhr.onload = () =>{
            if (xhr.status >= 300) {
                reject("Error, status code = " + xhr.status)
              } else {
                resolve(xhr.responseText);
              }
        };

        xhr.onerror = () => {
            reject("Error, status code = " + xhr.status);
        };

        xhr.send(JSON.stringify({"username":username,"password":password}));
    })
    return response;
}

function registerRequest(){
    const response = new Promise((resolve, reject) => {
        xhr = new XMLHttpRequest();

        xhr.open("POST","https://"+location.hostname+"/register");
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
        xhr.setRequestHeader('Content-Type','application/json');
        
        xhr.onload = () =>{
            if (xhr.status >= 300) {
                reject("Error, status code = " + xhr.status)
              } else {
                resolve(xhr.responseText);
              }
        };

        xhr.onerror = () => {
            reject("Error, status code = " + xhr.status);
        };

        xhr.send(JSON.stringify({"firstname":firstname,"lastname":lastname,"username":username,"email":email,"password":password}));
    })
    return response;
}

function submit(event){
    event.preventDefault();
    document.getElementById("myModal").style.display="block";
    firstname=document.getElementById("fname").value;
    lastname=document.getElementById("lname").value;
    username=document.getElementById("uname").value;
    email=document.getElementById("email").value;
    password=document.getElementById("password").value;
    
    if(option==="login"){  
        if(username=="" || password==""){
            document.getElementById("myModal").style.display="none";
            alert("Enter necessary details");
            return;
        }
        loginRequest().then((res) => {
            res = JSON.parse(res);
            if(res["status"]==="true"){
                sessionStorage.setItem("username",username);
                window.location.replace("https://"+location.hostname+"/home");
            }
            else{
                document.getElementById("myModal").style.display="none";
                alert(res["false"]);
                location.reload();
            }
        })
    }
    else if(option==="register"){
        if(username=="" || password=="" || firstname=="" || lastname=="" || email==""){
            document.getElementById("myModal").style.display="none";
            alert("Enter necessary details");
            return;
        }
        registerRequest().then((res) => {
            res = JSON.parse(res);
            if(res["status"]==="true"){
                sessionStorage.setItem("username",username);
                alert("Registration Successfull");
                window.location.replace("https://"+location.hostname+"/login-register");
            }
            else{
                document.getElementById("myModal").style.display="none";
                alert(res["false"]);
                location.reload();
            }
        })
    }   

}