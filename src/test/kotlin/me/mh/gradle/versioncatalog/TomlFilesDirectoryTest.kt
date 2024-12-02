package me.mh.gradle.versioncatalog

import me.mh.gradle.versioncatalog.testdouble.TestDependencyResolutionManagement
import me.mh.gradle.versioncatalog.testdouble.TestMutableVersionCatalogContainer
import me.mh.gradle.versioncatalog.testdouble.TestSettings
import me.mh.gradle.versioncatalog.testdouble.TestVersionCatalogBuilder
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.*

internal class TomlFilesDirectoryTest {
    @Test
    fun `tomlFile 경로를 찾아야 한다`(
        @TempDir(cleanup = CleanupMode.ALWAYS) tempDir: Path,
    ) {
        // given
        val projectRootDirectory = tempDir
        val tomlFile = Files.createTempFile(projectRootDirectory.toAbsolutePath(), "temp_", ".toml")

        val tomlFilesDirectory = TomlFilesDirectory(
            projectRootDirectoryName = projectRootDirectory.name,
            directoryPathUnderProjectRoot = ""
        )

        val testSettings = TestSettings(
            projectRootDirectory.toFile(),
            TestDependencyResolutionManagement(TestMutableVersionCatalogContainer(TestVersionCatalogBuilder()))
        )

        // when
        val tomlFilePaths = tomlFilesDirectory.findAllTomlFilePaths(testSettings)

        // then
        assertThat(tomlFilePaths).hasSize(1)
        assertThat(tomlFilePaths.first()).isEqualTo(tomlFile)
    }
}