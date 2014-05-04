/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JuanSosa
 */
public class Imagen {
     private DataBase db;
     private ResultSet rs;
     private CallableStatement procedure; 
     
      public Imagen(){
         this.db = new DataBase();
     }

         public boolean AgregarImagen (Model.Imagen imagen){
                 try {
            db.Open();
            procedure = db.getConexion().prepareCall("call jc_sp_insert_imagen(?)");
            procedure.setInt("idNoticiaP",imagen.getIdNoticia());
            procedure.setString("nombreP",imagen.getNombre());
            procedure.setString("pathP",imagen.getPath());
            procedure.setString("descripcionP",imagen.getDescripcion());
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
     public boolean EliminarImagen (Model.Imagen ImagenEliminada){
                 try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_delete_noticia(?);");
            procedure.setInt("idImagenNoticiaP",ImagenEliminada.getIdImagenNoticia());
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
}
