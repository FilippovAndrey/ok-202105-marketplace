sealed interface Base

sealed interface PersistentList {
    object Emptylist: PersistentList
    class ConstList: PersistentList
}

class ChildA: Base

class ChildB: Base

class ChildC: Base

fun main() {
    val obj: Base = ChildA()

    val result = when(obj) {
        is ChildA -> "a"
        is ChildB -> "b"
        is ChildC -> "c"
    }
}