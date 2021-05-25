package com.github.eniltonangelim.ggbank.adapter.repository.account

import com.github.eniltonangelim.ggbank.entities.account.model.Account
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.AccountNumber
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Balance
import com.github.eniltonangelim.ggbank.entities.account.model.value_objects.Name
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import java.math.BigDecimal

class AccountFakeRepositoryImpl : AccountRepository {

    private val db = mutableMapOf(
        10 to Account(AccountNumber(10), Balance(BigDecimal(100)), Name("Angelim")),
        20 to Account(AccountNumber(20), Balance(BigDecimal(100)), Name("Carlos"))
    )

    override fun save(account: Account): AccountNumber {
        val id = account.accountNumber
        this.db.put(id.get(), account)
        return id
    }

    override fun findByAccountNumber(accountNumber: AccountNumber): Account {
        val id = accountNumber
        return this.db.get(id.get())!!
    }

}