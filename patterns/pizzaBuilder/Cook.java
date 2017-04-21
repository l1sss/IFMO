package patterns.pizzaBuilder;

/**
 * Created by l1s on 21.04.17.
 */
public class Cook {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void cookPizza() {
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildComponents();
        pizzaBuilder.buildCheeze();
        pizzaBuilder.buildSouce();
    }
}
