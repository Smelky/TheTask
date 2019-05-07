<!DOCTYPE html>
<html>
<body>
<%
  response.setStatus(response.SC_MOVED_TEMPORARILY);
  response.setHeader("Location", "/test_war_exploded/list");
%>
</body>
</html>
