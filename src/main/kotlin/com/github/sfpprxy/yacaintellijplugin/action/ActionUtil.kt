package com.github.sfpprxy.yacaintellijplugin.action

import com.github.sfpprxy.yacaintellijplugin.exception.YacaException
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.psi.PsiFile

class ActionUtil {
    companion object {
        fun getEditor(e: AnActionEvent) = (CommonDataKeys.EDITOR.getData(e.dataContext)
                ?: throw YacaException("Editor not found"))

        fun getFilePath(e: AnActionEvent): String {
            val project = e.project ?: throw YacaException("Project not found")
            val projectRoot = project.basePath ?: throw YacaException("Project root not found")
            val filePath = getPsiFile(e).virtualFile.path
            return filePath.substring(projectRoot.length + 1)
        }

        fun getFileSize(e: AnActionEvent): Int {
            return getPsiFile(e).virtualFile.length.toInt()
        }

        fun getPsiFile(e: AnActionEvent): PsiFile {
            return e.getData(CommonDataKeys.PSI_FILE) ?: throw YacaException("PsiFile not found")
        }

        fun hasSelection(e: AnActionEvent): Boolean {
            return e.getRequiredData(CommonDataKeys.EDITOR).caretModel.currentCaret.hasSelection()
        }
    }
}