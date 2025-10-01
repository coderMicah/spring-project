<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <pre>${errorMessage}</pre>
    <form action="login" method="post">

        <div>
            <label for="name">name</label>
            <input name="name" type="text">
        </div>
        <div>
            <label for="password">Password</label>
            <input name="password" type="password">
        </div>
        <button type="submit">Submit</button>
    </form>
</body>

</html>