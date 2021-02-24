<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ include file="header.jsp"%>
</head>
<body>
    <div class="container">
        <div class="panel">
            <div class="panel-default">
                <div class ="rows">
                    <div class="col-md-2"></div>
                    <div class="col-md-8 jumbotron">
                        <form class="form-horizontal" action="#" method="post">
                            <fieldset>
                                <legend>Book a reservation</legend>
                                <div class="form-group">
                                    <label>Name:</label>
                                    <input type="text" name="customer_name" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Phone:</label>
                                    <input type="text" name="phone" class="form-control">
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
                                    <input type="text" name="postal_code" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label>Notes: </label>
                                    <textarea rows="5" cols="20" name="comments" class="form-control"></textarea>
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
</html>