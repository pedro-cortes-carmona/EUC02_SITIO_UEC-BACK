package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pedro.cortes
 */
@Entity
@Table(name = "UEC_CATALOGO_AUTORIZADORES2021")
public class UecCatalogoAutorizadores2021 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String soeid;
    @Column(name = "SOEID_DIVISIONAL")
    private String soeidDivisional;
    @Column(name = "SOEID_DISTRITAL")
    private String soeidDistrital;
    private String division;
    private String distristo;
    private String nombre;
    private String inic;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    private Long alta;
    private String correo;
    @Column(name = "IS_CETE100")
    private Long isCete100;
    @Column(name = "IS_CAMPESP")
    private Long isCampesp;
    @Column(name = "ID_NIVEL_AUTO")
    private Long idNivelAuto;

    public UecCatalogoAutorizadores2021() {
    }

    public UecCatalogoAutorizadores2021(String soeid) {
        this.soeid = soeid;
    }

    public String getSoeid() {
        return soeid;
    }

    public void setSoeid(String soeid) {
        this.soeid = soeid;
    }

    public String getSoeidDivisional() {
        return soeidDivisional;
    }

    public void setSoeidDivisional(String soeidDivisional) {
        this.soeidDivisional = soeidDivisional;
    }

    public String getSoeidDistrital() {
        return soeidDistrital;
    }

    public void setSoeidDistrital(String soeidDistrital) {
        this.soeidDistrital = soeidDistrital;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistristo() {
        return distristo;
    }

    public void setDistristo(String distristo) {
        this.distristo = distristo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInic() {
        return inic;
    }

    public void setInic(String inic) {
        this.inic = inic;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Long getAlta() {
        return alta;
    }

    public void setAlta(Long alta) {
        this.alta = alta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIsCete100() {
        return isCete100;
    }

    public void setIsCete100(Long isCete100) {
        this.isCete100 = isCete100;
    }

    public Long getIsCampesp() {
        return isCampesp;
    }

    public void setIsCampesp(Long isCampesp) {
        this.isCampesp = isCampesp;
    }

    public Long getIdNivelAuto() {
        return idNivelAuto;
    }

    public void setIdNivelAuto(Long idNivelAuto) {
        this.idNivelAuto = idNivelAuto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soeid != null ? soeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UecCatalogoAutorizadores2021)) {
            return false;
        }
        UecCatalogoAutorizadores2021 other = (UecCatalogoAutorizadores2021) object;
        if ((this.soeid == null && other.soeid != null) || (this.soeid != null && !this.soeid.equals(other.soeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.citi.euces.perfilador.entities.UecCatalogoAutorizadores2021[ soeid=" + soeid + " ]";
    }
    
}
