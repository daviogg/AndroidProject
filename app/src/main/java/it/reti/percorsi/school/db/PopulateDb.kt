package it.reti.percorsi.school.db

import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.ClassroomType
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.db.entities.Vote
import it.reti.percorsi.school.db.repository.SchoolRepository
import kotlin.random.Random

object PopulateDb {

    fun generateClassrooms(schoolRepository: SchoolRepository) : List<Classroom>{

        val classA = Classroom(1, "Scienze", populateClassWithStudents(generateStudentsClassA(schoolRepository)), ClassroomType.SCIENCE, "A")
        val classB = Classroom(2, "Matematica", populateClassWithStudents(generateStudentsClassB(schoolRepository)), ClassroomType.MATHEMATICS, "B")
        val classC = Classroom(3, "Arte", populateClassWithStudents(generateStudentsClassC(schoolRepository)), ClassroomType.ART, "C")
        val classD = Classroom(4, "Letteratura", populateClassWithStudents(generateStudentsClassD(schoolRepository)), ClassroomType.LITERATURE, "D")
        val classE = Classroom(5, "Astronomia", populateClassWithStudents(generateStudentsClassE(schoolRepository)), ClassroomType.ASTRONOMY, "E")

        return listOf(classA, classB, classC, classD, classE)
    }

    private fun populateClassWithStudents(students: List<Student>): List<Int>{
       val studentsId = mutableListOf<Int>()
        for(student in students){
            studentsId.add(student.uid)
        }
        return studentsId
    }

    fun generateStudentsClassA(schoolRepository: SchoolRepository) : List<Student>{

        val galilei = Student(0,1, "Galileo", "Galilei",45.889633, 8.702064, generateRandomVotes(0, schoolRepository))
        val newton  = Student(1,1,  "Isaac", "Newton",45.889633, 8.702064, generateRandomVotes(1, schoolRepository))
        val darwin = Student(2, 1, "Charles", "Darwin",45.889633, 8.702064, generateRandomVotes(2, schoolRepository))
        val copernico = Student(3,1,  "Nicolo", "Copernico",45.889633, 8.702064, generateRandomVotes(3, schoolRepository))
        val golgi = Student(4,1,  "Camillo", "Golgi", 45.889633, 8.702064,generateRandomVotes(4, schoolRepository))
        val fermi = Student(5, 1, "Enrico", "Fermi", 45.889633, 8.702064,generateRandomVotes(5, schoolRepository))
        val hack = Student(6, 1, "Margherita", "Hack",45.889633, 8.702064, generateRandomVotes(6, schoolRepository))
        val pasteur = Student(7, 1, "Louis", "Pasteur",45.889633, 8.702064, generateRandomVotes(7,schoolRepository))

        return listOf(galilei, newton, darwin, copernico, golgi, fermi, hack, pasteur)
    }

    fun generateStudentsClassB(schoolRepository: SchoolRepository) : List<Student>{

        val wiles = Student(8, 2, "Andrew", "Wiles", 45.889633, 8.702064,generateRandomVotes(8,schoolRepository ))
        val fibonacci = Student(9, 2, "Leonardo", "Fibonacci",45.889633, 8.702064, generateRandomVotes(9, schoolRepository))
        val turing = Student(10, 2, "Alan", "Turing",45.889633, 8.702064,generateRandomVotes(10, schoolRepository))
        val euler = Student(11, 2, "Leonard", "Euler",45.889633, 8.702064, generateRandomVotes(11, schoolRepository))
        val gauss = Student(12, 2, "Friedrich", "Gauss",45.889633, 8.702064, generateRandomVotes(12, schoolRepository))
        val riemann = Student(13, 2, "Bernhard", "Riemann",45.889633, 8.702064, generateRandomVotes(13, schoolRepository))

        return listOf(wiles, fibonacci, turing, euler, gauss, riemann)
    }
    fun generateStudentsClassC(schoolRepository: SchoolRepository) : List<Student>{

        val daVinci = Student(14, 3, "Leonardo", "DaVinci",45.889633, 8.702064,generateRandomVotes(14,schoolRepository))
        val buonarroti = Student(15, 3, "Michelangelo", "Buonarroti", 45.889633, 8.702064,generateRandomVotes(15, schoolRepository))
        val vanGogh = Student(16, 3, "Vincent", "Van Gogh", 45.889633, 8.702064,generateRandomVotes(16, schoolRepository))
        val picasso = Student(17,3,  "Pablo", "Picasso", 45.889633, 8.702064,generateRandomVotes(17,schoolRepository))
        val monet  = Student(18, 3, "Claude", "Monet", 45.889633, 8.702064,generateRandomVotes(18,schoolRepository))
        val dali = Student(19, 3,"Salvator", "Dali", 45.889633, 8.702064,generateRandomVotes(19,schoolRepository))
        val cezanne = Student(20, 3, "Paul", "Cezanne",45.889633, 8.702064, generateRandomVotes(20,schoolRepository))
        val renoir = Student(21, 3, "Auguste", "Renoir",45.889633, 8.702064, generateRandomVotes(21,schoolRepository))
        val goya =  Student(22, 3, "Francisco", "Goya", 45.889633, 8.702064,generateRandomVotes(22,schoolRepository))

        return listOf(daVinci, buonarroti, vanGogh, picasso, monet, dali, cezanne, renoir, goya)
    }

