package patterns.builder.pizzaBuilderVer1;

import java.util.Collection;
import java.util.TreeSet;


public class Pizza {
    private Dough dough;
    private Cheeze cheeze;
    private Souce souce;
    private Collection<String> components;

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setCheeze(Cheeze cheeze) {
        this.cheeze = cheeze;
    }

    public void setSouce(Souce souce) {
        this.souce = souce;
    }

    public void setComponents(Collection<String> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", cheeze=" + cheeze +
                ", souce=" + souce +
                ", components=" + components +
                '}';
    }
}

abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizza() {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildCheeze();
    public abstract void buildSouce();
    public abstract void buildComponents();
}

class StudentPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough(Dough.LAYERED);
    }

    @Override
    public void buildCheeze() {
        pizza.setCheeze(Cheeze.RUSSIAN);
    }

    @Override
    public void buildSouce() {
        pizza.setSouce(Souce.MAZIK);
    }

    @Override
    public void buildComponents() {
        Collection<String> components = new TreeSet<>();
        components.add("tomato");
        components.add("dill");

        pizza.setComponents(components);
    }
}

class LuxuryPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough(Dough.SOLID);
    }

    @Override
    public void buildCheeze() {
        pizza.setCheeze(Cheeze.MASCARPONE);
    }

    @Override
    public void buildSouce() {
        pizza.setSouce(Souce.BBQ);
    }

    @Override
    public void buildComponents() {
        Collection<String> components = new TreeSet<>();
        components.add("bacon");
        components.add("tomato");
        components.add("onion");
        components.add("olives");

        pizza.setComponents(components);
    }
}