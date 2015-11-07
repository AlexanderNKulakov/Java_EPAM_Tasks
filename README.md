# Java_EPAM_Tasks
EPAM Tasks



src\main\java\src
src\main\resources

src\test



https://github.com/Vyacheslav-Lapin/JavaFundamentals


VM option: -ea  for assert support

M2_HOME for Maven

http://search.maven.org
https://bintray.com/

plagin code plains?



https://www.angularjs.org/     ReactJs
Ajax   webSocket
Velocity
TeanLeaf

IoC = DI

Aspectj  
SpringAOC


book Spring 4 dlya professionalov

Goole Guice

Selenium


use Comcat
settings IDEA - Application Server  use new Tomcat
zatem Modules + add


Java EE -  Web App (3.1)
delaem new folder -  (link): bin lib host-manager manager
catalina_home delete
ROOT mapim na papku web
bin/startup.bat


web/css/index.css:
#Models >

td {
 color :  888
}

td, th {
  border: 1px;
}

web/WEB-INF



http://devcolibri.com/4575


index.jsp:
<head>
 <link type"text/css" rel="stylesheet" href="css/index.css"/>
</head>

<table id="Model">
  <thead>
    <tr>
     <th>id</th>
     <th>nazvanie>
     ...
  </thead>
  
  <tbody>
    <tr>
      <td>1</td>
      <td>AK-47</td>
      ...
      
     


login.html:
Zalogin
<from action="catalog.jsp"
  <input name="j_username" type="text" value="login" title="login"/>
  <input name="j_password" type="password" value="" title="password"/>
  <input type="submit"/>
</form>



web.xml:

 <security-constraint>
        <web-resource-collection>
            <web-resource-name>secured</web-resource-name>
            <url-pattern>catalog.jsp</url-pattern>
            <http-method>GET</http-method>
            <http-method>POST</http-method>
        </web-resource-collection>
        <auth-constraint>
            <role-name>CUSTOMER</role-name>
        </auth-constraint>
    </security-constraint>

 <security-role>
        <role-name>CUSTOMER</role-name>
  </security-role>
    
    

<login-config>
  <auth-method>FORM</auth-method>
  <realm-name>EM Application</realm-name>
  <form-login-config>
    <form-login-page>/faces/html/common/login.jsp</form-login-page>
    <form-error-page>/faces/html/common/login.jsp?failed=true</form-error-page>
  </form-login-config>
</login-config>




tomcat-user.xml:
<role rolename="tomcat"/>
<role rolename="role1"/>
<role rolemame="manager-gui"/>

<group groupname="CUSTOMER roles="manager-gui,role1,tomcat"
 desctiption="Vozmognost' prosmotra catalova>"/
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui"
  groups="CUSTOMER">
<user username="both"  password  roles=manager-gui,role1?
<user username=user1?" roles="role1"/>


error.html


catalog.jsp
<title>Secretnui catalog</title>








ILI cherez filr:
src\package_security\SecurityFilter

@WebFilter(urlPatterns = "catalog.jsp")  
public class SecurityFilter implements Filter {

    public void init(.) {}
    
    public void doFilter(ServletRequest servletRequset ...)
        //TODO proverit' login i  parol
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequest httpServletResponce = (HttpServletRequest) servletResponse;
        
        String username = httpServletRequest.getParameter("j_username");
        String password = httpServletRequest.getParameter("j_password");
        
        if (username !=null & password != null && username.equals("tomcat") && password.equals("tomcat")
            filterChain.doFilter(servletRequest, servletResponse);
        else
         // new RequestDispatcher("").forward(httpServletRequest, httpServletResponse);
            httpServletRequest.getRequestDispatcher("error.html").forward(httpServletRequest("catalog.jsp?"
   
   public void desttoy() {}

}


annotacii ili web.xml:
      filter>
        <filter-name>sec<filter-name>
        <filter-class>com.epam.jf.ee....SecurityFilter
      filter-mapping>
        <filter-name>sec</filter-name>
        <url-pattern>/catalog.jsp</url-pattern>



setting projects:  Run Edit Configuration  
        TOmcat Server
        Build artifact  .war



Database - DAtasource 
CREATE TABLE User (
  ind INT AUTO_INCREMENT,
  name VERCHAR(60),
  login VERCHAR(20),
  password VARCHAR(20),
  is_txt_enable BOOL
)
