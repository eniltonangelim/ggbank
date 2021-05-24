package com.github.eniltonangelim.ggbank.entities.account.model

import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import com.github.eniltonangelim.ggbank.entities.account.port.DepositOperation
import com.github.eniltonangelim.ggbank.entities.account.port.WithdrawOperation
import java.math.BigDecimal

class Account(
    val accountNumber: AccountNumber,
    val balance: Balance,
    val name: Name,
) : WithdrawOperation, DepositOperation {
    override fun deposit(
        credit: BigDecimal
    ) = this.balance.add(credit)

    override fun withdrawal(
        debit: BigDecimal
    ) = this.balance.subtract(debit)
}
