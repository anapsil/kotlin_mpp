package dev.anapsil.common.presentation

import dev.anapsil.common.model.Member

interface DataRepository {
    val members: List<Member>?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()
}