package com.valentinerutto.tourists.util

import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.data.remote.model.newfeedlist.NewsFeedListResponse

class Mapper {
    fun mapToDomainModel(model:NewsFeedListResponse):List<NewsFeedEntity>{
        val result =
            model.data.map {
                NewsFeedEntity(id = it.id, commentCount = it.commentCount,
                    title = it.title, description = it.description,
                    userName = it.user.name, userPPic = it.user.profilepicture,)}
        return result
    }
}