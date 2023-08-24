import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = amountPeople(scanner);
        Calculator calculator = new Calculator(amount);
        calculator.addItem(scanner);
        calculator.printCheck();
        scanner.close();
    }

    public static int amountPeople(Scanner scanner) {
        int amount;
        System.out.println("Введите, пожалуйста, количество гостей:");
        while (true) {
            try {
                amount = scanner.nextInt();
                if (amount <= 1) {
                    System.out.println("Гостей должно быть больше одного, попробуйте ещё раз.");
                } else break;
            } catch (Exception e) {
                System.out.println("Неверный формат, попробуйте ещё раз.");
                scanner.skip(".*\\n");
            }
        }
        System.out.println("Количество гостей: " + amount + ".");
        scanner.skip(".*\\n");
        return amount;
    }
}