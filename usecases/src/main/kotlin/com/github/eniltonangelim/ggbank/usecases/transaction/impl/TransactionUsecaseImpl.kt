package com.github.eniltonangelim.ggbank.usecases.transaction.impl

import com.github.eniltonangelim.ggbank.entities.account.model.AccountTransferCommand
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.usecases.transaction.TransactionUsecase
import com.github.eniltonangelim.ggbank.usecases.transaction.dto.RegisterTransactionRequestDTO

class TransactionUsecaseImpl(val accountRepository: AccountRepository) : TransactionUsecase {

    override fun getAccount(accountNumber: AccountNumber) =
        accountRepository.findByAccountNumber(accountNumber)

    override fun transfer(registerTransaction: RegisterTransactionRequestDTO) {
        val value = Balance(registerTransaction.value)
        val accountWithdraw = getAccount(AccountNumber(registerTransaction.accountToWithdraw))
        val accountDeposit = getAccount(AccountNumber(registerTransaction.accountToDeposit))
        val transferCommand = AccountTransferCommand(value, accountWithdraw, accountDeposit)

        transferCommand.execute()
        accountRepository.save(accountWithdraw)
        accountRepository.save(accountDeposit)
    }
}