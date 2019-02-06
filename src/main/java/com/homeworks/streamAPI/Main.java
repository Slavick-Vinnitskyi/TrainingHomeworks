import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = new Random()
                .ints(10, 1, 10)
                .toArray();
        System.out.print("array : ");
        Arrays.stream(array)
                .forEach(x -> System.out.print(x + " "));

        double mediumValue = Arrays.stream(array)
                .average()
                .getAsDouble();
        System.out.printf("\navarage : %.2f\n", mediumValue);

        int minValue = Arrays.stream(array)
                .min()
                .getAsInt();
        System.out.printf("min value : %d\n", minValue);

        int[] minValueIndex = IntStream.range(0, array.length)
                .filter(i -> array[i] == minValue)
                .toArray();
        System.out.print("index : ");
        Arrays.stream(minValueIndex).forEach(x -> System.out.print(x + " "));

        long countZeroElement = Arrays.stream(array)
                .filter(x -> x == 0)
                .count();
        System.out.printf("count of zero element : %d \n", countZeroElement);

        long countBiggerZeroElement = Arrays.stream(array)
                .filter(x -> x > 0)
                .count();
        System.out.printf("count of bigger then zero element : %d \n", countBiggerZeroElement);

        int multiplicationNumber = 4;
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum : " + sum);
        int multipleArray = Arrays
                .stream(array)
                .map((x) -> x *= multiplicationNumber)
                .reduce(0, (x, y) -> x + y);

        System.out.println("Array reduced to its sum : " + multipleArray);

        List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 2, 5, 3, 4));
        list.removeIf(x -> x == 4);
        System.out.println();
        list.forEach(System.out::print);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "e");
        map.put(1, "d");
        map.put(2, "g");
        map.put(3, "f");
        List<Map.Entry> entryList = new ArrayList(map.entrySet());
        entryList.forEach(x -> System.out.print(x + "  "));
        Object s = entryList.get(0);
        System.out.println(s.toString());
    }
}
