import java.util.ArrayList;
import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
          InObject one = new InObject(Arrays.asList(0,0,0,1,
                                                    0,0,1,1,
                                                    0,1,0,1,
                                                    0,0,0,1,
                                                    0,0,0,1),   Arrays.asList(1,0,0,0,0,0,0,0,0));

          InObject two = new InObject(Arrays.asList(0,1,1,0,
                                                    1,0,0,1,
                                                    0,0,1,0,
                                                    0,1,0,0,
                                                    1,1,1,1),   Arrays.asList(0,1,0,0,0,0,0,0,0));

        InObject three = new InObject(Arrays.asList(0,1,1,1,
                                                    0,0,0,1,
                                                    0,0,1,1,
                                                    0,0,0,1,
                                                    0,1,1,1), Arrays.asList(0,0,1,0,0,0,0,0,0));

         InObject four = new InObject(Arrays.asList(0,1,0,1,
                                                    0,1,0,1,
                                                    0,1,1,1,
                                                    0,0,0,1,
                                                    0,0,0,1),  Arrays.asList(0,0,0,1,0,0,0,0,0));

         InObject five = new InObject(Arrays.asList(0,1,1,1,
                                                    0,1,0,0,
                                                    0,1,1,1,
                                                    0,0,0,1,
                                                    0,1,1,1),  Arrays.asList(0,0,0,0,1,0,0,0,0));

          InObject six = new InObject(Arrays.asList(0,1,1,1,
                                                    0,1,0,0,
                                                    0,1,1,1,
                                                    0,1,0,1,
                                                    0,1,1,1),   Arrays.asList(0,0,0,0,0,1,0,0,0));

        InObject seven = new InObject(Arrays.asList(1,1,1,1,
                                                    0,0,1,0,
                                                    0,1,0,0,
                                                    0,1,0,0,
                                                    0,1,0,0), Arrays.asList(0,0,0,0,0,0,1,0,0));

        InObject eight = new InObject(Arrays.asList(0,1,1,0,
                                                    1,0,0,1,
                                                    0,1,1,0,
                                                    1,0,0,1,
                                                    0,1,1,0), Arrays.asList(0,0,0,0,0,0,0,1,0));

         InObject nine = new InObject(Arrays.asList(0,1,1,1,
                                                    0,1,0,1,
                                                    0,1,1,1,
                                                    0,0,0,1,
                                                    0,1,1,1),  Arrays.asList(0,0,0,0,0,0,0,0,1));
        Perceptron p = new Perceptron(20,20,9);
        System.out.println(p.toString());   /* просто вывожу его*/
        p.study(Arrays.asList(one,two,three,four,five,six,seven,eight,nine),10000L,0.65);
        System.out.println("\n" + "check after learning: ");
        System.out.println("one");
        p.check_perceptron(one);
        System.out.println("two");
        p.check_perceptron(two);
        System.out.println("three");
        p.check_perceptron(three);
        System.out.println("four");
        p.check_perceptron(four);
        System.out.println("five");
        p.check_perceptron(five);
        System.out.println("six");
        p.check_perceptron(six);
        System.out.println("seven");
        p.check_perceptron(seven);
        System.out.println("eight");
        p.check_perceptron(eight);
        System.out.println("nine");
        p.check_perceptron(nine);

        System.out.println("\n"+"Check distorted values: ");
        InObject one_1 = new InObject(Arrays.asList(0,0,1,1,
                                                    0,0,0,1,
                                                    0,0,0,1,
                                                    0,0,0,1,
                                                    0,0,0,1),   Arrays.asList(1,0,0,0,0,0,0,0,0));

        InObject one_2 = new InObject(Arrays.asList(0,0,0,1,
                                                    0,0,1,1,
                                                    0,0,0,1,
                                                    0,0,0,1,
                                                    0,0,0,1),   Arrays.asList(1,0,0,0,0,0,0,0,0));

        InObject two_1 = new InObject(Arrays.asList(0,1,1,0,
                                                    0,0,0,1,
                                                    0,0,1,0,
                                                    0,1,0,0,
                                                    0,1,1,1),   Arrays.asList(0,1,0,0,0,0,0,0,0));

        InObject two_2 = new InObject(Arrays.asList(1,1,1,0,
                                                    1,0,0,1,
                                                    0,0,1,0,
                                                    0,1,0,0,
                                                    0,1,1,1),   Arrays.asList(0,1,0,0,0,0,0,0,0));
        System.out.println("1.1");
        p.check_perceptron(one_1);
        System.out.println("1.2");
        p.check_perceptron(one_2);
        System.out.println("2.1");
        p.check_perceptron(two_1);
        System.out.println("2.2");
        p.check_perceptron(two_2);
    }
}
