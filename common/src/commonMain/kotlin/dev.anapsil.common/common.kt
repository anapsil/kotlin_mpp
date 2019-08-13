package dev.anapsil.common

import kotlin.coroutines.CoroutineContext

expect fun platformName():String

fun createApplicationScreenMessage() : String {
    return "Hello World, from ${platformName()}"
}

internal expect val ApplicationDispatcher: CoroutineContext