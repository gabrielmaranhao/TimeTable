/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Gabriel
 */
import timetable.*;
        

import java.io.FileOutputStream;
import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; //Write in Office 2007, 2012 format
import org.apache.poi.xssf.usermodel.XSSFSheet; //Write in Office 2007, 2012 format
import org.apache.poi.ss.usermodel.*;
import au.com.bytecode.opencsv.CSVReader;
import java.awt.Desktop;
import java.io.FileReader;
import java.util.*;

public class ExelViewer {  
    
    
        public static void HorariosGeral() throws Exception{
                
                /* Step -1 : Read input CSV file in Java */
                String inputCSVFile = "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-horarios.csv";
                CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
                /* Variables to loop through the CSV File */
                String [] nextLine; /* for every line in the file */            
                int lnNum = 0; /* line number */
                /* Step -2 : Define POI Spreadsheet objects */          
                XSSFWorkbook  new_workbook = new XSSFWorkbook (); //create a blank workbook object
                XSSFSheet sheet = new_workbook.createSheet("CSV_to_XLSX");  //create a worksheet with caption score_details
                /* Step -3: Define logical Map to consume CSV file data into excel */
                Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
                /* Step -4: Populate data into logical Map */
                
                
                while ((nextLine = reader.readNext()) != null) {
                    
                    
                        lnNum++; 
                        
                        if(nextLine[0].equals("//")){
                            
                            
                        }
                        else if(nextLine[0].equals("// Arquivo de Saída: Horário de aulas")){
                            
                        }
                        else if(nextLine[0].equals("//Disciplina/Time-Slot/Professor/Sala")){
                        }
                        else{
                        
                        
                        
                        excel_data.put(Integer.toString(lnNum), new Object[] {nextLine[0],nextLine[1],nextLine[2],nextLine[3]}); 
                        }
                        
                        
                        
                        
                }
                /* Step -5: Create Excel Data from the map using POI */
                Set<String> keyset = excel_data.keySet();
                int rownum = 0;
                for (String key : keyset) { //loop through the data and add them to the cell
                        Row row = sheet.createRow(rownum++);
                        Object [] objArr = excel_data.get(key);
                        int cellnum = 0;
                        for (Object obj : objArr) {
                                Cell cell = row.createCell(cellnum++);
                                if(obj instanceof Double)
                                        cell.setCellValue((Double)obj);
                                else
                                        cell.setCellValue((String)obj);
                                }
                }
                /* Write XLS converted CSV file to the output file */
                FileOutputStream output_file = new FileOutputStream(new File("CSV_2_XLSX.xlsx")); //create XLSX file
                new_workbook.write(output_file);//write converted XLSX file to output stream
                output_file.close(); //close the file
        }
        
        
        public static void HorariosGeral2(ArrayList<Aula> au) throws Exception{
            int linha = 0;
            XSSFWorkbook  new_workbook = new XSSFWorkbook (); //create a blank workbook object
            XSSFSheet sheet = new_workbook.createSheet("CSV_to_XLSX");  //create a worksheet with caption score_details
            /* Step -3: Define logical Map to consume CSV file data into excel */
            Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
            
            
            for(Aula aula : au){
            
            
            
            excel_data.put(Integer.toString(linha), new Object[] 
            {au.get(linha).disp.getCodD(),au.get(linha).timeSlot.getCod(),au.get(linha).prof.getCod(),au.get(linha).sala.getCod()}); 
            
            linha++;
            
            }
            linha = 0;
            
            
            /* Step -5: Create Excel Data from the map using POI */
                Set<String> keyset = excel_data.keySet();
                int rownum = 0;
                for (String key : keyset) { //loop through the data and add them to the cell
                        Row row = sheet.createRow(rownum++);
                        Object [] objArr = excel_data.get(key);
                        int cellnum = 0;
                        for (Object obj : objArr) {
                                Cell cell = row.createCell(cellnum++);
                                if(obj instanceof Double)
                                        cell.setCellValue((Double)obj);
                                else
                                        cell.setCellValue((int)obj);
                                }
                }
                /* Write XLS converted CSV file to the output file */
                FileOutputStream output_file = new FileOutputStream(new File("CSV_2_XLSX.xlsx")); //create XLSX file
                new_workbook.write(output_file);//write converted XLSX file to output stream
                output_file.close(); //close the file
                
                try {   // abre exel com arquivo
                        Desktop.getDesktop().open(new File("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\CSV_2_XLSX.xlsx"));
                } catch (IOException e) {e.printStackTrace();}
                
            
            
            
        }
}
