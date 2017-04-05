package lesson9.Shop;

import lesson4.linkedList.LinkedList;
import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

import java.util.Scanner;

/**
 * Created by l1s on 02.04.17.
 */

/////////////////////////////////////////////////// SHOP ///////////////////////////////////////////////////////////////
public class Shop {
    private List stock;
    private List cart;
    private List transaction;
    private int cartPrice;
    private int balance;

    public Shop() {
        this.stock = new LinkedList();
        this.cart = new ArrayList();
        this.transaction = new ArrayList();
    }

    //юзерфрендли интерфейс =)
    public void letsShopping() {
        //логинимся
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String s = sc.nextLine();
        User user = new Shop.User(s);

        StringBuilder builder = new StringBuilder();
        builder.append("\nСписок команд:\n" +
                "show       посмотреть доступные товары\n" +
                "add        добавить в корзину\n" +
                "cart       просмотр корзины\n" +
                "rm         удалить товар из корзины\n" +
                "buy        совершить покупку\n" +
                "exit       выход\n");
        System.out.println(builder);

        //смотрим магазин
        System.out.println("Наши товары:");
        show();
        System.out.println("*********************************************************");

        //собственно сам консольный интерфейс...
        while (true) {
            String c = sc.nextLine();

            switch (c) {
                case "show":
                    show();
                    break;

                case "add":
                    System.out.println("введите id товара: ");
                    int id = sc.nextInt();
                    putToCart(id);
                    break;

                case "cart":
                    showCart();
                    break;

                case "buy":
                    if (getCart().size() == 0) {
                        System.out.println("Ваша корзина пуста!");
                    } else {
                        System.out.println("введите сумму: ");
                        int sum = sc.nextInt();
                        buy(user.getId(), sum);
                    }
                    break;

                case "rm":
                    if (getCart().size() == 0) {
                        System.out.println("Ваша корзина пуста!");
                    } else {
                        System.out.println("введите id товара: ");
                        int prId = sc.nextInt();
                        removeFromCart(prId);
                    }
                    break;

                case "trans":
                    for (Object o : transaction)
                        System.out.println(o);
                    break;

                case "exit":
                    return;
            }
        }
    }

    //добавить товар в магазин
    public void putToShop(String name, int price) {
        Product p = new Product(name, price);
        stock.add(p);
    }

    //добавить товар в корзину
    public void putToCart(int id) {
        for (Object o : stock) {
            if (((Product) o).getId() == id) {
                cart.add(o);
                cartPrice += ((Product) o).getPrice();
                stock.remove(o);
                System.out.println("Товар добавлен в корзину");
                return;
            }
        }
        System.out.println("Товара нет в наличии");
    }

    //удалить из корзины
    public void removeFromCart(int id) {
        for (Object o : cart) {
            if (((Product)o).getId() == id) {
                cart.remove(o);
                cartPrice -= ((Product)o).getPrice();
                stock.add(o);
                System.out.println("Товар удалён из корзины");
                return;
            }
        }
        System.out.println("Товара с таким id нет в корзине");
    }

    //просмотр корзины
    public void showCart() {
        System.out.println("============ Корзина ==============");
        for (Object o : cart) {
            System.out.println(o);
        }
        System.out.println("===================================");
        System.out.println("Стоимость корзины: " + cartPrice);
    }

    //покупка
    public void buy(int usrId, int price) {
        if (price < cartPrice) System.out.println("Недостаточно средств");
        else {
            transaction.add(new Transaction(usrId, cartPrice));
            balance += cartPrice;
            cartPrice = 0;
            cart = new ArrayList();
            System.out.println("Спасибо за покупку!");
        }
    }

    public List getCart() {
        return cart;
    }

    //просмотр магазина
    public void show() {
        if (stock.size() == 0) {
            System.out.println("Магазин пуст, ждём привоза.");

            return;
        }
        for (Object o : stock)
            System.out.println(o);
    }

//================================================== USER ==============================================================
    public static class User {
        private int id;
        private String name;

        public User(String name) {
            this.name = name;
            this.id = Math.abs(name.hashCode());
            System.out.println("Привет " + name + "! Твой id: " + id);
        }

        public int getId() {
            return id;
        }
    }
}
