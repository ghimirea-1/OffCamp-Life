<%@ page import="java.util.List" %>
<%@ page import="com.offcamplife.model.PantryItem" %>

<html>
<head>
    <title>Pantry</title>
</head>
<body>

<h2>Add Pantry Item</h2>

<form method="post" action="pantry">
    Name: <input type="text" name="name" required /><br/>
    Category: <input type="text" name="category" /><br/>
    Storage Type: <input type="text" name="storageType" /><br/>
    Expiry Date: <input type="date" name="expiryDate" /><br/>
    <button type="submit">Add</button>
</form>

<hr/>

<h2>Pantry Items</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Storage</th>
        <th>Expiry</th>
        <th>Action</th>
    </tr>

    <%
        List<PantryItem> items = (List<PantryItem>) request.getAttribute("items");
        if (items != null) {
            for (PantryItem i : items) {
    %>
    <tr>
        <td><%= i.getName() %></td>
        <td><%= i.getCategory() %></td>
        <td><%= i.getStorageType() %></td>
        <td><%= i.getExpiryDate() %></td>
        <td>
            <a href="pantry?action=delete&id=<%= i.getId() %>"
               onclick="return confirm('Delete this item?');">
                Delete
            </a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
