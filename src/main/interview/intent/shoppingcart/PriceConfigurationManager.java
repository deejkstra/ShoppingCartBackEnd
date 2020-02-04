package interview.intent.shoppingcart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class PriceConfigurationManager {

    private static final String PRICE_CONFIG_PATH = "src/main/resources/static/priceConfig.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Getter
    private List<PriceConfiguration> priceConfigurations;

    private Map<String, PriceConfiguration> priceConfigurationMap;

    public PriceConfigurationManager() {
        try {
            priceConfigurations = objectMapper.readValue(
                    new File(PRICE_CONFIG_PATH),
                    new TypeReference<List<PriceConfiguration>>(){});
            log.info(priceConfigurations.toString());

            priceConfigurationMap = priceConfigurations.stream()
                    .collect(Collectors.toMap(PriceConfiguration::getId, e -> e));
            log.info(priceConfigurationMap.toString());
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public Set<String> getIds() {
        return priceConfigurationMap.keySet();
    }

    public PriceConfiguration getPriceConfiguration(String id) {
        return priceConfigurationMap.get(id);
    }
}
