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
	    
     
	<c:set var="login2" value="${pageContext.session}" scope="session" />   
	<c:out value="${sessionScope.login2}" />
  
   
	<jsp:useBean id="cards" class="com.epam.jf.e2ee.creditcards.CardsBean" />
	
	<jsp:setProperty name="cards" property="login" value="${login2}" /> 
	
	<jsp:getProperty name="cards" property="login" />  
    <c:out value="${cards.login}" />
   
    <c:set var="carditems" value="${cards.tableLines}" />
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
		<c:forEach items="${carditems}" var="carditem">
		<tr> 
			<c:forEach items="${carditem}" var="cardrow">
			<td> 
				<c:out value="${cardrow}"/>
			</td>
			</c:forEach>
		</tr>
		</c:forEach>
		   </tbody>
   </table>
   
   
   <br><br>  
	Список ваших кредитных карт:
   <table class="Cards">
         <thead>
        <tr>
            <th width="200">Номер карты</th>
			<th>Дата окончания действия карты</th>
            <th width="200">Счет карты</th>
            <th>Баланс счета</th>
			<th>Блокирован ли счет</th>
	
        </tr>
       </thead>
	   
		<mytags:cardlisttag/>
 
  </body>
</html>


