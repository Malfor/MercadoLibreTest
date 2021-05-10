package com.rodolfo.domain.model

import com.rodolfo.domain.BaseTest
import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_NICK_NAME
import org.junit.Assert
import org.junit.Test

class ShopTest : BaseTest() {

    @Test
    fun createShopSuccessful() {
        //Arrange - Act
        val shop = Shop(nickName = nickname)
        //Assert
        Assert.assertNotNull(shop)
    }

    @Test
    fun createShopWithoutNickName() {
        //Arrange
        nickname = null
        //Act
        try {
            Shop(nickName = nickname)
        } catch (ex: WrongFieldException) {
            //Assert
            Assert.assertEquals(ERROR_NICK_NAME,ex.message)
        }
    }

    @Test
    fun createShopNickNameEmpty() {
        //Arrange
        nickname = ""
        //Act
        try {
            Shop(nickName = nickname)
        } catch (ex: WrongFieldException) {
            //Assert
            Assert.assertEquals(ERROR_NICK_NAME, ex.message)
        }
    }
}