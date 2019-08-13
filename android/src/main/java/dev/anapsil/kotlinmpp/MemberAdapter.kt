package dev.anapsil.kotlinmpp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.anapsil.common.model.Member

class MemberAdapter(var members: List<Member>) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MemberViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_member, parent, false)
    )

    override fun getItemCount() = members.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) = holder.bind(members[position])

    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(member: Member) {
            Picasso.get()
                .load(member.avatarUrl)
                .into(itemView.findViewById<ImageView>(R.id.member_avatar))
            itemView.findViewById<TextView>(R.id.member_login).text = member.login
        }
    }
}