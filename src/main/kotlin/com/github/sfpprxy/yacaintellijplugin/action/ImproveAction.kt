package com.github.sfpprxy.yacaintellijplugin.action

import com.github.sfpprxy.yacaintellijplugin.services.Improvement
import com.github.sfpprxy.yacaintellijplugin.services.ImprovementContext
import com.github.sfpprxy.yacaintellijplugin.services.YacaService
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

interface ImproveAction {
    fun asyncImprove(e: AnActionEvent) {
        val improvementContext = buildImprovementContext(e)

        // https://flylib.com/books/en/2.558.1/why_are_guis_single_threaded_.html

        val blockingQueue: BlockingQueue<Improvement> = LinkedBlockingQueue(1)

        ApplicationManager.getApplication().executeOnPooledThread {
            val improvement = YacaService.getInstance().improve(improvementContext)
            blockingQueue.put(improvement)
        }

        ApplicationManager.getApplication().executeOnPooledThread {
            val improvement = blockingQueue.take()
            useImprovement(e, improvement)
        }
    }

    fun buildImprovementContext(e: AnActionEvent): ImprovementContext

    fun useImprovement(e: AnActionEvent, improvement: Improvement)
}