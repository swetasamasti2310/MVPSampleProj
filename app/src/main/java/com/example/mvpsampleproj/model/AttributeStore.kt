package com.example.mvpsampleproj.model

object AttributeStore {
    val INTELLIGENCE: List<AttributeValue> by lazy {
        val avatars = mutableListOf<AttributeValue>()
        avatars.add(AttributeValue("none"))
        avatars.add(AttributeValue("Aristotle", 3))
        avatars.add(AttributeValue("Newton", 7))
        avatars.add(AttributeValue("Einstein", 10))
        avatars
    }

    val STRENGTH: List<AttributeValue> by lazy {
        val avatars = mutableListOf<AttributeValue>()
        avatars.add(AttributeValue("none"))
        avatars.add(AttributeValue("Thor", 3))
        avatars.add(AttributeValue("Hulk", 7))
        avatars.add(AttributeValue("Hercules", 10))
        avatars
    }

    val ENDURENCE: List<AttributeValue> by lazy {
        val avatars = mutableListOf<AttributeValue>()
        avatars.add(AttributeValue("none"))
        avatars.add(AttributeValue("Aluminium", 3))
        avatars.add(AttributeValue("Gold", 7))
        avatars.add(AttributeValue("Iron", 10))
        avatars
    }
}