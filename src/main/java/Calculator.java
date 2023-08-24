import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    int amount;
    float sum;
    List<Item> items = new ArrayList<>();
    Calculator (int amount) {
        this.amount = amount;
    }

    void addItem(Scanner scanner) {
        String input;
        String name;
        float price;
        while (true) {
            System.out.println("Добавьте позицию в счёт. Введите название:");
            name = scanner.nextLine();
            System.out.println("Укажите стоимость товара:");
            while (true) {
                try {
                    price = scanner.nextFloat();
                    if (price >= 0) {
                        sum += price;
                        break;
                    } else {
                        System.out.println("Неверный формат, попробуйте ещё раз.");
                    }
                } catch (Exception e) {
                    System.out.println("Неверный формат, попробуйте ещё раз.");
                    scanner.skip(".*\\n");
                }
            }

            items.add(new Item(name, price));
            System.out.println("Товар успешно добавлен. Добавить ещё один?\n(Для выхода наберите команду \"Завершить\")");
            input = scanner.next();
            if (input.equalsIgnoreCase("Завершить")) { break; }
            scanner.skip(".*\\n");
        }
    }

    void printCheck() {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("- " + Formatter.formatString(items.get(i).name) + ": " + Formatter.formatFloat(items.get(i).price) + " " + Formatter.formatRoubles(items.get(i).price));
        }
        System.out.println("Каждый гость должен оплатить " + Formatter.formatFloat(sum/amount) + " " + Formatter.formatRoubles(sum/amount));
    }

}
