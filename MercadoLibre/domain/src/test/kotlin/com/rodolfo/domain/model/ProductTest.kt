package com.rodolfo.domain.model

import com.rodolfo.domain.BaseTest
import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_AVAILABLE_QUANTITY
import com.rodolfo.domain.utils.ERROR_ID
import com.rodolfo.domain.utils.ERROR_PRICE
import com.rodolfo.domain.utils.ERROR_TITLE
import org.junit.Assert
import org.junit.Test

class ProductTest : BaseTest() {

    @Test
    fun createProductSuccessful() {
        // Arrange - Act
        val product = Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
        )
        //Assert
        Assert.assertNotNull(product)
    }

    @Test
    fun createProductWithoutId() {
        // Arrange
        idStrig = null
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_ID, ex.message)
        }
    }

    @Test
    fun createProductIdEmpty() {
        // Arrange
        idStrig = ""
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_ID, ex.message)
        }
    }

    @Test
    fun createProductWithoutTitle() {
        // Arrange
        title = null
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_TITLE, ex.message)
        }
    }

    @Test
    fun createProductTitleEmpty() {
        // Arrange
        title = ""
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_TITLE, ex.message)
        }
    }

    @Test
    fun createProductWithoutPrice() {
        // Arrange
        price = null
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_PRICE, ex.message)
        }
    }

    @Test
    fun createProductWithoutAvailableQuantity() {
        // Arrange
        availableQuantity = null
        // Act
        try {
            Product(
                id = idStrig,
                title = title,
                seller = Seller(id = idInt, shop = Shop(nickName = nickname)),
                price = price,
                availableQuantity = availableQuantity,
                attributes = listOf(Attributes(name = name, valueName = valueName))
            )
        } catch (ex: WrongFieldException) {
            // Assert
            Assert.assertEquals(ERROR_AVAILABLE_QUANTITY, ex.message)
        }
    }

}