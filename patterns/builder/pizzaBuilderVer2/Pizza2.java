package patterns.builder.pizzaBuilderVer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by l1s on 23.04.17.
 */
public class Pizza2 {

    private final DOUGH dough;
    private final CHEEZE cheeze;
    private final SOUCE souce;
    private final Collection<String> components;

    enum DOUGH {SOLID, LAYERED}
    enum CHEEZE {RUSSIAN, MASCARPONE}
    enum SOUCE {MAZIK, BBQ}

    public static class Builder {

        //обязательные параметры
        private final DOUGH dough;
        private final CHEEZE cheeze;
        private final SOUCE souce;
        private Collection<String> components = null;

        public Builder(DOUGH dough, CHEEZE cheeze, SOUCE souce) {
            this.dough = dough;
            this.cheeze = cheeze;
            this.souce = souce;
        }

        public Builder addComponents(String... val) {
            if (components == null)
                components = new ArrayList<>();
            components.addAll(Arrays.asList(val));

            return this;
        }

        public Pizza2 build() {
            return new Pizza2(this);
        }
    }

        private Pizza2(Builder builder) {
            dough = builder.dough;
            cheeze = builder.cheeze;
            souce = builder.souce;
            components = builder.components;
        }

    @Override
    public String toString() {
        return "Pizza2{" +
                "dough=" + dough +
                ", cheeze=" + cheeze +
                ", souce=" + souce +
                ", components=" + components +
                '}';
    }
}
