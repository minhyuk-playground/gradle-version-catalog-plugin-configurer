package me.mh.gradle.versioncatalog

import org.gradle.api.initialization.Settings
import kotlin.io.path.name

data class VersionCatalogMeta(
    val tomlFilesDirectory: TomlFilesDirectory,
    val versionCatalogSources: VersionCatalogSources,
) {
    fun findAllTomlFiles(settings: Settings): Collection<TomlFile> =
        tomlFilesDirectory.findAllTomlFilePaths(settings)
            .filter { versionCatalogSources.isExists(it.name) }
            .map { TomlFile(versionCatalogSources.getVersionCatalogName(it.name), it) }
            .toSet()
}