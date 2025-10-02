<%@include file="/WEB-INF/jsp/fragments/header.jspf" %>

    <body>
        <%@ include file="/WEB-INF/jsp/fragments/navbar.jspf" %>
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-lg-6 col-md-8 col-sm-10">

                        <div class="card shadow-lg border-0 rounded-3">
                            <div class="card-body p-4">

                                <h2 class="text-center mb-4 text-primary">Update Todo</h2>

                                <form:form class="needs-validation" action="update-todo" method="post"
                                    modelAttribute="todo">

                                    <!-- Description -->
                                    <div class="mb-3">
                                        <form:label path="description" class="form-label fw-bold">Description
                                        </form:label>
                                        <form:input class="form-control form-control-lg" path="description"
                                            placeholder="Enter task description" />
                                        <form:errors path="description" cssClass="form-text text-danger" />
                                    </div>



                                    <!-- Start Date -->
                                    <div class="mb-3">
                                        <form:label path="startDate" class="form-label fw-bold">Start Date
                                        </form:label>
                                        <form:input class="form-control form-control-lg" path="startDate" type="date" />
                                        <form:errors path="startDate" cssClass="form-text text-danger" />
                                    </div>

                                    <!-- Hidden Status -->
                                    <form:hidden path="status" />

                                    <!-- Hidden ID -->
                                    <form:hidden path="id" />

                                    <!-- Submit Button -->
                                    <div class="d-grid">
                                        <button class="btn btn-success btn-lg" type="submit">Update Todo</button>
                                    </div>

                                </form:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </body>

    </html>