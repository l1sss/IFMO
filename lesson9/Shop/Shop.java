package lesson9.Shop;

import lesson4.linkedList.LinkedList;
import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

/**
 * Created by l1s on 02.04.17.
 */

/////////////////////////////////////////////////// SHOP ///////////////////////////////////////////////////////////////
public class Shop {
    private List stock;
    private List cart;
    private List transaction;
    private int cartPrice = 0;
    private int balance = 0;

    public Shop() {
        this.stock = new LinkedList();
        this.cart = new ArrayList();
        this.transaction = new ArrayList();
    }

    //добавить товар в магазин
    public void add(Product p) {
        if (stock.get(p) == null) {
            stock.add(p);

            return;
        }
        ((Product)stock.get(p)).setQty(((Product)stock.get(p)).getQty() + p.getQty()); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    //добавить товар в корзину
    public void put(int id) {
        for (Object o : stock) {
            if (((Product) o).getId() == id) {
                cart.add(o);
                cartPrice += ((Product) o).getPrice();
                System.out.println("Товар добавлен в корзину");
                return;
            }
        }
        System.out.println("Товара нет в наличии");
    }

    //удалить из корзины
    public void remove(int id) {
        for (Object o : cart) {
            if (((Product)o).getId() == id) {
                cart.remove(o);
                cartPrice -= ((Product)o).getPrice();
                System.out.println("Товар удалён из корзины");
                return;
            }
        }
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

    //просмотр магазина
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
