<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<sec:authentication property="principal" var="principal"></sec:authentication>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage-employee</title>
    <%@ include file="employeeHeader.jsp"%>
</head>
<body>
<div class="container-fluid">
    <h1>Manage Employee</h1>
    <div class ="row">
        <div class="col-2 bg-dark text-light">
            <a class="row">Add hours</a>
            <a class="row">Schedule</a>
            <a class="row" href="/employee/list_employee?username=${principal.username}">List Employee</a>
        </div>
        <div class="col-8 bg-light">
            <a>Add hours</a>
            <a>Schedule</a>
            <a href="/employee/list_employee?username=${principal.username}">List Employee</a>
        </div>
    </div>


</div>
</body>
</html>