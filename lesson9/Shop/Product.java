package lesson9.Shop;

/**
 * Created by l1s on 02.04.17.
 */
public class Product {
    private int id;
    private String name;
    private int price;
    private int qty;

    public Product(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.id = Math.abs(name.hashCode() % 10_000);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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
        return  "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", qty=" + qty;
    }
}
