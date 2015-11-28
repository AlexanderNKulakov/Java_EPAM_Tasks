<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytags"%>
<html>
  <head>
    <title>Личный кабинет пользователя</title>
	<link type="text/css" rel="stylesheet" href="css/profile.css"/>
  </head>
  <body>
  
	Вы вошли как <mytags:getlogintag/>
	
	<a href="logout">Выйти</a>
  
	<br>
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
   

   
     
     
    <c:set var="login" scope="session" value="${2345}" />
	<c:out value="${login}" />
	

   
   
   <jsp:useBean id="cards" class="com.epam.jf.e2ee.creditcards.CardsBean" />
   <jsp:getProperty name="cards" property="cardlist" />  
   <c:out value="${cards.cardlist}" />
   

   
 
  </body>
</html>


