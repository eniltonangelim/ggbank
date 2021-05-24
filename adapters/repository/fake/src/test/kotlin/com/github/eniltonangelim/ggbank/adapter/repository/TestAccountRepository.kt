package com.github.eniltonangelim.ggbank.adapter.repository

import com.github.eniltonangelim.ggbank.entities.account.model.Account
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import java.math.BigDecimal
import kotlin.test.assertEquals


class TestAccountRepository : KoinTest {

    private val hundred = BigDecimal(100)
    private val accountNumber = AccountNumber(10)
    private val accountNumberCreatedExpected = AccountNumber(30)
    private lateinit var account: Account
    private lateinit var accountCreatedExpected: Account

    val repository by inject<AccountRepository>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(fakeRepositoryModule)
    }

    @BeforeEach
    fun prepare() {
        startKoin {
            modules(listOf(fakeRepositoryModule))
        }
        account = Account(AccountNumber(10), Balance(hundred), Name("Angelim"))
        accountCreatedExpected = Account(AccountNumber(30), Balance(hundred), Name("Carlos"))
    }

    @AfterEach
    fun after(){
        stopKoin()
    }

    @Test
    @DisplayName("Recupera a conta com ID 10")
    fun test0() {
        val accountFake = repository.findByAccountNumber(accountNumber)
        assertEquals(account.accountNumber, accountFake.accountNumber, "A conta deve ser igual")
    }

    @Test
    @DisplayName("Cria a conta Carlos")
    fun test1() {
        repository.save(accountCreatedExpected)
        val accountCreated = repository.findByAccountNumber(accountNumberCreatedExpected)
        assertEquals(accountCreatedExpected.accountNumber, accountCreated.accountNumber, "A conta deve ser igual")
    }


}