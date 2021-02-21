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

<div class="container">
    <div class="panel">
        <div class="panel-default">
            <div class ="row">
                <h1>Manage Employee</h1>
                <div class="col-md-2">
                    <a>Add hours</a>
                    <a>Schedule</a>
                    <a href="/employee/list_employee?username=${principal.username}">List Employee</a>
                </div>
                <div class="col-md-10 jumbotron">

                </div>
            </div>
        </div>

    </div>

</div>
</body>
</html>