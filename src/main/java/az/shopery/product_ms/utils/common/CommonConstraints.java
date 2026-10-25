package az.shopery.product_ms.utils.common;

import az.shopery.product_ms.utils.enums.SubscriptionTier;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConstraints {

    public static final int BASIC_MAX_PRODUCTS_PER_MONTH = 5;
    public static final int STANDARD_MAX_PRODUCTS_PER_MONTH = 20;
    public static final int PREMIUM_MAX_PRODUCTS_PER_MONTH = Integer.MAX_VALUE;

    public static final Map<SubscriptionTier, Integer> MAX_PRODUCTS_PER_MONTH_BY_TIER = Map.of(
            SubscriptionTier.BASIC, BASIC_MAX_PRODUCTS_PER_MONTH,
            SubscriptionTier.STANDARD, STANDARD_MAX_PRODUCTS_PER_MONTH,
            SubscriptionTier.PREMIUM, PREMIUM_MAX_PRODUCTS_PER_MONTH
    );
}
