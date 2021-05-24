package com.github.eniltonangelim.ggbank.entities.account.port

import com.github.eniltonangelim.ggbank.entities.account.model.Account
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber

interface AccountRepository {

    fun save(account: Account): AccountNumber
    fun findByAccountNumber(accountNumber: AccountNumber): Account

}