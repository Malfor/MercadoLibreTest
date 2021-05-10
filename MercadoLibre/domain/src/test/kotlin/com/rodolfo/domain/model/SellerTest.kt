package com.rodolfo.domain.model

import com.rodolfo.domain.BaseTest
import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_ID
import org.junit.Assert
import org.junit.Test

class SellerTest : BaseTest() {

    @Test
    fun createSellerSuccessful() {
        //Arrange - Act
        val seller = Seller(id = idInt, shop = Shop(nickName = nickname))
        //Assert
        Assert.assertNotNull(seller)
    }

    @Test
    fun createSellerWithoutId() {
        //Arrange
        idInt = null
        //Act
        try {
            Seller(id = idInt, shop = Shop(nickName = nickname))
        } catch (ex: WrongFieldException) {
            //Assert
            Assert.assertEquals(ERROR_ID, ex.message)
        }
    }

}