<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.offcamplife.model.PantryItem" %>

<html>
<head>
    <title>Pantry</title>
</head>
<body>

<h2>Add Pantry Item</h2>

<form method="post" action="pantry">
    Name: <input type="text" name="name" required><br><br>
    Category: <input type="text" name="category"><br><br>
    Storage Type: <input type="text" name="storageType"><br><br>
    Expiry Date: <input type="date" name="expiryDate"><br><br>

    <button type="submit">Add Item</button>
</form>

<hr>

<h2>My Pantry</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Storage</th>
        <th>Expiry</th>
    </tr>

    <%
        List<PantryItem> items =
                (List<PantryItem>) request.getAttribute("items");

        if (items != null) {
            for (PantryItem i : items) {
    %>
    <tr>
        <td><%= i.getName() %></td>
        <td><%= i.getCategory() %></td>
        <td><%= i.getStorageType() %></td>
        <td><%= i.getExpiryDate() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
