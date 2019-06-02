package com.example.mvpsampleproj.presenter

import androidx.annotation.DrawableRes
import com.example.mvpsampleproj.model.AttributeType

class CreatureContract {

    interface Presenter {
        fun updateName(name: String)
        fun attributeSelected(attributeType: AttributeType, Position: Int)
        fun drawableSelected(drawable: Int)
        fun isDrawableSelected(): Boolean
        fun saveCreature()
    }

    interface View {
        fun showHitPoints(hitPoints: String)
        fun showAvatarDrawable(@DrawableRes resourceId: Int)
        fun showCreatureSaved()
        fun showCreatureSaveError()
    }
}