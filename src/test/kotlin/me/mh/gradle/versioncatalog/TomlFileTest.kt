package me.mh.gradle.versioncatalog

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.nio.file.Paths

internal class TomlFileTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "   "])
    fun `name 은 빈문자열이면 안된다`(name: String) {
        // given when then
        assertThrows<IllegalArgumentException> {
            TomlFile(name, Paths.get(""))
        }
    }

    @Test
    fun `tomlFilePath 는 반드시 존재해야한다`() {
        assertThrows<IllegalArgumentException> {
            TomlFile("test", Paths.get("./test"))
        }
    }
}