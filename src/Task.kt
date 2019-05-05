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