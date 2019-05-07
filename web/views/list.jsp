<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-grey w3-opacity w3-center w3-padding">
    <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/test_war_exploded/remove'">Delete</button>
    <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/test_war_exploded/add'">Add user</button>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>
        <%
            List<User> listOfUsers = (List<User>) request.getAttribute("listOfUsers");

            if (listOfUsers != null && !listOfUsers.isEmpty()) {
                out.println("<ul class=\"w3-ul\">");
                for (int i = 0; i < listOfUsers.size(); i++) {
                    out.println("<li class=\"w3-hover-sand\">" + "Id: " + listOfUsers.get(i).getId() +
                            " Name: " + listOfUsers.get(i).getName() +
                            " Password: " + listOfUsers.get(i).getPassword() + "</li>");
                }
                out.println("</ul>");
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red" +
                    " w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>There are no users yet!</h5>\n" +
                    "</div>");
        %>
    </div>
</div>
</div>
</body>
</html>
