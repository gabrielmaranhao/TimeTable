/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;

/**
 *
 * @author Gabriel M., Gabriel O., Danillo, Marcos
 */
public class Estudante {
    
    int cod;
    String nome;
    //int disp[] = new int[10];
    
    ArrayList<Integer> displ = new ArrayList<>();
    
    

    public Estudante(int cod, String nome,ArrayList<Integer> displ ) {
        this.cod = cod;
        this.nome = nome;
        this.displ = displ;
    }

    public ArrayList<Integer> getDispl() {
        return displ;
    }

    public void setDispl(ArrayList<Integer> displ) {
        this.displ = displ;
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
