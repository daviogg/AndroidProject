package it.reti.percorsi.school.synchro

import android.content.Context
import androidx.work.WorkerParameters
import androidx.work.Worker
import it.reti.percorsi.school.db.PopulateDb
import it.reti.percorsi.school.db.SchoolDatabase

class PopulateDbWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        val db : SchoolDatabase = SchoolDatabase.buildDatabase(applicationContext)
        db.schoolDao().insertClassrooms(PopulateDb.generateClassrooms())
        return Result.success()
    }
}