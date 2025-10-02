<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">

        <title>Login</title>
    </head>

    <body>
        <div class="container">
            <h1>Login</h1>
            <pre>${errorMessage}</pre>
            <form class="form" action="login" method="post">

                <div class="form-group">
                    <label for="name">name</label>
                    <input class="form-control" name="name" type="text">
                </div>
                <div class="form-group mt-3">
                    <label for="password">Password</label>
                    <input class="form-control" name="password" type="password">
                </div>
                <button class="mt-3 btn btn-primary" type="submit">Submit</button>
            </form>
        </div>
    </body>

    </html>