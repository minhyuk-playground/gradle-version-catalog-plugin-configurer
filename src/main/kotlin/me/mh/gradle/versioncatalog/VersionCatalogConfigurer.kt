package me.mh.gradle.versioncatalog

import org.gradle.api.initialization.Settings
import org.gradle.api.internal.file.FileOperations
import org.gradle.kotlin.dsl.support.serviceOf

object VersionCatalogConfigurer {
    fun configure(settings: Settings, meta: VersionCatalogMeta) {
        with(settings) {
            val tomlFiles = meta.findAllTomlFiles(this)
            val fileOperations = serviceOf<FileOperations>()

            dependencyResolutionManagement {
                versionCatalogs {
                    tomlFiles.forEach {
                        create(it.name) {
                            from(fileOperations.configurableFiles(it.tomlFilePath))
                        }
                    }
                }
            }
        }
    }
}