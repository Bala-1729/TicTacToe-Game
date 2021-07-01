const username = sessionStorage.getItem("username");

async function HTTPRequest(method, url, jsonValue) {
  const response = await new Promise((resolve, reject) => {
    xhr = new XMLHttpRequest();

    xhr.open(method, "http://" + location.hostname + ":8080/game" + url, true);

    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = () => {
      if (xhr.status >= 300) {
        reject("Error, status code = " + xhr.status);
      } else {
        resolve(xhr.responseText);
      }
    };

    xhr.onerror = () => {
      reject("Error, status code = " + xhr.status);
    };

    if (method === "POST") xhr.send(JSON.stringify(jsonValue));
    else xhr.send();
  });
  return response;
}

function load_scoreboard(event){
    openTab(event, "personal");
    document.getElementById("name").innerHTML=`Hello ${username}!`;
}
  
function openTab(evt, tabName) {
  let localurl = "";
  if (tabName == "personal") localurl = `/scoreboard/personal`;
  else localurl = "/scoreboard/global";
  document.getElementById("personal").style.display = "none";
  document.getElementById("global").style.display = "none";
  document.getElementById("loading").style.display="block";
  HTTPRequest("POST", localurl, username).then((res) => {
    res = JSON.parse(res);
    console.log(res);
    let table = document.getElementById(tabName + "table");
    for (let i = table.rows.length - 1; i > 0; i--) {
      table.deleteRow(i);
    }
    for (let i = res.length - 1; i >= 0; i--) {
      let row = table.insertRow(res.length - i);
      let cell1 = row.insertCell(-1);
      let cell2 = " ";
      if (tabName != "personal") {
        cell2 = row.insertCell(-1);
      }
      let cell3 = row.insertCell(-1);
      let cell4 = row.insertCell(-1);
      let cell5 = row.insertCell(-1);

      cell1.innerHTML = res.length - i;
      if (tabName != "personal") {
        cell2.innerHTML = res[i]["username"];
      }
      cell3.innerHTML = res[i]["wonby"];
      cell4.innerHTML = res[i]["date"].split(" ")[0];
      cell5.innerHTML = res[i]["date"].split(" ")[1];
    }

    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName+"_button").className += " active";
    document.getElementById("loading").style.display="none";
    document.getElementById(tabName).style.display = "table";
    document.getElementById(tabName).style.display = "block";
  });
}
