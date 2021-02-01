package Information;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InformationClass {
    /*
    This class will help with the text e.g. Welcome text, Help text & Option text
     */
    public StringBuilder getHelpText(){
        String helpFileLocation = System.getProperty("user.dir")+"\\help\\Help.txt";
        StringBuilder helpText = new StringBuilder();
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(helpFileLocation));
            String line;
            while((line = bufferedReader.readLine())!=null){
                helpText.append(line).append("\n");
            }
        }catch (IOException e){
            helpText.append("Invalid");
        }
        return helpText;
    }

    public void getWelcomeText(){
        String welcomeFileLocation = System.getProperty("user.dir")+"\\help\\WelcomeText.txt";
        StringBuilder welcomeText= new StringBuilder();
        boolean welcomeFileStatus = false;
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(welcomeFileLocation));
            welcomeFileStatus = true;
            String line;
            while((line = bufferedReader.readLine())!=null){
                welcomeText.append(line).append("\n");
            }
        }catch(IOException exception){
            System.out.println("Welcome Text not found!!!");
        }
        if(welcomeFileStatus && welcomeText.length()>0){
            System.out.println(welcomeText);
        }else{
            System.out.println("To continue\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\nFor execution, Type '1'\nFor help, Type '-help\n----------------------'");
        }
    }

    public StringBuilder getOptionText(){
        String optionsFileLocation = System.getProperty("user.dir")+"\\help\\UnitOptions.txt";
        StringBuilder optionText = new StringBuilder();
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(optionsFileLocation));
            String line;
            while((line = bufferedReader.readLine())!=null){
                optionText.append(line).append("\n");
            }
        }catch (IOException e){
            optionText.append("Invalid");
        }
        return optionText;
    }
}
