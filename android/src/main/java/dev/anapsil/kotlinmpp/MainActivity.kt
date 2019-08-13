package dev.anapsil.kotlinmpp

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dev.anapsil.common.model.Member
import dev.anapsil.common.network.UpdateProblem
import dev.anapsil.common.presentation.MembersPresenter
import dev.anapsil.common.presentation.MembersView

class MainActivity : AppCompatActivity(), MembersView {

    private val repository by lazy { (application as GitHubKMPApplication).dataRepository }
    private val presenter by lazy { MembersPresenter(this, repository) }

    private val memberAdapter = MemberAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recycler_view).adapter = memberAdapter

        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override var isUpdating = false

    override fun onUpdate(members: List<Member>) {
        memberAdapter.members = members
        runOnUiThread {
            memberAdapter.notifyDataSetChanged()
        }
    }

    override fun showError(error: Throwable) {
        val errorMessage = when (error) {
            is UpdateProblem -> "Failed to get data from server, please check your internet connection"
            else -> "Unknown error"
        }

        Toast.makeText(this, errorMessage, LENGTH_SHORT).show()
    }
}