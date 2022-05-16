package net.pixnet.videoplayer

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.button.MaterialButton
import net.pixnet.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application, VideoRepository())
        ).get(MainViewModel::class.java)

        viewModel.fetchVideo()
    }

    private fun initView() {
        val adapter = VideoAdapter(this, list)
        binding.vpVideo.adapter = adapter
        binding.vpVideo.addOnPageChangeListener(listener)
    }

    val listener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {}

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(p0: Int) {
            // TODO: playVideo 
        }
    }

    fun setAvatar(videoId:String){
        val avatarUrl = "http://storage.googleapis.com/usr-framy/headshot/{$videoId}.jpg"

    }

    fun setplaceHolder(videoId:String){
        val holderUrl = "http://storage.googleapis.com/pst-framy/stk/{$videoId}.jpg"
    }
    
    fun playVideo(videoId:String) {
        val url = "http://storage.googleapis.com/pst-framy/vdo/{$videoId}.mp4"
        val mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare() // might take long! (for buffering, etc)
            start()
        }
    }
}