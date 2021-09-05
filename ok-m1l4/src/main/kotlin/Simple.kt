import java.lang.IllegalArgumentException

fun sout(block: () -> Any?) {
    var result = block()
    println(result)
}

class MyContext {
    fun time() = System.currentTimeMillis()
}

fun soutWithPrefix(block: MyContext.() -> Any?) {
    val context = MyContext()
    var result = block(context)
    println("$result")
}

typealias EmailType = String

@JvmInline
value class Email(val email: String) {
    init {
        if(!email.contains("@")) {
            throw IllegalArgumentException("Wrong email $email")
        }
    }
    companion object {
        fun fromGmail(email:String):Email {
            return Email("$email@gmail.com")
        }
    }

}

val a: EmailType = "asdasd"


fun main() {
    val b: Email = Email.fromGmail("asd@as")
}

data class User(
    val name: String,
    val age: String
)
