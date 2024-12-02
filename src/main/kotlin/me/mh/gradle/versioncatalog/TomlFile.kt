package me.mh.gradle.versioncatalog

import java.nio.file.Path
import kotlin.io.path.exists

data class TomlFile(
    val name: String,
    val tomlFilePath: Path
) {
    init {
        require(name.isNotBlank()) { "name should not be blank" }
        require(tomlFilePath.exists()) { "tomlFilePath does not exist" }
    }
}
