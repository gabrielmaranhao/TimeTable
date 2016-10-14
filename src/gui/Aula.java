/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import timetable.*;

/**
 *
 * @author Gabriel
 */
public class Aula {
    
    int curso;
    int periodo;
    Disciplina disp;
    TimeSlot timeSlot;
    Professor prof;
    SalaAula sala;

    public Aula(int curso, int periodo, Disciplina disp, TimeSlot timeSlot, Professor prof, SalaAula sala) {
        this.curso = curso;
        this.periodo = periodo;
        this.disp = disp;
        this.timeSlot = timeSlot;
        this.prof = prof;
        this.sala = sala;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public Disciplina getDisp() {
        return disp;
    }

    public void setDisp(Disciplina disp) {
        this.disp = disp;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public SalaAula getSala() {
        return sala;
    }

    public void setSala(SalaAula sala) {
        this.sala = sala;
    }
      
}
