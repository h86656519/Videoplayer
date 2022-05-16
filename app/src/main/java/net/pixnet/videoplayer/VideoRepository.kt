package net.pixnet.videoplayer

import net.pixnet.videoplayer.http.ApiManager
import net.pixnet.videoplayer.http.VideoApi

class VideoRepository {
    private val apiManager: ApiManager = ApiManager.getInstance()

    fun fetchRemoteVideo(): VideoApi {
        return apiManager.getVideoApiRetrofit()
    }

}