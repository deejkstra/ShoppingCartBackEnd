package interview.intent.shoppingcart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.function.Function;

@Slf4j
public class ShoppingCartManager {
    private final Map<UUID, ShoppingCart> shoppingCartMap = new HashMap<>();

    @Autowired
    PriceConfigurationManager priceConfigurationManager;

    public UUID createCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartMap.put(shoppingCart.getId(), shoppingCart);
        return shoppingCart.getId();
    }

    public Set<UUID> getShoppingCarts() {
        return shoppingCartMap.keySet();
    }

    public void addToCart(UUID id, String itemId) {
        shoppingCartMap.get(id).add(itemId);
    }

    public double getTotalPrice(UUID id) {
        Function<String, PriceConfiguration> priceConfigurationFunc =
                (itemId) -> priceConfigurationManager.getPriceConfiguration(itemId);

        return shoppingCartMap.get(id).getTotalPrice(priceConfigurationFunc);
    }

    public Map<String, Integer> getCartContents(UUID id) {
        return shoppingCartMap.get(id).getCart();
    }

    public void clearCart(UUID id) {
        shoppingCartMap.get(id).reset();
    }
}
