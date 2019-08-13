package dev.anapsil.common.presentation

import dev.anapsil.common.model.Member

interface MembersView : BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: List<Member>)
}