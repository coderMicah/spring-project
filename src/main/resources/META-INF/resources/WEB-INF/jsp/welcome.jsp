<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
        <title>Welcome</title>
    </head>

    <body>
        <div class="container">
            <h1>Welcome ${name}</h1>
            <div>
                <a href="/todos">Manage</a>Todos
            </div>
        </div>
    </body>

    </html>