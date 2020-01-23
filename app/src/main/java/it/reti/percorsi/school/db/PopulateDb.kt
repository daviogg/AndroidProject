package it.reti.percorsi.school.db

import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.ClassroomType
import it.reti.percorsi.school.db.entities.Student
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

        val galilei = Student(0,1, "Galileo", "Galilei",45.889633, 8.702064, generateRandomVotes())
        val newton  = Student(1,1,  "Isaac", "Newton",45.889633, 8.702064, generateRandomVotes())
        val darwin = Student(2, 1, "Charles", "Darwin",45.889633, 8.702064, generateRandomVotes())
        val copernico = Student(3,1,  "Nicolo", "Copernico",45.889633, 8.702064, generateRandomVotes())
        val golgi = Student(4,1,  "Camillo", "Golgi", 45.889633, 8.702064,generateRandomVotes())
        val fermi = Student(5, 1, "Enrico", "Fermi", 45.889633, 8.702064,generateRandomVotes())
        val hack = Student(6, 1, "Margherita", "Hack",45.889633, 8.702064, generateRandomVotes())
        val pasteur = Student(7, 1, "Louis", "Pasteur",45.889633, 8.702064, generateRandomVotes())

        return listOf(galilei, newton, darwin, copernico, golgi, fermi, hack, pasteur)
    }

    fun generateStudentsClassB() : List<Student>{

        val wiles = Student(8, 2, "Andrew", "Wiles", 45.889633, 8.702064,generateRandomVotes())
        val fibonacci = Student(9, 2, "Leonardo", "Fibonacci",45.889633, 8.702064, generateRandomVotes())
        val turing = Student(10, 2, "Alan", "Turing",45.889633, 8.702064,generateRandomVotes())
        val euler = Student(11, 2, "Leonard", "Euler",45.889633, 8.702064, generateRandomVotes())
        val gauss = Student(12, 2, "Friedrich", "Gauss",45.889633, 8.702064, generateRandomVotes())
        val riemann = Student(13, 2, "Bernhard", "Riemann",45.889633, 8.702064, generateRandomVotes())

        return listOf(wiles, fibonacci, turing, euler, gauss, riemann)
    }
    fun generateStudentsClassC() : List<Student>{

        val daVinci = Student(14, 3, "Leonardo", "DaVinci",45.889633, 8.702064,generateRandomVotes())
        val buonarroti = Student(15, 3, "Michelangelo", "Buonarroti", 45.889633, 8.702064,generateRandomVotes())
        val vanGogh = Student(16, 3, "Vincent", "Van Gogh", 45.889633, 8.702064,generateRandomVotes())
        val picasso = Student(17,3,  "Pablo", "Picasso", 45.889633, 8.702064,generateRandomVotes())
        val monet  = Student(18, 3, "Claude", "Monet", 45.889633, 8.702064,generateRandomVotes())
        val dali = Student(19, 3,"Salvator", "Dali", 45.889633, 8.702064,generateRandomVotes())
        val cezanne = Student(20, 3, "Paul", "Cezanne",45.889633, 8.702064, generateRandomVotes())
        val renoir = Student(21, 3, "Auguste", "Renoir",45.889633, 8.702064, generateRandomVotes())
        val goya =  Student(22, 3, "Francisco", "Goya", 45.889633, 8.702064,generateRandomVotes())

        return listOf(daVinci, buonarroti, vanGogh, picasso, monet, dali, cezanne, renoir, goya)
    }

    fun generateStudentsClassD() : List<Student>{

        val leopardi = Student(23, 4,"Giacomo", "Leopardi", 45.889633, 8.702064,generateRandomVotes())
        val pascoli  = Student(24, 4,"Giovanni", "Pascoli",45.889633, 8.702064,generateRandomVotes() )
        val montale = Student(25, 4,"Eugenio", "Montale",45.889633, 8.702064,generateRandomVotes() )
        val alighieri = Student(26, 4,"Dante", "Alighieri", 45.889633, 8.702064,generateRandomVotes())
        val hesse = Student(27, 4,"Hermann", "Hesse",45.889633, 8.702064,generateRandomVotes() )
        val ungaretti = Student(28, 4,"Giuseppe", "Ungaretti",45.889633, 8.702064,generateRandomVotes() )
        val petrarca = Student(29,4,"Francesco", "Petrarca",45.889633, 8.702064, generateRandomVotes())
        val shakespeare = Student(30, 4,"William", "Shakespeare",45.889633, 8.702064,generateRandomVotes() )

        return listOf(leopardi, pascoli, montale, alighieri, hesse, ungaretti, petrarca, shakespeare)
    }

    fun generateStudentsClassE() : List<Student>{

        val comolli = Student(31, 5,"Marco", "Comolli",45.889633, 8.702064, generateRandomVotes())
        val oggioni = Student(32, 5,"Davide", "Oggioni", 45.889633, 8.702064,generateRandomVotes())
        val rossi = Student(33, 5,"Mario", "Rossi", 45.889633, 8.702064,generateRandomVotes())
        val bianchi = Student(34, 5,"Stefano", "Bianchi", 45.889633, 8.702064,generateRandomVotes())
        val sgarbossa = Student(35, 5,"Mattia", "Sgarbossa",45.889633, 8.702064, generateRandomVotes())
        val sing = Student(36, 5,"Sing", "Kahlon", 45.889633, 8.702064,generateRandomVotes())
        val sanguin = Student(37, 5,"Andrea", "Sanguin", 45.889633, 8.702064,generateRandomVotes())
        val gecchele = Student(38, 5,"Mattia", "Gecchele",45.889633, 8.702064, generateRandomVotes())

        return listOf(comolli, oggioni, rossi, bianchi, sgarbossa, sing, sanguin, gecchele)
    }


    private fun generateRandomVotes(): List<Int>{

        val votes : List<Int> = arrayListOf()

        for (i in 6 downTo 0 step 1){
            val vote = Random.nextInt(1, 10)
            votes.toMutableList().add(vote)
        }
        return votes
    }


    private fun getRandomQuote(): String {
        val examNames = listOf("Analisi 1", "Analisi 2", "Biologia", "Scienze", "Alboritmi", "Pittura", "Atomi", "Reti", "Sistemi complessi")
        val randomValue = Random.nextInt(examNames.size)
        return examNames[randomValue]
    }



}