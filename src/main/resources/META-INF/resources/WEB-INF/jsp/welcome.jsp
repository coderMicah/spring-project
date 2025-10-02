<%@include file="/WEB-INF/jsp/fragments/header.jspf" %>

    <body>
        <%@ include file="/WEB-INF/jsp/fragments/navbar.jspf" %>
            <div class="container">
                <h1>Welcome ${name}</h1>
                <div>
                    <a href="/todos">Manage</a>Todos
                </div>
            </div>
    </body>

    </html>