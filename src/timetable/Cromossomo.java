package timetable;

import java.util.ArrayList;
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
public class Cromossomo {

    //nesta classe criamos um indivíduo para aplicar função de fitness.

    public Cromossomo() {
    }
    //
    Random randomGenerator = new Random();

    public void GerarIndividuo() {

        ArrayList<Integer> slots = new ArrayList<Integer>();
        
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
    
    //metodo para gerar uma lista de disciplinas randomicamente
//    public ArrayList<Disciplina> GerarDisciplinaRandom(ArrayList<Disciplina> lista){
//        ArrayList<Disciplina> 
//        
//    }    //metodo para gerar uma lista de disciplinas randomicamente
//    public ArrayList<Disciplina> GerarDisciplinaRandom(ArrayList<Disciplina> lista){
//        ArrayList<Disciplina> 

    
    //metodo teste para printar a lista randomica
    public void printaLista(ArrayList<Integer> slots){
        int j = 0;
        for(Integer i : slots){
            System.out.println("indice "+j+":"+slots.get(j));
            j++;
        }
    }

}
