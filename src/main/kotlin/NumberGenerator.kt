package org.example

import java.io.File

class NumberGenerator {
    companion object {
        private const val MIN_NUM = 1
        private const val MAX_NUM = 100
        fun generateLargeFile(filePath: String, lines: Int) {
            File(filePath).printWriter().use { out ->
                for (i in 1..lines) {
                    out.println((MIN_NUM..MAX_NUM).random())
                }
            }
        }
    }
}