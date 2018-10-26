import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = new Random().ints(10, 1 , 10).toArray();
        System.out.print("array : ");
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));

        double mediumValue = Arrays.stream(array).average().getAsDouble();
        System.out.printf("\navarage : %.2f\n", mediumValue);

        int minValue = Arrays.stream(array).min().getAsInt();
        System.out.printf("min value : %d\n", minValue);

        int[] minValueIndex = IntStream.range(0, array.length).filter(i -> array[i] == minValue).toArray();
        System.out.print("index : ");
        Arrays.stream(minValueIndex).forEach(x -> System.out.print(x + " "));

        long countZeroElement = Arrays.stream(array).filter(x -> x == 0).count();
        System.out.printf("count of zero element : %d \n", countZeroElement);

        long countBiggerZeroElement = Arrays.stream(array).filter(x -> x > 0).count();
        System.out.printf("count of bigger then zero element : %d \n", countBiggerZeroElement);

        int multiplicationNumber = 4;
        int [] multipleArray = Arrays.stream(array).map((x) -> x *= multiplicationNumber).toArray();
        System.out.printf("array multiplicated by %d: ", multiplicationNumber);
        Arrays.stream(multipleArray).forEach(x -> System.out.print(x + " "));


    }
}
