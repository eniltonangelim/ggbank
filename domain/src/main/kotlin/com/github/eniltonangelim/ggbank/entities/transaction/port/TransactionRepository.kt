package com.github.eniltonangelim.ggbank.entities.transaction.port

import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.transaction.model.Transaction
import com.github.eniltonangelim.ggbank.entities.transaction.model.value_objects.TransactionId

interface TransactionRepository {
    fun save(transaction: Transaction): TransactionId
    fun findAllByAccountNumber(accountNumber: AccountNumber): List<Transaction>
}