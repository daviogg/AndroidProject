package it.reti.percorsi.school.db

import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.ClassroomType
import it.reti.percorsi.school.db.entities.Student
import java.util.*
import kotlin.random.Random

object PopulateDb {

    fun generateClassrooms() : List<Classroom>{

        val classA = Classroom(1, "Scienze", populateClassWithStudents(generateStudentsClassA()), ClassroomType.SCIENCE, "A")
        val classB = Classroom(2, "Matematica", populateClassWithStudents(generateStudentsClassB()), ClassroomType.MATHEMATICS, "B")
        val classC = Classroom(3, "Arte", populateClassWithStudents(generateStudentsClassC()), ClassroomType.ART, "C")
        val classD = Classroom(4, "Letteratura", populateClassWithStudents(generateStudentsClassD()), ClassroomType.LITERATURE, "D")
        val classE = Classroom(5, "Astronomia", populateClassWithStudents(generateStudentsClassE()), ClassroomType.ASTRONOMY, "E")

        return listOf(classA, classB, classC, classD, classE)
    }

    private fun populateClassWithStudents(students: List<Student>): List<Int>{
       val studentsId = mutableListOf<Int>()
        for(student in students){
            studentsId.add(student.uid)
        }
        return studentsId
    }

    fun generateStudentsClassA() : List<Student>{

        val galilei = Student(0,1, "Galileo", "Galilei", listOf())
        val newton  = Student(1,1,  "Isaac", "Newton", listOf())
        val darwin = Student(2, 1, "Charles", "Darwin", listOf())
        val copernico = Student(3,1,  "Nicolo", "Copernico", listOf())
        val golgi = Student(4,1,  "Camillo", "Golgi", listOf())
        val fermi = Student(5, 1, "Enrico", "Fermi", listOf())
        val hack = Student(6, 1, "Margherita", "Hack", listOf())
        val pasteur = Student(7, 1, "Louis", "Pasteur", listOf())

        return listOf(galilei, newton, darwin, copernico, golgi, fermi, hack, pasteur)
    }

    fun generateStudentsClassB() : List<Student>{

        val wiles = Student(8, 2, "Andrew", "Wiles", listOf())
        val fibonacci = Student(9, 2, "Leonardo", "Fibonacci", listOf())
        val turing = Student(10, 2, "Alan", "Turing",listOf())
        val euler = Student(11, 2, "Leonard", "Euler", listOf())
        val gauss = Student(12, 2, "Friedrich", "Gauss", listOf())
        val riemann = Student(13, 2, "Bernhard", "Riemann", listOf())

        return listOf(wiles, fibonacci, turing, euler, gauss, riemann)
    }
    fun generateStudentsClassC() : List<Student>{

        val daVinci = Student(14, 3, "Leonardo", "DaVinci",listOf())
        val buonarroti = Student(15, 3, "Michelangelo", "Buonarroti", listOf())
        val vanGogh = Student(16, 3, "Vincent", "Van Gogh", listOf())
        val picasso = Student(17,3,  "Pablo", "Picasso", listOf())
        val monet  = Student(18, 3, "Claude", "Monet", listOf())
        val dali = Student(19, 3,"Salvator", "Dali", listOf())
        val cezanne = Student(20, 3, "Paul", "Cezanne", listOf())
        val renoir = Student(21, 3, "Auguste", "Renoir", listOf())
        val goya =  Student(22, 3, "Francisco", "Goya", listOf())

        return listOf(daVinci, buonarroti, vanGogh, picasso, monet, dali, cezanne, renoir, goya)
    }

    fun generateStudentsClassD() : List<Student>{

        val leopardi = Student(23, 4,"Giacomo", "Leopardi", listOf())
        val pascoli  = Student(24, 4,"Giovanni", "Pascoli",listOf() )
        val montale = Student(25, 4,"Eugenio", "Montale",listOf() )
        val alighieri = Student(26, 4,"Dante", "Alighieri", listOf())
        val hesse = Student(27, 4,"Hermann", "Hesse",listOf() )
        val ungaretti = Student(28, 4,"Giuseppe", "Ungaretti",listOf() )
        val petrarca = Student(29,4,"Francesco", "Petrarca", listOf())
        val shakespeare = Student(30, 4,"William", "Shakespeare",listOf() )

        return listOf(leopardi, pascoli, montale, alighieri, hesse, ungaretti, petrarca, shakespeare)
    }

    fun generateStudentsClassE() : List<Student>{

        val comolli = Student(31, 5,"Marco", "Comolli", listOf())
        val oggioni = Student(32, 5,"Davide", "Oggioni", listOf())
        val rossi = Student(33, 5,"Mario", "Rossi", listOf())
        val bianchi = Student(34, 5,"Stefano", "Bianchi", listOf())
        val sgarbossa = Student(35, 5,"Mattia", "Sgarbossa", listOf())
        val sing = Student(36, 5,"Sing", "Kahlon", listOf())
        val sanguin = Student(37, 5,"Andrea", "Sanguin", listOf())
        val gecchele = Student(38, 5,"Mattia", "Gecchele", listOf())

        return listOf(comolli, oggioni, rossi, bianchi, sgarbossa, sing, sanguin, gecchele)
    }


/*
    private fun generateRandomExams(): List<Exam>{

        val exams : List<Exam> = arrayListOf()

        for (i in 6 downTo 0 step 1){
            val exam = Exam(UUID.randomUUID(), Random.nextInt(1, 10), getRandomQuote())
            exams.toMutableList().add(exam)
        }
        return exams
    }*/


    private fun getRandomQuote(): String {
        val examNames = listOf("Analisi 1", "Analisi 2", "Biologia", "Scienze", "Alboritmi", "Pittura", "Atomi", "Reti", "Sistemi complessi")
        val randomValue = Random.nextInt(examNames.size)
        return examNames[randomValue]
    }



}