package com.meu.runningapp.data.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {
    //this function convert a ByteArray into Bitmap, possibiliting to show the image on app.
    @TypeConverter
    fun toBitmap(bytes:ByteArray):Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

    //this function convert a bitmap into ByteArray, possibiliting to save the image in the ROOM.
    @TypeConverter
    fun fromBitmap(bmp:Bitmap) : ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }
}