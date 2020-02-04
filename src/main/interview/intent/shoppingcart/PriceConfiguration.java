package interview.intent.shoppingcart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class PriceConfiguration {
    @JsonProperty("id") private final String id;
    @JsonProperty("description") private final String description;
    @JsonProperty("unit_price") private final double unitPrice;
    @JsonProperty("volume_discounts") private final List<VolumeDiscount> volumeDiscounts;

    @AllArgsConstructor
    @Getter
    @ToString
    static class VolumeDiscount {
        @JsonProperty("number") private final int number;
        @JsonProperty("price") private final double price;
    }

    public double getPrice(int count) {
        if (volumeDiscounts.isEmpty()) {
            return unitPrice * count;
        }

        VolumeDiscount volumeDiscount = volumeDiscounts.get(0);

        int volume = count / volumeDiscount.getNumber();
        int remaining = count % volumeDiscount.getNumber();

        return volume * volumeDiscount.getPrice() + remaining * unitPrice;
    }
}
