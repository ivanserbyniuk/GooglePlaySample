package com.googleplay.ivan.googleplay.billing;


import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClient.SkuType;
import java.util.Arrays;
import java.util.List;

/**
 * Static fields and methods useful for billing
 */
public final class BillingConstants {
    // SKUs for our products: the premium upgrade (non-consumable) and gas (consumable)
    public static final String SKU_PREMIUM = "premium";
    public static final String SKU_GAS = "gas";

    // SKU for our subscription (infinite gas)
    public static final String SKU_GOLD_MONTHLY = "gold_monthly";
    public static final String SKU_GOLD_YEARLY = "gold_yearly";

    private static final String[] IN_APP_SKUS = {SKU_GAS, SKU_PREMIUM};
    private static final String[] SUBSCRIPTIONS_SKUS = {SKU_GOLD_MONTHLY, SKU_GOLD_YEARLY};

    private BillingConstants(){}

    /**
     * Returns the list of all SKUs for the billing type specified
     */
    public static List<String> getSkuList(@BillingClient.SkuType String billingType) {
        return (billingType == SkuType.INAPP) ? Arrays.asList(IN_APP_SKUS)
                : Arrays.asList(SUBSCRIPTIONS_SKUS);
    }
}

