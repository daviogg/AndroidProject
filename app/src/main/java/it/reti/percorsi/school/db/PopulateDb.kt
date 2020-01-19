package it.reti.percorsi.school.db

import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.ClassroomType
import it.reti.percorsi.school.db.entities.Exam
import it.reti.percorsi.school.db.entities.Student
import java.util.*
import kotlin.random.Random

object PopulateDb {

    fun generateClassrooms() : List<Classroom>{

        val classA = Classroom(1, "Scienze", generateStudentsClassA(), ClassroomType.SCIENCE, "A")
        val classB = Classroom(2, "Matematica", generateStudentsClassB(), ClassroomType.MATHEMATICS, "B")
        val classC = Classroom(3, "Arte", generateStudentsClassC(), ClassroomType.ART, "C")
        val classD = Classroom(4, "Letteratura", generateStudentsClassD(), ClassroomType.LITERATURE, "D")
        val classE = Classroom(5, "Astronomia", generateStudentsClassE(), ClassroomType.ASTRONOMY, "E")

        return listOf(classA, classB, classC, classD, classE)
    }

    fun generateStudentsClassA() : List<Student>{

        val galilei = Student(0, "Galileo", "Galilei", generateRandomExams())
        val newton  = Student(1, "Isaac", "Newton", generateRandomExams())
        val darwin = Student(2, "Charles", "Darwin", generateRandomExams())
        val copernico = Student(3, "Nicolo", "Copernico", generateRandomExams())
        val golgi = Student(4, "Camillo", "Golgi", generateRandomExams())
        val fermi = Student(5, "Enrico", "Fermi", generateRandomExams())
        val hack = Student(6, "Margherita", "Hack", generateRandomExams())
        val pasteur = Student(7, "Louis", "Pasteur", generateRandomExams())

        return listOf(galilei, newton, darwin, copernico, golgi, fermi, hack, pasteur)
    }

    fun generateStudentsClassB() : List<Student>{

        val wiles = Student(0, "Andrew", "Wiles", generateRandomExams())
        val fibonacci = Student(1, "Leonardo", "Fibonacci", generateRandomExams())
        val turing = Student(2, "Alan", "Turing", generateRandomExams())
        val euler = Student(3, "Leonard", "Euler", generateRandomExams())
        val gauss = Student(4, "Friedrich", "Gauss", generateRandomExams())
        val riemann = Student(5, "Bernhard", "Riemann", generateRandomExams())

        return listOf(wiles, fibonacci, turing, euler, gauss, riemann)
    }
    fun generateStudentsClassC() : List<Student>{

        val daVinci = Student(0, "Leonardo", "DaVinci", generateRandomExams())
        val buonarroti = Student(1, "Michelangelo", "Buonarroti", generateRandomExams())
        val vanGogh = Student(2, "Vincent", "Van Gogh", generateRandomExams())
        val picasso = Student(3, "Pablo", "Picasso", generateRandomExams())
        val monet  = Student(4, "Claude", "Monet", generateRandomExams())
        val dali = Student(5, "Salvator", "Dali", generateRandomExams())
        val cezanne = Student(6, "Paul", "Cezanne", generateRandomExams())
        val renoir = Student(7, "Auguste", "Renoir", generateRandomExams())
        val goya =  Student(8, "Francisco", "Goya", generateRandomExams())

        return listOf(daVinci, buonarroti, vanGogh, picasso, monet, dali, cezanne, renoir,goya)
    }

    fun generateStudentsClassD() : List<Student>{

        val leopardi = Student(0, "Giacomo", "Leopardi", generateRandomExams())
        val pascoli  = Student(1, "Giovanni", "Pascoli", generateRandomExams())
        val montale = Student(2, "Eugenio", "Montale", generateRandomExams())
        val alighieri = Student(3, "Dante", "Alighieri", generateRandomExams())
        val hesse = Student(4, "Hermann", "Hesse", generateRandomExams())
        val ungaretti = Student(5, "Giuseppe", "Ungaretti", generateRandomExams())
        val petrarca = Student(6, "Francesco", "Petrarca", generateRandomExams())
        val shakespeare = Student(7, "William", "Shakespeare", generateRandomExams())

        return listOf(leopardi, pascoli, montale, alighieri, hesse, ungaretti, petrarca, shakespeare)
    }

    fun generateStudentsClassE() : List<Student>{

        val comolli = Student(0, "Marco", "Comolli", generateRandomExams())
        val oggioni = Student(1, "Davide", "Oggioni", generateRandomExams())
        val rossi = Student(2, "Mario", "Rossi", generateRandomExams())
        val bianchi = Student(3, "Stefano", "Bianchi", generateRandomExams())
        val sgarbossa = Student(4, "Mattia", "Sgarbossa", generateRandomExams())
        val sing = Student(5, "Sing", "Kahlon", generateRandomExams())
        val sanguin = Student(6, "Andrea", "Sanguin", generateRandomExams())
        val gecchele = Student(7, "Mattia", "Gecchele", generateRandomExams())

        return listOf(comolli, oggioni, rossi, bianchi, sgarbossa, sing, sanguin, gecchele)
    }



    private fun generateRandomExams(): List<Exam>{

        val exams : List<Exam> = arrayListOf()

        for (i in 6 downTo 0 step 1){
            val exam = Exam(UUID.randomUUID(), Random.nextInt(1, 10), getRandomQuote())
            exams.toMutableList().add(exam)
        }
        return exams
    }


    private fun getRandomQuote(): String {
        val examNames = listOf("Analisi 1", "Analisi 2", "Biologia", "Scienze", "Alboritmi", "Pittura", "Atomi", "Reti", "Sistemi complessi")
        val randomValue = Random.nextInt(examNames.size)
        return examNames[randomValue]
    }



}