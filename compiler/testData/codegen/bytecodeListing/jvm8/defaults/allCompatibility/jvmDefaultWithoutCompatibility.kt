// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// WITH_RUNTIME

@JvmDefaultWithoutCompatibility
interface NoDefaultImpl {
    fun test() {}
    val prop: String
        get() = "123"
}

interface WithDefaultImpl: NoDefaultImpl {

}

interface WithDefaultImplPure {
    fun test() {}
    val prop: String
        get() = "123"
}

interface WithDefaultImplDeprecated: WithDefaultImplPure {
    @java.lang.Deprecated
    override fun test() {
        super.test()
    }

    override val prop: String
        @java.lang.Deprecated get() = super.prop
}


@JvmDefaultWithoutCompatibility
interface NoDefaultImpl2FromDefaultImpls : WithDefaultImplPure {
    fun test2() {}
}

@JvmDefaultWithoutCompatibility
class KotlinClass : NoDefaultImpl