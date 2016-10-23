
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
    
    static WorkSheet ws;
    static String userhome = System.getProperty("user.home");
        
        
        
        public static WorkSheet HorariosGeral() throws Exception{
            
            XSSFWorkbook new_workbook = new XSSFWorkbook (); //create a blank workbook object
            XSSFSheet sheet = new_workbook.createSheet("TabelaHorários");  //create a worksheet with caption score_details
            /* Step -3: Define logical Map to consume CSV file data into excel */
            WorkSheet ws = new WorkSheet(new_workbook, sheet);
                   
            
            int rownum = 0;
            Row row = ws.sheet.createRow(0);
            Object [] objArr = null;
            int cellnum = 0;
            Cell cell = row.getCell(0);
            CellStyle cellStyle = ws.new_workbook.createCellStyle();
            CellStyle style = ws.new_workbook.createCellStyle();
            CellStyle stylee = ws.new_workbook.createCellStyle();
            Font font = ws.new_workbook.createFont();
            
            
            
            
            
            for(int i=0;i<200;i++){
                    row = ws.sheet.createRow(i);
                       for(int j=0;j<30;j++){
                            cell = row.getCell(j);
                            }
                    }
            int z=0;
           for(int curso =0; curso<3;curso++){
               
               
           if(curso == 0){
                    
            ws.sheet.addMergedRegion(new CellRangeAddress(
            0, //first row (0-based)
            0, //last row  (0-based)
            2, //first column (0-based)
            4  //last column  (0-based)
            ));
            
            row = ws.sheet.createRow(0);
            createCell1(ws.new_workbook,row,(short)2,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Engenharia de Computação",stylee);
        
            int x=0;
            int y =0;
            
          
            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());
            
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            
            for(int periodo = 1; periodo<=12; periodo++){
                
                row = ws.sheet.createRow(x+1);
                createCell1(ws.new_workbook,row,(short)1,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Segunda",cellStyle);
                createCell1(ws.new_workbook,row,(short)2,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Terça",cellStyle);
                createCell1(ws.new_workbook,row,(short)3,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quarta",cellStyle);
                createCell1(ws.new_workbook,row,(short)4,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quinta",cellStyle);
                createCell1(ws.new_workbook,row,(short)5,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sexta",cellStyle);
                createCell1(ws.new_workbook,row,(short)6,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sábado",cellStyle);
                    
                TimeSlotsCell(row, ws.sheet,cell, x+2, ws.new_workbook, cellStyle,z);
                PeriodoCell(row,x+1 , ws.sheet, cell,0, font, style, ws.new_workbook, periodo,z);
                x = x+16;
                
                 
            }
            ws.sheet.autoSizeColumn((short) 0);
            
           }
           else{
               z= z+9;
               
               if (curso == 1){
                   
                   ws.sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    2+z, //first column (0-based)
                    4+z  //last column  (0-based)
                    ));
            
                    //row = ws.sheet.createRow(0);
                    createCell2(ws.new_workbook,row,0,ws.sheet,cell,2+z,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Engenharia Elétrica",stylee);                 
                   
               }
               else{
                   
                   ws.sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    2+z, //first column (0-based)
                    4+z  //last column  (0-based)
                    ));
            
                    //row = ws.sheet.createRow(0);
                    createCell2(ws.new_workbook,row,0,ws.sheet,cell,2+z,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Engenharia Mecânica",stylee); 
                   
               }
               
                int x=0;
                int y =0;
                for(int periodo = 1; periodo<=10; periodo++){
                
                //row = ws.sheet.createRow(x+1);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(1+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Segunda",cellStyle);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(2+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Terça",cellStyle);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(3+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quarta",cellStyle);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(4+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Quinta",cellStyle);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(5+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sexta",cellStyle);
                createCell2(ws.new_workbook,row,x+1,ws.sheet,cell,(short)(6+z),CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,"Sábado",cellStyle);
                    
                TimeSlotsCell(row, ws.sheet,cell, x+2, ws.new_workbook, cellStyle,z);
                PeriodoCell(row,x+1, ws.sheet, cell,0+z, font, style, ws.new_workbook, periodo,z);
                x = x+16;
                
                 
            }
    
           }
           ws.sheet.autoSizeColumn((short) 9);
           ws.sheet.autoSizeColumn((short) 18);
               
           }
               
          /* Write XLS converted CSV file to the output file */
                return ws;

        
        }

        public static void FillTables(ArrayList<Aula> au) throws Exception{
            int linha = 0;
            WorkSheet ws;
            ws = HorariosGeral();
            int rownum = 0;
            int cellnum = 0;
            CellStyle cellStyle = ws.new_workbook.createCellStyle();
            
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            
            Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
            Object [] objArr = null;    
            
                for(Aula aula : au){
                
                        excel_data.put(Integer.toString(au.get(linha).timeSlot.getCod()), new Object[] 
                          
                            {au.get(linha).disp.getCodD(),
                            au.get(linha).timeSlot.getCod(),
                            au.get(linha).prof.getCod(),
                            au.get(linha).sala.getCod()}); 
            
                linha++;
            
            }
            linha = 0;
            
                
                
                
                
//                //* Step -5: Create Excel Data from the map using POI */
                  Set<String> keyset = excel_data.keySet();

                        int i=0;
                       for(Aula aula : au){
                           
 //                          if( keyset.contains(Integer.toString(au.get(i).timeSlot.getCod()))){
                               
                              if(au.get(i).curso == 1){  // Eng. comp
                               
                                  cellnum = 1;
                                  
                                  switch(au.get(i).periodo){
                                      
                                           case 1:
                                               rownum = 2;
                                          
                                          break;
                                           case 2:
                                               rownum = 18;
                                          
                                          break;
                                           case 3:
                                               rownum = 34;
                                          
                                          break;
                                           case 4:
                                               rownum = 50;
                                          
                                          break;
                                           case 5:
                                               rownum = 66;
                                          
                                          break;
                                           case 6:
                                               rownum = 82;
                                          
                                          break;
                                           case 7:
                                               rownum = 98;
                                          
                                          break;
                                           case 8:
                                               rownum = 114;
                                          
                                          break;
                                           case 9:
                                               rownum = 130;
                                          
                                          break;
                                           case 10:
                                               rownum = 146;
                                          
                                          break;
                                           case 11:
                                               rownum = 162;
                                          
                                          break;
                                           case 12:
                                               rownum = 178;
                                          
                                          break;
                                         
                              }
                                  
                                  
                              }
                              else if(au.get(i).curso == 2){
                                  
                                  cellnum = 10;
                                  
                                  switch(au.get(i).periodo){
                                      
                                           case 1:
                                               rownum = 2;
                                          
                                          break;
                                           case 2:
                                               rownum = 18;
                                          
                                          break;
                                           case 3:
                                               rownum = 34;
                                          
                                          break;
                                           case 4:
                                               rownum = 50;
                                          
                                          break;
                                           case 5:
                                               rownum = 66;
                                          
                                          break;
                                           case 6:
                                               rownum = 82;
                                          
                                          break;
                                           case 7:
                                               rownum = 98;
                                          
                                          break;
                                           case 8:
                                               rownum = 114;
                                          
                                          break;
                                           case 9:
                                               rownum = 130;
                                          
                                          break;
                                           case 10:
                                               rownum = 146;
                                          
                                          break;
          
                              }
                                  
                                  
                              }
                              else{
                                  
                                  cellnum = 19;
                                  
                                  switch(au.get(i).periodo){
                                      
                                           case 1:
                                               rownum = 2;
                                          
                                          break;
                                           case 2:
                                               rownum = 18;
                                          
                                          break;
                                           case 3:
                                               rownum = 34;
                                          
                                          break;
                                           case 4:
                                               rownum = 50;
                                          
                                          break;
                                           case 5:
                                               rownum = 66;
                                          
                                          break;
                                           case 6:
                                               rownum = 82;
                                          
                                          break;
                                           case 7:
                                               rownum = 98;
                                          
                                          break;
                                           case 8:
                                               rownum = 114;
                                          
                                          break;
                                           case 9:
                                               rownum = 130;
                                          
                                          break;
                                           case 10:
                                               rownum = 146;
                                          
                                          break;
                                                
                              }
                                  
                              }
                              
                              
                              switch(au.get(i).timeSlot.getDia()){
                                  
                                  case 2:
                                      
                                      
                                      break;
                                  case 3:
                                      cellnum = cellnum +1;
                                      
                                      
                                      break;
                                  case 4:
                                      
                                      cellnum = cellnum +2;
                                      
                                      break;
                                  case 5:
                                      
                                      cellnum = cellnum +3;
                                      
                                      break;
                                  case 6:
                                      
                                      cellnum = cellnum +4;
                                      
                                      break;
                                  case 7:
                                      
                                      cellnum = cellnum +5;
                                      
                                      break;    
                                      
                                      
                                      
                              }
                              
                              switch(au.get(i).timeSlot.getHoraInicio()){
                                  
                                  
                                       case "07:00":
                                      break;
                                       case "08:00": rownum = rownum +1;
                                      break;
                                       case "09:00": rownum = rownum +2;
                                      break;
                                       case "10:00": rownum = rownum +3;
                                      break;
                                       case "11:00": rownum = rownum +4;
                                      break;
                                       case "13:00": rownum = rownum +5;
                                      break;
                                       case "14:00": rownum = rownum +6;
                                      break;
                                       case "15:00": rownum = rownum +7;
                                      break;
                                       case "16:00": rownum = rownum +8;
                                      break;
                                       case "17:00": rownum = rownum +9;
                                      break;
                                       case "18:00": rownum = rownum +10;
                                      break;
                                       case "19:00": rownum = rownum +11;
                                      break;
                                       case "20:00": rownum = rownum +12;
                                      break;
                                       case "21:00": rownum = rownum +13;
                                      break;
      
                              }
                              
                              createCell2(ws.new_workbook, 
                                      ws.sheet.getRow(rownum), 
                                      rownum, 
                                      ws.sheet,
                                      ws.sheet.getRow(rownum).getCell(cellnum), 
                                      cellnum,CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, 
                                      au.get(i).disp.getDescri()+"|Prof0"+au.get(i).prof.getCod()+"|"+au.get(i).sala.getCod(), // texto
                                      cellStyle);
                               
                              ws.sheet.autoSizeColumn((short) cellnum);
                               
                               
                         i++;  
                       }
                       
                       //C:\Users\Gabriel\Documents\NetBeansProjects\TimeTable\src\files\ag-horarios.csv

//                /* Write XLS converted CSV file to the output file */
                  FileOutputStream output_file = new FileOutputStream(new File(userhome+"\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\TabelaHorários.xlsx")); //create XLSX file
                  ws.new_workbook.write(output_file);//write converted XLSX file to output stream
                  output_file.close(); //close the file

                 try {   // abre exel com arquivo
                        Desktop.getDesktop().open(new File(userhome+"\\Documents\\NetBeansProjects\\TimeTable\\src\\files\\TabelaHorários.xlsx"));
                } catch (IOException e) {e.printStackTrace();}
        }
        
        private static void createCell1(XSSFWorkbook wb, Row row, short column, short halign, short valign, String value,CellStyle cellStyle) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }
        
        private static void PeriodoCell(Row row,int rownum,Sheet sheet,Cell cell,int cellNum,Font font,CellStyle style,XSSFWorkbook new_workbook, int periodo, int z){
            
            row = sheet.getRow(rownum);
            cell = row.getCell(cellNum);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(font);                
            createCell2(new_workbook,row,rownum,sheet,cell,(short)z,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER, periodo + "º Período",style);
            
        }
        
        public static void createCell2(XSSFWorkbook wb,Row row,int rownum,Sheet sheet,Cell cell,int cellNum, short halign, short valign, String value,CellStyle cellStyle) {
        row = sheet.getRow(rownum);
        cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
            }
        
        cell.setCellValue(value);
        
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }
        
        private static void TimeSlotsCell(Row row, Sheet sheet,Cell cell, int rownum, XSSFWorkbook new_workbook, CellStyle cellStyle, int z){
            
            int j=0;
            
            for(timetable.TimeSlot ts : timetable.LeituraCSV.TIMESLOT){
                
                
                int num = timetable.LeituraCSV.TIMESLOT.get(j).getCod();
                
                if(((num >= 32 && num <= 36) || (num >= 38 && num <= 46)) && timetable.LeituraCSV.TIMESLOT.get(j).getDia() == 2){
                    
                        if( z == 0){
                        row = sheet.createRow(rownum);    
                        createCell1(new_workbook,row,(short)0,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,
                        timetable.LeituraCSV.TIMESLOT.get(j).getHoraInicio() +"-"+ timetable.LeituraCSV.TIMESLOT.get(j).getHoraFinal(),cellStyle);
                        rownum++;
                        }
                        else{
                            
                        createCell2(new_workbook,row,rownum,sheet,cell,(short)z,CellStyle.ALIGN_CENTER,CellStyle.VERTICAL_CENTER,
                        timetable.LeituraCSV.TIMESLOT.get(j).getHoraInicio() +"-"+ timetable.LeituraCSV.TIMESLOT.get(j).getHoraFinal(),cellStyle);
                        rownum++;
                            
                        }
                      
                }
                
                j++;
                
            }
            
            
        }
}
