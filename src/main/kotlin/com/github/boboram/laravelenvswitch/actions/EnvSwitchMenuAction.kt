package com.github.boboram.laravelenvswitch.actions

import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icons.Icons

/**
 * internal class EnvSwitchMenuAction
 */
internal class EnvSwitchMenuAction : ActionGroup() {
    override fun getChildren(event: AnActionEvent?): Array<AnAction> {
        return arrayOf(
            PopupDialogAction(
                "Local Env",
                "Local Env Switch",
                Icons.LOCAL.getIcon()
            ),
            PopupDialogAction(
                "Pre Env",
                "Pre Env Switch",
                Icons.PRE.getIcon()
            ),
            PopupDialogAction(
                "Live Env",
                "Live Env Switch",
                Icons.LIVE.getIcon()
            )
        )
    }
}
