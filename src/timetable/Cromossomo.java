package timetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danillo, Marcos, Gabriel M., Gabriel O.
 */
public class Cromossomo{

    //nesta classe criamos um indivíduo para aplicar função de fitness.
    
    //variaveis ----
    ArrayList<Disciplina> disciplinas;
    ArrayList<Estudante> estudantes;
    ArrayList<Professor> professores;
    ArrayList<SalaAula> salaaulas;
    ArrayList<Restricoes> restricoes;
    ArrayList<TimeSlot> timeslots;
    ArrayList<ArrayList<AcidoNucleico>> cromossomo = new ArrayList<ArrayList<AcidoNucleico>>();
    ArrayList<AcidoNucleico> inner = new ArrayList<AcidoNucleico>();
    AcidoNucleico aux = new AcidoNucleico();
    ArrayList<AcidoNucleico> slotaux = new ArrayList<AcidoNucleico>();
    
    Random randomGenerator = new Random();
    ArrayList<String> output;
    
    ArrayList<Integer> todosTS = new ArrayList<Integer>();

    
    public Cromossomo(ArrayList<Disciplina> disciplinas, ArrayList<Estudante> estudantes, ArrayList<TimeSlot> timeslots,
                        ArrayList<Professor> professores, ArrayList<SalaAula> salaaulas, ArrayList<Restricoes> restricoes) {
        
        this.disciplinas = disciplinas;
        this.estudantes = estudantes;
        this.professores = professores;
        this.salaaulas = salaaulas;
        this.restricoes = restricoes;
        this.timeslots = timeslots;
        
        //popular lista
        for(int i = 0; i <75; i++){
            for(int j = 0 ; j < salaaulas.size(); j++){
                aux.setUsado(false);
                aux.setSala(salaaulas.get(j));
                aux.setTimeslot(timeslots.get(i));
                inner.add(aux);
                aux = new AcidoNucleico();
            }
            cromossomo.add(inner);
            inner = new ArrayList<AcidoNucleico>();
        }
        
        for(int x = 0; x < 168; x++){
            todosTS.add(x + 1);
        }
        
    }
    
   
    
    public void GerarIndividuo() {
        
        int cont=0;
        Disciplina disc;
        ArrayList<TimeSlot> var;
        ArrayList<Integer> timeslotDisp;
        ArrayList<Integer> profList;
        ArrayList<Integer> profTSIndis;
        ArrayList<Integer> profTSDis;
        int prof;
        boolean profSel = false;
        int indexProf = 0;
        
        //randomizar as disciplinas
        Collections.shuffle(disciplinas);
        while(true){
            int curso;
            int periodo;
            int codD;
            
           
            
            disc = disciplinas.get(cont);
            codD = disc.codD;
            curso = disc.codC;
            periodo = disc.codP;
            //Gera horaris disponiveis para o curso
            ArrayList<Integer> timeslot = GerarSlotsCurso(disc.codC);
            //Se existir restricoes na disciplina elas serao retornadas 
            timeslotDisp = GerarRestDisc(codD);
            //Interseccao das restricoes com os horarios do curso
            timeslot.retainAll(timeslotDisp);
            //Retorna uma lista randomica de professores que podem dar a disciplina
            profList = GerarProfRand(codD);
            //selecionar timeslots necessários para a disciplina;
            int h_p, h_t;
            h_p = disc.cargaH_P;
            h_t = disc.cargaH_T;
            
            while(!profSel){
                //Seleciona um professor da lista
                prof = profList.get(indexProf);
                //Busca as restricoes do professor
                profTSIndis = RetRestProf(prof);
                // Copia uma lista com todos os timeslots
                profTSDis = todosTS;
                //Remove da lista com todos timeslots os indisponiveis devido as restricoes
                profTSDis.removeAll(profTSIndis);
                //Copia os timeslots disponiveis da disciplina
                timeslotDisp = timeslot;
                //Faz inteseccao dos horarios disponiveis do professor com o da materia
                timeslotDisp.retainAll(profTSDis);
                //Verifica se os timeslots disponiveis eh suficiente para a materia
                if(timeslotDisp.size() >= (h_p + h_t)){
                //caso seja, o professor em questão é selecionado
                //incrementa o contador
                    profSel=true;
                    indexProf++;
                }
            }

            //Verifica se a disciplina tem aulas praticas
            if(h_p!=0){
                  //Verifica se o timeslot sorteado esta livre para ser utilizado
                  for(Integer islot : timeslotDisp){ 
                    //Timeslot deve ser disponivel tanto para a disciplina quanto para o professor
                      slotaux = this.cromossomo.get(islot);
                      for (AcidoNucleico an : slotaux){
                          if(an.sala.tipo == disc.tipoS_P && an.usado == false){
                              an.disc = disc;
                              an.usado = true;
                              
                          }
                      }
                  
                }
            }
            if(h_t != 0){
                
            }
            
            
        
        }
        
    }
    //TIMESLOTS DISPONÍVEIS 
    // 32 ao 36 e 38 ao 46 (segunda das 7:00 às 12:00, 13:00 às 22:00);
    // 56 ao 60 e 62 ao 70 (terça)
    // 80 ao 84 e 86 ao 94 (quarta)
    // 104 ao 108 e 110 ao 118 (quinta)
    // 128 ao 132 e 134 ao 142 (sexta)
    // 152 ao 156 (sabado)
    public ArrayList<Integer> GerarSlotsRandom() {
        ArrayList<Integer> slots = new ArrayList<Integer>();
        boolean flag = false;
        //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
            while(slots.size()<75){
                int num = randomGenerator.nextInt(170)+1; //+1 pois começa do 0
                //"range" de numeros disponíveis
                if ((num >= 32 && num <= 36) || (num >= 38 && num <= 46)
                        || (num >= 56 && num <= 60) || (num >= 62 && num <= 70)
                        || (num >= 80 && num <= 84) || (num >= 86 && num <= 94)
                        || (num >= 104 && num <= 108) || (num >= 110 && num <= 118)
                        || (num >= 128 && num <= 132) || (num >= 134 && num <= 142)
                        || (num >= 152 && num <= 156))
                {
                    //verificando se não há números repetidos na lista
                    if(slots.isEmpty()){
                        slots.add(num);
                    }else{
                        for(Integer i : slots){
                            if(i == num){
                                flag = true;
                            }
                        }
                        if(!flag){
                            slots.add(num); 
                        }
                        flag = false; //reseta o flag
                    }
            } 
            }
        //retorna uma lista de ordem randômica com o número do timeslot que será usado para criar o cromossomo.
        printaLista(slots);
        return slots;
    }
    
