package com.ee

import com.ee.Product
import com.ee.ShoppingCart
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode


class UnitTest {

    @Test
    fun `story 1`() {

        //given
        val cart = ShoppingCart()

        //when
        val product = Product("Dove Soap", BigDecimal(39.99), BigDecimal(5))
        cart.add(product)

        //then
        assertThat(cart.totalCost(), `is`(equalTo(BigDecimal(199.95).setScale(2, RoundingMode.HALF_UP))) )
    }

    @Test
    fun `story 2`() {

        //given
        val cart = ShoppingCart()

        //when
        val product1 = Product("Dove Soap", BigDecimal(39.99), BigDecimal(5))
        cart.add(product1)
        val product2 = Product("Dove Soap", BigDecimal(39.99),  BigDecimal(3))
        cart.add(product2)

        //then
        assertThat(cart.totalCost(), `is`(equalTo(BigDecimal(319.92).setScale(2, RoundingMode.HALF_UP))) )

    }

    @Test
    fun `story 3`() {

        //given
        val cart = ShoppingCart(BigDecimal(12.5))

        //when
        val product1 = Product("Dove Soap", BigDecimal(39.99), BigDecimal(2))
        cart.add(product1)
        val product2 = Product("Axe Deo", BigDecimal(99.99), BigDecimal(2))
        cart.add(product2)

        //then
        assertThat(cart.totalCost(), `is`(equalTo(BigDecimal(314.96).setScale(2, RoundingMode.HALF_UP))) )
        assertThat(cart.totalTax(), `is`(equalTo(BigDecimal(35.00).setScale(2, RoundingMode.HALF_UP))) )

    }

}
