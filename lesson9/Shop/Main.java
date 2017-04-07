package lesson9.Shop;

/**
 * Created by l1s on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(); //создаём магазинчик

        //добавляем товары в магазин
        shop.putToShop("cat Barsik", 0, 1);
        shop.putToShop("Axe", 29, 10);
        shop.putToShop("RPG", 1200, 2);
        shop.putToShop("Axe", 29, 11);

        //шопимся
        shop.letsShopping();
    }
}