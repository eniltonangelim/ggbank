package com.github.eniltonangelim.ggbank.entities.account.model.value_objects

data class Name(private val value: String = "Whoami") {
    fun get() = value
}