package collections.shop;

/**
 * Created by l1s on 07.04.17.
 */
public class CartProduct {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public CartProduct(int id, String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPice() {
        return price;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "арт." + id +
                "   " + name +
                "   цена=" + price + "$ " +
                quantity + "шт.";
    }
}
