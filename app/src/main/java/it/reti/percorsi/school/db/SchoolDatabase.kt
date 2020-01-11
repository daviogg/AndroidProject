package it.reti.percorsi.school.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import it.reti.percorsi.school.db.converter.DataConverter
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Exam
import it.reti.percorsi.school.db.entities.Student

@Database(entities = [Classroom::class, Student::class, Exam::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

    companion object {
        @Volatile
        private var instance: SchoolDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = databaseBuilder(
            context,
            SchoolDatabase::class.java, "school.db"
        ).build()
    }
}