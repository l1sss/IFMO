package collections.shop;

import collections.linkedList.LinkedList;
import collections.linkedList.List;
import collections.arrayList.ArrayList;

import java.util.Scanner;

/**
 * Created by l1s on 02.04.17.
 */

/////////////////////////////////////////////////// SHOP ///////////////////////////////////////////////////////////////
public class Shop {
    private List<Product> stock;
    private List<CartProduct> cart;
    private List<Transaction> transaction;
    private int cartPrice;
    private int balance;

    public Shop() {
        this.stock = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.transaction = new ArrayList<>();
    }

    public List getCart() {
        return cart;
    }

    //добавить товар в магазин
    public void putToShop(String name, int price, int quantity) {
        Product p = new Product(name, price, quantity);
        if (stock.get(p) != null) {
            (stock.get(p)).setQuantity((stock.get(p).getQuantity() + quantity));
        }else
            stock.add(p);
    }

    //добавить товар в корзину
    public void putToCart(int id, int quantity) {
        if (id < 0 || id > stock.size()) {
            System.out.println("Некорректный id!");

            return;
        }
        if (quantity < 1 || stock.get(id).getQuantity() < quantity) {
            System.out.println("Некорректный запрос кол-ва");

            return;
        }
        Product p = stock.get(id);

        if (getFromCart(id) != null) {
            if ((p.getQuantity() + quantity) > stock.get(p).getQuantity()) {
                System.out.println("Недоступное количество!");

                return;
            }
            p.setQuantity(p.getQuantity() + quantity);
            cartPrice += p.getPrice() * quantity;

            return;
        }
        cart.add(new CartProduct(id, p.getName(), p.getPrice(), quantity));
        cartPrice += getFromCart(id).getPrice() * quantity;
        System.out.println("Товар добавлен в корзину");
    }

    //взять товар из корзины по id
    public CartProduct getFromCart(int id) {
        for (CartProduct cp : cart) {
            if (cp.getId() == id) return cp;
        }
        return null;
    }

    /*//удалить из корзины
    public void removeFromCart(int id) {
        for (Product tmp : cart) {
            Product p = (Product) o;
            if (p.getId() == id) {
                cart.remove(o);
                cartPrice -= p.getPrice();
                stock.add(o);
                System.out.println("Товар удалён из корзины");
                return;
            }
        }
        System.out.println("Товара с таким id нет в корзине");
    }*/

    //просмотр корзины
    public void showCart() {
        System.out.println("============ Корзина ==============");
        for (CartProduct p : cart) {
            System.out.println(p);
        }
        System.out.println("===================================");
        System.out.println("Стоимость корзины: " + cartPrice);
    }

    //покупка
    public void buy(int usrId, int price) {
        if (price < cartPrice) {
            System.out.println("Недостаточно средств");

            return;
        }
        for (CartProduct cp : cart) {
            stock.get(cp.getId()).setQuantity(stock.get(cp.getId()).getQuantity() - cp.getQuantity());
        }
        transaction.add(new Transaction(usrId, cartPrice));
        balance += cartPrice;
        cartPrice = 0;
        cart = new LinkedList<>();
        System.out.println("Спасибо за покупку!");
    }

    //просмотр магазина
    public void show() {
        if (stock.size() == 0) {
            System.out.println("Магазин пуст, ждём привоза.");

            return;
        }
        for (Product p : stock)
            System.out.println(p);
    }

    //юзерфрендли интерфейс =)
    public void letsShopping() {
        //логинимся
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя: ");
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
                    System.out.println("введите кол-во: ");
                    int qty = sc.nextInt();
                    putToCart(id, qty);
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
                        //removeFromCart(prId);
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
//================================================== USER ==============================================================
    public static class User {
        private int id;
        private static int usrID = 1;
        private String name;

        public User(String name) {
            this.name = name;
            this.id = usrID++;
            System.out.println("Привет " + name + "! Твой id: " + id);
        }

        public int getId() {
            return id;
        }
    }
}
