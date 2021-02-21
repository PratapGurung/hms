<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js" ></script>
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js" ></script>

<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<sec:authentication property="principal" var="principal"></sec:authentication>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Hotel Management System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a href="" class="nav-link">Home</a>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link">My Schedule</a>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link">My Paystub</a>
            </li>
            <li class="nav-item">
                <a href="/employee/manageEmployee" class="nav-link">Manage Employee</a>
            </li>
            <%--<li class="nav-item">
                <a href="" class="nav-link">${principal.role.roleName}</a>
            </li>--%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${principal.username} <%--${principal.lastName}--%>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/employee/logout">Logout</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>