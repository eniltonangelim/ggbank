package com.github.eniltonangelim.ggbank.application


import com.github.eniltonangelim.ggbank.application.configuration.repositoryModule
import org.junit.Rule

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@DisplayName("Test Application")
@SpringBootTest
class TestApplication : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(repositoryModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }



    @Test
    @DisplayName("Test a dependencias do repositorio")
    fun test0() {
//
    }

}