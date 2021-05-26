package com.github.eniltonangelim.ggbank.application.configuration

import org.junit.experimental.categories.Category
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules

@Category(CheckModuleTest::class)
@DisplayName("Valida configuracao de injecao de dependencias")
class TestConfigurationModule : AutoCloseKoinTest() {

    @Test
    @DisplayName("Valida modulo repositorio")
    fun checkModules() = checkModules {
        modules(repositoryModule)
    }

}