import DelegateExample.Companion.doSmth
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ConstValue(
    private val value: Int
) : ReadOnlyProperty<Any?, Int> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }
}

class DelegateExample {
    val constVal by ConstValue(100500)

    companion object {
        fun doSmth() {
            println("123")
        }
    }
}

fun main() {
    val example = DelegateExample()
    println(example.constVal)
    doSmth()
}