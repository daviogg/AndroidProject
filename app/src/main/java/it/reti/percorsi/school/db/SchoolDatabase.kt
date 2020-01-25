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
import it.reti.percorsi.school.db.entities.Vote
import java.util.concurrent.Executors

@Database(entities = [Classroom::class, Student::class, Vote::class], version = 7)
@TypeConverters(ClassroomConverter::class)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

    companion object {


        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        fun buildDatabase(context: Context): SchoolDatabase {
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
                        Executors.newSingleThreadExecutor().execute {
                            INSTANCE?.let {
                               /* getInstance(context).schoolDao()
                                    .insertStudents(generateStudentsClassA())
                                getInstance(context).schoolDao()
                                    .insertStudents(generateStudentsClassB())
                                getInstance(context).schoolDao()
                                    .insertStudents(generateStudentsClassC())
                                getInstance(context).schoolDao()
                                    .insertStudents(generateStudentsClassD())
                                getInstance(context).schoolDao()
                                    .insertStudents(generateStudentsClassE())
                                getInstance(context).schoolDao()
                                    .insertClassrooms(generateClassrooms())*/
                            }
                        }
                    }
                }).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}