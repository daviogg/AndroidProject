package it.reti.percorsi.school.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import it.reti.percorsi.school.db.entities.ClassroomType

class ClassroomConverter {

    @TypeConverter
    fun listToJson(value: List<Int>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Int>? {
        val objects = Gson().fromJson(value, Array<Int>::class.java) as Array<Int>
        return objects.toList()
    }

    @TypeConverter
    fun listToJsonType(value: ClassroomType?): String {
        return value.toString()
    }

    @TypeConverter
    fun jsonToListType(value: String): ClassroomType? {
        return enumValueOf<ClassroomType>(value)
    }



}