package requirements_validations;

import fruits_summary.Counting_Fruits;

import java.util.List;

public class Requirements_Check {
    /*
    This class will accommodate the validation of each functionality
     */
    public void verifyUnit(int param, List<List<String>> fruits){
        Counting_Fruits counting_fruits = new Counting_Fruits();
        switch (param){
            case 1:
                counting_fruits.getTotalFruitsCount(fruits);
                break;
            case 2:
                counting_fruits.getTotalTypesOfFruits(fruits);
                break;
            case 3:
                counting_fruits.getOldestFruits(fruits);
                break;
            case 4:
                counting_fruits.groupByFruitTypesDESC(fruits);
                break;
            case 5:
                counting_fruits.groupByFruitTypes_n_Characteristics(fruits);
                break;
            default:
                System.out.println("Not a correct parameter "+ param);
                break;
        }
    }
}
