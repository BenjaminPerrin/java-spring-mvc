<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Distributeur Spring MVC</title>
    </head>
    <body>
        <h2>Crédit :${balance} </h2>
        
        <table>
            <caption>Liste des produits</caption>
            <tr>
                <th>name</th>
                <th>price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="product" items="${listProducts}">
                <c:set var="p" value ="${product}" />
                <tr>
                    <td><c:out value="${p.getName()}"/></td>
                    <td><c:out value="${p.getQuantity()}"/></td>
                    <td><c:out value="${p.getPrice()}"/></td>
                </tr>
            </c:forEach>
        </table>
        <caption>Ajouter du crédit</caption>
        <form:form method="POST" action="/addBalance" modelAttribute="userForm">
            <table>
                <tr>
                    <td><form:label path="balance">Credit</form:label></td>
                    <td>
                        <form:input path="balance" type="number" />
                        <form:errors path="balance" />
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
        
        <caption>Acheter un produit</caption>
        <form:form method="POST" action="/buyProduct" modelAttribute="buyForm">
            <table>
                <tr>
                    <td>
                        <select name="category">
                        <c:forEach items="${listProducts}" var="products">
                        <option value="${products.id}">${products.name}</option>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
        
        
</select>
    </body>
</html>