package com.github.eniltonangelim.ggbank.application.configuration

import com.github.eniltonangelim.ggbank.adapter.repository.account.AccountRepositoryImpl
import com.github.eniltonangelim.ggbank.adapter.repository.transaction.TransactionRepositoryImpl
import com.github.eniltonangelim.ggbank.controller.TransactionController
import com.github.eniltonangelim.ggbank.controller.impl.TransactionRestController
import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import com.github.eniltonangelim.ggbank.usecases.transaction.TransactionUsecase
import com.github.eniltonangelim.ggbank.usecases.transaction.impl.TransactionUsecaseImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

private class ConfigurationInjectModule {

}

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl() }
    single<TransactionRepository> { TransactionRepositoryImpl() }
}

val usecasesModule = module {
    single<TransactionUsecase> { TransactionUsecaseImpl(get()) }
}

val controllerModule = module {
    single<TransactionController> { TransactionRestController(get()) }
}

fun startInject() {
    startKoin {
        modules(listOf(repositoryModule, usecasesModule, controllerModule))
    }
}