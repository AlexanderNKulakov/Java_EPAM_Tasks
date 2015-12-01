<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytags"%>
<html>
  <head>
    <title>Личный кабинет пользователя</title>
	<link type="text/css" rel="stylesheet" href="css/profile.css"/>
  </head>
  <body>
  
	Вы вошли как <mytags:getlogintag/>,
	
	<a href="logout">Выйти</a>
  
	  
   <br><br>  
	Список ваших кредитных карт:
   <table class="Cards">
        <thead>
			<tr>
				<th width="200">Номер карты</th>
				<th>Дата окончания действия карты</th>
				<th width="200">Счет карты</th>
				<th>Баланс счета</th>
			</tr>
		</thead>
		
		<tbody>
			<mytags:cardlisttag/>
		</tbody>
	</table>
	
	<br><br>  
	Ваши счета:
   <table class="Cards">
        <thead>
			<tr>
				<th width="200">Номер счета</th>
				<th>Баланс счета</th>
				<th>Блокировка</th>
				<th>Пополнить</th>
				<th>Сделать платеж</th>
			</tr>
		</thead>
		
		<tbody>
			<mytags:billlisttag/>
		</tbody>
	</table>
	
  
  </body>
</html>


