package com.example.ivan.googleplaysamples.billing

import android.content.Context
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener

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

    }



}