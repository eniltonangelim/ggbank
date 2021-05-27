package com.github.eniltonangelim.ggbank.entities.account.model

import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance

data class AccountTransferCommand(
    val value: Balance,
    val accountWithdrawOperation: Account,
    val accountDepositOperation: Account
) {

    fun execute() {
        accountWithdrawOperation.withdrawal(value.get())
        accountDepositOperation.deposit(value.get())
    }

}