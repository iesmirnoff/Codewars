package kyu6.bouncing_balls

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BouncingBallTest {
    @Test
    fun test1() {
        assertEquals(3, bouncingBall(3.0, 0.66, 1.5))
    }
    @Test
    fun test2() {
        assertEquals(15, bouncingBall(30.0, 0.66, 1.5))
    }
}