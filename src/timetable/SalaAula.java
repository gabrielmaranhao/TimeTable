/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 * @author Gabriel
 */
public class SalaAula {
    
    int cod;
    String descri;
    int tipo;
    int capacidade;

    public SalaAula(int cod, String descri, int tipo, int capacidade) {
        this.cod = cod;
        this.descri = descri;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public SalaAula() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    
}
