package com.github.eniltonangelim.ggbank.adapter.repository

import com.github.eniltonangelim.ggbank.adapter.repository.account.AccountRepositoryImpl
import com.github.eniltonangelim.ggbank.adapter.repository.transaction.TransactionRepositoryImpl
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import org.koin.dsl.module

val fakeRepositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl() }
    single<TransactionRepository> { TransactionRepositoryImpl() }
}