<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List User</title>
    <%@ include file="employeeHeader.jsp"%>
</head>
<body>
<h1>Manage Employee</h1>
    <div>
            <c:if test="${!empty employees}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Customer Name</th>
                        <th>Phone</th>
                        <th>Address Line</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Postal Code</th>
                        <th>Country</th>
                        <th>Hired date</th>
                        <th>Actions</th>

                    </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${employees}" var="e">
                            <tr>
                                <th>${e.firstName} ${e.lastName}</th>
                                <th>${e.phone}</th>
                                <th>${e.addressLine}</th>
                                <th>${e.city}</th>
                                <th>${e.state}</th>
                                <th>${e.postalCode}</th>
                                <th>${e.country}</th>
                                <th>${e.hiredDate}</th>
                                <th>
                                    <a href="/employee/edit_employee?id=${e.employeeId}" class="btn btn-primary">Edit</a>|
                                    <a href="/employee/delete_employee?id=${e.employeeId}" class="btn btn-danger">Delete</a>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
    </div>
</body>
</html>