package me.mh.gradle.versioncatalog

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class VersionCatalogCacheTest {

    @BeforeEach
    fun setUp() {
        VersionCatalogCache.clear()
    }

    @Test
    fun `이미 저장되어있는 값이라면 예외가 발생해야한다`() {
        // given
        val value = "hello world"
        VersionCatalogCache.put(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH, value)

        // when then
        assertThatThrownBy {
            VersionCatalogCache.put(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH, value)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `저장된 값을 가져와야한다`() {
        // given
        val value = "hello world"
        val cacheKey = CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH
        VersionCatalogCache.put(cacheKey, value)

        // when
        val cachedValue = VersionCatalogCache.get(cacheKey, String::class)

        // then
        assertThat(value).isEqualTo(cachedValue)
    }

    @Test
    fun `저장된 값이 없다면 예외가 발생해야한다`() {
        // given when then
        assertThatThrownBy {
            VersionCatalogCache.get(CacheKey.TOML_FILES_ROOT_DIRECTORY_PATH, String::class)
        }.isExactlyInstanceOf(NoSuchElementException::class.java)
    }


}