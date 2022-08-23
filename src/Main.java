import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        System.out.println("~ Список покупок ~" + "\n" + "Доступные операции:" + "\n" + "1. Добавить" + "\n" + "2. Показать"
                + "\n" + "3. Удалить" + "\n" + "4. Найти" + "\n" + "Для выхода введите end");

        while (true) {
            System.out.println("\n" + "Выберите операцию: ");

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int item;

            try {
                item = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Введите номер операции!");
                continue;
            }

            switch (item) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String inputProduct = scanner.nextLine();
                    try {
                        int numInputProduct = Integer.parseInt(inputProduct);
                        System.out.println("Введите текст, а не число!");
                        continue;

                    } catch (NumberFormatException e) {
                        list.add(inputProduct);
                        System.out.println("Итого в списке покупок: " + list.size());
                        break;
                    }

                case 2:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                    break;

                case 3:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }

                    System.out.println("Какую хотите удалить? Введите номер или название");

                    String inputDel = scanner.nextLine();

                    try {
                        int deleteNum = Integer.parseInt(inputDel) - 1;
                        if (deleteNum < list.size() && deleteNum >= 0) {
                            System.out.println("Покупка " + "'" + list.get(deleteNum) + "'" + " удалена, список покупок:");
                            list.remove(deleteNum);
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println((i + 1) + ". " + list.get(i));
                            }
                        } else {
                            System.out.println("Ошибка ввода! Выберите номер покупки их списка!");
                        }
                        break;

                    } catch (NumberFormatException e) {

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(inputDel)) {
                                System.out.println("Покупка " + "'" + list.get(i) + "'" + " удалена, список покупок:");
                                list.remove(list.get(i));
                                for (int j = 0; j < list.size(); j++) {
                                    System.out.println((j + 1) + ". " + list.get(j));
                                }
                            }
                        }
                        break;
                    }

                case 4:
                    System.out.println("Введите текст для поиска:");
                    String foundProduct = scanner.nextLine();
                    String foundProductLower = foundProduct.toLowerCase();
                    System.out.println("Найдено:");
                    for (String product : list) {
                        String productLower = product.toLowerCase();
                        if (productLower.contains(foundProductLower)) {
                            System.out.println((list.indexOf(product) + 1) + ". " + product);
                        }
                    }

                    break;

                default:
                    System.out.println("Некорректный ввод, выберите пункт из списка!");
                    break;

            }

        }

    }
}
