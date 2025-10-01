<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">


        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Todos</title>
    </head>

    <body>
        <h1>${name}'s Todos</h1>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="todo" items="${todos}">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.username}</td>
                        <td>${todo.description}</td>
                        <td>${todo.startDate}</td>
                        <td>${todo.status ? 'Done' : 'Pending'}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
    <script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

    </html>