package com.github.eniltonangelim.ggbank.entities.account.model

import com.github.eniltonangelim.ggbank.entities.account.exception.AccountException
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.math.BigDecimal

@DisplayName("Debit Account Validation")
class TestDebitAccount {

    private val messageExpected = "debit is required"
    private val hundred = BigDecimal(100)
    private lateinit var account: Account


    @BeforeEach
    fun prepare() {
        account = Account(AccountNumber(1), Balance(hundred), Name("Angelim"))
    }

    @Test
    @DisplayName("valor de debito zero como obrigatorio")
    fun test0() {
        try {
            account.withdrawal(BigDecimal(0))
            fail("fail: 4messageExpected")
        } catch (e: AccountException) {
            assertEquals(messageExpected, e.message)
        }
    }

    @Test
    @DisplayName("valor de debito negativo como obrigatorio")
    fun test1() {
        try {
            account.withdrawal(BigDecimal(-10))
            fail("fail: $messageExpected")
        } catch (e: AccountException) {
            assertEquals(messageExpected, e.message)
        }
    }

    @Test
    @DisplayName("valor debito maior que o saldo")
    fun test2() {
        try {
            account.withdrawal(hundred.add(BigDecimal.ONE))
            fail("fail: $messageExpected")
        } catch (e: AccountException) {
            assertEquals("Account balance is insufficient", e.message)
        }
    }

    @Test
    @DisplayName("valor debito igual a saldo")
    fun test3() {
        try {
            account.withdrawal(hundred)
            assertEquals(BigDecimal.ZERO, account.balance.get(), "Saldo deve zerar")
        } catch (e: AccountException) {
            fail("deve debitar com sucesso - ${e.message}")
        }
    }

    @Test
    @DisplayName("valor debito menor que saldo")
    fun test4() {
        try {
            account.withdrawal(BigDecimal.TEN)
            var expected = hundred.subtract(BigDecimal.TEN)
            assertEquals(expected, account.balance.get(), "Saldo deve bater")
        } catch (e: AccountException) {
            fail("deve debitar com sucesso - ${e.message}")
        }
    }

}