package patterns.builder.pizzaBuilderVer1;

/**
 * Created by l1s on 21.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Cook cook = new Cook();

        PizzaBuilder studPizzaBuilder = new StudentPizzaBuilder();

        cook.setPizzaBuilder(studPizzaBuilder);
        cook.cookPizza();

        Pizza studPizza = cook.getPizza();

        System.out.println(studPizza);


        PizzaBuilder luxPizzaBuilder = new LuxuryPizzaBuilder();

        cook.setPizzaBuilder(luxPizzaBuilder);
        cook.cookPizza();

        Pizza luxPizza = cook.getPizza();

        System.out.println(luxPizza);
    }
}
