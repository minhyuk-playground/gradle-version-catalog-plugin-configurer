package me.mh.gradle.versioncatalog

data class VersionCatalogSources(
    val values: Set<VersionCatalogSource>
) {
    private val versionCatalogTable = values.associateBy { it.tomlFileName }

    fun isExists(tomlFileName: String): Boolean = versionCatalogTable.containsKey(tomlFileName)

    fun getVersionCatalogName(tomlFileName: String): String =
        versionCatalogTable[tomlFileName]?.name
            ?: throw NoSuchElementException("Not found version catalog name. tomlFileName: $tomlFileName")
}

data class VersionCatalogSource(
    val name: String,
    val tomlFileName: String
) {
    init {
        require(name.isNotBlank()) { "name should not be blank" }
        require(tomlFileName.isNotBlank()) { "tomlFileName should not be blank" }
    }
}