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

/*
Apos ler o código e entender +- seu funcionamento!

ERROS enncontrados:

1) Me parece que todos os 3 genes estão com mesmas discuplinas, porque na geração das tabelas, 
só é gerado de um curso(porem no debus da pra ver que o cromossomo ta compreto com todos os cursos)
... ainda não sei, pode ser erro na geração tb, ou na vizualização...

2) quase todo periodo fica uma disciplina com somente uma aula, não respeitando sua carga horária

3) quando rodar o programa quase sempr vai dar erro, mas algumas vezes da certo...isso pq
tem um array que ta ficando vaazio(as vezes fica) e eu requisito acesso dele o TSAptosDispProf


*/

public class GerarIndividuo {
    
     // Copia a base de tados para as seguintes variaveis                           
     ArrayList<Professor> TodosProf = new ArrayList<Professor>(LeituraCSV.PROFESSOR);
     ArrayList<Disciplina> TodosDisp = new ArrayList<Disciplina>( LeituraCSV.DISCIPLINA);
     ArrayList<SalaAula> TodosSala = new ArrayList<SalaAula>(LeituraCSV.SALA);
     ArrayList<TimeSlot> TodosTS = new ArrayList<TimeSlot>(LeituraCSV.TIMESLOT);
     ArrayList<Estudante> TodosEstu =new ArrayList<Estudante>( LeituraCSV.ESTUDANTE);
     ArrayList<Curso> TodosCur = new ArrayList<Curso>(LeituraCSV.CURSO);
     ArrayList<Integer> TodosPer =new ArrayList<Integer>();
     
     Random randomGenerator = new Random(); // nao uso
     
//     Professor prof;
//     Disciplina disp;
     ArrayList<Estudante> estu;
     TimeSlot ts;
     
      Molecula molecula = new Molecula(); // OBJETO, representa uma aula, com um prof, uma discipina e uma sala
      AcidoNucleico2 acidos = new AcidoNucleico2(); //HASH MAP Key = int TimeSlot , representa todas as aulas de um determinado período
      Gene gen = new Gene(); // HASH MAP Key = int Periodo, representa todos os períodos de um curso
      Cromossomo2 cro = new Cromossomo2(); // HASH MAP Key = int curso, representa todos os cursos de uma Escola (cromossomo FINAL)
      
    
    public Cromossomo2 Individuo(){
          RandTudo(); // randomiza a base de dados
          RandTudo(); // duas vezes, porque sim
          
          for(int c = 1; c<=3; c++){  // percorrer todos os cursos
          
                int curso = CursoEscolhido();  // retorna um curso aleatório
                TodosPer = preenchePeriodo();  // preenche array de períodos 
                
                for(int p = 1; p<=10; p++ ){  //percorre todos os periodos desse curso
                    
                     ArrayList<TimeSlot> TodosTS = new ArrayList<>(LeituraCSV.TIMESLOT); // copia base de dados de TimeSlot
                      RandTudo(); // randomiza de novo tudo
                        
                        int periodo = PeriodoEscolhido();  // retorna um periodo 
          
                        ArrayList<TimeSlot> ts = TSCurso(curso); // retorna os TS válidos para tal curso
                        
                        //OBS cada molécula é um item do HASHMAP Acido Nucleico, onde a chave é o timeSlot
                        acidos = GerarMoleculaEacidoNucleico(ts, curso, periodo);  //retorna os acidos nucleicos desse periodo de tal curso 
                        GerarGene(acidos,periodo);// adiciona o acido no respectivo periodo(que é a chave do HashMap)
  
                }
                cro.cromossomo.put(curso,gen);// adiciona o gene ao cromossomo, no respectivo curso(que é a chave do HASHMAP)
  
          }
          return cro; // retorna o cromossomo completo, individuo
          
      }
    
    public void GerarGene(AcidoNucleico2 acido, int periodo){
        

        gen.gene.put(periodo,acido); // adiciona o acido nucleico ao gene, periodo é a chave
   
    } 
      
