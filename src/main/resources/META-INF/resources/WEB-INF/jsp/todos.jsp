<%@include file="/WEB-INF/jsp/fragments/header.jspf" %>

    <body>
        <%@ include file="/WEB-INF/jsp/fragments/navbar.jspf" %>

            <div class="container">
                <h1 class="my-4">${name}'s Todos</h1>
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <!-- <th>Id</th> -->
                            <!-- <th>Username</th> -->
                            <th>Description</th>
                            <th>Start Date</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="todo" items="${todos}">
                            <tr>
                                <!-- <td>${todo.id}</td> -->
                                <!-- <td>${todo.username}</td> -->
                                <td>${todo.description}</td>
                                <td>${todo.startDate}</td>
                                <td>${todo.status ? 'Done' : 'Pending'}</td>
                                <td>
                                    <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                                    <a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/add-todo" class="btn btn-success">Add Todo</a>
            </div>
    </body>
    <script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

    </html>