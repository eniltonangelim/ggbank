package com.github.eniltonangelim.ggbank.entities.transaction.model

import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.transaction.model.value_objects.TransactionId
import java.math.BigDecimal
import java.util.*

class Transaction(
    val id: TransactionId,
    val date: Date,
    val accountNumber: AccountNumber,
    val describe: String,
    val type: TransactionType,
    val amount: BigDecimal,
    val postBalance: BigDecimal
)