    public ArrayList<Integer> GerarSlotsCurso(int curso) {
        
        if(curso == 1){
            //Para engenharia da computacao: Slots disponiveis
            //32 ao 36, 43 ao 46, 56 ao  60, 67 ao 70, 80 ao 84, 91 ao 94, 
            //104 ao 108, 115 ao 118, 128 ao 132, 139 ao 142, 152 ao 156
            ArrayList<Integer> slots = new ArrayList<Integer>();
            boolean flag = false;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
            while(slots.size()<50){
                int num = randomGenerator.nextInt(170)+1; //+1 pois começa do 0
                //"range" de numeros disponíveis
                if ((num >= 32 && num <= 36) || (num >= 43 && num <= 46)
                        || (num >= 56 && num <= 60) || (num >= 67 && num <= 70)
                        || (num >= 80 && num <= 84) || (num >= 91 && num <= 94)
                        || (num >= 104 && num <= 108) || (num >= 115 && num <= 118)
                        || (num >= 128 && num <= 132) || (num >= 139 && num <= 142)
                        || (num >= 152 && num <= 156))
                {
                    //verificando se não há números repetidos na lista
                    if(slots.isEmpty()){
                        slots.add(num);
                    }else{
                        for(Integer i : slots){
                            if(i == num){
                                flag = true;
                            }
                        }
                        if(!flag){
                            slots.add(num); 
                        }
                        flag = false; //reseta o flag
                    }
            } 
            }
        //retorna uma lista de ordem randômica com o número do timeslot que será usado para criar o cromossomo.
        printaLista(slots);
        return slots;
        }
        else if(curso == 2){
            //Engenharia Eletrica : Todos os timeslots possiveis
            ArrayList<Integer> slots = new ArrayList<Integer>();
            boolean flag = false;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
                while(slots.size()<75){
                    int num = randomGenerator.nextInt(170)+1; //+1 pois começa do 0
                    //"range" de numeros disponíveis
                    if ((num >= 32 && num <= 36) || (num >= 38 && num <= 46)
                            || (num >= 56 && num <= 60) || (num >= 62 && num <= 70)
                            || (num >= 80 && num <= 84) || (num >= 86 && num <= 94)
                            || (num >= 104 && num <= 108) || (num >= 110 && num <= 118)
                            || (num >= 128 && num <= 132) || (num >= 134 && num <= 142)
                            || (num >= 152 && num <= 156))
                    {
                        //verificando se não há números repetidos na lista
                        if(slots.isEmpty()){
                            slots.add(num);
                        }else{
                            for(Integer i : slots){
                                if(i == num){
                                    flag = true;
                                }
                            }
                            if(!flag){
                                slots.add(num); 
                            }
                            flag = false; //reseta o flag
                        }
                } 
                }
            //retorna uma lista de ordem randômica com o número do timeslot que será usado para criar o cromossomo.
            printaLista(slots);
            return slots;
        }
        else{
            //Engenharia Mecanica: Timeslots disponiveis 
            //32 ao 36, 38 ao 42, 56 ao 60, 62 ao 66, 80 ao 84, 86 ao 90,104 ao
            //108, 110 ao 114, 128 ao 132, 134 ao 138, 152 ao 156
            ArrayList<Integer> slots = new ArrayList<Integer>();
            boolean flag = false;
            //o ArrayList slots deve ter exatamente 75 posições, pois é o numero de timeslots válidos
            while(slots.size()<55){
                    int num = randomGenerator.nextInt(170)+1; //+1 pois começa do 0
                    //"range" de numeros disponíveis
                    if ((num >= 32 && num <= 36) || (num >= 38 && num <= 42)
                            || (num >= 56 && num <= 60) || (num >= 62 && num <= 66)
                            || (num >= 80 && num <= 84) || (num >= 86 && num <= 90)
                            || (num >= 104 && num <= 108) || (num >= 110 && num <= 114)
                            || (num >= 128 && num <= 132) || (num >= 134 && num <= 138)
                            || (num >= 152 && num <= 156))
                    {
                        //verificando se não há números repetidos na lista
                        if(slots.isEmpty()){
                            slots.add(num);
                        }else{
                            for(Integer i : slots){
                                if(i == num){
                                    flag = true;
                                }
                            }
                            if(!flag){
                                slots.add(num); 
                            }
                            flag = false; //reseta o flag
                        }
                } 
                }
            //retorna uma lista de ordem randômica com o número do timeslot que será usado para criar o cromossomo.
            printaLista(slots);
            return slots;
        }
    }
    
    
    /**
     * Esta metodo retorna uma lista de professores aptos a ministrar a disciplina
     * disc, que eh o parametro de entrada.
     * @param disc
     * @return 
     */ 
    public ArrayList<Professor> GerarProf(int disc){
        ArrayList<Professor> profs = new ArrayList<Professor>();
        for(Professor aux: professores){
            for(int i : aux.dispM){
                if(i == disc){
                    profs.add(aux);
                }
            }
        }
        return profs;
    }
    
