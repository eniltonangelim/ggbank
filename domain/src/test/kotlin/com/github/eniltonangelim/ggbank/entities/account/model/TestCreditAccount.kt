package com.github.eniltonangelim.ggbank.entities.account.model

import com.github.eniltonangelim.ggbank.entities.account.exception.AccountException
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.math.BigDecimal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName


@DisplayName("Credit Account Validation")
class TestCreditAccount {

    val messageExpected = "credit is required"
    private var hundred: BigDecimal = BigDecimal(100)
    private lateinit var account: Account

    @BeforeEach
    fun prepare() {
        account = Account(AccountNumber(1), Balance(hundred), Name("Angelim"))
    }

    @Test
    @DisplayName("valor de credito negativo como obrigatorio")
    fun test0() {
        try {
            account.deposit(BigDecimal(-10))
            fail(messageExpected)
        } catch (e: AccountException) {
            assertEquals(messageExpected, e.message)
        }
    }

    @Test
    @DisplayName("valor de credito zero como obrigatorio")
    fun test1() {
        try {
            account.deposit(BigDecimal.ZERO)
            fail(messageExpected)
        } catch (e: AccountException) {
            assertEquals(messageExpected, e.message)
        }
    }

    @Test
    @DisplayName("valor de credito acima de zero")
    fun test2() {
        try {
            account.deposit(BigDecimal.ONE)
            val balance = hundred.add(BigDecimal.ONE)
            assertEquals(balance, account.balance.get(), "Saldo deve ser igual")
        } catch (e: AccountException) {
            fail("Deve creditar com sucesso - ${e.message}" )
        }
    }

}