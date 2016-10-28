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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;



public class GerarIndividuo {
    
     ArrayList<Professor> TodosProf = new ArrayList<Professor>(LeituraCSV.PROFESSOR);
     ArrayList<Disciplina> TodosDisp = new ArrayList<Disciplina>( LeituraCSV.DISCIPLINA);
     ArrayList<SalaAula> TodosSala = new ArrayList<SalaAula>(LeituraCSV.SALA);
     ArrayList<TimeSlot> TodosTS = new ArrayList<TimeSlot>(LeituraCSV.TIMESLOT);
     ArrayList<Estudante> TodosEstu =new ArrayList<Estudante>( LeituraCSV.ESTUDANTE);
     ArrayList<Curso> TodosCur = new ArrayList<Curso>(LeituraCSV.CURSO);
     ArrayList<Integer> TodosPer =new ArrayList<Integer>();
     
     Random randomGenerator = new Random();
     
//     Professor prof;
//     Disciplina disp;
     ArrayList<Estudante> estu;
     TimeSlot ts;
     
      Molecula molecula = new Molecula();
      AcidoNucleico2 acidos = new AcidoNucleico2();
      Gene gen = new Gene();
      Cromossomo2 cro = new Cromossomo2();
      
    
    public Cromossomo2 Individuo(){
          RandTudo();
          RandTudo();
          
          for(int c = 1; c<=3; c++){
          
                int curso = CursoEscolhido();
                TodosPer = preenchePeriodo();
                
                for(int p = 1; p<=10; p++ ){
                    
                     ArrayList<TimeSlot> TodosTS = new ArrayList<>(LeituraCSV.TIMESLOT);
                      RandTudo();
                        
                        int periodo = PeriodoEscolhido();
          
                        ArrayList<TimeSlot> ts = TSCurso(curso);
                        
                        
                        acidos = GerarMoleculaEacidoNucleico(ts, curso, periodo);
                        GerarGene(acidos,periodo);
  
                }
                cro.cromossomo.put(curso,gen);
  
          }
          return cro;
          
      }
    
    public void GerarGene(AcidoNucleico2 acido, int periodo){
        

        gen.gene.put(periodo,acido);
   
    } 
      
