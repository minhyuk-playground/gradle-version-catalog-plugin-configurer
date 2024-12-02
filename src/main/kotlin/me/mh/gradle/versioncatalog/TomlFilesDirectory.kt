package me.mh.gradle.versioncatalog

import org.gradle.api.initialization.Settings
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name

data class TomlFilesDirectory(
    val pathUnderProjectRoot: String = "/gradle",
    val pathSeparator: String = "/"
) {
    fun findAllTomlFilePaths(settings: Settings): Set<Path> {
        val tomlFilesRootDirectoryPath = findTomlFilesRootDirectory(settings)

        val queue: Queue<Path> = LinkedList()
        queue.offer(tomlFilesRootDirectoryPath)

        val tomlFiles = mutableSetOf<Path>()

        while (queue.isNotEmpty()) {
            val currentDirectory = queue.poll()
            currentDirectory
                .listDirectoryEntries()
                .onEach {
                    if (it.isDirectory()) {
                        queue.offer(it)
                    }
                }
                .filter { it.name.endsWith(".toml") }
                .forEach { tomlFiles.add(it) }
        }

        return tomlFiles
    }

    private fun findTomlFilesRootDirectory(settings: Settings): Path {
        if (VersionCatalogCache.isExists(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH)) {
            return VersionCatalogCache.get(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH, Path::class)
        }

        val tomlFilesDirectoryPath = replaceDirectorySeparator(pathSeparator)
        var currentDirectoryPath: Path? = Paths.get(settings.rootDir.absolutePath)

        do {
            if (currentDirectoryPath == null) {
                throw NoSuchElementException("Not found toml files root directory. name : $pathUnderProjectRoot")
            }

            val tomlFilesRootDirectoryPath = Paths.get(
                currentDirectoryPath.toString(),
                tomlFilesDirectoryPath.toString()
            )

            if (tomlFilesRootDirectoryPath.exists()) {
                VersionCatalogCache.put(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH, tomlFilesRootDirectoryPath)
                return tomlFilesRootDirectoryPath
            }

            currentDirectoryPath = currentDirectoryPath.parent
        } while (true)
    }

    private fun replaceDirectorySeparator(
        oldSeparator: String,
        newSeparator: String = File.separator
    ): Path =
        pathUnderProjectRoot.let {
            if (it.startsWith(oldSeparator)) {
                return@let it
            }
            "$oldSeparator$it"
        }.let {
            if (oldSeparator == File.separator) {
                return@let it
            }
            it.replace(oldSeparator, newSeparator)
        }.let {
            Paths.get(it)
        }
}