package com.github.eniltonangelim.ggbank.usecases.transaction.impl

import com.github.eniltonangelim.ggbank.entities.account.model.AccountTransfer
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.entities.account.port.DepositOperation
import com.github.eniltonangelim.ggbank.entities.account.port.WithdrawOperation
import com.github.eniltonangelim.ggbank.entities.transaction.model.TransactionType
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import com.github.eniltonangelim.ggbank.usecases.transaction.TransactionUsecase
import java.math.BigDecimal

class TransactionUsecaseImpl() : TransactionUsecase {


    private lateinit var accountRepository: AccountRepository
    private lateinit var transactionRepository: TransactionRepository

    override fun getAccount(accountNumber: AccountNumber) = accountRepository.findByAccountNumber(accountNumber)


    override fun transfer(
        value: BigDecimal,
        type: TransactionType,
        accountWithdrawOperation: AccountNumber,
        accountDepositOperation: AccountNumber
    ) {

        val accountWithdraw = getAccount(accountWithdrawOperation)
        val accountDeposit = getAccount(accountDepositOperation)
        // TODO: valis is exists account

        // TODO: transactions types

        AccountTransfer.transfer(value, accountWithdraw, accountDeposit)

        accountRepository.save(accountWithdraw)
        accountRepository.save(accountDeposit)
    }
}