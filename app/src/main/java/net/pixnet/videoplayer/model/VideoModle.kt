package net.pixnet.videoplayer.model


import com.google.gson.annotations.SerializedName

data class VideoModle(
    @SerializedName("p")
    val p: List<P>
)