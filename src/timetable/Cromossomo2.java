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
public class Cromossomo2{
    
    
    
    HashMap<Integer,Gene> cromossomo = new HashMap<Integer,Gene>();

    public Cromossomo2(HashMap<Integer,Gene> cromossomo) {
        this.cromossomo = cromossomo;
        
    }

    public Cromossomo2() {
    }

    public HashMap<Integer, Gene> getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(HashMap<Integer, Gene> cromossomo) {
        this.cromossomo = cromossomo;
    }

   
    
    
    
}
