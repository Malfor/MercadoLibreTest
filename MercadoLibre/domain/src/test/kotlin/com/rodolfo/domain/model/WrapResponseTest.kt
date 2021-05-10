package com.rodolfo.domain.model

import com.rodolfo.domain.BaseTest
import com.rodolfo.domain.utils.ERROR_NICK_NAME
import org.junit.Assert
import org.junit.Test

class WrapResponseTest : BaseTest() {

    @Test
    fun createWrapResponseWithData() {
        //Arrange - Act
        val wrapResponse = WrapResponse<Product>(data = product)
        //Assert
        Assert.assertNotNull(wrapResponse.data)
    }

    @Test
    fun createWrapResponseWithError() {
        //Arrange - Act
        val wrapResponse = WrapResponse<Product>(error = ERROR_NICK_NAME)
        //Assert
        Assert.assertEquals(ERROR_NICK_NAME, wrapResponse.error)
    }

}