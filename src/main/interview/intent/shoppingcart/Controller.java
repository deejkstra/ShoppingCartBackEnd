package interview.intent.shoppingcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @Resource
    ShoppingCartManager shoppingCartManager;

    @Resource
    PriceConfigurationManager priceConfigurationManager;

    @GetMapping(value = "/createShoppingCart", produces = "application/json")
    @ResponseBody
    public UUID createShoppingCart() {
        return shoppingCartManager.createCart();
    }

    @GetMapping(value = "/addToCart", produces = "application/json")
    @ResponseBody
    public void addToCart(@RequestParam String cartId,
                                          @RequestParam String itemId) {
        UUID id = UUID.fromString(cartId);
        shoppingCartManager.addToCart(id, itemId);
    }

    @GetMapping(value = "/getCartItems", produces = "application/json")
    @ResponseBody
    public Map<String, Integer> getCartItems(@RequestParam String cartId) {
        UUID id = UUID.fromString(cartId);
        return shoppingCartManager.getCartContents(id);
    }

    @GetMapping(value = "/getTotalPrice", produces = "application/json")
    @ResponseBody
    public Double getTotalPrice(@RequestParam String cartId) {
        return shoppingCartManager.getTotalPrice(UUID.fromString(cartId));
    }

    @GetMapping(value = "/clearCart", produces = "application/json")
    @ResponseBody
    public void clearCart(@RequestParam String cartId) {
        shoppingCartManager.clearCart(UUID.fromString(cartId));
    }

    @GetMapping(value = "/getShoppingCarts", produces = "application/json")
    @ResponseBody
    public Set<UUID> getShoppingCart() {
        return shoppingCartManager.getShoppingCarts();
    }

    @GetMapping(value = "/getInventory", produces = "application/json")
    @ResponseBody
    public List<PriceConfiguration> getInventory() {
        return priceConfigurationManager.getPriceConfigurations();
    }
}
