package picking_fruits;

import fruits_summary.Counting_Fruits;
import requirements_validations.Requirement_Enforce;
import requirements_validations.Requirements_Check;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gathering_Fruits extends Requirement_Enforce {
    /*
    This class will extract data from csv and csv validation as well
     */
    public void extractDataFromCSV(String fileName, String input, int param){
        /*
           Checking the file name is empty or unsupported file type and
           there after JVM will terminate and next lines of codes will not execute
        */
        if(fileName != null && fileName.trim().endsWith(".csv")){
            List<List<String>> fruits = readCSVFile(fileName.trim());
            if(input.trim().length() > 0 && input.trim().length() < 6 && input.trim().contains("run")){
                new Counting_Fruits().viewResults(fruits);
            }else if(input.trim().length() > 0 && input.trim().length() < 6 && input.trim().contains("unit")){
                new Requirements_Check().verifyUnit(param,fruits);
            }
        }else{
            System.out.println("Check your input file... \nThis program accepts only CSV file as input");
        }
    }

    private List<List<String>> readCSVFile(String fileName){
        List<List<String>> fruits = new ArrayList <>();
        BufferedReader bufferedReader ;
        /*
          This is to check if the file is exists in the given location
         */
        if(new File(fileName).exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
                String eachLine;
                try {
                    while ((eachLine = bufferedReader.readLine()) != null) {
                        if(eachLine.contains(",")) {
                            String[] fruit = eachLine.split(",");
                            fruits.add(Arrays.asList(fruit));
                        }else{
                            System.out.println("This program doesn't support this CSV file structure!!!");
                            exitForUnsupportedCSVStructure();
                        }
                    }
                } catch (IOException ioException) {
                    System.out.println("Check your CSV input file, file is unreadable");
                    ioException.printStackTrace();
                    exitForInvalidFile();
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.printf("Program cannot find this >>> %s <<< file\nCheck your input file...", fileName);
                fileNotFoundException.printStackTrace();
                exitForUnsupportedCSVStructure();
            }
        }else{
            System.out.println("File does not exist in the given filepath : "+fileName);
            exitForInvalidFile();
        }
        return fruits;
    }
}
