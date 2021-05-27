package com.github.eniltonangelim.ggbank.controller.impl

import com.github.eniltonangelim.ggbank.controller.TransactionController
import com.github.eniltonangelim.ggbank.usecases.transaction.TransactionUsecase
import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(TransactionRestController.PATH)
class TransactionRestController(val transactionUsecase: TransactionUsecase) : TransactionController {

    companion object {
        internal const val PATH = "/transaction"
    }

    @PostMapping
    override fun transfer(transactionRequestDTO: RegisterTransactionRequestDTO) {
        transactionUsecase.transfer(transactionRequestDTO)
    }

}