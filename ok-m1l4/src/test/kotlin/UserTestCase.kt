import dsl.contacts
import dsl.user
import models.Action
import kotlin.test.Test
import kotlin.test.assertEquals

class UserTestCase {
    @Test
    fun `sout `() {
        val user = user {
            name {
                first = "Andrey"
                last = "Filippov"
            }
            contacts {
                email = "mail@mail"
                phone = "123456"
            }
            actions {
                add(Action.DELETE)
                add("UPDATE")

                +Action.CREATE
                +"READ"
            }
            available {
                tuesday("12:00")
                friday("21:30")
                monday("21:20")
            }
        }

        assertEquals(user.firstName, "Andrey")
        println(user)
    }
}