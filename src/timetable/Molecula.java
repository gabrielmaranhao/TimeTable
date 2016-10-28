/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Molecula {
    
    TimeSlot timeslot;
    //boolean usado;
    Professor prof;
    Disciplina disc;
    SalaAula sala;
    ArrayList<Estudante> estudantes;

    public Molecula(TimeSlot timeslot, Professor prof, Disciplina disc, SalaAula sala, ArrayList<Estudante> estudantes) {
        this.timeslot = timeslot;
        this.prof = prof;
        this.disc = disc;
        this.sala = sala;
        this.estudantes = estudantes;
    }

    public Molecula() {
    }
    

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public Disciplina getDisc() {
        return disc;
    }

    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }

    public SalaAula getSala() {
        return sala;
    }

    public void setSala(SalaAula sala) {
        this.sala = sala;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    
    
}
