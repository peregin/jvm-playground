package study


// stands for scala case class
data class Person(val name: String) {
    fun greet(): String {
        return "Aloha $name"
    }
}

fun Int.body(f: () -> Unit) {
    for (i in 1..this) {
        f()
    }
}

fun main(args: Array<String>) {
    val person = Person("Kotlin Island")
    println(person.greet())

    val anotherPerson = person.copy(name = "Scala Tower")
    println(anotherPerson.greet())

    val numbers = 1..10
    val n = numbers.map { it * 2 }.filter { it % 3 > 0 }.sum()
    println("n is $n")

    5.body{ println(person.greet()) }

}
