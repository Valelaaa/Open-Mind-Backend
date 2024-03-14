package com.example.openmindbackend.repository

interface BaseRepository<T> {
    fun fetchById(id: String): T
    fun fetchAll(): List<T>
    fun contains(entity: T): Boolean
    fun updateEntity(entity: T)
}