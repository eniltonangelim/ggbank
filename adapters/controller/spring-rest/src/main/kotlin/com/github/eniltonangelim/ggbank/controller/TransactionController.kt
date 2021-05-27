package com.github.eniltonangelim.ggbank.controller

import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO

interface TransactionController {

    fun transfer(transactionRequestDTO: RegisterTransactionRequestDTO)

}