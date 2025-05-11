package com.example.kotlintasks

import kotlin.math.PI

/**
 * Zad. 1:
 * Complete the code to print "Mary is 20 years old"
 *
 * fun main() {
 *     val name = "Mary"
 *     val age = 20
 *     // Write your code here
 * }
 */
fun exercise1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

/**
 * Zad. 2):
 * Compute the area of a circle with radius 5.
 *
 * fun main() {
 *     val radius = 5.0
 *     val area = ...
 *     println(area)
 * }
 */
fun exercise2(): Double {
    val radius = 5.0
    return PI * radius * radius
}

/**
 * Zad. 3:
 * Define area as a single-expression function.
 *
 * fun area(radius: Double): Double {
 *     return PI * radius * radius
 * }
 */
fun area(radius: Double) = PI * radius * radius

/**
 * Zad. 4:
 * Convert hours, minutes, and seconds to total seconds using default arguments.
 *
 * fun toSeconds(hours: Int, minutes: Int, seconds: Int): Int {
 *     return hours * 3600 + minutes * 60 + seconds
 * }
 */
fun toSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int {
    return hours * 3600 + minutes * 60 + seconds
}

/**
 * Zad. 5:
 * Rewrite the code using a while loop (pizza slices).
 *
 * fun main() {
 *     for (slices in 8 downTo 1) {
 *         println("Eat a slice")
 *     }
 * }
 */
fun exercise5() {
    var slices = 8
    while (slices > 0) {
        println("Eat a slice")
        slices--
    }
    println("All gone!")
}

/**
 * Zad. 6:
 * Implement FizzBuzz using for loop and when.
 *
 * fun main() {
 *     for (i in 1..15) {
 *         // print FizzBuzz logic
 *     }
 * }
 */
fun exercise6() {
    for (i in 1..15) {
        when {
            i % 15 == 0 -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}

/**
 * Zad. 7:
 * Print only words starting with the letter 'l'.
 *
 * fun main() {
 *     val words = listOf("lamp", "desk", "laptop", "chair")
 *     // your code here
 * }
 */
fun exercise7() {
    val words = listOf("lamp", "desk", "laptop", "chair")
    words.filter { it.startsWith("l") }.forEach { println(it) }
}

/**
 * Zad. 8:
 * Create list of URLs using lambda.
 *
 * fun main() {
 *     val names = listOf("kotlin", "java", "python")
 *     // your code here
 * }
 */
fun exercise8() {
    val names = listOf("kotlin", "java", "python")
    val urls = names.map { "https://www.$it.org" }
    println(urls)
}

/**
 * Zad. 9:
 * Write repeatN function using lambda.
 *
 * fun repeatN(n: Int, action: () -> Unit) {
 *     // implement
 * }
 */
fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) action()
}

/**
 * Zad. 10:
 * Create a Contact class and print its content.
 *
 * data class Contact(val name: String, val email: String)
 * fun main() {
 *     val contact = Contact("Anna", "anna@example.com")
 *     println(contact)
 * }
 */
data class Contact(val name: String, val email: String)

fun exercise10() {
    val contact = Contact("Anna", "anna@example.com")
    println(contact)
}

/**
 * Zad. 11:
 * Use Elvis operator to return default value.
 *
 * fun main() {
 *     val name: String? = null
 *     val length = if (name != null) name.length else 0
 *     println("Length: $length")
 * }
 */
fun exercise11() {
    val name: String? = null
    val length = name?.length ?: 0
    println("Length: $length")
}

/**
 * Zad. 12:
 * Use safe calls on nullable variable.
 *
 * fun main() {
 *     val text: String? = "Hello"
 *     println(text.toUpperCase())
 * }
 */
fun exercise12() {
    val text: String? = "Hello"
    println(text?.toUpperCase())
}
