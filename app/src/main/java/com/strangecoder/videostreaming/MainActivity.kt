package com.strangecoder.videostreaming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.strangecoder.videostreaming.databinding.ActivityMainBinding
import com.strangecoder.videostreaming.network.RetrofitService.retrofitService
import com.strangecoder.videostreaming.network.model.Video
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val videoList = MutableLiveData<List<Video>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*lifecycleScope.launch {
            val result = retrofitService.getPopularVideosAsync().await()
            videoList.value = result
        }

        videoList.observe(this) {
            binding.videoViewPager.adapter = ViewPagerVideoAdapter(it)
        }*/

        var list : ArrayList<Video> = ArrayList()
        list.add(Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))
        list.add(Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"))
        list.add(Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"))
        list.add(Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"))
        list.add(Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"))
        binding.videoViewPager.adapter = ViewPagerVideoAdapter(list)
    }
}