    public AcidoNucleico2 GerarMoleculaEacidoNucleico(ArrayList<TimeSlot> TsAptos, int curso, int periodo){ // gera todas as moléculas(aulas) e o acido nucleico(periodo) onde elas ficaram
        Molecula mol;
        AcidoNucleico2 acido = new AcidoNucleico2();
        
        Disciplina disciplina;
        Professor professor = new Professor();
        SalaAula salaT = new SalaAula();
        SalaAula salaP = new SalaAula();;
        SalaAula salaPE = new SalaAula();;
        ArrayList<Disciplina> disciplinasCursoPerido = new ArrayList<Disciplina>(); //disciplinas de um período
        
        ArrayList<TimeSlot> TSAptosDispProf = new ArrayList<TimeSlot>();  // TS aptos pelo curso,  disciplina e pelo prof
         ArrayList<TimeSlot> remover = new ArrayList<TimeSlot>(); // auxiliar de remoçao
         ArrayList<Professor> ProfApto = new ArrayList<Professor>(); // professores aptos para disciplina
         ArrayList<TimeSlot> TSOcupados = new ArrayList<TimeSlot>(); // TS que estão ocupados durante o periodo
         
         
         
         Collections.shuffle(TodosSala);  // randomiza as salas
         
         //Só existira um tipo de sala por período, cada periodo vai ter suas 3 salas distintas
        for(SalaAula sal : TodosSala){   // percorre sala por sala
            
            if(sal.tipo == 1){
                
                salaT = sal;   // seleciona uma sala do tipo 1, Teorica
                
            }
            if(sal.tipo == 2){  
                
                salaP = sal;  // seleciona uma saa do tipo 2, Prática
            }
            if(sal.tipo == 3){ 
                
                salaPE = sal; // seleciona uma sala do tipo 3, Pratica Especial
            }
            if((salaP.tipo != 0 && salaT.tipo != 0 && salaPE.tipo != 0)){  // se todas as 3 salas foram selecionas, sai do loop
                break;
            
        }
        }
        
        
       for(Disciplina disp : TodosDisp){ // percorre todas as disciplinas
           
           if(disp.codC == curso && disp.codP == periodo){ //compara se a disciplina tem o código do curso e do periodo igual aao curso e periodo passados no parametro
               
               disciplinasCursoPerido.add(disp); // se achar a disciplina, adiciona nessa liasta de disciplinas
               
                }
           }
           Collections.shuffle(disciplinasCursoPerido); // randomiza esse array de disciplinas 
           
           while(disciplinasCursoPerido.size() != 0){  // percorre todas as disciplinas desse curdo deste periodo
               
               disciplina = disciplinasCursoPerido.get(0); // pega a disciplina
               ArrayList<TimeSlot> TSAptosDisp = new ArrayList<TimeSlot>(TsAptos); // array de horarios
               
            //Set<Integer> keyset = acidos.acidoNucleico.keySet();
               
             
//               
               TSAptosDisp.removeAll(TSOcupados);  // caso tenha TS ocupado dentro do array de TS aptos para a disciplina, remove todos
               
               if(disciplina.horariosAptos.size() == 0){  //verifica se a disciplina tem restrição de horário
                    //se nao tem, todos TS sao aptos paa tal disciplina
                   
               }
               else{ // se tem
                   
          

                   for (TimeSlot tis : TsAptos) { // percorre todos os TS aptos para tal curso
                       
                           if(disciplina.horariosAptos.contains(tis.cod)){ // se conter dentro dos horários que a disciplina deve ser ministrada
                                                                           // o mesmo TS
                               remover.add(tis);  // adiciona na "remover" os TS (remover nesse caso nao faz o papel de remoção)                              
                           }
                           
                           
                       }
                   
                      if(!remover.isEmpty()){ //se remover não está vazia
                        TSAptosDisp.retainAll(remover);  // intersecção dos aptos para disciplina com o spresentes em remover, para manter somente
                      }                                  //mater somente os TS que a disciplina pode ser ministrada
                    
                    remover.clear(); //limpa a "remover"
                   
               }
               
               for( Professor prof : TodosProf){  // percorre todos os prof
                   int i = 0;
                   
                   while(i<= prof.dispMi.size()-1){  // enqunato i menor que o taanho do array disciplinas que o prof pode ministrr
                       
                       if(prof.dispMi.get(i) == disciplina.getCodD()){ // se a disciplina que o prof pode ministras for igual a
                                                                        // disciplina já escolhina
                           ProfApto.add(prof);  // adiciona na tabela de profs ue podem ministrar tal disciplina
                          
                       }
                       i++; // vai para a prof disciplina ministrada por tal prof
                       
                   }
                    
                   //if(professor.cod != 0){ 
                       break;

                  // }
                   
               }
               TSAptosDispProf = TSAptosDisp; // lista de TS de horarios aptos final recebe as aptas
               
               if(professor.horariosNAOaptos.size() == 0){// se horários NÃO disaponivis do professor nao existir
                   
                   TSAptosDispProf = TSAptosDisp; // lista de TS aptos continua a mesma
                   
                   
               }
               else{ // se existir
               
                    for(TimeSlot ts : TSAptosDisp){  // percorrer todos os TS Aptos
                   
                        if(professor.horariosNAOaptos.contains(ts.cod)){  // olha nos horaris do prof se contem tal TS
                            //TSAptosDisp.remove(ts);
                             remover.add(ts);// se sim remover coloca esse TS
  
                         }    
                    }
                    
               
                    for(int j =0 ; j<=remover.size()-1;j++){  // percorre toda a remove
                        TSAptosDispProf.remove(remover.get(j));  // usa remover para retirar do s Aptos todos que tem em remover
                    }
                    remover.clear(); // limpa remover
                    
               }
               
               Collections.shuffle(TSAptosDispProf); // embaralha a lsita final de TS disponiveis para aquela disciplina
               Collections.shuffle(ProfApto); // embaralha a lista de prof aptos de ministrar tal disp.
               
               
               if(TSAptosDispProf.size() > (disciplina.cargaH_P + disciplina.cargaH_T)){ // quantidade de TS disponiveis ao final, é maior que o número de Horas de aula dessa disciplina?
                   
                   int i = 0;
                   Collections.shuffle(TSAptosDispProf); //embaralha de novo
                   
                   for(int h_p = 1; h_p <= disciplina.cargaH_P; h_p++){  // para todos os horário de aula Pratica dess disciplina
                       
                       if(salaP.tipo == disciplina.tipoS_P){ // se a sala pratica for rnormal
                           
                           if(TSAptosDispProf.size() ==  0 || ProfApto.size() == 0){   // teste de debug, cai aqu ou não, não era pra entrar aqui
                           System.out.println("1) i > TTSAptosDispProf.size"+i+"<-i"+"Disp:"+disciplina.codD);
                       }
                       
                       mol = new Molecula(TSAptosDispProf.get(0), ProfApto.get(0), disciplina, salaP, null); //cia a molécula passando,Prof, disp, TS, e sala, falta alunos
                       acido.acidoNucleico.put(TSAptosDispProf.get(0).cod, mol);// adiciona no ácido nucleioco essa molécula, passando o TS de key
                       
                       ProfApto.get(0).horariosNAOaptos.add(TSAptosDispProf.get(0).cod); // adiciona esse horário como Não Apto para esse prof
                       
                       
                       TSOcupados.add(TSAptosDispProf.get(0));  // adiciona esse TS ao sslots ocupados 
                       TodosSala.remove(salaP); // remove a sala de uso, para no proximo periodo não ter mais ela
  
                       }
                       
                       if(salaPE.tipo == disciplina.tipoS_P){ // se a sala for pratica especial
                           
                            if(TSAptosDispProf.size() ==  0 || ProfApto.size() == 0){// teste de debug, cai aqu ou não, não era pra entrar aqui
                           System.out.println("2) i > TTSAptosDispProf.size"+i+"<-i"+"Disp:"+disciplina.codD);
                       }
                       
                       mol = new Molecula(TSAptosDispProf.get(0), ProfApto.get(0), disciplina, salaPE, null); //cia a molécula passando,Prof, disp, TS, e sala, falta alunos
                       acido.acidoNucleico.put(TSAptosDispProf.get(0).cod, mol);// adiciona no ácido nucleioco essa molécula, passando o TS de key
                       
                       ProfApto.get(0).horariosNAOaptos.add(TSAptosDispProf.get(0).cod);// adiciona esse horário como Não Apto para esse prof
                       
                       TSOcupados.add(TSAptosDispProf.get(0));// adiciona esse TS ao sslots ocupados 

                        TodosSala.remove(salaPE); // remove a sala de uso, para no proximo periodo não ter mais ela
                       }
                      
                       i++;
                   }
                   
                   Collections.shuffle(TSAptosDispProf);
                   
                   int j = 0;
                   for(int h_t = 1; h_t <= disciplina.cargaH_T; h_t++){ // para todos os horário de aula Teoricax dess disciplina
                       Collections.shuffle(TSAptosDispProf);
                      
                       //FAZ MESMA COISAQUE OS OUTROS LA ENCIMA
                       
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
                   
                   //apos finalizar todas as moléculas, colocou todas as aulas da disciplina escolhida
                   
                   disciplinasCursoPerido.remove(disciplina); // remove da lista de disp do período essa disciplina, 
                   TSAptosDispProf.clear(); // limpa prof aptos
                   TodosDisp.remove(disciplina); // remove disciplina de geral (acho que ta errado essa remoção
               }
               else{  // se quantidade de horários aptos for menor que o numero de horas disciplina não será ministrada
                   disciplinasCursoPerido.remove(disciplina); // remove a disciplina
                   TodosDisp.remove(disciplina);
                   TSAptosDispProf.clear(); // limpa profs
                   System.out.println("ERRO, TS insuficiente para Disciplina!"); // pirnta pra saber
               }
 
           }
           ProfApto = new ArrayList<Professor>();
           disciplina = new Disciplina();
           
           return acido; // retorna o acido para Gene receber
   
    }
    
    public ArrayList<TimeSlot> TSCurso(int curso){  // método padrão para retorna slots de cada curso
        
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
        
    public int CursoEscolhido(){ // retorna curso

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
      
    public int PeriodoEscolhido(){ // retorna periodo

        Collections.shuffle(TodosPer);
       int per  = TodosPer.get(0);
           TodosPer.remove(0);
            return per;

}
    
    public ArrayList<Integer> preenchePeriodo(){ // preenche array de periodo
        
        ArrayList<Integer> periodo = new ArrayList<Integer>();
        
        for(int i=1 ; i<=10; i++){
            
            periodo.add(i);
        }
        return periodo;
    }
    
    public void RandTudo(){ // embaralha tudo
        
        Collections.shuffle(TodosProf);
        Collections.shuffle(TodosCur);
        Collections.shuffle(TodosDisp);
        Collections.shuffle(TodosEstu);
        Collections.shuffle(TodosSala);
        Collections.shuffle(TodosTS);
        Collections.shuffle(LeituraCSV.CURSO);
        
    
    }
    
    
    
    
}
