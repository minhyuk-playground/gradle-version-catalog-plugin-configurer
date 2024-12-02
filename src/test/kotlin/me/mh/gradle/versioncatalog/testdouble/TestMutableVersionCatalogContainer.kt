package me.mh.gradle.versioncatalog.testdouble

import groovy.lang.Closure
import org.gradle.api.*
import org.gradle.api.initialization.dsl.VersionCatalogBuilder
import org.gradle.api.initialization.resolve.MutableVersionCatalogContainer
import org.gradle.api.provider.Provider
import org.gradle.api.specs.Spec
import java.util.*

class TestMutableVersionCatalogContainer(
    val testsVersionCatalogBuilder: VersionCatalogBuilder
) : MutableVersionCatalogContainer {
    override fun create(name: String): VersionCatalogBuilder = testsVersionCatalogBuilder

    override fun add(element: VersionCatalogBuilder): Boolean {
        throw UnsupportedOperationException()
    }

    override fun addAll(elements: Collection<VersionCatalogBuilder>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun clear() {
        throw UnsupportedOperationException()
    }

    override fun iterator(): MutableIterator<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun remove(element: VersionCatalogBuilder?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<VersionCatalogBuilder>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun retainAll(elements: Collection<VersionCatalogBuilder>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun contains(element: VersionCatalogBuilder?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsAll(elements: Collection<VersionCatalogBuilder>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isEmpty(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun addLater(provider: Provider<out VersionCatalogBuilder>) {
        throw UnsupportedOperationException()
    }

    override fun addAllLater(provider: Provider<out MutableIterable<VersionCatalogBuilder>>) {
        throw UnsupportedOperationException()
    }

    override fun <S : VersionCatalogBuilder?> withType(type: Class<S>): NamedDomainObjectSet<S> {
        throw UnsupportedOperationException()
    }

    override fun <S : VersionCatalogBuilder?> withType(
        type: Class<S>,
        configureAction: Action<in S>
    ): DomainObjectCollection<S> {
        throw UnsupportedOperationException()
    }

    override fun <S : VersionCatalogBuilder?> withType(
        type: Class<S>,
        configureClosure: Closure<*>
    ): DomainObjectCollection<S> {
        throw UnsupportedOperationException()
    }

    override fun matching(spec: Spec<in VersionCatalogBuilder>): NamedDomainObjectSet<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun matching(spec: Closure<*>): NamedDomainObjectSet<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun whenObjectAdded(action: Action<in VersionCatalogBuilder>): Action<in VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun whenObjectAdded(action: Closure<*>) {
        throw UnsupportedOperationException()
    }

    override fun whenObjectRemoved(action: Action<in VersionCatalogBuilder>): Action<in VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun whenObjectRemoved(action: Closure<*>) {
        throw UnsupportedOperationException()
    }

    override fun all(action: Action<in VersionCatalogBuilder>) {
        throw UnsupportedOperationException()
    }

    override fun all(action: Closure<*>) {
        throw UnsupportedOperationException()
    }

    override fun configureEach(action: Action<in VersionCatalogBuilder>) {
        throw UnsupportedOperationException()
    }

    override fun findAll(spec: Closure<*>): MutableSet<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun getNamer(): Namer<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun getAsMap(): SortedMap<String, VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun getNames(): SortedSet<String> {
        throw UnsupportedOperationException()
    }

    override fun findByName(name: String): VersionCatalogBuilder? {
        throw UnsupportedOperationException()
    }

    override fun getByName(name: String): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun getByName(name: String, configureClosure: Closure<*>): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun getByName(name: String, configureAction: Action<in VersionCatalogBuilder>): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun getAt(name: String): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun addRule(rule: Rule): Rule {
        throw UnsupportedOperationException()
    }

    override fun addRule(description: String, ruleAction: Closure<*>): Rule {
        throw UnsupportedOperationException()
    }

    override fun addRule(description: String, ruleAction: Action<String>): Rule {
        throw UnsupportedOperationException()
    }

    override fun getRules(): MutableList<Rule> {
        throw UnsupportedOperationException()
    }

    override fun named(nameFilter: Spec<String>): NamedDomainObjectSet<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun named(name: String): NamedDomainObjectProvider<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun named(
        name: String,
        configurationAction: Action<in VersionCatalogBuilder>
    ): NamedDomainObjectProvider<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun <S : VersionCatalogBuilder?> named(name: String, type: Class<S>): NamedDomainObjectProvider<S> {
        throw UnsupportedOperationException()
    }

    override fun <S : VersionCatalogBuilder?> named(
        name: String,
        type: Class<S>,
        configurationAction: Action<in S>
    ): NamedDomainObjectProvider<S> {
        throw UnsupportedOperationException()
    }

    override fun getCollectionSchema(): NamedDomainObjectCollectionSchema {
        throw UnsupportedOperationException()
    }

    override fun configure(configureClosure: Closure<*>): NamedDomainObjectContainer<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun create(name: String, configureClosure: Closure<*>): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun create(name: String, configureAction: Action<in VersionCatalogBuilder>): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun maybeCreate(name: String): VersionCatalogBuilder {
        throw UnsupportedOperationException()
    }

    override fun register(
        name: String,
        configurationAction: Action<in VersionCatalogBuilder>
    ): NamedDomainObjectProvider<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override fun register(name: String): NamedDomainObjectProvider<VersionCatalogBuilder> {
        throw UnsupportedOperationException()
    }

    override val size: Int
        get() = throw UnsupportedOperationException()
}