<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kwang
  Date: 2022-06-14
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 조회ㅑ</title>
</head>
<body>
  <form:form modelAttribute="cmd">
    <p>
      <label>from :
        <form:input path="from"/>
        <form:errors path="from"/>
      </label>

      ~
      <label>to:
        <form:input path="to"/>
        <form:errors path="to"/>
      </label>
      <input type="submit" value="조회">
    </p>
  </form:form>

  <c:if test="${! empty members}">
    <table>
      <tr>
        <th>아이디</th><th>이메일</th>
        <th>이름</th><th>가입일</th>
      </tr>
      <c:forEach var="mem" items="${members}">
        <tr>
          <td>${mem.id}</td>
          <td><a href="/members/${mem.id}">${mem.email}</a></td>
          <td>${mem.name}</td>
          <td><tf:formatDateTime value="${mem.registerDateTime}" pattern="yyyy-MM-dd"/></td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</body>
</html>
