/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Curso {
    
    int cod;
    String nome;
    int numPeri;
    int turno;

    public Curso(int cod, String nome, int numPeri, int turno) {
        this.cod = cod;
        this.nome = nome;
        this.numPeri = numPeri;
        this.turno = turno;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPeri() {
        return numPeri;
    }

    public void setNumPeri(int numPeri) {
        this.numPeri = numPeri;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
    
    
}
