package com.github.boboram.laravelenvswitch.services

import com.github.boboram.laravelenvswitch.constants.DefaultEnvExample
import com.intellij.openapi.project.Project
import java.io.File

/**
 * .env 파일 존재 여부 확인해서
 * 있으면 copy .env .env.{type}
 * 없으면 .env.{type} 생성 해주고 알림
 * @param currentProject : current working project
 * @param type : env type - local | pre | live
 **/
fun switchEnvFile(currentProject:Project?, type:String) :Boolean {
    val targetFullPath = "${currentProject?.basePath}/.env"
    val fullPath = "${targetFullPath}.${type}"

    val file = File(fullPath)
    val existFile :Boolean = file.exists()

    if (!existFile) {
        File(fullPath).writeText(DefaultEnvExample.laravelEnv)
    } else {
        file.copyTo(File(targetFullPath), true)
    }

    return existFile
}