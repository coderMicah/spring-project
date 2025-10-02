<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
            <title>Add Todo</title>
        </head>

        <body>
            <div class="container mt-4">
                <h1>Add Todo</h1>

                <form:form class="form" action="add-todo" method="post" modelAttribute="todo">

                    <!-- Description -->
                    <div class="form-group mb-3">
                        <label for="description">Description</label>
                        <form:input class="form-control" path="description" />
                        <form:errors path="description" cssClass="form-text text-danger" />
                    </div>

                    <!-- Id -->
                    <div class="form-group mb-3">
                        <!-- <label for="id">ID</label> -->
                        <form:hidden class="form-control" path="id" />
                        <form:errors path="id" cssClass="form-text text-danger" />
                    </div>

                    <!-- Start Date -->
                    <div class="form-group mb-3">
                        <!-- <label for="startDate">Start Date</label> -->
                        <form:hidden class="form-control" path="startDate" />
                        <form:errors path="startDate" cssClass="form-text text-danger" />
                    </div>

                    <!-- Status -->
                    <div class="form-group mb-3">
                        <!-- <label for="status">Status</label> -->
                        <form:hidden class="form-control" path="status" />
                        <form:errors path="status" cssClass="form-text text-danger" />
                    </div>

                    <button class="btn btn-success" type="submit">Submit</button>
                </form:form>
            </div>
        </body>

        </html>