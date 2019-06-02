package com.example.mvpsampleproj.presenter

import androidx.lifecycle.LiveData
import com.example.mvpsampleproj.model.Creature
import com.example.mvpsampleproj.model.CreatureRepository
import com.example.mvpsampleproj.model.room.RoomRepository

class AllCreaturesPresenter(
    private val repository: CreatureRepository = RoomRepository()
) : BasePresenter<AllCreaturesContract.View>(), AllCreaturesContract.Presenter {


    override fun getAllCreatures(): LiveData<List<Creature>> {
        return repository.getAllCreatures()
    }

    override fun clearAllCreatures() {
        repository.clearAllCreatures()
        getView()?.showCreaturesCleared()
    }

}