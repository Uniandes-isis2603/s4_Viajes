/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un combo en la persistencia y permite su
 * serialización.
 * @author estudiante
 */
@Entity
public class ComboEntity  extends BaseEntity implements Serializable {
    //-----------------------------------------------------------------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------------------------------------------------------------
  
    private double costo;
    
    private String nombre;
    
    private Long comboId;

    private int dias;
    
    private double horas;

    private int puntuacion;
    
    @PodamExclude
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VueloEntity> vuelos;
    
    @PodamExclude
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlojamientoEntity> alojamientos;

    @PodamExclude
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActividadEntity> actividades;
    
    @PodamExclude
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransporteTerrestreEntity> transportesTerrestres;

    

    //-----------------------------------------------------------------------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------------------------------------------------------------------
    
    
    public Long getComboId() {
        return comboId;
    }

    public void setComboId(Long comboId) {    
        this.comboId = comboId;
    }


    public double getCosto() {
        return costo;
    }
     
    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public List<VueloEntity> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloEntity> vuelos) {
        this.vuelos = vuelos;
    }

    public List<AlojamientoEntity> getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(List<AlojamientoEntity> alojamientos) {
        this.alojamientos = alojamientos;
    }

    public List<ActividadEntity> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadEntity> actividades) {
        this.actividades = actividades;
    }

     public List<TransporteTerrestreEntity> getTransportesTerrestres() {
        return transportesTerrestres;
    }
    
    public void setTransportesTerrestres(List<TransporteTerrestreEntity> transportesTerrestres) {
        this.transportesTerrestres = transportesTerrestres;
    }
}
