package me.mh.gradle.versioncatalog.testdouble

import org.gradle.api.Action
import org.gradle.api.artifacts.MutableVersionConstraint
import org.gradle.api.initialization.dsl.VersionCatalogBuilder
import org.gradle.api.provider.Property

class TestVersionCatalogBuilder: VersionCatalogBuilder {
    val testDependencyNotations = mutableListOf<Any>()

    override fun from(dependencyNotation: Any) {
        testDependencyNotations.add(dependencyNotation)
    }

    override fun getName(): String {
        throw UnsupportedOperationException()
    }

    override fun getDescription(): Property<String> {
        throw UnsupportedOperationException()
    }

    override fun version(alias: String, versionSpec: Action<in MutableVersionConstraint>): String {
        throw UnsupportedOperationException()
    }

    override fun version(alias: String, version: String): String {
        throw UnsupportedOperationException()
    }

    override fun library(alias: String, group: String, artifact: String): VersionCatalogBuilder.LibraryAliasBuilder {
        throw UnsupportedOperationException()
    }

    override fun library(alias: String, groupArtifactVersion: String) {
        throw UnsupportedOperationException()
    }

    override fun plugin(alias: String, id: String): VersionCatalogBuilder.PluginAliasBuilder {
        throw UnsupportedOperationException()
    }

    override fun bundle(alias: String, aliases: MutableList<String>) {
        throw UnsupportedOperationException()
    }

    override fun getLibrariesExtensionName(): String {
        throw UnsupportedOperationException()
    }
}