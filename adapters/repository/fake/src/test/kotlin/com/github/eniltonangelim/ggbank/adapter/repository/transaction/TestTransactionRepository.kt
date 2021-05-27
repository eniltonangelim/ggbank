package com.github.eniltonangelim.ggbank.adapter.repository.transaction


import com.github.eniltonangelim.ggbank.adapter.repository.fakeRepositoryModule
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.transaction.model.Transaction
import com.github.eniltonangelim.ggbank.entities.transaction.model.TransactionType
import com.github.eniltonangelim.ggbank.entities.transaction.model.value_objects.TransactionId
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals


@DisplayName("Transaction Repository Validation")
class TestTransactionRepository : KoinTest {

    private val transactionIdExpected: TransactionId = TransactionId()
    private val accountNumber = AccountNumber(10)
    private lateinit var transaction: Transaction

    val repository by inject<TransactionRepository>()

    @BeforeEach
    fun prepare() {
        startKoin {
            modules(listOf(fakeRepositoryModule))
        }

        transaction = Transaction(
            transactionIdExpected,
            Date(),
            accountNumber,
            "Compra no Uber",
            TransactionType.PURCHASE,
            BigDecimal(30),
            BigDecimal(70)
        )
    }

    @AfterEach
    fun after() {
        stopKoin()
    }

    @Test
    @DisplayName("Recupera extrato bancario da conta 10")
    fun test0() {
        repository.save(transaction)
        val transactions = repository.findAllByAccountNumber(accountNumber)
        val transactionCreated =  transactions.find { it.id == transactionIdExpected }

        assertEquals(transactionIdExpected, transactionCreated?.id, "O identificador deve ser igual")
    }

}