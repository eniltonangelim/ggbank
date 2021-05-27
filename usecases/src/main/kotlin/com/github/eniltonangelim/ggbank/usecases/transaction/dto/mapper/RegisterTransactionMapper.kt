package com.github.eniltonangelim.ggbank.usecases.transaction.dto.mapper

import com.github.eniltonangelim.ggbank.entities.account.model.Account
import com.github.eniltonangelim.ggbank.entities.account.model.AccountTransferCommand
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO

fun RegisterTransactionRequestDTO.toCommand(): AccountTransferCommand {
    return AccountTransferCommand(
        Balance(value),
        Account(AccountNumber(accountToWithdraw), Balance(), Name()),
        Account(AccountNumber(accountToDeposit), Balance(), Name())
    )
}