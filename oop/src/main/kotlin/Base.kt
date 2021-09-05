sealed class sealedClasses {
    abstract val value: Int
}

class ChildA: sealedClasses()

class ChildB: sealedClasses()

fun main() {
    val obj: sealedClasses = ChildA()
}