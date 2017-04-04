package lesson9.Shop;

/**
 * Created by l1s on 02.04.17.
 */
public class Product {
    private int id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.id = Math.abs(name.hashCode() % 10_000);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "арт." + id +
                "   " + name +
                "   цена=" + price;
    }
}
