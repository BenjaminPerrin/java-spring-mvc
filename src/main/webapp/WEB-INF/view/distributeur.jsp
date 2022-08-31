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
        <br/>
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
        <br/>
        <form:form method="POST" action="/addBalance" modelAttribute="userForm">
            <filedset>
                <legend>Ajouter du crédit</legend>
            </filedset>
            <table>
                <tr>
                    <td><form:label path="balance">Credit</form:label></td>
                    <td>
                        <form:input path="balance" type="number" step="0.01"/>
                        <form:errors path="balance" />
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
        <br/>
        <caption>Acheter un produit</caption>
        <form:form method="POST" action="/buyProduct" modelAttribute="buyForm">
            <table>
                <tr>
                    <td>
                        <select name="products">
                        <c:forEach items="${listProducts}" var="products">
                        <c:if test="${products.quantity > 0}">
                            <option value="${products.id}">${products.name}</option>
                        </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="buy" /></td>
                </tr>
            </table>
        </form:form>
        
        
</select>
    </body>
</html>