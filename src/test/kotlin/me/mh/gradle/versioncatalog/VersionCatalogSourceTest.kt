package me.mh.gradle.versioncatalog

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class VersionCatalogSourceTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "     "])
    fun `이름은 빈자열이면 안된다`(name: String) {
        // given when then
        assertThrows<IllegalArgumentException> {
            VersionCatalogSource(name = name, tomlFileName = "tomlFileName")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "     "])
    fun `tomlFileName 은 빈문자열이면 안된다`(
        tomlFileName: String
    ) {
        // given when then
        assertThrows<IllegalArgumentException> {
            VersionCatalogSource(name = "name", tomlFileName = tomlFileName)
        }
    }
}