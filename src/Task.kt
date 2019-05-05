/**
 * Hello, world!
 */
fun start(): String = "OK"

/**
 * Java to Kotlin conversion.
 */
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

/**
 * Named arguments.
 */
fun joinOptions(options: Collection<String>) = options.joinToString(", ", "[", "]")

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

/**
 * Lambdas.
 */
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }

/**
 * Strings.
 */
const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""

/**
 * Data classes.
 */
data class Person(val name: String, val age: Int = 0)

fun getPeople(): List<Person> = listOf(Person("Alice", 29), Person("Bob", 31))

/**
 * Nullable types.
 */
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    client ?: return
    message ?: return
    client.personalInfo?.let { personalInfo ->
        personalInfo.email?.let { email ->
            mailer.sendMessage(email, message)
        }
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

/**
 * Smart casts.
 */
fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


