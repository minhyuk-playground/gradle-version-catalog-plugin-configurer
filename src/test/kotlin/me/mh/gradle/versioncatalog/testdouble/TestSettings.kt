package me.mh.gradle.versioncatalog.testdouble

import groovy.lang.Closure
import org.gradle.StartParameter
import org.gradle.api.Action
import org.gradle.api.cache.CacheConfigurations
import org.gradle.api.file.BuildLayout
import org.gradle.api.initialization.ConfigurableIncludedBuild
import org.gradle.api.initialization.ProjectDescriptor
import org.gradle.api.initialization.Settings
import org.gradle.api.initialization.SharedModelDefaults
import org.gradle.api.initialization.dsl.ScriptHandler
import org.gradle.api.initialization.resolve.DependencyResolutionManagement
import org.gradle.api.invocation.Gradle
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.plugins.ObjectConfigurationAction
import org.gradle.api.plugins.PluginContainer
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.ProviderFactory
import org.gradle.api.toolchain.management.ToolchainManagement
import org.gradle.caching.configuration.BuildCacheConfiguration
import org.gradle.plugin.management.PluginManagementSpec
import org.gradle.vcs.SourceControl
import java.io.File
import java.nio.file.Paths

class TestSettings(
    val testRootDir: File,
    val testDependencyResolutionManagement: DependencyResolutionManagement,
) : Settings {
    override fun getRootDir(): File = testRootDir

    override fun dependencyResolutionManagement(
        dependencyResolutionConfiguration: Action<in DependencyResolutionManagement>
    ) {
        dependencyResolutionConfiguration.execute(testDependencyResolutionManagement)
    }

    override fun getPlugins(): PluginContainer {
        throw UnsupportedOperationException()
    }

    override fun apply(closure: Closure<*>) {
        throw UnsupportedOperationException()
    }

    override fun apply(action: Action<in ObjectConfigurationAction>) {
        throw UnsupportedOperationException()
    }

    override fun apply(options: MutableMap<String, *>) {
        throw UnsupportedOperationException()
    }

    override fun getPluginManager(): PluginManager {
        throw UnsupportedOperationException()
    }

    override fun getExtensions(): ExtensionContainer {
        throw UnsupportedOperationException()
    }

    override fun include(projectPaths: MutableIterable<String>) {
        throw UnsupportedOperationException()
    }

    override fun includeFlat(projectNames: MutableIterable<String>) {
        throw UnsupportedOperationException()
    }

    override fun getSettings(): Settings {
        throw UnsupportedOperationException()
    }

    override fun getLayout(): BuildLayout {
        throw UnsupportedOperationException()
    }

    override fun getBuildscript(): ScriptHandler {
        throw UnsupportedOperationException()
    }

    override fun getSettingsDir(): File {
        throw UnsupportedOperationException()
    }

    override fun getRootProject(): ProjectDescriptor {
        throw UnsupportedOperationException()
    }

    override fun project(path: String): ProjectDescriptor {
        throw UnsupportedOperationException()
    }

    override fun project(projectDir: File): ProjectDescriptor {
        throw UnsupportedOperationException()
    }

    override fun findProject(path: String): ProjectDescriptor? {
        throw UnsupportedOperationException()
    }

    override fun findProject(projectDir: File): ProjectDescriptor? {
        throw UnsupportedOperationException()
    }

    override fun getStartParameter(): StartParameter {
        throw UnsupportedOperationException()
    }

    override fun getProviders(): ProviderFactory {
        throw UnsupportedOperationException()
    }

    override fun getGradle(): Gradle {
        throw UnsupportedOperationException()
    }

    override fun includeBuild(rootProject: Any) {
        throw UnsupportedOperationException()
    }

    override fun includeBuild(rootProject: Any, configuration: Action<ConfigurableIncludedBuild>) {
        throw UnsupportedOperationException()
    }

    override fun getBuildCache(): BuildCacheConfiguration {
        throw UnsupportedOperationException()
    }

    override fun buildCache(action: Action<in BuildCacheConfiguration>) {
        throw UnsupportedOperationException()
    }

    override fun pluginManagement(pluginManagementSpec: Action<in PluginManagementSpec>) {
        throw UnsupportedOperationException()
    }

    override fun getPluginManagement(): PluginManagementSpec {
        throw UnsupportedOperationException()
    }

    override fun sourceControl(configuration: Action<in SourceControl>) {
        throw UnsupportedOperationException()
    }

    override fun getSourceControl(): SourceControl {
        throw UnsupportedOperationException()
    }

    override fun enableFeaturePreview(name: String) {
        throw UnsupportedOperationException()
    }

    override fun getDependencyResolutionManagement(): DependencyResolutionManagement {
        throw UnsupportedOperationException()
    }

    override fun toolchainManagement(toolchainManagementConfiguration: Action<in ToolchainManagement>) {
        throw UnsupportedOperationException()
    }

    override fun getToolchainManagement(): ToolchainManagement {
        throw UnsupportedOperationException()
    }

    override fun getCaches(): CacheConfigurations {
        throw UnsupportedOperationException()
    }

    override fun caches(cachesConfiguration: Action<in CacheConfigurations>) {
        throw UnsupportedOperationException()
    }

    override fun getDefaults(): SharedModelDefaults {
        throw UnsupportedOperationException()
    }

    override fun defaults(action: Action<in SharedModelDefaults>) {
        throw UnsupportedOperationException()
    }
}