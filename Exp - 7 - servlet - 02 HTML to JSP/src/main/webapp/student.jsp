<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>

<body>

    <h1>Student Information</h1>

    <form action="hello" method="post">

        <label>Name:</label>
        <input type="text" name="name" required>

        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>

        <br><br>

        <label>Course:</label>
        <input type="text" name="course" required>

        <br><br>

        <label>Age:</label>
        <input type="number" name="age" required>

        <br><br>

        <input type="submit" value="Register">

    </form>

</body>

</html>