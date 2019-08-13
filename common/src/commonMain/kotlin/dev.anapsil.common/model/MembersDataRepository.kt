package dev.anapsil.common.model

import dev.anapsil.common.network.GitHubApi
import dev.anapsil.common.network.UpdateProblem
import dev.anapsil.common.presentation.DataRepository

class MembersDataRepository(private val api:GitHubApi): DataRepository {

    override var members: List<Member>? = null

    override var onRefreshListeners: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause:Throwable) {
            throw UpdateProblem()
        }

        if (newMembers != members) {
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners() {
        onRefreshListeners.forEach {
            it()
        }
    }
}