/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Database.ConectorMySQL;
import java.util.Arrays;
import java.util.List;
import java.sql.ResultSet;
//import NoticiasFCFM.ConectorMySQL;
/**
 *
 * @author JuanSosa
 */
public class menuInteractivo {
    ConectorMySQL base;
    String nombre;
    String source;
    
    public String menuBD()
    {
        try
        {
            source="<html>\n" +
            "<head>\n" +
            "<meta charset=UTF-8\">\n" +
            "    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" >\n" +
            "<body>\n" +
            "<ul class=\"menu\">\n" ;
            
            source +="<li><a href=\"#\">Secciones</a>\n" +
        "      <ul>\n" ;
        //"        <li><a href=\"#\">html</a></li>\n" +        
            base= new ConectorMySQL();
        
            ResultSet rs=base.ExecProcedure("Seccion_sk");       
            while(!rs.isAfterLast())
            {
                rs.getString("seccion");
                source+="<li><a href=\"#\">"+rs.getString("seccion")+"</a></li>\n" ;
                rs.next();
            }
                    source+= "      </ul>\n" + "    </li>\n" ;
            return source;
                    
        }catch(Exception ex)
        {return "";}
        
    }
    
    public String ImprimirHTML()
    {
        source="<html>\n" +
        "<head>\n" +
        "<meta charset=UTF-8\">\n" +
        "    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" >\n" +
        "<body>\n" +
        "<ul class=\"menu\">\n" +
        "    <li><a href=\"#\">Templates</a>\n" +
        "      <ul>\n" +
        "        <li><a href=\"#\">html</a></li>\n" +
        "        <li><a href=\"#\">css</a></li>\n" +
        "        <li><a href=\"#\">photoshop</a></li>\n" +
        "      </ul>\n" +
        "    </li>\n" +
        " \n" +
        "    <li><a href=\"#\">Tutoriales</a>\n" +
        "      <ul>\n" +
        "        <li><a href=\"#\">html</a></li>\n" +
        "        <li><a href=\"#\">css</a></li>\n" +
        "        <li><a href=\"#\">photoshop</a></li>\n" +
        "      </ul>\n" +
        "    </li>\n" +
        " \n" +
        "     <li><a href=\"#\">Foro</a>\n" +
        "       <ul>\n" +
        "         <li><a href=\"#\">html</a></li>\n" +
        "         <li><a href=\"#\">css</a></li>\n" +
        "         <li><a href=\"#\">photoshop</a></li>\n" +
        "      </ul>\n" +
        "   </li>\n" +
        "\n" +
        "     <li><a href=\"#\">Esto</a>\n" +
        "       <ul>\n" +
        "         <li><a href=\"#\">Esta</a></li>\n" +
        "         <li><a href=\"#\">Bien</a></li>\n" +
        "         <li><a href=\"#\">Proo</a></li>\n" +
        "      </ul>\n" +
        "   </li>\n" +
        " </ul>\n" +
        "</body>\n" +
        "</html>";
        return source;
    } 
}
