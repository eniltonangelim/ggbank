package com.github.eniltonangelim.ggbank.entities.account.model.value_objects

data class AccountNumber(private val value: Int) {
    fun get() = value
}