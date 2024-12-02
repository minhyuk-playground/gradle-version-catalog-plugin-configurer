package me.mh.gradle.versioncatalog.testdouble

import org.gradle.api.Action
import org.gradle.api.artifacts.dsl.ComponentMetadataHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.initialization.resolve.DependencyResolutionManagement
import org.gradle.api.initialization.resolve.MutableVersionCatalogContainer
import org.gradle.api.initialization.resolve.RepositoriesMode
import org.gradle.api.initialization.resolve.RulesMode
import org.gradle.api.provider.Property

class TestDependencyResolutionManagement(
    val testVersionCatalogContainer: MutableVersionCatalogContainer
): DependencyResolutionManagement {
    override fun versionCatalogs(spec: Action<in MutableVersionCatalogContainer>) {
        spec.execute(testVersionCatalogContainer)
    }

    override fun repositories(repositoryConfiguration: Action<in RepositoryHandler>) {
        throw UnsupportedOperationException()
    }

    override fun getRepositories(): RepositoryHandler {
        throw UnsupportedOperationException()
    }

    override fun getRepositoriesMode(): Property<RepositoriesMode> {
        throw UnsupportedOperationException()
    }

    override fun components(registration: Action<in ComponentMetadataHandler>) {
        throw UnsupportedOperationException()
    }

    override fun getRulesMode(): Property<RulesMode> {
        throw UnsupportedOperationException()
    }

    override fun getComponents(): ComponentMetadataHandler {
        throw UnsupportedOperationException()
    }

    override fun getVersionCatalogs(): MutableVersionCatalogContainer {
        throw UnsupportedOperationException()
    }

    override fun getDefaultProjectsExtensionName(): Property<String> {
        throw UnsupportedOperationException()
    }

    override fun getDefaultLibrariesExtensionName(): Property<String> {
        throw UnsupportedOperationException()
    }
}