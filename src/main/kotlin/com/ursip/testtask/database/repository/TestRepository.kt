package com.ursip.testtask.database.repository

import com.ursip.testtask.database.entity.Test
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TestRepository: CrudRepository<Test, UUID>