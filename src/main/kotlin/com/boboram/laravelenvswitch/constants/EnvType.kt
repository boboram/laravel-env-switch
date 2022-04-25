package com.boboram.laravelenvswitch.constants

import com.boboram.laravelenvswitch.actions.EnvSwitchAction
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * env type
 */
enum class EnvType {
    Local, Pre, Live;

    /**
     * env description
     */
    private fun getDescription():String {
        return "${this.name} Env Switch"
    }

    /**
     * get menu icon by env
     */
    private fun getIcon() : Icon {
        return IconLoader.getIcon(
            "/icons/${name.lowercase()}Icon.svg",
            EnvType::class.java
        )
    }

    /**
     * get AnAction by env
     */
    fun getAction() : AnAction {
        return EnvSwitchAction(
            name,
            this.getDescription(),
            this.getIcon()
        )
    }
}