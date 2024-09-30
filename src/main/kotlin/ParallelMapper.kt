package org.example

import java.util.stream.Stream

class ParallelMapper : Mapper {
    override fun fourier(t: Stream<Number>): Stream<Number> {
        return t.parallel().map { Mapper.fourierTransfer(it) }
    }
}