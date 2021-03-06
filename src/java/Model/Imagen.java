/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JuanSosa
 */
public class Imagen {
    private int idImagenNoticia;
    private int idNoticia;
    private String nombre;
    private String path;
    private String descripcion;

    public Imagen()
    {}
    public Imagen(
        int idImagenNoticia,
        int idNoticia,
        String nombre,
        String path,
        String descripcion
            )
    {
        this.setDescripcion(descripcion);
        this.setIdImagenNoticia(idImagenNoticia);
        this.setIdNoticia(idNoticia);
        this.setNombre(nombre);
        this.setPath(path);
    }
    /**
     * @return the idImagenNoticia
     */
    public int getIdImagenNoticia() {
        return idImagenNoticia;
    }

    /**
     * @param idImagenNoticia the idImagenNoticia to set
     */
    public void setIdImagenNoticia(int idImagenNoticia) {
        this.idImagenNoticia = idImagenNoticia;
    }

    /**
     * @return the idNoticia
     */
    public int getIdNoticia() {
        return idNoticia;
    }

    /**
     * @param idNoticia the idNoticia to set
     */
    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
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
    
}
