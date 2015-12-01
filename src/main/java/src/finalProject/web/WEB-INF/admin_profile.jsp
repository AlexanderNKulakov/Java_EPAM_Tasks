<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytags"%>
<html>
  <head>
    <title>Личный кабинет администратора</title>
	<link type="text/css" rel="stylesheet" href="css/profile.css"/>
  </head>
  <body>
  
	Админка
	<br><br>
	Вы вошли как <mytags:getlogintag/>, 
	
	<a href="logout">Выйти</a>
  
	<br><br>
	
	Список счетов пользователей:
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


