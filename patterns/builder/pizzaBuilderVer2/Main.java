package patterns.builder.pizzaBuilderVer2;
/**
 * Created by l1s on 23.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Pizza2 studPizza = new Pizza2.Builder(Pizza2.DOUGH.LAYERED, Pizza2.CHEEZE.RUSSIAN, Pizza2.SOUCE.MAZIK)
                .addComponents("Tomato", "Pepper", "Spice")
                .build();

        Pizza2 luxPizza = new Pizza2.Builder(Pizza2.DOUGH.SOLID, Pizza2.CHEEZE.MASCARPONE, Pizza2.SOUCE.BBQ)
                .addComponents("Bacon", "Olive", "Spice")
                .build();

        System.out.println(studPizza);
    }
}
