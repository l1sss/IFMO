package lesson9.Shop;

import java.util.Scanner;

/**
 * Created by l1s on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(); //создаём магазинчик

        //создаём продукты
        Product cat = new Product("Кот Васян", 0);
        Product watermelon = new Product("Арбуз", 30);
        Product axe = new Product("Топор", 50);

        //добавляем их в магазин
        shop.add(cat);
        shop.add(watermelon);
        shop.add(axe);

        //логинимся
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String s = sc.nextLine();
        Shop.User user = new Shop.User(s);

        //смотрим магазин
        System.out.println("\nНаши товары:");
        shop.show();

        StringBuilder builder = new StringBuilder();
        builder.append("\nСписок команд:\n" +
                "show       посмотреть доступные товары\n" +
                "add        добавить в корзину\n" +
                "cart       просмотр корзины\n" +
                "rem        удалить товар из корзины\n" +
                "buy        совершить покупку\n" +
                "exit       выход\n");
        System.out.println(builder);

        //собственно сам консольный интерфейс...
        while (true) {
            String c = sc.nextLine();

            switch (c) {
                case "show":
                    shop.show();
                    break;

                case "add":
                    System.out.println("введите id товара: ");
                    int id = sc.nextInt();
                    shop.put(id);
                    break;

                case "cart":
                    shop.showCart();
                    break;

                case "buy":
                    if (shop.getCart().size() == 0) {
                        System.out.println("Ваша корзина пуста!");
                    } else {
                        System.out.println("введите сумму: ");
                        int sum = sc.nextInt();
                        shop.buy(user.getId(), sum);
                    }
                    break;

                case "rem":
                    if (shop.getCart().size() == 0) {
                        System.out.println("Ваша корзина пуста!");
                    } else {
                        System.out.println("введите id товара: ");
                        int prId = sc.nextInt();
                        shop.remove(prId);
                    }
                case "exit":
                    break;
            }
        }
    }
}