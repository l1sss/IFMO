package lesson9.Shop;

import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

/**
 * Created by l1s on 02.04.17.
 */

/////////////////////////////////////////////////// SHOP ///////////////////////////////////////////////////////////////
public class Shop {
    private Product[] stock;
    private List cart;
    private List transaction;
    private int cartPrice = 0;
    private int balance = 0;

    public Shop(int capacity) {
        this.stock = new Product[capacity];
        this.cart = new ArrayList();
        this.transaction = new ArrayList();
    }

    //добавить товар в магазин
    public void add(Product p) {
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] == null) {
                stock[i] = p;

                return;
            }
        }
    }

    //добавить товар в корзину
    public void put(int id) {
        for (Product p : stock) {
            if (p.getId() == id) {
                cart.add(p);
                cartPrice = p.getPrice();
                System.out.println("Товар добавлен в корзину");
                return;
            }
        }
        System.out.println("Товара нет в наличии");
    }

    public void showCart() {
        System.out.println("============ Корзина ==============");
        for (Object o : cart) {
            System.out.println(o);
        }
        System.out.println("===================================");
        System.out.println("Стоимость корзины: " + cartPrice);
    }

    public void buy(int usrId, int price) {
        if (price < cartPrice) System.out.println("Недостаточно средств");
        else {
            transaction.add(new Transaction(usrId, cartPrice));
            balance += cartPrice;
            cartPrice = 0;
            System.out.println("Спасибо за покупку!");
        }
    }

    public int getCartPrice() {
        return cartPrice;
    }

    public void show() {
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
            System.out.println("Ваш id: " + id);
        }

        public int getId() {
            return id;
        }
    }
}
