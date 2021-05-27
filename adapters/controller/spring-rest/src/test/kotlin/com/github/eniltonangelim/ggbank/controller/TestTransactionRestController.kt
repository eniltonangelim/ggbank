package com.github.eniltonangelim.ggbank.controller

import com.github.eniltonangelim.ggbank.entities.transaction.model.TransactionType
import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO
import org.junit.jupiter.api.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class TestTransactionRestController {

    @Autowired
    lateinit var restTemplate: TestRestTemplate
    lateinit var registerTransactionRequestDTO: RegisterTransactionRequestDTO

    @BeforeEach
    fun prepare() {
        registerTransactionRequestDTO = RegisterTransactionRequestDTO(
            BigDecimal(30),
            TransactionType.WITHDRAWL,
            10,
            20
        )
    }



    @DisplayName("Valida o endpoint da transferencia")
    fun test0() {
        try {
            restTemplate.postForEntity("/transfer", registerTransactionRequestDTO, Unit::class.java)
        } catch (e: Exception) {
            fail("Deve transferir com sucesso - ${e.message}")
        }


    }

}