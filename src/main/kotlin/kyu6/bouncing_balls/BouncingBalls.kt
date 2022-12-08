package kyu6.bouncing_balls


fun main() {
    val count = bouncingBall(3.0, 0.66, 1.5)
    println(count)
}

/**
 * https://www.codewars.com/kata/5544c7a5cb454edb3c000047

 * A child is playing with a ball on the nth floor of a tall building. The height of this floor above ground level, h, is known.

 * He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).

 * His mother looks out of a window 1.5 meters from the ground.

 * How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing?

 * Three conditions must be met for a valid experiment:
 * Float parameter "h" in meters must be greater than 0
 * Float parameter "bounce" must be greater than 0 and less than 1
 * Float parameter "window" must be less than h.
 * If all three conditions above are fulfilled, return a positive integer, otherwise return -1.

 * Note:
 * The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.
 */


/**
 * @param h - height of nth floor
 * @param bounce - the factor decreasing height of every bounce
 * @param window - height of mother's window
 */
fun bouncingBall(h: Double, bounce: Double, window: Double): Int {

    // filtering wrong values
    if (h <= 0) return -1
    if (bounce <= 0 || bounce >= 1) return -1
    if (window >= h) return -1

    // counting bounces
    return countBounces(h * bounce, bounce, window)
}

/**
 * @param nextBounceHeight - height of next bounce
 * @param bounceFactor - the factor decreasing height of every bounce
 * @param window - height of mother's window
 * @param counter - accumulator of bounces
 */
private tailrec fun countBounces(nextBounceHeight: Double, bounceFactor: Double, window: Double, counter: Int = 1): Int {
    return if (nextBounceHeight <= window)
        counter // bouncing have ended
    else
        // decrease height of the next bounce, increase counter and continue
        countBounces(nextBounceHeight * bounceFactor, bounceFactor, window, counter + 2)
}