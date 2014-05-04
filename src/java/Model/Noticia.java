/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author JuanSosa
 */
public class Noticia {
    private int noticiaId;
    private Seccion seccion;
    private int idUsuario;
    private String titulo;
    private String descripcion;
    private String noticia;
    private Date fecha;
    private int meGusta;
    private List<Video> videos;
    private List<Imagen> imagenes;
    
    public Noticia(){
        this.seccion= new Seccion();
        this.videos= new ArrayList<Video>();
        this.imagenes= new ArrayList<Imagen>();
    }
    public Noticia(
            int noticiaId,
            Seccion seccion,
            int idUsuario,
            String titulo,
            String descripcion,
            String noticia,
            Date fecha,
            int meGusta
            )
    {
        this.seccion= new Seccion();
        this.setNoticiaId(noticiaId);
        this.setSeccion(seccion);
        this.setIdUsuario(idUsuario);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setNoticia(noticia);
        this.setFecha(fecha);
        this.setMeGusta(meGusta);        
    }

    public Noticia(int aInt, int aInt0, int aInt1, String string, String string0, String string1, String string2, java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    /**
     * @return the noticiaId
     */
    public int getNoticiaId() {
        return noticiaId;
    }

    /**
     * @param noticiaId the noticiaId to set
     */
    public void setNoticiaId(int noticiaId) {
        this.noticiaId = noticiaId;
    }

    /**
     * @return the seccion
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the noticia
     */
    public String getNoticia() {
        return noticia;
    }

    /**
     * @param noticia the noticia to set
     */
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the meGusta
     */
    public int getMeGusta() {
        return meGusta;
    }

    /**
     * @param meGusta the meGusta to set
     */
    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    /**
     * @return the videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * @param videos the videos to set
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
   
}
            

