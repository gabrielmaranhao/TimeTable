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
    ArrayList<Integer> dispMi = new ArrayList<>();
    //int dispM[] = new int[10]; // discilplinas a ministras
    ArrayList<Integer> horariosNAOaptos = new ArrayList<>();

    public Professor(int cod, String nome, ArrayList<Integer> dispMi, ArrayList<Integer> horariosNAOaptos) {
        this.cod = cod;
        this.nome = nome;
        this.dispMi = dispMi;
        this.horariosNAOaptos = horariosNAOaptos;
    }

    public Professor() {
    }

    public ArrayList<Integer> getDispMi() {
        return dispMi;
    }

    public void setDispMi(ArrayList<Integer> dispMi) {
        this.dispMi = dispMi;
    }

    public ArrayList<Integer> getHorariosNAOaptos() {
        return horariosNAOaptos;
    }

    public void setHorariosNAOaptos(ArrayList<Integer> horariosAptos) {
        this.horariosNAOaptos = horariosAptos;
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

   
    
    
}
