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
import org.apache.poi.ss.util.*;

public class ExelViewer {  
    
    
        public static void HorariosGeral() throws Exception{
                
//                /* Step -1 : Read input CSV file in Java */
//                String inputCSVFile = "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\ag-horarios.csv";
//                CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
//                /* Variables to loop through the CSV File */
//                String [] nextLine; /* for every line in the file */            
//                int lnNum = 0; /* line number */
//                /* Step -2 : Define POI Spreadsheet objects */          
//                XSSFWorkbook  new_workbook = new XSSFWorkbook (); //create a blank workbook object
//                XSSFSheet sheet = new_workbook.createSheet("CSV_to_XLSX");  //create a worksheet with caption score_details
//                /* Step -3: Define logical Map to consume CSV file data into excel */
//                Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
//                /* Step -4: Populate data into logical Map */
//                
//                
//                while ((nextLine = reader.readNext()) != null) {
//                    
//                    
//                        lnNum++; 
//                        
//                        if(nextLine[0].equals("//")){
//                            
//                            
//                        }
//                        else if(nextLine[0].equals("// Arquivo de Saída: Horário de aulas")){
//                            
//                        }
//                        else if(nextLine[0].equals("//Disciplina/Time-Slot/Professor/Sala")){
//                        }
//                        else{
//                        
//                        
//                        
//                        excel_data.put(Integer.toString(lnNum), new Object[] {nextLine[0],nextLine[1],nextLine[2],nextLine[3]}); 
//                        }
//                        
//                        
//                        
//                        
//                }
//                /* Step -5: Create Excel Data from the map using POI */
//                Set<String> keyset = excel_data.keySet();
//                int rownum = 0;
//                for (String key : keyset) { //loop through the data and add them to the cell
//                        Row row = sheet.createRow(rownum++);
//                        Object [] objArr = excel_data.get(key);
//                        int cellnum = 0;
//                        for (Object obj : objArr) {
//                                Cell cell = row.createCell(cellnum++);
//                                if(obj instanceof Double)
//                                        cell.setCellValue((Double)obj);
//                                else
//                                        cell.setCellValue((String)obj);
//                                }
//                }
//                /* Write XLS converted CSV file to the output file */
//                FileOutputStream output_file = new FileOutputStream(new File("CSV_2_XLSX.xlsx")); //create XLSX file
//                new_workbook.write(output_file);//write converted XLSX file to output stream
//                output_file.close(); //close the file
        }
        
        
        public static void HorariosGeral2(ArrayList<Aula> au) throws Exception{
            int linha = 0;
            XSSFWorkbook  new_workbook = new XSSFWorkbook (); //create a blank workbook object
            XSSFSheet sheet = new_workbook.createSheet("CSV_to_XLSX");  //create a worksheet with caption score_details
            /* Step -3: Define logical Map to consume CSV file data into excel */
            Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
            
            
            for(Aula aula : au){
                
                        excel_data.put(Integer.toString(linha), new Object[] 
                           {au.get(linha).disp.getCodD(),
                            au.get(linha).timeSlot.getCod(),
                            au.get(linha).prof.getCod(),
                            au.get(linha).sala.getCod()}); 
            
                linha++;
            
            }
            linha = 0;
            
            int rownum = 0;
            Row row = sheet.createRow(0);
            Object [] objArr = null;
            int cellnum = 0;
            Cell cell = null;
            CellStyle cellStyle = new_workbook.createCellStyle();
            CellStyle style = new_workbook.createCellStyle();
            Font font = new_workbook.createFont();
            
            for(int i=0;i<1000;i++){
            row = sheet.createRow(i);
            }
            
            for(int i=0;i<1000;i++){
            cell = row.getCell(i);
            }
            
            

            sheet.addMergedRegion(new CellRangeAddress(
            0, //first row (0-based)
            0, //last row  (0-based)
            2, //first column (0-based)
            4  //last column  (0-based)
            ));
            
            row = sheet.createRow(0);
            createCell(new_workbook,row,(short)2,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Engenharia de Computação",cellStyle);
            row = sheet.createRow(1);
            
            createCell(new_workbook,row,(short)1,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Segunda",cellStyle);
            createCell(new_workbook,row,(short)2,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Terça",cellStyle);
            createCell(new_workbook,row,(short)3,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quarta",cellStyle);
            createCell(new_workbook,row,(short)4,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quinta",cellStyle);
            createCell(new_workbook,row,(short)5,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sexta",cellStyle);
            createCell(new_workbook,row,(short)6,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sábado",cellStyle);
            //
                    
 
            rownum = 2;
            int j=0;
            
            for(timetable.TimeSlot ts : timetable.LeituraCSV.TIMESLOT){
                
                
                int num = timetable.LeituraCSV.TIMESLOT.get(j).getCod();
                
                if(((num >= 32 && num <= 36) || (num >= 38 && num <= 46)) && timetable.LeituraCSV.TIMESLOT.get(j).getDia() == 2){
                    
                    
                        row = sheet.createRow(rownum);    
                        createCell(new_workbook,row,(short)0,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,
                        timetable.LeituraCSV.TIMESLOT.get(j).getHoraInicio() +"-"+ timetable.LeituraCSV.TIMESLOT.get(j).getHoraFinal(),cellStyle);
                        rownum++;
                }
                
                j++;
                
            }
            sheet.autoSizeColumn((short) 0);
            
            int x=1;
            int y =0;
            for(int periodo = 1; periodo<=12; periodo++){
                 
            PeriodoCell(row,x , sheet, cell,y, font, style, new_workbook, periodo);
                 x = x+16;
                 
            }
                           
           
            
           
            
            /* Step -5: Create Excel Data from the map using POI */
//                Set<String> keyset = excel_data.keySet();
//                rownum = 2;
//                for (String key : keyset) { //loop through the data and add them to the cell
//                        row = sheet.createRow(rownum++);
//                        objArr = excel_data.get(key);
//                        cellnum = 1;
//                        for (Object obj : objArr) {
//                                cell = row.createCell(cellnum++);
//                                if(obj instanceof Double)
//                                        cell.setCellValue((Double)obj);
//                                else
//                                        cell.setCellValue((int)obj);
//                                }
//                }
                /* Write XLS converted CSV file to the output file */
                FileOutputStream output_file = new FileOutputStream(new File("CSV_2_XLSX.xlsx")); //create XLSX file
                new_workbook.write(output_file);//write converted XLSX file to output stream
                output_file.close(); //close the file
                
                try {   // abre exel com arquivo
                        Desktop.getDesktop().open(new File("C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\TimeTable\\CSV_2_XLSX.xlsx"));
                } catch (IOException e) {e.printStackTrace();}
                  
        }
        private static void createCell(XSSFWorkbook wb, Row row, short column, short halign, short valign, String value,CellStyle cellStyle) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }
        private static void PeriodoCell(Row row,int rownum,Sheet sheet,Cell cell,int cellNum,Font font,CellStyle style,XSSFWorkbook new_workbook, int periodo){
            
            row = sheet.getRow(rownum);
            cell = row.getCell(cellNum);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(font);                
            createCell(new_workbook,row,(short)0,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER, periodo + "º Período",style);
            
        }
}
