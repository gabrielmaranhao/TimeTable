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
 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraCSV {

 

        String csvFile = "C:\\Users\\Aluno\\Downloads\\ag-informacoes.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int flag;
        
        
         ArrayList<TimeSlot> TIMESLOT = new ArrayList<TimeSlot>();
         
         ArrayList<Curso> CURSO = new ArrayList<Curso>();
         
         ArrayList<SalaAula> SALA = new ArrayList<SalaAula>();
         
         ArrayList<Disciplina> DISCIPLINA = new ArrayList<Disciplina>();
         
         ArrayList<Estudante> ESTUDANTE = new ArrayList<Estudante>();
         
         ArrayList<Professor> PROFESSOR = new ArrayList<Professor>();
        
        
        
        
        
        
public void Ler(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                   
                // use comma as separator
                //String[] country = line.split(cvsSplitBy);
                
                if(line.substring(0,2).equals("//")){
                    flag = -1;
                }
                
                if(line.equals("TIMESLOT")){
                    flag = 1;
                    line = br.readLine();
                    line = br.readLine();
                    
                   // LerTIMESLOT(line);

                }
                
                else  if(flag == 1){
                        LerTIMESLOT(line);
                    }
                
                if(line.equals("CURSO")){
                    flag = 2;
                    line = br.readLine();
                    line = br.readLine();
                         
                }else if(flag == 2){
                       LerCURSO(line);
                    }
                
                if(line.equals("SALA")){
                    flag = 3;
                    line = br.readLine();
                     line = br.readLine();
                     
                }else if(flag == 3){
                       LerSALA(line);
                    }
 
                if(line.equals("DISCIPLINA")){
                    flag = 4;
                    line = br.readLine();
                     line = br.readLine();
                    
                                                    
                }else if(flag == 4){
                        
                  LerDISCIPLINA(line);
                }
                
                
                if(line.equals("ESTUDANTE")){
                    flag = 5;
                    line = br.readLine();
                    line = br.readLine();
                                                     
                }else if(flag == 5){
                       LerESTUDANTE(line);  
                    }
                
                if(line.equals("PROFESSOR")){
                    flag = 6;
                    line = br.readLine();
                    line = br.readLine();
                                     
                }else if(flag == 6){
                       LerPROFESSOR(line);
                       }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void LerTIMESLOT(String line) {
        
        TimeSlot ts;
        String[] aux = line.split(cvsSplitBy);
        ts = new TimeSlot(Integer.parseInt(aux[0]),Integer.parseInt(aux[1]),aux[2],aux[3]);
        TIMESLOT.add(ts);     
        
    }

    private void LerCURSO(String line) {
    
        Curso cs;
        String [] aux = line.split(cvsSplitBy);
        
       // System.out.println(aux[2]);
        
        cs = new Curso(Integer.parseInt(aux[0]), aux[1], Integer.parseInt(aux[2].trim()), Integer.parseInt(aux[3].trim()));
        CURSO.add(cs);
        
    }

    private void LerSALA(String line) {
        
        SalaAula sa;
        String [] aux = line.split(cvsSplitBy);
        sa = new SalaAula(Integer.parseInt(aux[0]), aux[1], Integer.parseInt(aux[2]), Integer.parseInt(aux[3]));
        SALA.add(sa);
        
                
    }

    private void LerDISCIPLINA(String line) {
        
        Disciplina ds;
        String[] aux = line.split(cvsSplitBy);
        ds = new Disciplina(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]), aux[3],Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), Integer.parseInt(aux[6]), Integer.parseInt(aux[7]));
          DISCIPLINA.add(ds);
          
    }
    

    private void LerESTUDANTE(String line) {

        Estudante es;
        int[] aux1 = new int[10];
        String[] aux = line.split(cvsSplitBy);
        for(int i=2;i<aux.length;i++){
          
            aux1[i-2] = Integer.parseInt(aux[i]);
            // verificar espaçoes vazios
        }
        es = new Estudante(Integer.parseInt(aux[0]),aux[1],aux1);
        ESTUDANTE.add(es);
        
        
        

    }

    private void LerPROFESSOR(String line) {

        Professor pf;
        int[] aux1 = new int[10];
        String[] aux = line.split(cvsSplitBy);
        for(int i=2;i<aux.length;i++){
          
            aux1[i-2] = Integer.parseInt(aux[i]);
            // verificar espaçoes vazios
        }
        pf = new Professor(Integer.parseInt(aux[0]),aux[1],aux1);
        PROFESSOR.add(pf);
        
        

    }
    public void Escrever(){
    //metodo teste
        
        int i = 0;
    
        for( TimeSlot ts : TIMESLOT){
            
            System.out.println("Gravou: "+TIMESLOT.get(i).cod+","+TIMESLOT.get(i).dia+","+TIMESLOT.get(i).horaInicio+","+TIMESLOT.get(i).horaFinal);
            i++;
        }
        
        //(int i = 0;i < (CURSO.size()+SALA.size()+DISCIPLINA.size()+ESTUDANTE.size()+PROFESSOR.size());i++){
            
           // System.out.println("");
            
        //}
       
        
    }
    
}