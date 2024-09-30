package org.example

import java.io.File

object FileSystem {
    private const val DEFAULT_ROOT_PATH = "./src/"
    private const val DEFAULT_INDENTATION = 1

    private fun buildFileTree(file: File): FileMeta {
        val node = FileMeta(file.name, file.isDirectory)
        if (node.isDirectory) {
            file.listFiles()?.forEach { childFile ->
                val childNode = buildFileTree(childFile)
                node.children.add(childNode)
            }
        }
        return node
    }

    private val rootNode = buildFileTree(File(DEFAULT_ROOT_PATH))

    fun find(fileName: String, node: FileMeta = rootNode): FileMeta? {
        if (node.fileName == fileName) {
            return node
        }
        if (node.isDirectory) {
            for (childNode in node.children) {
                find(fileName, childNode)?.let { return it }
            }
        }
        return null
    }

    fun tree(node: FileMeta = rootNode, indentation: Int = DEFAULT_INDENTATION) {
        println("${" ".repeat(indentation)}-${if (node.isDeleted) "Deleted:" else ""} ${if (node.isDirectory) "[${node.fileName}]" else node.fileName}")

        node.children.forEach { child ->
            tree(child, indentation + indentation)
        }

    }

    fun rm(node: FileMeta) {
        if (node.isDeleted) {
            return
        }

        if (node.isDirectory) {
            for (childNode in node.children) {
                rm(childNode)
            }
        }
        node.isDeleted = true
    }
}