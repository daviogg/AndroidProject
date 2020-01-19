package it.reti.percorsi.school.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager

import it.reti.percorsi.school.db.converter.DataConverter
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Exam
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.synchro.PopulateDbWorker
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.TimeUnit

@Database(entities = [Classroom::class, Student::class, Exam::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

    companion object {


        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getDatabase(context: Context): SchoolDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_database"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // moving to a new thread
                        val synchroRequest = PeriodicWorkRequestBuilder<PopulateDbWorker>(30, TimeUnit.SECONDS)
                            .build()
                        WorkManager.getInstance(context!!).enqueue(synchroRequest)
                    }
                }).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}