    fun generateStudentsClassD(schoolRepository: SchoolRepository) : List<Student>{

        val leopardi = Student(23, 4,"Giacomo", "Leopardi", 45.889633, 8.702064,generateRandomVotes(23,schoolRepository))
        val pascoli  = Student(24, 4,"Giovanni", "Pascoli",45.889633, 8.702064,generateRandomVotes(24,schoolRepository) )
        val montale = Student(25, 4,"Eugenio", "Montale",45.889633, 8.702064,generateRandomVotes(25,schoolRepository) )
        val alighieri = Student(26, 4,"Dante", "Alighieri", 45.889633, 8.702064,generateRandomVotes(26,schoolRepository))
        val hesse = Student(27, 4,"Hermann", "Hesse",45.889633, 8.702064,generateRandomVotes(27,schoolRepository) )
        val ungaretti = Student(28, 4,"Giuseppe", "Ungaretti",45.889633, 8.702064,generateRandomVotes(28,schoolRepository) )
        val petrarca = Student(29,4,"Francesco", "Petrarca",45.889633, 8.702064, generateRandomVotes(29,schoolRepository))
        val shakespeare = Student(30, 4,"William", "Shakespeare",45.889633, 8.702064,generateRandomVotes(30,schoolRepository) )

        return listOf(leopardi, pascoli, montale, alighieri, hesse, ungaretti, petrarca, shakespeare)
    }

    fun generateStudentsClassE(schoolRepository: SchoolRepository) : List<Student>{


        val comolli = Student(31, 5,"Marco", "Comolli",45.889633, 8.702064, generateRandomVotes(31,schoolRepository))
        val oggioni = Student(32, 5,"Davide", "Oggioni", 45.889633, 8.702064,generateRandomVotes(32,schoolRepository))
        val rossi = Student(33, 5,"Mario", "Rossi", 45.889633, 8.702064,generateRandomVotes(33,schoolRepository))
        val bianchi = Student(34, 5,"Stefano", "Bianchi", 45.889633, 8.702064,generateRandomVotes(34,schoolRepository))
        val sgarbossa = Student(35, 5,"Mattia", "Sgarbossa",45.889633, 8.702064, generateRandomVotes(35,schoolRepository))
        val sing = Student(36, 5,"Sing", "Kahlon", 45.889633, 8.702064,generateRandomVotes(36,schoolRepository))
        val sanguin = Student(37, 5,"Andrea", "Sanguin", 45.889633, 8.702064,generateRandomVotes(37,schoolRepository))
        val gecchele = Student(38, 5,"Mattia", "Gecchele",45.889633, 8.702064, generateRandomVotes(38,schoolRepository))

        return listOf(comolli, oggioni, rossi, bianchi, sgarbossa, sing, sanguin, gecchele)
    }


    private fun generateRandomVotes(studentId: Int, schoolRepository: SchoolRepository): List<Int>{

        val votes : List<Int> = arrayListOf()

        for (i in 6 downTo 0 step 1){
            val vote = Vote(0, Random.nextInt(1, 10), studentId)
            votes.toMutableList().add(vote.uid)
            schoolRepository.insertVote(vote)
        }
        return votes
    }


    private fun getRandomQuote(): String {
        val examNames = listOf("Analisi 1", "Analisi 2", "Biologia", "Scienze", "Alboritmi", "Pittura", "Atomi", "Reti", "Sistemi complessi")
        val randomValue = Random.nextInt(examNames.size)
        return examNames[randomValue]
    }



}