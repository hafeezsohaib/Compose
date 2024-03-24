package com.kids.kidapp.soundHandle

import android.content.Context
import android.media.MediaPlayer
import com.kids.kidapp.data.ListData
import java.io.IOException

class SoundManage(context:Context) {
    private var context: Context? = null
    init {
        this.context=context
    }
    fun loadSound(data: ListData): MediaPlayer? {
            val assetManager = context?.assets
            val soundPath = "sounds/${data.sound.categoryName}/${data.sound.fileName}.mp3"

            return try {
                val assetFileDescriptor = assetManager?.openFd(soundPath)
                val mediaPlayer = MediaPlayer()
                if (assetFileDescriptor != null) {
                    mediaPlayer.setDataSource(assetFileDescriptor.fileDescriptor, assetFileDescriptor.startOffset, assetFileDescriptor.length)
                }
                mediaPlayer.prepare()
                mediaPlayer
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }


}