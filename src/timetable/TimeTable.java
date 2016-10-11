/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 *  @author Gabriel M., Gabriel O., Danillo, Marcos

 */
public class TimeTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LeituraCSV leitura = new LeituraCSV();
        
        leitura.LerInfos();
        leitura.LerRes();
        leitura.Escrever();
        
        Cromossomo cr = new Cromossomo();
        cr.GerarSlotsRandom();
        
        
    }
    
}
