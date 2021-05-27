package com.github.eniltonangelim.ggbank.usecases.transaction

import com.github.eniltonangelim.ggbank.entities.account.model.Account
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO

interface TransactionUsecase {
    fun getAccount(accountNumber: AccountNumber): Account
    fun transfer(registerTransaction: RegisterTransactionRequestDTO)
}