package it.reti.percorsi.school.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import it.reti.percorsi.school.db.PopulateDb.generateClassrooms
import it.reti.percorsi.school.db.PopulateDb.generateStudentsClassA
import it.reti.percorsi.school.db.PopulateDb.generateStudentsClassB
import it.reti.percorsi.school.db.PopulateDb.generateStudentsClassC
import it.reti.percorsi.school.db.PopulateDb.generateStudentsClassD
import it.reti.percorsi.school.db.PopulateDb.generateStudentsClassE
import it.reti.percorsi.school.db.converter.ClassroomConverter

import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student

@Database(entities = [Classroom::class, Student::class], version = 1)
@TypeConverters(ClassroomConverter::class)
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
                        /*val synchroRequest = PeriodicWorkRequestBuilder<PopulateDbWorker>(30, TimeUnit.SECONDS)
                            .build()
                        WorkManager.getInstance(context!!).enqueue(synchroRequest)*/
                        getDatabase(context).schoolDao().insertStudents(generateStudentsClassA())
                        getDatabase(context).schoolDao().insertStudents(generateStudentsClassB())
                        getDatabase(context).schoolDao().insertStudents(generateStudentsClassC())
                        getDatabase(context).schoolDao().insertStudents(generateStudentsClassD())
                        getDatabase(context).schoolDao().insertStudents(generateStudentsClassE())
                        getDatabase(context).schoolDao().insertClassrooms(generateClassrooms())
                    }
                }).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}