    public ArrayList<Integer> GerarRestDisc(int disc){
                //armazena os slots nos quais a disciplina pode ser dada, caso houver restrição.
            int slotsObrig[] = new int[30];
            
            ArrayList<Integer> aux = new ArrayList<Integer>();
            
            //criar uma lista que associa o periodo e o curso
            //essa disciplina possui restrição? 
            for( Restricoes r : restricoes){
                if(r.restricaoTipo == 2){ //restricao para disciplina
                    if(disc == r.codigoDisc){
                        slotsObrig = r.slotsObrig;
                    }
                }
            }
            
            for(int i : slotsObrig){
                aux.add(i);
            }
            
            return aux;
    }
    
    
    
    public void TimeslotProfDisc (ArrayList<Integer> timeslot, ArrayList<Professor> profs){
        ArrayList<Restricoes> aux = new ArrayList<Restricoes>();
        ArrayList<Professor> profAux = new ArrayList<Professor>();
        int pcod;
        boolean deuRuim = false;
        
        for(Restricoes r: restricoes){
            if (r.restricaoTipo == 1)
                aux.add(r);
        }
        
        for(int i: timeslot){
            for(Professor p: profs){
                for(Restricoes rr: aux){
                    if(p.cod == rr.codigoProf){
                        for(int kappa: rr.slotsIndisp){
                            if(kappa == i){
                                deuRuim = true;
                            }
                        }
                        if(deuRuim == false){
                            profAux.add(p);
                            deuRuim = false;
                        }    
                    }else{
                        profAux.add(p);
                    }
                }
            }
        }
    } 
    
    /**
     * Essa funcao retorna um professor aleatorio que ministra a disciplina 
     * introduzida na entrada
     * @param disc
     * @return 
     */
    public ArrayList<Integer> GerarProfRand(int disc){
    
        ArrayList<Professor> funcLisProf = professores;
        
        ArrayList<Integer> retProf = new ArrayList<>();
        
        Collections.shuffle(funcLisProf);
        
        professores.forEach((prof) -> {
            int [] dispM = prof.getDispM();
            for(int codDisc: dispM){
                if(codDisc == disc){
                    retProf.add(prof.getCod());
                }
            }
        });
        return retProf;
    }
    
    /**
     * Retorna as restricoes do professor. Horarios indisponiveis para ministrar
     * aulas.
     * @param codPro
     * @return 
     */
    public ArrayList<Integer> RetRestProf(int codPro){
        for(Restricoes profRes : restricoes){
            if(profRes.restricaoTipo == 1 && profRes.codigoProf == codPro){
                return profRes.getSlotsIndisp();
            }
        }
        ArrayList<Integer> empty = new ArrayList<Integer>();
        return empty;
    }
    
    //metodo teste para printar a lista randomica
    public void printaLista(ArrayList<Integer> slots){
        int j = 0;
        for(Integer i : slots){
            System.out.println("indice "+j+":"+slots.get(j));
            j++;
        }
    }

}
