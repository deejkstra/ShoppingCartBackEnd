package interview.intent.shoppingcart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class ShoppingCart {

    @Getter
    private final UUID id = UUID.randomUUID();

    @Getter
    private final Map<String, Integer> cart = new HashMap<>();

    public void add(String itemId) {
        cart.putIfAbsent(itemId, 0);
        cart.put(itemId, cart.get(itemId) + 1);
    }

    public double getTotalPrice(Function<String, PriceConfiguration> priceConfigurationFunc) {
        double total = 0.0;
        for (String key : cart.keySet()) {
            int count = cart.get(key);
            PriceConfiguration priceConfiguration = priceConfigurationFunc.apply(key);
            total += priceConfiguration.getPrice(count);
        }
        return total;
    }

    public void reset() {
        this.cart.clear();
    }
}
