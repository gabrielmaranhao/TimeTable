/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 @author Gabriel M., Gabriel O., Danillo, Marcos
 */
public class Disciplina {
    
    int codD;
    int codC;
    int codP;
    String descri;
    int cargaH_T; // carga horário terica
    int tipoS_T; // tipo de sala teorica
    int cargaH_P; //carga hrária pratica
    int tipoS_P;  // tipo sala pratica

    public Disciplina(int codD, int codC, int codP, String descri, int cargaH_T, int tipoS_T, int cargaH_P, int tipoS_P) {
        this.codD = codD;
        this.codC = codC;
        this.codP = codP;
        this.descri = descri;
        this.cargaH_T = cargaH_T;
        this.tipoS_T = tipoS_T;
        this.cargaH_P = cargaH_P;
        this.tipoS_P = tipoS_P;
    }

    public int getCodD() {
        return codD;
    }

    public void setCodD(int codD) {
        this.codD = codD;
    }

    public int getCodC() {
        return codC;
    }

    public void setCodC(int codC) {
        this.codC = codC;
    }

    public int getCodP() {
        return codP;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getCargaH_T() {
        return cargaH_T;
    }

    public void setCargaH_T(int cargaH_T) {
        this.cargaH_T = cargaH_T;
    }

    public int getTipoS_T() {
        return tipoS_T;
    }

    public void setTipoS_T(int tipoS_T) {
        this.tipoS_T = tipoS_T;
    }

    public int getCargaH_P() {
        return cargaH_P;
    }

    public void setCargaH_P(int cargaH_P) {
        this.cargaH_P = cargaH_P;
    }

    public int getTipoS_P() {
        return tipoS_P;
    }

    public void setTipoS_P(int tipoS_P) {
        this.tipoS_P = tipoS_P;
    }
    
    
}
