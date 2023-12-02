package com.wei.picquest.feature.contactme.contactme

import com.wei.picquest.core.base.Action
import com.wei.picquest.core.base.State

sealed class ContactMeViewAction : Action {
    object Call : ContactMeViewAction()
}

data class ContactMeViewState(
    val nameTw: String = "N/A",
    val nameEng: String = "N/A",
    val position: String = "N/A",
    val phone: String = "N/A",
    val linkedinUrl: String = "N/A",
    val email: String = "N/A",
    val timeZone: String = "N/A",
) : State
