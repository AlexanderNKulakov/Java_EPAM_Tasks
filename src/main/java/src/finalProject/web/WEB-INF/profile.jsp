<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<html>
  <head>
    <title>Личный кабинет пользователя</title>
	<link type="text/css" rel="stylesheet" href="css/profile.css"/>
  </head>
  <body>
  
	Список ваших кредитных карт:
	<table class="Cards">
       <thead>
        <tr>
            <th width="200">Номер карты</th>
            <th>Баланс</th>
            <th width="200">Счет карты</th>
			<th>Дата окончания действия</th>
        </tr>
       </thead>
       <tbody>
        <tr>
            <td>1123 2323 4555 6667</td>
            <td>200 руб</td>
            <td>1454504504054054050</td>
            <td>2017-10-05</td>
        </tr>
       </tbody>
   </table>
   
   
   <mytag:showCards/>
   
   <%
		out.println("jsp out.println");
   %>
   
    <c:set var="salary" scope="session" value="${2000*2}" />
	<c:set var="salary" scope="session" value="${salary+89}" />
	<c:out value="${salary}" />
   
   
   <nav>
    <ul>
      <li><a href="#">About</a></li>
      <li><a href="#">Portfolio</a></li>
      <li><a href="#">Blog</a></li>
      <li><a href="#">Contact</a></li>
    </ul>
</nav>
   
 
  </body>
</html>


