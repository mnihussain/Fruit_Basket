package execution;

import Information.InformationClass;
import picking_fruits.Gathering_Fruits;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecutionClass {
    /*
    This is the main class to execute the 'Fruit_Basket' program
     */
    public static void main(String[] args) {
        InformationClass info = new InformationClass();
        Gathering_Fruits gathering_fruits = new Gathering_Fruits();
        String fileName = System.getProperty("user.dir")+"\\input\\Fruits.csv";
        String helpText = info.getHelpText().toString();
        String optionText = info.getOptionText().toString();
        info.getWelcomeText();
        Scanner scanner = new Scanner(System.in);
        System.out.print("_");
        String input;
        try {
            input = scanner.next();
            if(input.trim().length() > 0 &&input.trim().length() < 6 && input.trim().contains("run")){
                gathering_fruits.extractDataFromCSV(fileName, input, 0);
            }else if(input.trim().length() > 0 &&input.trim().length() < 6 && input.trim().contains("help")){
                if(!helpText.equalsIgnoreCase("Invalid")){
                    System.out.println(helpText);
                }else{
                    System.out.println("No help information found");
                }
            }else if(input.trim().length() > 0 &&input.trim().length() < 6 && input.trim().contains("unit")){
                if(!optionText.equalsIgnoreCase("Invalid")){
                    System.out.println(optionText);
                    System.out.print("_");
                    int param;
                    try {
                        param = scanner.nextInt();
                        gathering_fruits.extractDataFromCSV(fileName, input, param);
                    }catch (InputMismatchException inputMismatchException){
                        System.out.println("Type the correct keyword as mentioned above");
                    }
                }else{
                    System.out.println("No information for options found");
                }
            }else if(input.trim().length() > 0 &&input.trim().length() < 6 && input.trim().contains("exit")){
                System.out.println("Exiting the program...");
                System.exit(0);
            }else{
                System.out.println("Type the correct keyword as mentioned above");
            }
        }catch(InputMismatchException mismatchException){
            System.out.println("Type the correct keyword as mentioned above");
        }
        scanner.close();
    }

    public void runWhile(boolean bol){
        /*
        while true keep the thread alive
        until hit the 'run' scanner will always available
        one thread will execute the whole execution and main thread will receive a boolean value true upon completion
        a timer will set for 10 seconds then thread will be closing upon saying 'inactive'
         */
    }
}