    public AcidoNucleico2 GerarMoleculaEacidoNucleico(ArrayList<TimeSlot> TsAptos, int curso, int periodo){ // se periodo for 11 ou 12 não existem disciplinas
        Molecula mol;
        AcidoNucleico2 acido = new AcidoNucleico2();
        
        Disciplina disciplina;
        Professor professor = new Professor();
        SalaAula salaT = new SalaAula();
        SalaAula salaP = new SalaAula();;
        SalaAula salaPE = new SalaAula();;
        ArrayList<Disciplina> disciplinasCursoPerido = new ArrayList<Disciplina>();
        
        ArrayList<TimeSlot> TSAptosDispProf = new ArrayList<TimeSlot>();
         ArrayList<TimeSlot> remover = new ArrayList<TimeSlot>();
         ArrayList<Professor> ProfApto = new ArrayList<Professor>();
         ArrayList<TimeSlot> TSOcupados = new ArrayList<TimeSlot>();
         
         
         
         Collections.shuffle(TodosSala);
         
        for(SalaAula sal : TodosSala){
            
            if(sal.tipo == 1){
                
                salaT = sal;
                
            }
            if(sal.tipo == 2){
                
                salaP = sal;
            }
            if(sal.tipo == 3){
                
                salaPE = sal;
            }
            if((salaP.tipo != 0 && salaT.tipo != 0 && salaPE.tipo != 0)){
                break;
            
        }
        }
        
        
       for(Disciplina disp : TodosDisp){
           
           if(disp.codC == curso && disp.codP == periodo){
               
               disciplinasCursoPerido.add(disp);
               
                }
           }
           Collections.shuffle(disciplinasCursoPerido);
           
           while(disciplinasCursoPerido.size() != 0){  // percorre todas as disciplinas desse curdo deste periodo
               
               disciplina = disciplinasCursoPerido.get(0);
               ArrayList<TimeSlot> TSAptosDisp = new ArrayList<TimeSlot>(TsAptos);
               
            //Set<Integer> keyset = acidos.acidoNucleico.keySet();
               
             
//               
               TSAptosDisp.removeAll(TSOcupados);
               
               if(disciplina.horariosAptos.size() == 0){  //verifica se tem restrição de horário
                    //se nao tem, todos TS sao aptos paa tal disciplina
                   
               }
               else{
                   
          

                   for (TimeSlot tis : TsAptos) {
                       
                           if(disciplina.horariosAptos.contains(tis.cod)){
                               
                               remover.add(tis);  //se tem, TS aptos passam a ser os da disciplina                               
                           }
                           
                           
                       }
                   
                      if(!remover.isEmpty()){
                        TSAptosDisp.retainAll(remover);
                      }
                    
                    remover.clear();
                   
               }
               
               for( Professor prof : TodosProf){
                   int i = 0;
                   
                   while(i<= prof.dispMi.size()-1){
                       
                       if(prof.dispMi.get(i) == disciplina.getCodD()){
                           
                           ProfApto.add(prof);
                          
                       }
                       i++;
                       
                   }
                    
                   if(professor.cod != 0){
                       break;

                   }
                   
               }
               TSAptosDispProf = TSAptosDisp;
               
               if(professor.horariosNAOaptos.size() == 0){
                   
                   TSAptosDispProf = TSAptosDisp;
                   
                   
               }
               else{
               
                    for(TimeSlot ts : TSAptosDisp){
                   
                        if(professor.horariosNAOaptos.contains(ts.cod)){
                            //TSAptosDisp.remove(ts);
                             remover.add(ts);
  
                         }    
                    }
                    
               
                    for(int j =0 ; j<=remover.size()-1;j++){
                        TSAptosDispProf.remove(remover.get(j));
                    }
                    remover.clear();
                    
               }
               
               Collections.shuffle(TSAptosDispProf);
               Collections.shuffle(ProfApto);
               
               
               if(TSAptosDispProf.size() > (disciplina.cargaH_P + disciplina.cargaH_T)){ // quantidade de TS disponiveis ao final, é maior que o número de Horas de aula?
                   
                   int i = 0;
                   Collections.shuffle(TSAptosDispProf);
                   
                   for(int h_p = 1; h_p <= disciplina.cargaH_P; h_p++){
                       
                       if(salaP.tipo == disciplina.tipoS_P){
                           
                           if(TSAptosDispProf.size() ==  0 || ProfApto.size() == 0){
                           System.out.println("1) i > TTSAptosDispProf.size"+i+"<-i"+"Disp:"+disciplina.codD);
                       }
                       
                       mol = new Molecula(TSAptosDispProf.get(0), ProfApto.get(0), disciplina, salaP, null);
                       acido.acidoNucleico.put(TSAptosDispProf.get(0).cod, mol);
                       
                       ProfApto.get(0).horariosNAOaptos.add(TSAptosDispProf.get(0).cod);
                       
                       
                       TSOcupados.add(TSAptosDispProf.get(0));  
                       TodosSala.remove(salaP);
  
                       }
                       
                       if(salaPE.tipo == disciplina.tipoS_P){
                           
                            if(TSAptosDispProf.size() ==  0 || ProfApto.size() == 0){
                           System.out.println("2) i > TTSAptosDispProf.size"+i+"<-i"+"Disp:"+disciplina.codD);
                       }
                       
                       mol = new Molecula(TSAptosDispProf.get(0), ProfApto.get(0), disciplina, salaPE, null);
                       acido.acidoNucleico.put(TSAptosDispProf.get(0).cod, mol);
                       
                       ProfApto.get(0).horariosNAOaptos.add(TSAptosDispProf.get(0).cod);
                       
                       TSOcupados.add(TSAptosDispProf.get(0));

                        TodosSala.remove(salaPE);
                       }
                       
                      
                        

                       i++;
                   }
                   
                   Collections.shuffle(TSAptosDispProf);
                   
                   int j = 0;
                   for(int h_t = 1; h_t <= disciplina.cargaH_T; h_t++){
                       Collections.shuffle(TSAptosDispProf);
                      
                       
                      if(TSAptosDispProf.size() ==  0 || ProfApto.size() == 0) {
                           System.out.println("3) i > TTSAptosDispProf.size"+j+"<-i"+"Disp:"+disciplina.codD);
                       }
                       
                       mol = new Molecula(TSAptosDispProf.get(0), ProfApto.get(0), disciplina, salaT, null);
                       acido.acidoNucleico.put(TSAptosDispProf.get(0).cod, mol);
                       
                       ProfApto.get(0).horariosNAOaptos.add(TSAptosDispProf.get(0).cod);
                       
                       
                       TSOcupados.add(TSAptosDispProf.get(0)); 
                       TodosSala.remove(salaT);
                       
                       i++;
                   }
                   
                   disciplinasCursoPerido.remove(disciplina);
                   TSAptosDispProf.clear();
                   TodosDisp.remove(disciplina);
               }
               else{  // disciplina não será ministrada
                   disciplinasCursoPerido.remove(disciplina);
                   TodosDisp.remove(disciplina);
                   TSAptosDispProf.clear();
                   System.out.println("ERRO, TS insuficiente para Disciplina!");
               }
 
           }
           ProfApto = new ArrayList<Professor>();
           disciplina = new Disciplina();
           
           return acido;
   
    }
    
