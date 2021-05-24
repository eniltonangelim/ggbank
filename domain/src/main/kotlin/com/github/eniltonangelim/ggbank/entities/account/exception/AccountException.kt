package com.github.eniltonangelim.ggbank.entities.account.exception

import java.lang.Exception

open class AccountException(override val message: String) : Exception(message)

@Throws(AccountException::class)
fun required(field: String) { throw AccountException("$field is required") }

fun insufficientBalance() {
    throw AccountException("Account balance is insufficient")
}