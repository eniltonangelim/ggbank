package com.github.eniltonangelim.ggbank.entities.account.port

import java.math.BigDecimal

interface DepositOperation {
    fun deposit(credit: BigDecimal)
}