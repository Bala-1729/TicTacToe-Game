<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Scoreboard</title>
    <link href="<c:url value="/resources/scoreboard.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/scoreboard.js" />" defer> </script>
  </head>
  <body onload="load_scoreboard(event)">
    <div class="header" style="text-align: center;">
        <h3 id="name" style="display:block;float:left;color: #EDEDED;margin-left: 20px;margin-bottom: 0px;margin-top: 30px;font-size: x-large;"></h3>
        <h1 class="heading">Scoreboard</h1>
        <button class="logout_button" onclick="logout()">Log out</button>
    </div>
    <div class="links">
        <a href="home" style="text-decoration: none">Home</a>
        <a href="scoreboard" style="text-decoration: none">Scoreboard</a>
    </div>
    <div class="tab">
      <button id="personal_button" class="tablinks" onclick="openTab(event, 'personal')">
        Personal
      </button>
      <button id="global_button" class="tablinks" onclick="openTab(event, 'global')">
        Global
      </button>
    </div>
    <div id="loading" class="loading">
        <h3>Loading Table....</h3>
    </div>
    <div id="personal" class="tabcontent">
      <table id="personaltable">
        <tr>
          <th>S.no</th>
          <th>Won By</th>
          <th>Date</th>
          <th>Time</th>
        </tr>
      </table>
    </div>

    <div id="global" class="tabcontent">
        <table id="globaltable">
            <tr>
              <th>S.no</th>
              <th>Username</th>
              <th>Won By</th>
              <th>Date</th>
              <th>Time</th>
            </tr>
          </table>
    </div>
  </body>
</html>
