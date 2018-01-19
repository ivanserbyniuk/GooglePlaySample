package com.play.ivan.googleplay.billing

import android.content.Context
import com.android.billingclient.api.*
import com.android.billingclient.api.BillingClient.BillingResponse
import com.android.billingclient.api.BillingClient.SkuType




/**
 * Created by ivan on 1/18/18.
 */
class Billing(context: Context) : PurchasesUpdatedListener {

    var billingClient: BillingClient = BillingClient.newBuilder(context).setListener(this).build()
            .apply {
                startConnection(object : BillingClientStateListener {
                    override fun onBillingServiceDisconnected() {

                    }

                    override fun onBillingSetupFinished(responseCode: Int) {

                    }
                })
            }

    override fun onPurchasesUpdated(responseCode: Int, purchases: MutableList<Purchase>?) {
        if (responseCode == BillingResponse.OK && purchases != null) {
            for (purchase in purchases) {
                //handlePurchase(purchase)
            }
        } else if (responseCode == BillingResponse.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
        } else {
            // Handle any other error codes.
        }
    }


    fun query() {
        val skuList = listOf ("premium_upgrade","gas" )
        val params = SkuDetailsParams.newBuilder()
        params.setSkusList(skuList).setType(SkuType.INAPP)
        billingClient.querySkuDetailsAsync(params.build(), ::onQuerySuccess)
    }

    private fun onQuerySuccess(responseCode: Int, skuDetailsList: List<SkuDetails>) {


    }


}