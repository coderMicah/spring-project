<%@include file="/WEB-INF/jsp/fragments/header.jspf" %>

    <body class="bg-light">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <!-- Card for login form -->
                    <div class="card shadow-lg mt-5">
                        <div class="card-body p-4">
                            <h2 class="card-title text-center mb-4 text-primary">Login</h2>

                            <!-- Display error message -->
                            <c:if test="${not empty errorMessage}">
                                <div class="alert alert-danger" role="alert">
                                    ${errorMessage}
                                </div>
                            </c:if>

                            <form action="login" method="post">

                                <!-- Username -->
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name</label>
                                    <input class="form-control form-control-lg" name="name" type="text"
                                        placeholder="Enter your name" required>
                                </div>

                                <!-- Password -->
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input class="form-control form-control-lg" name="password" type="password"
                                        placeholder="Enter your password" required>
                                </div>

                                <!-- Submit button -->
                                <div class="d-grid">
                                    <button class="btn btn-primary btn-lg" type="submit">Login</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>