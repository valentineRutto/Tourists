package com.valentinerutto.tourists.di

import org.koin.dsl.module

private const val BASE_URL =
    "http://restapi.adequateshop.com/api"

val networkingModule = module {}
val databaseModule = module {}
val repositoryModule = module {}
val viewModelModule = module {}