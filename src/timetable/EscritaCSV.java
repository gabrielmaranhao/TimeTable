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
/**
 *
 * @author Gabriel
 */
public class EscritaCSV {
    
    
    public void escreveInfos(ArrayList<ArrayList<AcidoNucleico>> cromossomo) throws FileNotFoundException{
        
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-horarios.csv"));
        StringBuilder sb = new StringBuilder();
        int i=0;
        
        for(ArrayList<AcidoNucleico> arry : cromossomo){
            
            for(AcidoNucleico acid : cromossomo.get(i)){
                
                if(acid.usado == false){
                
                    // faz nada
                }
                else{
              
                sb.append(Integer.toString(acid.disc.codD));
                sb.append(',');
                
                sb.append(Integer.toString(acid.timeslot.cod));
                sb.append(',');
                
                sb.append(Integer.toString(acid.prof.cod));
                sb.append(',');
                
                sb.append(Integer.toString(acid.sala.cod));
                sb.append('\n');
                
                }
                
                
            }
           
            
          i++;
          
        }
        
        
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
        
        
    }
    
    
    
    
}
