@file:Suppress("unused")

package com.github.sfpprxy.yacaintellijplugin

import com.intellij.DynamicBundle
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey

/**
 *
 * Yet Another Coding Assistant - Intellij Plugin
 *
 * ██╗   ██╗ █████╗  ██████╗ █████╗
 * ╚██╗ ██╔╝██╔══██╗██╔════╝██╔══██╗
 *  ╚████╔╝ ███████║██║     ███████║
 *   ╚██╔╝  ██╔══██║██║     ██╔══██║
 *    ██║   ██║  ██║╚██████╗██║  ██║
 *    ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
 *
 */

@NonNls
private const val BUNDLE = "messages.YacaBundle"

object YacaBundle : DynamicBundle(BUNDLE) {
    @Suppress("SpreadOperator")
    @JvmStatic
    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            getMessage(key, *params)

    @Suppress("SpreadOperator", "unused")
    @JvmStatic
    fun messagePointer(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            getLazyMessage(key, *params)
}
