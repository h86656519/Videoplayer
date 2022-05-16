package net.pixnet.videoplayer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import net.pixnet.videoplayer.model.VideoModle

class MainViewModel(application: Application, private val repo: VideoRepository) :
    AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    fun fetchVideo() {
        val weatherDisposable =
            repo.fetchRemoteVideo().video()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { println("資料取得完成") }
                .subscribe({ model: VideoModle ->

                    println("影音資料: ${model.p[0].id}")

                }) { e: Throwable? ->
                    println("影音檔取得失敗 $e")
                }
        compositeDisposable.add(weatherDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}