package fruits_summary;

import java.util.List;

public interface Summary_Format {
    /*
    This interface has base of all expected criteria
     */
    void getTotalFruitsCount(List<List <String>> fruits);
    void getTotalTypesOfFruits(List<List <String>> fruits);
    void getOldestFruits(List <List <String>> fruits);
    void groupByFruitTypesDESC(List <List <String>> fruits);
    void groupByFruitTypes_n_Characteristics(List <List <String>> fruits);
}
