import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WeightHistogramCalculator implements HistogramCalculator {

    private static final int BIN_SIZE = 20;
    private final List<Student> students;

    public WeightHistogramCalculator(List<Student> students) {
        this.students = students;
    }

    @Override
    public Map<String, Integer> calculateWomen() {
        Map<String, Integer> result = new HashMap<>();
        for (Student s : students){
            if (Objects.equals(s.getGender(), "Mujer")){
                String key = toBin(s.getWeight());
                result.put(key, result.getOrDefault(key, 0)+1);
            }
        }
        return result;
    }

    @Override
    public Map<String, Integer> calculateMen() {
        Map<String, Integer> result = new HashMap<>();
        for (Student s : students){
            if (Objects.equals(s.getGender(), "Hombre")){
                String key = toBin(s.getWeight());
                result.put(key, result.getOrDefault(key, 0)+1);
            }
        }
        return result;
    }

    private String toBin(double weight) {
        return low(weight) + " - " + high(weight);
    }

    private int high(double weight){
        return low(weight) + BIN_SIZE;
    }

    private int low(double weight) {
        return (int)(weight/BIN_SIZE) * BIN_SIZE
    }
}
