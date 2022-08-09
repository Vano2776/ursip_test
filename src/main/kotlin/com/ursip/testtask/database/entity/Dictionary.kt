package com.ursip.testtask.database.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dictionary")
class Dictionary(

    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "name")
    var name: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Dictionary

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Dictionary(id=$id, name=$name)"
    }
}