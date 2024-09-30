package org.example

data class FileMeta(
    val fileName: String,
    val isDirectory: Boolean,
    var isDeleted: Boolean = false,
    val children: MutableList<FileMeta> = mutableListOf()
)
