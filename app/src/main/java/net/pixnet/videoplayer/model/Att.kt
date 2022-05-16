package net.pixnet.videoplayer.model


import com.google.gson.annotations.SerializedName

data class Att(
    @SerializedName("id")
    val id: String,
    @SerializedName("l")
    val l: Int,
    @SerializedName("p_ids")
    val pIds: String,
    @SerializedName("type")
    val type: String
)