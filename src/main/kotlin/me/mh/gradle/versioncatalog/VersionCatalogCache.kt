package me.mh.gradle.versioncatalog

import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type
import kotlin.reflect.KClass
import kotlin.reflect.cast

object VersionCatalogCache {
    private val storage = mutableMapOf<CacheKey, Any>()

    fun put(key: CacheKey, value: Any) {
        if (isExists(key)) {
            throw IllegalArgumentException("$key already exists")
        }
        storage[key] = value
    }

    fun isExists(key: CacheKey): Boolean = storage.containsKey(key)

    fun <T : Any> get(key: CacheKey, valueType: KClass<T>): T {
        val value = storage[key] ?: throw NoSuchElementException("Not found $key value")
        if (valueType.isInstance(value)) {
            return valueType.cast(value)
        }
        throw IllegalStateException("$value is not instance of $type")
    }

    fun clear() {
        storage.clear()
    }
}

enum class CacheKey {
    TOML_FILES_ROOT_DIRECTORY_PATH
}