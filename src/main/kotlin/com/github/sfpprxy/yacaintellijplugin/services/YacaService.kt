package com.github.sfpprxy.yacaintellijplugin.services

import com.github.sfpprxy.yacaintellijplugin.YacaBundle.message
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.util.io.HttpRequests

@Service
class YacaService {

    fun improve(ctx: ImprovementContext): Improvement {
        val improvementContext = gson.toJson(ctx)
        thisLogger().debug("improvementContext: $improvementContext")

        val improvementRes = HttpRequests.post(apiUrl, HttpRequests.JSON_CONTENT_TYPE)
                .throwStatusCodeException(false)
                .connect {
                    it.write(improvementContext)
                    it.readString()
                }
        thisLogger().debug("improvementRes: $improvementRes")

        return gson.fromJson(improvementRes, Improvement::class.java)
    }


    companion object {
        fun getInstance(): YacaService = service()

        val gson: Gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val apiUrl: String = message("settings.backend.api.url")
    }
}
