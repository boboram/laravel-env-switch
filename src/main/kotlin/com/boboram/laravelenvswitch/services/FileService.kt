package com.boboram.laravelenvswitch.services

import com.boboram.laravelenvswitch.constants.DefaultEnvExample
import com.boboram.laravelenvswitch.constants.SwitchType
import com.intellij.openapi.application.Application
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import java.io.IOException


/**
 * .env 파일 존재 여부 확인해서
 * 있으면 copy .env .env.{type}
 * 없으면 .env.{type} 생성 해주고 알림
 * @param currentProject : current working project
 * @param type : env type - local | pre | live
 * @return switchType : 스위칭 결과
 **/
fun switchEnvFile(currentProject:Project?, type:String) :SwitchType {

    val targetFullPath = "${currentProject?.basePath}/.env"
    val fullPath = "${targetFullPath}.${type}"
    var switchType = SwitchType.Success

    //# 가상 파일 찾기
    //# .env 파일 (실제 환경 파일)
    val envFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(targetFullPath);
    //# .env.{#type} 파일 (env별 파일 - 복사할 파일)
    val envToTypeFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(fullPath);

    //# setBinaryContent는 runWriteAction 내부에서 실행돼야함
    val app: Application = ApplicationManager.getApplication()

    //.env 파일이 없는 경우
    if (envFile === null) {
        switchType = SwitchType.CreateEnv
        createEnvFile(currentProject, "", app)
    } else if (envToTypeFile === null) {
        //복사할 파일이 없는 경우 .env.{#type} 파일을 생성한다.
        switchType = SwitchType.CreateEnvToType
        createEnvFile(currentProject, type, app)
    } else { //두개의 파일이 모두 있는 경우라면
        //.env.type 파일이 존재한다면 .env에 넣어주기
        app.runWriteAction {
            try {
                envFile?.let {
                    it.setBinaryContent(envToTypeFile?.contentsToByteArray())
                    it.refresh(false, false) //동기화, 재귀호출X
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }

    return switchType
}

/**
 * 새로운 .env.{type} 생성 함수
 * @param currentProject : 현재 동작중인 프로젝트
 * @param type : .env 파일 타입, .env라면 ""
 * @param app
 */
fun createEnvFile(currentProject:Project?, type:String, app:Application) {
    val vFromDir: VirtualFile? = currentProject?.basePath?.let {
        LocalFileSystem.getInstance()
                .findFileByPath(it)
    }
    var fileName:String = ".env"
    if (type !== "") {
        fileName = "${fileName}.${type}"
    }
    vFromDir?.let {
        app.runWriteAction {
            try {
                val fileToCopy:VirtualFile? = it.createChildData(currentProject, fileName);
                fileToCopy?.let {
                    //envExample 문자열 넣어주기
                    it.setBinaryContent(DefaultEnvExample.laravelEnv.toByteArray(Charsets.UTF_8))
                    it.refresh(false, false)
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }
}