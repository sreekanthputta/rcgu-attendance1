package com.slabs.rcguattendance;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Sreekanth Putta on 12-05-2016.
 */
public class exportExcel {
    public static File Excel ;
    public static int i=1;
    public static boolean saveExcelFile(Context context) {
        boolean success;
        success = false;
        boolean flag=false;


        Excel = new File(Environment.getExternalStorageDirectory().getPath() +"/RCGU Attendance/"+MainActivity.Tevent.getText().toString()+".xls");
        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell c = null;
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("RCGU");
        Row row;


        //Cell style for header row
        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        FileOutputStream os ;
        //if(!Excel.exists()) {


            // Generate column headings
            row = sheet1.createRow(0);

            c = row.createCell(0);
            c.setCellValue("Name");
            c.setCellStyle(cs);

            c = row.createCell(1);
            c.setCellValue("Pin");
            c.setCellStyle(cs);

            c = row.createCell(2);
            c.setCellValue("Year");
            c.setCellStyle(cs);

            c = row.createCell(3);
            c.setCellValue("Branch");
            c.setCellStyle(cs);

            c = row.createCell(4);
            c.setCellValue("Section");
            c.setCellStyle(cs);

            c = row.createCell(5);
            c.setCellValue("Email");
            c.setCellStyle(cs);

            c = row.createCell(6);
            c.setCellValue("Blood");
            c.setCellStyle(cs);

            c = row.createCell(7);
            c.setCellValue("Phone");
            c.setCellStyle(cs);

            c = row.createCell(8);
            c.setCellValue("Hostel");
            c.setCellStyle(cs);

            c = row.createCell(9);
            c.setCellValue("Local");
            c.setCellStyle(cs);

            c = row.createCell(10);
            c.setCellValue("College");
            c.setCellStyle(cs);

            c = row.createCell(11);
            c.setCellValue("Age");
            c.setCellStyle(cs);

            c = row.createCell(12);
            c.setCellValue("Gender");
            c.setCellStyle(cs);

            sheet1.setColumnWidth(0, (15 * 500));
            sheet1.setColumnWidth(1, (15 * 500));
            sheet1.setColumnWidth(2, (15 * 500));
            sheet1.setColumnWidth(3, (15 * 500));
            sheet1.setColumnWidth(4, (15 * 500));
            sheet1.setColumnWidth(5, (15 * 500));
            sheet1.setColumnWidth(6, (15 * 500));
            sheet1.setColumnWidth(7, (15 * 500));
            sheet1.setColumnWidth(8, (15 * 500));
            sheet1.setColumnWidth(9, (15 * 500));
            sheet1.setColumnWidth(10, (15 * 500));
            sheet1.setColumnWidth(11, (15 * 500));
            sheet1.setColumnWidth(12, (15 * 500));
  //      }



        /*try{
            // Creating Input Stream
            FileInputStream myInput = new FileInputStream(Excel);

            // Create a POIFSFileSystem object
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            // Create a workbook using the File System
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            // Get the first sheet from workbook
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);


            /** We now need something to iterate through the cells.**/
     /*       Iterator<Row> rowIter = mySheet.rowIterator();

            boolean checkcell=true;
            for (int j=0; j< mySheet.getLastRowNum() + 1; j++) {
                Row row1 = mySheet.getRow(j);
                Log.e("getrow",String.valueOf(j));
                Cell cell0=null,cell1=null,cell7=null;
                if(row1.getCell(0).toString().length()!=0){cell0 = row1.getCell(0);} //get first cell
                if(row1.getCell(0).toString().length()!=0){cell1 = row1.getCell(1);}
                if(row1.getCell(0).toString().length()!=0){cell7 = row1.getCell(7);}
                if(cell0.toString().equals(name1)||cell1.toString().equals(pin1)||cell7.toString().equals(phone1)){
                    flag=true;
                }
                if(cell0.toString().length()==0&&checkcell){
                    i=j;
                    checkcell=false;
                }
                Log.e("i",String.valueOf(i));
            }
            if(checkcell){
                i=mySheet.getLastRowNum()+1;
            }
            Log.e("i",String.valueOf(i));
        }
        catch (Exception e) {
            i=1;
            e.printStackTrace();
        }*/

        //      if(!flag){















        //    }
        //   else{
        //      Toast.makeText(context ,name1+", already added",Toast.LENGTH_SHORT).show();
        // }


        // Create a path where we will place our List of objects on external storage


        try {
            os = new FileOutputStream(Excel);
            wb.write(os);
            //  Log.w("FileUtils", "Writing file" + file);
            success = true;
        } catch (IOException e) {
            //  Log.w("FileUtils", "Error writing " + file, e);
        } catch (Exception e) {
            //  Log.w("FileUtils", "Failed to save file", e);
        } finally {

        }

        return success;
    }





