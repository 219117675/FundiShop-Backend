package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.Listing;
import za.ac.cput.domain.Storefront;
import za.ac.cput.domain.enums.TradeCategory;

public final class ListingFactory {

    private ListingFactory() {
    }

    public static Listing create(Storefront storefront, String name, String description,
                                      BigDecimal price, Integer stockQuantity, TradeCategory category,
                                      String imageUrl) {
            return Listing.builder()
                    .storefront(storefront)
                    .name(name)
                    .description(description)
                    .price(price)
                    .stockQuantity(stockQuantity)
                    .category(category)
                    .imageUrl(imageUrl)
                    .build();
        }

}