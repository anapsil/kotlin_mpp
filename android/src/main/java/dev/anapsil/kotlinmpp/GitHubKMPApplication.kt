package dev.anapsil.kotlinmpp

import android.app.Application
import dev.anapsil.common.model.MembersDataRepository
import dev.anapsil.common.network.GitHubApi
import dev.anapsil.common.presentation.DataRepository

class GitHubKMPApplication : Application() {

    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GitHubApi())
    }
}