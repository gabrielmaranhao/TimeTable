/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
/**
 *
 * @author Gabriel
 */
public class EscritaCSV {

    public EscritaCSV() {
    }
    
    
    public void escreveInfos(Cromossomo2 cromossomo) throws FileNotFoundException{
        
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-horarios.csv"));
        StringBuilder sb = new StringBuilder();
        
        
        for(int c = 1; c<=3 ; c++){
            
            for(int p = 1; p<=10; p++){
               Set<Integer> keysetTS =  cromossomo.cromossomo.get(c).gene.get(p).acidoNucleico.keySet();
               
                for(Integer TS : keysetTS){
                    
                            
                     sb.append(Integer.toString(cromossomo.cromossomo.get(c).gene.get(p).acidoNucleico.get(TS).disc.codD));
                    sb.append(',');
                
                    sb.append(Integer.toString(cromossomo.cromossomo.get(c).gene.get(p).acidoNucleico.get(TS).timeslot.cod));
                    sb.append(',');
                
                    sb.append(Integer.toString(cromossomo.cromossomo.get(c).gene.get(p).acidoNucleico.get(TS).prof.cod));
                    sb.append(',');
                
                    sb.append(Integer.toString(cromossomo.cromossomo.get(c).gene.get(p).acidoNucleico.get(TS).sala.cod));
                    sb.append('\n');
                             
               }
            }
        }
     
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
 
     
}
    
}