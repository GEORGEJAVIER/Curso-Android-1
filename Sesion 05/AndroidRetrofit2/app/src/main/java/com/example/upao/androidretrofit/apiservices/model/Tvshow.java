package com.example.upao.androidretrofit.apiservices.model;

/**
 * Created by UPAO on 15/06/2016.
 */
public class Tvshow {
    private String titulo;
    private int anno;
    private String pais;
    private String imagen;
    private int temporadas;
    private String genero;
    private String resumen;

    public Tvshow() {
    }

    public Tvshow(String titulo, int anno, String pais, int temporadas, String genero, String resumen) {
        this.titulo = titulo;
        this.anno = anno;
        this.pais = pais;
        this.temporadas = temporadas;
        this.genero = genero;
        this.resumen = resumen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}
