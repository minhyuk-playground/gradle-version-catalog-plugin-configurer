rootProject.name = "gradle-version-catalog-plugin-configurer"

dependencyResolutionManagement {
    versionCatalogs {
        create("testLibs") {
            from(files("./system/versions/libs.test.versions.toml"))
        }
    }
}