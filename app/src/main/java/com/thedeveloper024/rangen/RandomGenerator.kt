package com.thedeveloper024.rangen

import java.lang.Math.random

fun generateRandom (a: Int, b: Int): Int = ((random() * (b - a + 1)) + a).toInt()

class RandomGenerator(minimum: Int, maximum: Int) {
    var min: Int = minimum
    var max: Int = maximum

    fun generate(): Int = generateRandom(min, max)
}