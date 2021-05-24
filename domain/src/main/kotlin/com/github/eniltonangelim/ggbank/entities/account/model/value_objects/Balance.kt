package com.github.eniltonangelim.ggbank.entities.account.model.value_objects

import com.github.eniltonangelim.ggbank.entities.account.exception.insufficientBalance
import com.github.eniltonangelim.ggbank.entities.account.exception.required
import java.math.BigDecimal

data class Balance(private var balance: BigDecimal = BigDecimal.ZERO) {
    fun get() = balance
    fun add(credit: BigDecimal) {
        if (credit.compareTo(BigDecimal.ZERO) <= 0)
            required("credit")

        balance = balance.add(credit)
    }

    fun subtract(debit: BigDecimal) {
        if (debit.compareTo(BigDecimal.ZERO) <= 0)
            required("debit")

        if (debit.compareTo(balance) > 0)
            insufficientBalance()

        balance = balance.subtract(debit)
    }
}