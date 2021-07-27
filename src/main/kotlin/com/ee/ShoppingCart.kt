package com.ee

import java.math.BigDecimal
import java.math.RoundingMode

class ShoppingCart(
    val tax: BigDecimal = BigDecimal(0)
) {
    private val products = mutableListOf<Product>()

    fun add(product: Product) {
        this.products.add(product)
    }

    private fun getCartCostPreTax(): BigDecimal {
        return products.fold(BigDecimal(0), { acc, it -> acc.plus(it.price.multiply(it.quantity)) }).setScale(2, RoundingMode.HALF_UP)
    }

    fun totalCost(): BigDecimal {
        val acc = getCartCostPreTax()
        val amountIncTax = acc.multiply(tax.divide(BigDecimal(100)))
        return acc.add(amountIncTax).setScale(2, RoundingMode.HALF_UP)
    }

    fun totalTax(): BigDecimal {
        val acc = getCartCostPreTax()
        val taxAmount = acc.multiply(tax.divide(BigDecimal(100)))
        return taxAmount.setScale(2, RoundingMode.HALF_UP)
    }
}
