package com.boboram.laravelenvswitch.constants

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * env type
 * 환경 타입과 그것에 맞는 설명, 아이콘을 반환
 */
enum class EnvType {
    Local, Pre, Live;

    /**
     * env description
     * 코틀린의 가시성 기본은 public
     */
    fun getDescription():String {
        return "$name Env Switch"
    }

    /**
     * get menu icon by env
     */
    fun getIcon() : Icon {
        return IconLoader.getIcon(
            "/icons/${name.lowercase()}Icon.svg",
            EnvType::class.java
        )
    }
}