package com.github.eniltonangelim.ggbank.usecases.transaction.dto

import com.github.eniltonangelim.ggbank.entities.transaction.model.TransactionType
import java.math.BigDecimal

data class RegisterTransactionRequestDTO(
    val value: BigDecimal,
    val type: TransactionType,
    val accountToWithdraw: Int,
    val accountToDeposit: Int
) {

}