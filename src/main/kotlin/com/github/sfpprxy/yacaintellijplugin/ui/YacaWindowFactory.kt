package com.github.sfpprxy.yacaintellijplugin.ui

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory

class YacaWindowFactory : ToolWindowFactory {

    init {
        thisLogger().info("Init YacaWindowFactory, Happy developing!\n" +
                "██╗   ██╗ █████╗  ██████╗ █████╗ \n" +
                "╚██╗ ██╔╝██╔══██╗██╔════╝██╔══██╗\n" +
                " ╚████╔╝ ███████║██║     ███████║\n" +
                "  ╚██╔╝  ██╔══██║██║     ██╔══██║\n" +
                "   ██║   ██║  ██║╚██████╗██║  ██║\n" +
                "   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

    }

    override fun shouldBeAvailable(project: Project) = false
}
