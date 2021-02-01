package fruits_summary;

import requirements_validations.Requirement_Enforce;
import java.util.*;

public class Counting_Fruits extends Requirement_Enforce implements Summary_Format {

    /*
    This class will provide all the expected results
     */

    public void viewResults(List<List <String>> fruits){
        Counting_Fruits counting_fruits = new Counting_Fruits();
        counting_fruits.getTotalFruitsCount(fruits);
        counting_fruits.getTotalTypesOfFruits(fruits);
        counting_fruits.getOldestFruits(fruits);
        counting_fruits.groupByFruitTypesDESC(fruits);
        counting_fruits.groupByFruitTypes_n_Characteristics(fruits);
    }

    public void getTotalFruitsCount(List<List <String>> fruits){
        System.out.println("Total number of fruit:\n"+fruits.size());
    }

    public void getTotalTypesOfFruits(List<List <String>> fruits){
        Set<String> fruitTypes = new HashSet <>();
        for(List<String> fruit: fruits){
            fruitTypes.add(fruit.get(0));
        }
        System.out.println("\nTotal types of fruit:\n"+fruitTypes.size());
    }

    public void getOldestFruits(List<List <String>> fruits){
        Map<String, Integer> oldestFruitsCollections = new HashMap <>();
        List<Integer> agesOfFruits = new ArrayList <>();
        for(List<String>fruit:fruits){
            try {
                agesOfFruits.add(Integer.parseInt(fruit.get(1)));
            }catch(NumberFormatException numberFormatException){
                exitForUnsupportedCSVStructure();
            }
        }
        int oldest = Collections.max(agesOfFruits);
        for (int index = 0; index <agesOfFruits.size(); index++){
            if(agesOfFruits.get(index) == oldest){
                oldestFruitsCollections.put(fruits.get(index).get(0), agesOfFruits.get(index));
            }
        }
        System.out.println("\nOldest fruit & age:");
        oldestFruitsCollections.entrySet().forEach(System.out::println);
    }

    public void groupByFruitTypesDESC(List<List <String>> fruits){
        Map<String, Integer> groupByFruits = new HashMap <>();
        List<String> fruitNames = new ArrayList <>();
        fruits.forEach(fruit -> fruitNames.add(fruit.get(0)));
        String pickedFruit = fruitNames.get(0);
        if(fruitNames.size()>1) {
            for(int iteration = 1; iteration <fruitNames.size(); iteration++ ) {
                int fruitCount = 0;
                if (!groupByFruits.containsKey(pickedFruit)) {
                    for (String fruitName : fruitNames) {
                        if (fruitName.equalsIgnoreCase(pickedFruit)) {
                            fruitCount++;
                        }
                    }
                    groupByFruits.put(pickedFruit, fruitCount);
                }
                pickedFruit = fruitNames.get(iteration);
            }
        }else{
            groupByFruits.put(pickedFruit, 1);
        }
        System.out.println("\nThe number of each types of fruit in descending order:");
        groupByFruits.entrySet().forEach(System.out::println);
    }

    public void groupByFruitTypes_n_Characteristics(List <List <String>> fruits) {
        List<List<String>> allTypes = new ArrayList <>();
        List<String>type_n_char = new ArrayList <>();
        for (List <String> fruit : fruits) {
            List <String> character = new ArrayList <>();
            for (int range = 2; range < fruit.size(); range++) {
                character.add(fruit.get(range));
            }
            Collections.sort(character);
            character.add(0,fruit.get(0));
            allTypes.add(character);
        }

        for (int index = 0; index < allTypes.size(); index++){
            int counter = 1;
            String finalOutput;
            for(int subIndex = 1; subIndex < allTypes.size(); subIndex++){
                if(allTypes.get(index).equals(allTypes.get(subIndex))) {
                    counter++;
                }
            }
            finalOutput= counter+" "+allTypes.get(index);
            if(!type_n_char.contains(finalOutput)){
                type_n_char.add(finalOutput);
            }
        }
        System.out.println("\nThe various characteristics (count, color, shape, etc.) of each fruit by type:");
        type_n_char.forEach(System.out::println);
    }
}
