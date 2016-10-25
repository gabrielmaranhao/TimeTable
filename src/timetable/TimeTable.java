/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 *  @author Gabriel M., Gabriel O., Danillo, Marcos

 */
public class TimeTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       
        LeituraCSV leitura = new LeituraCSV();
        ArrayList<ArrayList<AcidoNucleico>> cromossomo = new ArrayList<ArrayList<AcidoNucleico>>();
        EscritaCSV escrita = new EscritaCSV();
        
        leitura.LerInfos();
        leitura.LerRes();
        leitura.Escrever();
        
        Cromossomo cr = new Cromossomo(LeituraCSV.DISCIPLINA,
                LeituraCSV.ESTUDANTE,
                LeituraCSV.TIMESLOT,
                LeituraCSV.PROFESSOR,
                LeituraCSV.SALA,
                LeituraCSV.RESTRICAO);
        
        cr.GerarIndividuo();
        cromossomo = cr.GerarIndividuo();
        escrita.escreveInfos(cromossomo);
        //cr.GerarSlotsRandom();
        
        
    }
    
}
