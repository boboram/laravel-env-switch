package com.boboram.laravelenvswitch.actions

import com.boboram.laravelenvswitch.constants.EnvType
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 * internal class EnvSwitchMenuAction
 * tool > 처음나오게 되는 laravel-env-switch 메뉴의 하위메뉴 정의
 * laravel-env-switch 메뉴는 plugin.xml 에서 명시
 */
internal class EnvSwitchMenuAction : ActionGroup() {
    override fun getChildren(event: AnActionEvent?): Array<AnAction> {
        return arrayOf(
            EnvSwitchAction.makeSwitchMenu(EnvType.Local),
            EnvSwitchAction.makeSwitchMenu(EnvType.Pre),
            EnvSwitchAction.makeSwitchMenu(EnvType.Live)
        )
    }
}
