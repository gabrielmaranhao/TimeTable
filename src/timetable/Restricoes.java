/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 * @author Danillo, Marcos, Gabriel M., Gabriel O.
 */
public class Restricoes {
    
    //restricao tipo = 1  restricao de professor
    //restricao tipo = 2  restricao de disciplina
    int restricaoTipo;
    
    //codigo do professor e um array que indica quais timeslots o prof estará INDISPONIVEL
    int codigoProf;
    int slotsIndisp[] = new int[20];
    
    //codigo da disciplina e um array que indica em quais os timeslots a disciplina DEVE ser ministrada
    int codigoDisc;
    int slotsObrig[] = new int[30];

    public Restricoes(int restricaoTipo, int codigo, int[] array) {
        //ao criar um objeto do tipo Restrições se deve indicar se é uma restrição de professor ou de disciplina
        //utilizando o flag "restricaoTipo" que pode ser 1 ou 2
        this.restricaoTipo = restricaoTipo;
        if(restricaoTipo==1){
            this.codigoProf = codigo;
            this.slotsIndisp = array;
        }
        else if(restricaoTipo==2){
            this.codigoDisc = codigo;
            this.slotsObrig = array;
        }else{
            System.out.println("CODIGO DEVE SER 1 OU 2");
        }
     
    }
    
    
    
}
