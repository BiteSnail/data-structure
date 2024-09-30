import org.example.FileSystem
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class FileSystemTest {
    private fun captureOutput(action: () -> Unit): String {
        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        System.setOut(printStream)

        return try {
            action()
            outputStream.toString("UTF-8")
        } finally {
            System.setOut(originalOut)
        }
    }

    @Test
    @DisplayName("파일 시스템 트리 만들기 테스트")
    fun showFileTreeTest() {
        val expectedFileNames =
            listOf("FileMeta.kt", "Main.kt", "FileSystem.kt", "FileSystemTest.kt")

        val capturedOutput = captureOutput {
            FileSystem.tree()
        }

        expectedFileNames.forEach { fileName ->
            assertTrue(capturedOutput.contains(fileName))
        }
    }

    @Test
    @DisplayName("파일 디렉토리 삭제 테스트")
    fun deleteDirectoryTest() {
        val directoryName = "dontneed"
        val expectedDeletedItems =
            listOf("Deleted: [dontneed]", "Deleted: report.txt", "Deleted: lyrics.md")
        val directory = FileSystem.find(directoryName)

        FileSystem.rm(directory!!)

        val capturedOutput = captureOutput {
            FileSystem.tree()
        }

        expectedDeletedItems.forEach { itemName ->
            assertTrue(capturedOutput.contains(itemName))
        }
    }

}