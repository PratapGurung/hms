<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Change Phone</title>
    <%@ include file="customerHeader.jsp"%>
    <script>
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    </script>
</head>
<body>
    <div class="container">

        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <p id="profile-name" class="profile-name-card">Change Phone Number</p>
            <form class="form-signin" action="/customer/update/phone" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text"  class="form-control" value="${customer.phone}"  name="phone"  required autofocus>

                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Change</button>

            </form><!-- /form -->
            <%--<button class="btn btn-lg btn-secondary btn-block btn-signup" type="button" onclick="location.href='/customer/signup';">Sign up</button>--%>
        </div><!-- /card-container -->
    </div><!-- /container -->
</body>
</html>