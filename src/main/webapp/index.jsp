<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test Project</title>
</head>
<body>
<h1>Test Project</h1>
<form method="get" action="<c:url value="/command"/>">
    <input type="hidden" name="command" value="get_richest_user">
    <input type="text" placeholder="richest user" value="${richestUser}">
    <button type="submit">get</button>
</form>
<form method="get" action="<c:url value="/command"/>">
    <input type="hidden" name="command" value="get_accounts_sum">
    <input type="text" placeholder="accounts sum" value="${sumOfAccounts}">
    <button type="submit">get</button>
</form>
</body>
</html>

