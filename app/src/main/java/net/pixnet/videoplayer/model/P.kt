package net.pixnet.videoplayer.model


import com.google.gson.annotations.SerializedName

data class P(
    @SerializedName("at")
    val at: Long,
    @SerializedName("att")
    val att: Att,
    @SerializedName("count")
    val count: List<Int>,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("is_prv")
    val isPrv: String,
    @SerializedName("p_stk")
    val pStk: List<List<Any>>,
    @SerializedName("plc")
    val plc: List<String>,
    @SerializedName("private")
    val `private`: List<Any>,
    @SerializedName("reply")
    val reply: List<List<Any>>,
    @SerializedName("source")
    val source: List<Any>
)