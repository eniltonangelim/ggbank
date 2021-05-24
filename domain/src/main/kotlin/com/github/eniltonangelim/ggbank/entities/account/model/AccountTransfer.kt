package com.github.eniltonangelim.ggbank.entities.account.model

import com.github.eniltonangelim.ggbank.entities.account.port.DepositOperation
import com.github.eniltonangelim.ggbank.entities.account.port.WithdrawOperation
import java.math.BigDecimal

open class AccountTransfer {
    companion object {
         fun transfer(
            value: BigDecimal,
            accountWithdrawOperation: WithdrawOperation,
            accountDepositOperation: DepositOperation
        ) {
            accountWithdrawOperation.withdrawal(value)
            accountDepositOperation.deposit(value)
        }
    }
}