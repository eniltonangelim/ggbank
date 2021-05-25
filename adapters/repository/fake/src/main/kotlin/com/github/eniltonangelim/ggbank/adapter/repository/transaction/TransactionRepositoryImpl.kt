package com.github.eniltonangelim.ggbank.adapter.repository.transaction

import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.transaction.model.Transaction
import com.github.eniltonangelim.ggbank.entities.transaction.model.value_objects.TransactionId
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import java.util.*

class TransactionRepositoryImpl : TransactionRepository {

    private val db: MutableMap<UUID, Transaction> = mutableMapOf(
    )

    override fun save(transaction: Transaction): TransactionId {
        val id = transaction.id
        this.db.put(id.get(), transaction)
        return id
    }

    override fun findAllByAccountNumber(accountNumber: AccountNumber): List<Transaction> {
        return this.db
            .mapValues { (key, value) -> value }
            .filterValues { it.accountNumber.equals(accountNumber) }
            .values
            .toList()
    }
}