package lesson9.Shop;

import java.util.Scanner;

/**
 * Created by l1s on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(3); //создаём магазинчик

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
                "add        добавить в корзину\n" +
                "cart       просмотр корзины\n" +
                "buy        совершить покупку\n" +
                "exit       выход\n");
        System.out.println(builder);

        //добавляем товар в корзину
        while (true) {
            String c = sc.nextLine();

            if (c.equals("show")) shop.show();

            else if (c.equals("add")) {
                System.out.println("введите id товара: ");
                int id = sc.nextInt();
                shop.put(id);
            }
            else if (c.equals("cart")) shop.showCart();

            else if (c.equals("buy")) {
                System.out.println("введите свой id: ");
                int id = sc.nextInt();
                System.out.println("введите сумму: ");
                int sum = sc.nextInt();
                shop.buy(id, sum);
            }
            else if (c.equals("exit")) break;
        }
    }
}