    public static void addElement(Context context, String eventname1, String name1, String pin1, String year1, String branch1, String section1, String email1, String blood1, String phone1, String hostel1, String local1, String college1, String age1, String gender1){
        try{
            //Read the spreadsheet that needs to be updated
            FileInputStream input_document = new FileInputStream(new File(Environment.getExternalStorageDirectory().getPath())+"/RCGU Attendance/"+MainActivity.Tevent.getText()+".xls");
            //Access the workbook
            HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
            //Access the worksheet, so that we can update / modify it.
            HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
            // declare a Cell object
            Cell c = null;
            // Access the cell first to update the value
            boolean flag=false;
            try{
                for (int j=0; j< my_worksheet.getLastRowNum() + 1; j++) {
                Row row1 = my_worksheet.getRow(j);
                Log.e("getrow",String.valueOf(j));
                Cell cell0=null,cell1=null,cell7=null;
                if(row1.getCell(0).toString().length()!=0){cell0 = row1.getCell(0);} //get first cell
                if(row1.getCell(0).toString().length()!=0){cell1 = row1.getCell(1);}
                if(row1.getCell(0).toString().length()!=0){cell7 = row1.getCell(7);}
                if(cell0.toString().equals(name1)||cell1.toString().equals(pin1)||cell7.toString().equals(phone1)){
                    flag=true;
                }
                }
                Log.e("i",String.valueOf(i));
            }
        catch (Exception e) {
            i=1;
            e.printStackTrace();
        }

            if(!flag){

            int j ;
            for(j=0;j<my_worksheet.getLastRowNum()+1;j++){
                if(my_worksheet.getRow(j)==null){
                    break;
                };
            }
            Row row;
            if(my_worksheet.getRow(j)==null){
                row = my_worksheet.createRow(j) ;
            }
            else {
                row = my_worksheet.getRow(j);
            }
            if(row.getCell(0)==null) {

                c = row.createCell(0);
                c.setCellValue(name1);

                c = row.createCell(1);
                c.setCellValue(pin1);

                c = row.createCell(2);
                c.setCellValue(year1);

                c = row.createCell(3);
                c.setCellValue(branch1);

                c = row.createCell(4);
                c.setCellValue(section1);

                c = row.createCell(5);
                c.setCellValue(email1);

                c = row.createCell(6);
                c.setCellValue(blood1);

                c = row.createCell(7);
                c.setCellValue(phone1);

                c = row.createCell(8);
                c.setCellValue(hostel1);

                c = row.createCell(9);
                c.setCellValue(local1);

                c = row.createCell(10);
                c.setCellValue(college1);

                c = row.createCell(11);
                c.setCellValue(age1);

                c = row.createCell(12);
                c.setCellValue(gender1);


            } else{
                c = row.getCell(0);
                c.setCellValue(name1);
            }

            Toast.makeText(context ,MainActivity.name+", Successfully added",Toast.LENGTH_SHORT).show();

                // Get current value and then add 5 to it
                //cell.setCellValue(cell.getNumericCellValue() + 5);
                //Close the InputStream
                input_document.close();
                //Open FileOutputStream to write updates
                FileOutputStream output_file =new FileOutputStream(new File(Environment.getExternalStorageDirectory().getPath())+"/RCGU Attendance/"+MainActivity.Tevent.getText()+".xls");
                //write changes
                my_xls_workbook.write(output_file);
                //close the stream
                output_file.close();
                //Toast.makeText(context,"New Event Created",Toast.LENGTH_SHORT).show();

            }
           else{
                Toast.makeText(context ,name1+", already added",Toast.LENGTH_SHORT).show();
           }


        }
        catch (IOException e){
            Toast.makeText(context,"File cant be created",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }


}
