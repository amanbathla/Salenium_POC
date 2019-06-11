package excel;

public class ReadExcel {

    public static void main(String[] args) {


        String excelPath = "C:\\Users\\AmanBathla\\Desktop\\AMHI_salenium_POC\\src\\main\\java\\excel\\data.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(excelPath,"Sheet1");

    }
}
