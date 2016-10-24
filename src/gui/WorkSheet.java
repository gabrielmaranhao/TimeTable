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

import org.apache.poi.xssf.usermodel.XSSFWorkbook; //Write in Office 2007, 2012 format
import org.apache.poi.xssf.usermodel.XSSFSheet; //Write in Office 2007, 2012 format
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;



public  class WorkSheet {
    
    XSSFWorkbook  new_workbook; //create a blank workbook object
    XSSFSheet sheet;  //create a worksheet with caption score_details

    public WorkSheet(XSSFWorkbook  new_workbook, XSSFSheet sheet) {
        this.new_workbook = new_workbook;
        this.sheet = sheet;
    }

    public XSSFWorkbook getNew_workbook() {
        return new_workbook;
    }

    public void setNew_workbook(XSSFWorkbook new_workbook) {
        this.new_workbook = new_workbook;
    }

    public XSSFSheet getSheet() {
        return sheet;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    
    
    
    
}
