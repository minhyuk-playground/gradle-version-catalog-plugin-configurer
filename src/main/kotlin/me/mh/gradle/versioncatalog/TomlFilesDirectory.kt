package me.mh.gradle.versioncatalog

import org.gradle.api.initialization.Settings
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.io.path.isDirectory
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name

data class TomlFilesDirectory(
    val projectRootDirectoryName: String,
    val directoryPathUnderProjectRoot: String,
    val directorySeparator: String = "/"
) {
    init {
        require(projectRootDirectoryName.isNotBlank()) { "projectRootDirectoryName should not be blank" }
    }

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
        val projectRootDirectoryPath = findProjectRootDirectoryPath(settings)
        return directoryPathUnderProjectRoot.let {
            if (it.startsWith(directorySeparator)) {
                return@let it
            }
            "$directorySeparator$it"
        }.let {
            if (directorySeparator == File.separator) {
                return@let it
            }
            it.replace(directorySeparator, File.separator)
        }.let {
            Paths.get("$projectRootDirectoryPath$it")
        }
    }

    private fun findProjectRootDirectoryPath(settings: Settings): Path {
        if (VersionCatalogCache.isExists(CacheKey.PROJECT_ROOT_DIRECTORY_PATH)) {
            return VersionCatalogCache.get(CacheKey.PROJECT_ROOT_DIRECTORY_PATH, Path::class)
        }

        var currentDirectoryPath: Path? = Paths.get(settings.rootDir.absolutePath)

        do {
            if (currentDirectoryPath == null) {
                throw NoSuchElementException("Not found project root directory. name : $projectRootDirectoryName")
            }

            if (currentDirectoryPath.name == projectRootDirectoryName) {
                VersionCatalogCache.put(CacheKey.PROJECT_ROOT_DIRECTORY_PATH, currentDirectoryPath)
                return currentDirectoryPath
            }

            currentDirectoryPath = currentDirectoryPath.parent
        } while (true)
    }
}