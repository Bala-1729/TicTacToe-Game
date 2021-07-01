let modal = document.getElementById("myModal");
let array = [[".",".","."],[".",".","."],[".",".","."]]
let difficulty = "novice";
let result = document.getElementById("result");
let username = sessionStorage.getItem("username");
let undoElement = document.getElementById("undo");
let redoElement = document.getElementById("redo");

function load(){
    if(username=="null" || username==null){
        window.location.replace("https://"+location.hostname+"/login-register");
        return;
    }
    HTTPRequest("GET","/reset",null);
    document.getElementById("name").innerHTML=`Hello ${username}!`;
    undoElement.disabled=true;
    redoElement.disabled=true;
    document.getElementById("body").style.display="block";
}

function hideModel(){
    difficulty = event.target.id
    document.getElementById("difficulty").innerHTML=`Difficulty: ${difficulty}`;
    modal.style.display = "none";
}

function updateValuePlayer1(id){
    let localValue = document.getElementById(id);
    localValue.value="X";
    localValue.className="player1";
    array[Math.ceil(id/3)-1][(id-1)%3]="X";
}

function updateValuePlayer2(row,col){
    document.getElementById(row*3+col+1).value="O";
    document.getElementById(row*3+col+1).className="player2";
    array[row][col]="O";
}

function logout(){
    array = [[".",".","."],[".",".","."],[".",".","."]];
    sessionStorage.setItem("username",null);
    window.location.replace("https://"+location.hostname+"/login-register");
}
async function HTTPRequest(method,url,jsonValue){
    const response = await new Promise( (resolve, reject) => {
        xhr = new XMLHttpRequest();

        xhr.open(method,"https://"+location.hostname+url,true);
    
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

        if(method==="POST")
            xhr.send(JSON.stringify(jsonValue));
        else
            xhr.send();
    });

    return response;
    
}

function undo(){
    HTTPRequest("GET","/undo",null).then((res) =>{
        res = JSON.parse(res);
        undoElement.disabled=true;
        res.forEach((ele) => {
            let localId = ele["row"]*3+ele["col"]+1;
            document.getElementById(localId).value = ".";
            array[ele["row"]][ele["col"]]=".";
            document.getElementById(localId).className = "undo";
        undoElement.disabled=false;

        });
    });
    redoElement.disabled=false;
}


function redo(){
    HTTPRequest("GET","/redo",null).then((res) =>{
        res = JSON.parse(res);
        redoElement.disabled=true;
        res.forEach((ele) => {
            let localId = ele["row"]*3+ele["col"]+1;
            let localValue = ele["player"]=="1"?"X":"O";
            document.getElementById(localId).value = localValue;
            array[ele["row"]][ele["col"]]= localValue;
            document.getElementById(localId).className = localValue=="X"?"player1":"player2";
            redoElement.disabled=false;
        });
    });
    undoElement.disabled=false;
}

function changeValue(){
    undoElement.disabled=false;
    redoElement.disabled=true;
    if(document.getElementById(event.target.id).value!='.'){return;}
    updateValuePlayer1(event.target.id);
    HTTPRequest("POST","/cpu-move",{"array":array,"level":difficulty,"player":'1'}).then((res)=>{
        res = JSON.parse(res);
        
        if(res["status"]!="ongoing") {
            let localPlayer = "";
            if(res["status"]=="tie") {
                localPlayer = "Tie";
            }
            if(res["player"]=="2") {
                localPlayer = "CPU";
            }
            else if(res["player"]=="1") {
                localPlayer = username;
        }
            HTTPRequest("POST","/scorecard",{"username":username,"wonby":localPlayer});
        }
        if(res["status"]==="checkmate"){
            document.querySelectorAll('input').forEach(x => {if(x.id!=res["index1"] && x.id!=res["index2"] && x.id!=res["index3"]) x.disabled=true});
            if(res["player"]=="1")
                result.innerHTML=`${username} wins!!!`;
            else
                result.innerHTML="CPU wins!!!";
            if(res["player"]=="2")
                updateValuePlayer2(res["row"],res["col"]);
            document.getElementById("undoRedo").style.display="none";
            document.getElementById("reset").style.display="block";
            return;
        }
        else if(res["status"]==="tie"){
            if(res["player"]=="2")
                updateValuePlayer2(res["row"],res["col"]);
            result.innerHTML="Tie!!!";
            document.getElementById("undoRedo").style.display="none";
            document.getElementById("reset").style.display="block";
            return;
        }
        updateValuePlayer2(res["row"],res["col"]);
    });
}