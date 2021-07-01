<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Tic Tac Toe</title>
    <link rel="shortcut icon" href="<c:url value="/resources/favicon.ico" />" type="image/x-icon" />
     <link href="<c:url value="/resources/home.css"/>" rel="stylesheet">
     <script type="text/javascript" src="<c:url value="/resources/home.js" />" defer> </script>
  </head>

  <body id="body" style="display: none;" onload="load()">
    <div id="myModal" class="modal">
      <div class="modal-content">
        <h2>Choose Difficulty</h2>
        <button id="novice" class="level_button" onclick="hideModel()">Novice</button>
        <button id="expert" class="level_button" onclick="hideModel()">Expert</button>
      </div>
    </div>
    <div class="header" style="text-align: center;">
        <h3 id="name" style="display:block;float:left;color: #EDEDED;margin-left: 20px;margin-bottom: 0px;margin-top: 30px;font-size: x-large;"></h3>
        <h1 class="heading">Let's Play Tic Tac Toe!</h1>
        <button class="logout_button" onclick="logout()">Log out</button>
    </div>
    <div class="links">
        <a href="home" style="text-decoration: none">Home</a>
        <a href="scoreboard" style="text-decoration: none">Scoreboard</a>
    </div>
    <div class="container">
      <div onclick="changeValue()" style="margin-top: 50px;">
        <table class="center">
          <tr>
            <td>
              <input id="1" name="1" type="button" value="." />
            </td>
            <td>
              <input id="2" name="2" type="button" value="." />
            </td>
            <td>
              <input id="3" name="3" type="button" value="." />
            </td>
          </tr>

          <tr>
            <td>
              <input id="4" name="4" type="button" value="." />
            </td>
            <td>
              <input id="5" name="5" type="button" value="." />
            </td>
            <td>
              <input id="6" name="6" type="button" value="." />
            </td>
          </tr>

          <tr>
            <td>
              <input id="7" name="7" type="button" value="." />
            </td>
            <td>
              <input id="8" name="8" type="button" value="." />
            </td>
            <td>
              <input id="9" name="9" type="button" value="." />
            </td>
          </tr>
        </table>
      </div>
      <div>
        <h2 id="result"></h2>
        <button id="reset" class="button" onclick="window.location.reload()">Reset</button>
        <!-- <button id="cpu_first" class="button" style="display:block" onclick="changeValue()">CPU First</button> -->
      </div>
      <div
        id="undoRedo"
        style="text-align: center;"
      >
        <button id="undo" class="level_button" onclick="undo()">Undo</button>
        <button id="redo" class="level_button" onclick="redo()">Redo</button>
      </div>
      <h3 id="difficulty" style="text-align: center;"></h3>
  </div>
  </body>
</html>
