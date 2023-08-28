package com.valentinerutto.tourists.util

interface Paginator<Key,Item> {
   suspend fun loadNextItems()
   suspend fun reset()
}