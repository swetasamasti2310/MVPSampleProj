package com.example.mvpsampleproj.presenter

import androidx.lifecycle.LiveData
import com.example.mvpsampleproj.model.Creature

class AllCreaturesContract {

    interface Presenter {
        fun getAllCreatures(): LiveData<List<Creature>>
        fun clearAllCreatures()
    }

    interface View {
        fun showCreaturesCleared()
    }

}