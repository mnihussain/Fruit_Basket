package requirements_validations;

public class Requirement_Enforce {
    /*
    This class will enforce exit criteria of the program
     */
    public void exitForInvalidFile(){
        System.out.println("Exiting Fruit Basket...");
        /*
            Requirement 1:
            Requirement is exiting code if CSV file does not exist
        */
        System.exit(2);
    }

    public void exitForUnsupportedCSVStructure(){
        System.out.println("Exiting Fruit Basket...");
        /*
            Requirement 2:
            Requirement is exiting code if CSV file does not match the structure outlined
            which is - per fruit should have type, age and characteristics
        */
        System.exit(0);
    }
}
