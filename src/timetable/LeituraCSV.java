package timetable;

/**
 *
 * @author Gabriel
 * tetse gabriel maranhao
 * teste 2
 */
 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LeituraCSV {

        static String userhome = System.getProperty("user.home"); 
        
        String csvResFile = userhome+"\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-restricoes.csv";
        String csvFile = userhome+"\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-informacoes.csv";
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int flag;
        
        
         public static ArrayList<TimeSlot> TIMESLOT = new ArrayList<TimeSlot>();
         
         public static ArrayList<Curso> CURSO = new ArrayList<Curso>();
         
         public static ArrayList<SalaAula> SALA = new ArrayList<SalaAula>();
         
         public static ArrayList<Disciplina> DISCIPLINA = new ArrayList<Disciplina>();
         
         public static ArrayList<Estudante> ESTUDANTE = new ArrayList<Estudante>();
         
         public static ArrayList<Professor> PROFESSOR = new ArrayList<Professor>();
         
         //arraylist para armazenar as restrições
         
         ArrayList<Restricoes> RESTRICAOPROF = new ArrayList<Restricoes>();
         
         ArrayList<Restricoes> RESTRICAODISC = new ArrayList<Restricoes>();
               
        
public void LerInfos(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                   
                // use comma as separator
                //String[] country = line.split(cvsSplitBy);
                
                //Ignora as linhas vazias
                if(line.trim().isEmpty()){}
                else{
                
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
            }
            
            //retorna padrões de leitura
             line = "";
             br = null;
             flag = 0;


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

public void LerRes(){
     try {

            br = new BufferedReader(new FileReader(csvResFile));
            while ((line = br.readLine()) != null) {
              
                //Ignora as linhas vazias
                if(line.trim().isEmpty()){}
                else{
                
                if(line.substring(0,2).equals("//")){
                    flag = -1;
                }
                
                if(line.equals("DISCIPLINA")){
                    flag = 1;
                    line = br.readLine();
                    //line = br.readLine();
                }
                else if(flag==1){
                    LerResDISCIPLINA();
                }
                
                if(line.equals("PROFESSOR")){
                    flag = 2;
                    line = br.readLine();
                    line = br.readLine();
                }
                else if(flag==2){
                    LerResPROFESSOR();
                }
                
                   
              
                
                
                }
            }
            
            //retorna padrões de leitura
             line = "";
             br = null;
             flag = 0;

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
    
    private void LerResDISCIPLINA() {
        //lê as restrições para Disciplinas
        Restricoes restr;
        int[] aux1 = new int[30];
        String[] aux = line.split(cvsSplitBy);
        //após adicionar cada valor separado por virgula em um array, adiciona somente a partir do segundo no array aux1
        //que representa as restrições
        for(int i=1; i<aux.length;i++){
            aux1[i-1] = Integer.parseInt(aux[i]);
        }
        // 2 = CODIGO PARA RESTRIÇÃO DE DISCIPLINA, AUX[0] É O CODIGO DA DISCIPLINA, AUX1 ARRAY COM OS TIMESLOTS RESERVADOS
        restr = new Restricoes(2, Integer.parseInt(aux[0]), aux1);
        RESTRICAODISC.add(restr);
    }

    private void LerResPROFESSOR() {
        //lê as restrições para professores
        Restricoes restr;
        int[] aux1 = new int[30];
        String[] aux = line.split(cvsSplitBy);
        //mesmo processo utilizado em LerResDisciplina()
        for(int i=1; i<aux.length;i++){
            aux1[i-1] = Integer.parseInt(aux[i]);
        }
        // 1 = CODIGO PARA RESTRIÇÃO DE PROFESSOR, AUX[0] É O CODIGO DO PROF, AUX1 ARRAY COM OS TIMESLOTS INDISPONIVEIS
        restr = new Restricoes(1, Integer.parseInt(aux[0]), aux1);
        RESTRICAOPROF.add(restr);
    }
    
    public void Escrever(){
    //metodo teste
        
        int i = 0;
        int j = 0;
        int k = 0;
    
        for( TimeSlot ts : TIMESLOT){
            
            System.out.println("Gravou: "+TIMESLOT.get(i).cod+","+TIMESLOT.get(i).dia+","+TIMESLOT.get(i).horaInicio+","+TIMESLOT.get(i).horaFinal);
            i++;
        }
        
        
        //(int i = 0;i < (CURSO.size()+SALA.size()+DISCIPLINA.size()+ESTUDANTE.size()+PROFESSOR.size());i++){
            
           // System.out.println("");
            
        //}
        
     //printar as restrições
     //Arrays.toString() ---> metodo que printa todos os elementos de uma array
        for(Restricoes res : RESTRICAODISC){
            int p = res.slotsObrig.length;
            System.out.println("RestrDisc: "+RESTRICAODISC.get(j).codigoDisc+", "+Arrays.toString(RESTRICAODISC.get(j).slotsObrig));
            j++;
        }
        for(Restricoes res : RESTRICAOPROF){
            System.out.println("RestrProf: "+RESTRICAOPROF.get(k).codigoProf+", "+Arrays.toString(RESTRICAOPROF.get(k).slotsIndisp));
            k++;
        }
        
        
    }
 
}