    public ArrayList<TimeSlot> TSCurso(int curso){
        
        ArrayList<TimeSlot> remover = new ArrayList<TimeSlot>();
        
        if(curso == 1){
            //Para engenharia da computacao: Slots disponiveis
            //32 ao 36, 43 ao 46, 56 ao  60, 67 ao 70, 80 ao 84, 91 ao 94, 
            //104 ao 108, 115 ao 118, 128 ao 132, 139 ao 142, 152 ao 156
            ArrayList<TimeSlot> ECTslots = new ArrayList<TimeSlot>(LeituraCSV.TIMESLOT);;
            int i= 0;
            int num=0;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
            for(TimeSlot ts : ECTslots){  //OLHAR NUMERO D 
                num = ts.cod ; 
                //"range" de numeros disponíveis
                if ((num >= 32 && num <= 36) || (num >= 43 && num <= 46)
                        || (num >= 56 && num <= 60) || (num >= 67 && num <= 70)
                        || (num >= 80 && num <= 84) || (num >= 91 && num <= 94)
                        || (num >= 104 && num <= 108) || (num >= 115 && num <= 118)
                        || (num >= 128 && num <= 132) || (num >= 139 && num <= 142)
                        || (num >= 152 && num <= 156)){
   
            }
                else{
                    
                    remover.add(ts);
                    
                }
                i++;
            }
        //retorna uma lista de ordem randômica com o número do timeslot que será usado para criar o cromossomo.
        //printaLista(slots);
        //return slots;
        ECTslots.removeAll(remover);
        remover.clear();
        return ECTslots;
        }
        else if(curso == 2){
            //Engenharia Eletrica : Todos os timeslots possiveis
            
            ArrayList<TimeSlot> EETslots = new ArrayList<TimeSlot>(LeituraCSV.TIMESLOT);;
            int i= 0;
            int num=0;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
                for(TimeSlot ts : EETslots){
                    num = ts.cod ; //+1 pois começa do 0
                    //"range" de numeros disponíveis
                    if ((num >= 32 && num <= 36) || (num >= 38 && num <= 46)
                            || (num >= 56 && num <= 60) || (num >= 62 && num <= 70)
                            || (num >= 80 && num <= 84) || (num >= 86 && num <= 94)
                            || (num >= 104 && num <= 108) || (num >= 110 && num <= 118)
                            || (num >= 128 && num <= 132) || (num >= 134 && num <= 142)
                            || (num >= 152 && num <= 156))
                    {
                              
                } 
                    else{
                    
                    remover.add(ts);;
                    
                }
                i++;
                }
                EETslots.removeAll(remover);
                remover.clear();
                return EETslots;
            
        }
        else{
            //Engenharia Mecanica: Timeslots disponiveis 
            ArrayList<TimeSlot> EMTslots = new ArrayList<TimeSlot>(LeituraCSV.TIMESLOT);;
            int i= 0;
            int num=0;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
                for(TimeSlot ts : EMTslots){
                    num = ts.cod ; //+1 pois começa do 0
                    if ((num >= 43 && num <= 46) || (num >= 67 && num <= 70)
                            || (num >= 91 && num <= 94) ||(num >= 115 && num <= 118) 
                            || (num >= 139 && num <= 142))
                    {
                              
                } 
                    else{
                    
                    remover.add(ts);
                    
                }
                i++;
                }
                EMTslots.removeAll(remover);
                remover.clear();
                return EMTslots;
            
        }
        
        
        
    }
        
    public int CursoEscolhido(){

        if(LeituraCSV.CURSO.get(0).getCod() == 1){
            LeituraCSV.CURSO.remove(0);
            return 1;
        }
        else if(LeituraCSV.CURSO.get(0).getCod() == 2){
            LeituraCSV.CURSO.remove(0);
            return 2;
        }
        else{
            LeituraCSV.CURSO.remove(0);
            return 3;
        }
        
        
    }
      
    public int PeriodoEscolhido(){

        Collections.shuffle(TodosPer);
       int per  = TodosPer.get(0);
           TodosPer.remove(0);
            return per;

}
    
    public ArrayList<Integer> preenchePeriodo(){
        
        ArrayList<Integer> periodo = new ArrayList<Integer>();
        
        for(int i=1 ; i<=10; i++){
            
            periodo.add(i);
        }
        return periodo;
    }
    
    public void RandTudo(){
        
        Collections.shuffle(TodosProf);
        Collections.shuffle(TodosCur);
        Collections.shuffle(TodosDisp);
        Collections.shuffle(TodosEstu);
        Collections.shuffle(TodosSala);
        Collections.shuffle(TodosTS);
        Collections.shuffle(LeituraCSV.CURSO);
        
    
    }
    
    
    
    
}
