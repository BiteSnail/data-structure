package org.example

import java.util.stream.Stream
import kotlin.math.exp

interface Mapper {
    companion object {
        fun fourierTransfer(n: Number): Number {
            return n.toDouble() * exp(Math.PI * -2.0)
        }
    }

    fun fourier(t: Stream<Number>): Stream<Number>
}