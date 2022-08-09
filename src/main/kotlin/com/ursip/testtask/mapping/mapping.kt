package com.ursip.testtask.mapping

import com.ursip.testtask.database.entity.Dictionary
import com.ursip.testtask.database.entity.Document
import com.ursip.testtask.database.entity.Test
import com.ursip.testtask.dto.DictionaryDto
import com.ursip.testtask.dto.DocumentDto
import com.ursip.testtask.dto.TestDto

fun Test.toDto(): TestDto =
    TestDto(
        name = this.name,
        document = if (this.document != null) DocumentDto(this.document!!.date) else null,
        dictionary = if (this.dictionary != null) DictionaryDto(this.dictionary!!.name) else null
    )

fun TestDto.toTest(): Test =
    Test(
        name = this.name,
        document = if (this.document != null) Document(date = this.document.date) else null,
        dictionary = if (this.dictionary != null) Dictionary(name = this.dictionary.name) else null
    )

fun Test.refresh(testDto: TestDto): Test {
    name = testDto.name

    if (testDto.document != null)
        document = document?.also { it.date = testDto.document.date } ?: Document(date = testDto.document.date)
    else
        document = null

    if (testDto.dictionary != null)
        dictionary = dictionary?.also { it.name = testDto.dictionary.name } ?: Dictionary(name = testDto.dictionary.name)
    else
        dictionary = null

    return this
}

