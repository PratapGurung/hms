
<link rel="stylesheet" href="/resources/css/signup.css">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js" ></script>
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js" ></script>
<body>
<div class="container">
    <div class="panel">
        <div class="panel-default">
            <div class ="rows">
                <div class="col-md-2"></div>
                <div class="col-md-8 jumbotron">
                    <form class="form-horizontal" action="save_customer" method="post">
                        <fieldset>
                            <legend>Registration Form</legend>
                            <div class="form-group">
                                <div class="form-group">
                                    <label>First Name:</label>
                                    <input type="text" name="firstName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Last Name:</label>
                                    <input type="text" name="lastName" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" name="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>password:</label>
                                <input type="password" name="password" class="form-control">
                            </div>
                            <div class="form-group row">
                                <div class="col">
                                    <label>Email:</label>
                                    <input type="text" name="email" class="form-control">
                                </div>
                                <div class="col">
                                    <label>Phone:</label>
                                    <input type="text" name="phone" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Address line: </label>
                                <input type="text" name="address_line" class="form-control">
                            </div>
                            <div class="form-group">
                                <lable>City:</lable>
                                <input type="text" name="city" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>State: </label>
                                <input type="text" name="state" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Zipcode: </label>
                                <input type="text" name="postalCode" class="form-control">
                            </div>
                            <div class="form-group">
                                <lable>Country:</lable>
                                <input type="text" name="country" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Submit" class="btn btn-success">
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>
</body>
