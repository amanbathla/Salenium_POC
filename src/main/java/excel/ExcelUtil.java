package excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

   static XSSFWorkbook workbook;
   static XSSFSheet sheet;

    public ExcelUtil(String excelPath, String sheetname) {
        try {


            this.workbook = new XSSFWorkbook(excelPath);
            this.sheet = workbook.getSheet(sheetname);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Get row count
    public int getColumnCount(){

        int columnCount = 0;
        try{

            columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Column Count is :" + columnCount);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return columnCount;

    }


    //Get Column count

    public  int getRowCount(){

        int rowCount = 0;
        try{

            rowCount =  sheet.getPhysicalNumberOfRows();
            System.out.println("Row Count is :" + rowCount);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return rowCount;

    }
    // Get Cell data

    public  String  getCellDataString(int rowNum,int columnNum){
      String cellDataSheet = null;
        try{
          //Get row data
           cellDataSheet = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();

            System.out.println(cellDataSheet);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellDataSheet;
    }


    // Get Cell data

    public static void  getCellDataNumeric(int rowNum,int columnNum){
        try{
            //to call integer value
              double passwd = sheet.getRow(0).getCell(0).getNumericCellValue();

            System.out.println(passwd);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

}
