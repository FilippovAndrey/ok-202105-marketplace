import dsl.UserContext
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SimpleTestCase {

    @Test
    fun `sout without params`() {
        sout {
            1 + 122
        }
    }

    @Test
    fun `sout with prefix`() {
        soutWithPrefix {
            "${time()}: 1 + 122"
        }
    }

    @Test
    fun `HW test`() {
        doTest {
            data {
//                User("Andrey", "123")
                name = "Andrey"
                age = "321"
            }
            assertions {
                add {
                    assertEquals(it.name, "Andrey")
                }
                add {
                    assertEquals(it.age, "321")
                }
            }
        }
    }

    class UserContext {
        var name: String = ""
        var age: String = ""
    }

    class AssertionsContext {
        val assertions: MutableList<Function1<User, Unit>> = mutableListOf()

        fun add(f: (User) -> Unit){
            assertions.add(f)
        }
    }

    class TestContext {
        var data: User? = null

        fun data(block: UserContext.() -> Unit) {
            val context = UserContext().apply(block)
            data = User(context.name, context.age)
        }

        fun assertions(block: AssertionsContext.() -> Unit) {
            assertNotNull(data)
            val context = AssertionsContext().apply(block)
            context.assertions.forEach {
                it(data!!)
            }
        }
        fun run() {

        }
    }

    private fun doTest(block: TestContext.() -> Unit) {
        TestContext().apply(block).run()
    }
}