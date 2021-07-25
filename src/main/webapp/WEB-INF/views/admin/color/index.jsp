<%-- 
    Document   : index
    Created on : 25 July 2021, 10:05:18 am
    Author     : vatra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../shared/header.jsp" %>


<h1>Color</h1>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Code</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="color" items="${requestScope.colors}">
        <tr>
            <td>${color.id}</td>
            <td>${color.name}</td>
            <td>${color.code}</td>
            <td>
                <!--in this expression lang no else only if so use choose-->
                <c:choose>
                    <c:when test="${color.status}">
                        <span class="badge bg-success">Active</span>
                    </c:when>
                    <c:otherwise>
                        <span class="badge bg-danger">Inactive</span>
                    </c:otherwise>

                </c:choose>
            </td>
            <td>

                <a href="" class="btn btn-success position-relative">Edit</a>
                <a href="" class="btn btn-danger position-relative" onclick="return confirm('Are you sure to delete color ${color.name} ?')">Delete</a>
 

            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="../shared/footer.jsp" %>