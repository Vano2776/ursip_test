package com.ursip.testtask.database.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "test")
class Test(

    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "name")
    var name: String? = "test",

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "document_id")
    var document: Document? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "dictionary_id")
    var dictionary: Dictionary? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Test

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Test(id=$id, name=$name, document=$document, dictionary=$dictionary)"
    }
}