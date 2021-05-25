package kotlin.com.github.eniltonangelim.ggbank.application.configuration

import com.github.eniltonangelim.ggbank.entities.account.port.AccountRepository
import com.github.eniltonangelim.ggbank.entities.transaction.port.TransactionRepository
import org.koin.dsl.module

val fakeRepositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl() }
    single<TransactionRepository> { TransactionRepositoryImpl() }
}