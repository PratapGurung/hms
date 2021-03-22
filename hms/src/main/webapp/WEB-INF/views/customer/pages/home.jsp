<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Home Page</title>
    <%@ include file="customerHeader.jsp"%>
    <script>
        const http = new XMLHttpRequest();
        const url='http://127.0.0.1:9085/test';
        http.open("POST", url);
        http.send();
        http.onreadystatechange = (e) => {
            document
                .getElementById("output")
                .innerHTML = http.responseText;
        }
    </script>
</head>
<body>
<div id="output"></div>
<h1>Customer Home page</h1>
</body>
</html>