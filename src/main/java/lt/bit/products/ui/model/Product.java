package lt.bit.products.ui.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
private UUID id = UUID.randomUUID();
private String name;
private BigDecimal price;
private Integer quantity;
}

