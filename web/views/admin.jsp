<%@ page import="java.util.List" %>
<%@ page import="app.entities.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/test_war_exploded/list'">To list</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/test_war_exploded'">To menu</button>
    <button class="w3-btn w3-round-large"
            onclick="location.href='/test_war_exploded/add'">Change function to Addition
    </button>
</div>
<div class="w3-container w3-padding">
    <%
        Product productForAddition = (Product) request.getAttribute("productForAddition");
        List<Product> listOfProducts = (List<Product>) request.getAttribute("listOfProducts");

        String outParameter = "<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green" +
                " w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                "   <h5>";

        if (productForAddition != null) {
            if (listOfProducts.size() > 0) {
                for (int i = 0; i < listOfProducts.size(); i++) {
                    if (productForAddition.equals(listOfProducts.get(i))) {
                        out.println(outParameter + "Product: '" + productForAddition.getName() +
                                "' has already created!</h5>\n" + "</div>");
                        break;
                    } else {
                        out.println(outParameter + "Product: '" + productForAddition.getName() +
                                "' added to List!</h5>\n" + "</div>");
                        break;
                    }
                }
            } else {
                out.println(outParameter + "Product: '" + productForAddition.getName() +
                        "' added to List!</h5>\n" + "</div>");
            }
        } else {
            out.println(outParameter + "Fill in all the fields please!</h5>\n" + "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add product</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Id:
                <input type="text" name="Id" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Name:
                <input type="text" name="Name" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Description:
                <input type="text" name="Description" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Price:
                <input type="text" name="Price" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/test_war_exploded/add'">Add</button>
        </form>
    </div>
</div>
</body>
</html>

<html>
<head>
    <title>Delete product</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-padding">
    <%


        Product productForDelete = (Product) request.getAttribute("productForRemove");

        if (listOfProducts == null){
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red" +
                    " w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>There are no Products yet!</h5>\n" +
                    "</div>");
        }

        if (productForDelete != null) {
            if (listOfProducts.size() > 0) {
                for (int i = 0; i < listOfProducts.size(); i++) {
                    if (productForDelete.getId().equals(listOfProducts.get(i).getId())) {
                        out.println(outParameter + "Product: '" + productForDelete.getName() + "' has been deleted!</h5>\n" +
                                "</div>");
                    } else {
                        out.println(outParameter + "This product doesn't exist!</h5>\n" + "</div>");
                    }
                }
            }
        } else {
            out.println(outParameter + "Fill in all the fields please!</h5>\n" + "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2> Delete product</h2>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/test_war_exploded/list'">To list</button>
            <button class="w3-btn w3-round-large" onclick="location.href='/test_war_exploded'">To menu</button>
            <button class="w3-btn w3-round-large"
                    onclick="location.href='/test_war_exploded/remove'">Change function to Delete
            </button>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
            <form method="post" class="w3-selection w3-light-grey w3-padding">
                <label>Id:
                    <input type="text" name="Id" class="w3-input w3-animate-input w3-border w3-round-large"
                           style="width: 30%"><br/>
                </label>
                <label> Name:
                    <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                           style="width: 30%"><br/>
                </label>
                <button type = submit class="w3-btn w3-hover-red w3-round-large">Delete</button>
            </form>
        </div>
</div>
</body>
</html>
