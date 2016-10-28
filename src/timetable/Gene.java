/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class Gene {
    
   

   HashMap<Integer,AcidoNucleico2> gene = new HashMap<Integer,AcidoNucleico2>();

    public Gene(HashMap<Integer,AcidoNucleico2> gene) {
        this.gene = gene;
    }

    public Gene() {
    }
    

    public HashMap<Integer, AcidoNucleico2> getGene() {
        return gene;
    }

    public void setGene(HashMap<Integer, AcidoNucleico2> gene) {
        this.gene = gene;
    }
    
   
   
    
}

