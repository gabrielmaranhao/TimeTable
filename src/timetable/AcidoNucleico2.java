/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;


import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class AcidoNucleico2 {
    

   HashMap<Integer,Molecula> acidoNucleico = new HashMap<Integer,Molecula>();
   

    public AcidoNucleico2(HashMap<Integer,Molecula> acidoNucleico) {
        
        this.acidoNucleico = acidoNucleico;
    }

    public AcidoNucleico2() {
    }

    public HashMap<Integer, Molecula> getAcidoNucleico() {
        return acidoNucleico;
    }

    public void setAcidoNucleico(HashMap<Integer, Molecula> acidoNucleico) {
        this.acidoNucleico = acidoNucleico;
    }
   
   
    
    
}
