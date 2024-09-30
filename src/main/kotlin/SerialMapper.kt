package org.example

import java.util.stream.Stream

class SerialMapper : Mapper {
    override fun fourier(t: Stream<Number>): Stream<Number> {
        return t.map { Mapper.fourierTransfer(it) }
    }
}