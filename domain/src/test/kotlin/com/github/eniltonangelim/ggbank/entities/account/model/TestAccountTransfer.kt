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

@DisplayName("Account Transfer Validation")
class TestAccountTransfer {

    private val hundred = BigDecimal(100)
    private val fifty = BigDecimal(50)
    private val hundredFifty = BigDecimal(150)

    private lateinit var accountWithdraw: Account
    private lateinit var accountDeposit: Account

    @BeforeEach
    fun prepare() {
        accountWithdraw = Account(AccountNumber(10), Balance(hundred), Name("Angelim"))
        accountDeposit = Account(AccountNumber(20), Balance(hundred), Name("Carlos"))
    }

    @Test
    @DisplayName("transferir R$ 150 sem saldo suficiente")
    fun test0() {
        try {
            val accountTransferCommand = AccountTransferCommand(Balance(hundredFifty), accountWithdraw, accountDeposit)
            accountTransferCommand.execute()
            assertEquals(
                hundred.subtract(hundredFifty),
                accountWithdraw.balance.get(),
                "Saldo da conta debito deve ser igual ao valor esperado"
            )
            assertEquals(
                hundred.add(hundredFifty),
                accountDeposit.balance.get(),
                "Saldo da conta credito deve ser igual ao valor esperado"
            )
            fail("A conta debito nao tem saldo suficiente")
        } catch (e: AccountException) {
            assertEquals("Account balance is insufficient", e.message)
        }

    }

    @Test
    @DisplayName("transferir  R$ 50")
    fun test1() {
        try {
            val accountTransferCommand = AccountTransferCommand(Balance(fifty), accountWithdraw, accountDeposit)
            accountTransferCommand.execute()
            assertEquals(
                hundred.subtract(fifty),
                accountWithdraw.balance.get(),
                "Saldo da conta debito deve ser igual ao valor esperado"
            )
            assertEquals(
                hundred.add(fifty),
                accountDeposit.balance.get(),
                "Saldo da conta credito deve ser igual ao valor esperado"
            )
        } catch (e: AccountException) {
            fail("Deve transferir com sucesso")
        }
    }

}
