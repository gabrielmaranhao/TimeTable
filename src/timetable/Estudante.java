/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 * @author Gabriel M., Gabriel O., Danillo, Marcos
 */
public class Estudante {
    
    int cod;
    String nome;
    int disp[] = new int[10];
    
    

    public Estudante(int cod, String nome, int[] disp) {
        this.cod = cod;
        this.nome = nome;
        this.disp = disp;
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

    public int[] getDisp() {
        return disp;
    }

    public void setDisp(int[] disp) {
        this.disp = disp;
    }
    
    
}
