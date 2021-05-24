package com.github.eniltonangelim.ggbank.adapter.repository

import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import org.koin.dsl.module

val fakeRepositoryModule = module {
    single<AccountRepository> { AccountFakeRepositoryImpl() }
}