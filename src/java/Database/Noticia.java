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
     
    public boolean AgregarImagen (Model.Noticia noticia){
                 try {
            db.Open();
            procedure = db.getConexion().prepareCall("call jc_sp_insert_noticia(?)");
            procedure.setInt("idUsuarioP",noticia.getIdUsuario());
            procedure.setInt("idSeccionP",noticia.getSeccion().getSeccionId());
            procedure.setString("tituloP",noticia.getTitulo());
            procedure.setString("descripcionP",noticia.getDescripcion());
            procedure.setString("noticiaP",noticia.getNoticia());
           // procedure.setDate("fechaP",noticia.getFecha());
            if (procedure.executeUpdate()>0){
                
            db.getConexion().commit();
            return true;
            }else{
            return false;
            }
           
        }catch(Exception error){
            return false;
        }
        finally{
        db.Close();
        }
     }
     
     public boolean ModificarNoticia (Model.Noticia noticiaModificada){
                    try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_update_usuario(?,?,?,?,?,?)");
            procedure.setInt("idSeccionP", noticiaModificada.getSeccion().getSeccionId());
            procedure.setInt("idUsuarioP", noticiaModificada.getIdUsuario());
            procedure.setString("tituloP", noticiaModificada.getTitulo());
            procedure.setString("descripcionP", noticiaModificada.getDescripcion());
            procedure.setString("noticiaP", noticiaModificada.getNoticia());
           // procedure.se("fechaP", noticiaModificada.getFecha());
            if (procedure.executeUpdate()>0){
            db.getConexion().commit();
            return true;
            }else{
                return false;
            }
        }catch(Exception error){
        return false;
        }finally{db.Close();}
    }
     
     public boolean EliminarNoticia (Model.Noticia noticiaEliminada){
                 try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_delete_noticia(?);");
            procedure.setInt("idNoticiaP",noticiaEliminada.getNoticiaId());
            if(procedure.executeUpdate()>0)
            {
                db.getConexion().commit();
                return true;
            }
            else
            {
                return false;
            }            
        }catch(Exception Error)
        {
             return false;          
        }finally
        {
            db.Close();
        }
       
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
                            rs.getDate("fecha")));
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
