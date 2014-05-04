/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JuanSosa
 */
public class Noticia {
     private DataBase db;
     private ResultSet rs;
     private CallableStatement procedure; 
     
     public Noticia(){
         this.db = new DataBase();
     }
     
     public boolean AgregarNoticia (Model.Noticia noticia){
         return false;
     }
     
     public boolean ModificarNoticia (Model.Noticia noticiaModificada){
         return false;
     }
     public boolean EliminarNoticia (Model.Noticia noticiaEliminada){
         return false;
     }
     public List<Model.Noticia> TraerNoticias(){
          List<Model.Noticia> list= new ArrayList<Model.Noticia>();
        try
        {
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_select_noticia()");
            rs=procedure.executeQuery();
            if(rs.isBeforeFirst())
            {
                rs.next();
                while(!rs.isAfterLast())
                {                    
                    list.add(new Model.Noticia(
                            rs.getInt("idNoticia"),
                            rs.getInt("idSeccion"),
                            rs.getInt("idUsuario"),
                            rs.getString("u.Usuario"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getString("noticia"),
                            rs.getString(null)));
                    rs.next();
                }   
                return list;
            }    
            else
            {
                return null;
            }            
        }
        catch(Exception ex)
        {
             return null;
        }
        finally
        {
            db.Close();
        }
     }
}
