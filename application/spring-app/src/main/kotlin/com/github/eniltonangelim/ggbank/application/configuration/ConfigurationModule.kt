package com.github.eniltonangelim.ggbank.application.configuration

import com.github.eniltonangelim.ggbank.adapter.repository.account.AccountRepositoryImpl
import com.github.eniltonangelim.ggbank.adapter.repository.transaction.TransactionRepositoryImpl
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import org.koin.core.context.startKoin
import org.koin.dsl.module

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl() }
    single<TransactionRepository> { TransactionRepositoryImpl() }
}

fun startInject() {
    startKoin {
        modules(listOf(repositoryModule))
    }
}