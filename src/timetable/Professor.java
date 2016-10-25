/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;

/**
 *
 *  @author Gabriel M., Gabriel O., Danillo, Marcos

 */
public class Professor {
    
    int cod;
    String nome;
    ArrayList<Integer> dispM = new ArrayList<Integer>(); // discilplinas a ministras

    public Professor(int cod, String nome, ArrayList<Integer> dispM) {
        this.cod = cod;
        this.nome = nome;
        this.dispM = dispM;
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

    public ArrayList<Integer> getDispM() {
        return dispM;
    }

    public void setDispM(ArrayList<Integer> dispM) {
        this.dispM = dispM;
    }
    
    
    
}
