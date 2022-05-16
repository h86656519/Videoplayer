package net.pixnet.videoplayer.http

import io.reactivex.rxjava3.core.Observable
import net.pixnet.videoplayer.model.VideoModle
import retrofit2.http.GET

interface VideoApi {

    @GET("/test1.0/backstage/exm1")
    fun video(): Observable<VideoModle>
}