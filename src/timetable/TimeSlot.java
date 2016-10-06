/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 * @author Gabriel M, Gabriel O., Danillo, Marcos
 */
public class TimeSlot {
    
    int cod;
    int dia;
    String horaInicio;
    String horaFinal;

    public TimeSlot(int cod, int dia, String horaInicio, String horaFinal) {
         this.cod = cod;
         this.dia = dia;
         this.horaFinal = horaFinal;
         this.horaInicio = horaInicio;
        
        
        
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getCod() {
        return cod;
    }

    public int getDia() {
        return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }
    
    
    
    
    
}
