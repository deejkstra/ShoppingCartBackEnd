package interview.intent.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ShoppingcartApplicationTests {

	@Autowired
	ShoppingCartManager shoppingCartManager;

	@Test
	void test_totalPrice_v1() {
		UUID uuid = shoppingCartManager.createCart();
		String input = "ABCDABAA";

		input.chars()
				.mapToObj(id -> Character.toString((char) id))
				.forEach(id -> shoppingCartManager.addToCart(uuid, id));

		double expectedPrice = 32.4;
		Assertions.assertTrue(shoppingCartManager.getTotalPrice(uuid) == expectedPrice);
	}

	@Test
	void test_totalPrice_v2() {
		UUID uuid = shoppingCartManager.createCart();
		String input = "CCCCCCC";

		input.chars()
				.mapToObj(id -> Character.toString((char) id))
				.forEach(id -> shoppingCartManager.addToCart(uuid, id));

		double expectedPrice = 7.25;
		Assertions.assertTrue(shoppingCartManager.getTotalPrice(uuid) == expectedPrice);
	}

	@Test
	void test_totalPrice_v3() {
		UUID uuid = shoppingCartManager.createCart();
		String input = "ABCD";

		input.chars()
				.mapToObj(id -> Character.toString((char) id))
				.forEach(id -> shoppingCartManager.addToCart(uuid, id));

		double expectedPrice = 15.40;
		Assertions.assertTrue(shoppingCartManager.getTotalPrice(uuid) == expectedPrice);
	}
}
