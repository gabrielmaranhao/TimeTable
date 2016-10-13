/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;

/**
 *
 * @author Danillo, Marcos, Gabriel M., Gabriel O.
 */
public class AcidoNucleico {
    boolean usado;
    Professor prof;
    SalaAula sala;
    Disciplina disc;
    TimeSlot timeslot;
    ArrayList<Estudante> estudantes;

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

    public Disciplina getDisc() {
        return disc;
    }

    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public AcidoNucleico() {
        
    }
}
