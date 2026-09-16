package za.ac.cput.factory;

import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.Storefront;

public final class StorefrontFactory {

    private StorefrontFactory() {
    }

    public static Storefront create(FundiProfile fundiProfile, String name, String logoUrl,
                                          String description, String serviceArea) {
            return Storefront.builder()
                    .fundiProfile(fundiProfile)
                    .name(name)
                    .logoUrl(logoUrl)
                    .description(description)
                    .serviceArea(serviceArea)
                    .build();
        }

}