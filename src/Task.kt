fun start(): String = "OK"

fun toJSON(collection: Collection<Int>): String {

    var json = "["
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        json += element
        if (iterator.hasNext()) {
            json += ", "
        }
    }
    json += "]"

    return json
}

fun joinOptions(options: Collection<String>) = options.joinToString(", ", "[", "]")

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }

const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""

data class Person(val name: String, val age: Int = 0)

fun getPeople(): List<Person> = listOf(Person("Alice", 29), Person("Bob", 31))
