<html>
<head>
<title>Calcy</title>
</head>
<body>
    <h2>Calcy</h2>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/mvc/calcy" method="POST">
        Number 1 : <input name="num1" type="text" placeholder="Enter num1"/>
           Number 2 : <input name="num2" type="text" placeholder="Enter num2" />
        <br>
        Operation : <select name="operation">
            <option value="add">Addition</option>
            <option value="sub">Subtraction</option>
            <option value="mul">Multiply</option>
            <option value="div">Divide</option>
        </select>
        <br>
        <input type="submit" />
    </form>
</body>
</html>