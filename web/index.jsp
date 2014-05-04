<%-- 
    Document   : index
    Created on : 9/03/2014, 04:33:23 PM
    Author     : JuanSosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="NoticiasFCFM.Ejemplo" %>
<%@ page import="Database.*" %>
<%@ page import="Model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
           /* Model.Usuario usr= new Model.Usuario(                    
                0,
                2,
                "",
                "F",
                "maleny@gmail.com",
                "amleny",
                "Maleny",
                "Banda",
                "",
                "Male",
                "8181829804");*/
            //new Database.Usuario().RegistrarUsuario(usr);
            Model.Usuario usr= new Model.Usuario();
            usr.setIdUsuario(14);
            new Database.Usuario().TraerInfoUsuario(usr);
            new Database.Seccion().TraerSecciones();
            Model.Seccion seccion = new Model.Seccion(0,"Alerta");
            new Database.Seccion().AgregarSeccion(seccion);
            Model.Seccion seccionID = new Model.Seccion(2, "Deportes");
            new Database.Seccion().EliminarSeccion(seccionID);
            out.println("<title>JSP Page juanito</title>");
        %>
    </head>
    <body>
    </body>
</html>

