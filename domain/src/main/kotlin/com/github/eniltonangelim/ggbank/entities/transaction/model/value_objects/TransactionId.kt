package com.github.eniltonangelim.ggbank.entities.transaction.model.value_objects

import java.util.*

data class TransactionId(private val id: UUID = UUID.randomUUID()) {
    fun get() = id
}
