package com.github.eniltonangelim.ggbank.entities.account.port

import java.math.BigDecimal

interface WithdrawOperation {
    fun withdrawal(
        debit: BigDecimal
    )
}