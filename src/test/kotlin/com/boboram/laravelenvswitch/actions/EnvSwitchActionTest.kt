package com.boboram.laravelenvswitch.actions

import com.boboram.laravelenvswitch.constants.EnvType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.Icon
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EnvSwitchActionTest {
    @Test
    fun testMakeSwitchEnv() {
        val envType = EnvType.Local
        val action = EnvSwitchAction(envType.name, envType.getDescription(), envType.getIcon())

        assertEquals(action.templateText, EnvSwitchAction.makeSwitchMenu(envType).templateText)
        assertEquals(action.templatePresentation.toString(), EnvSwitchAction.makeSwitchMenu(envType).templatePresentation.toString())
    }

}

class EnvSwitchAction : AnAction {

    /**
     * 이 생성자는 동적으로 추가된 메뉴 작업을 지원하는 데 사용
     * 메뉴 항목에 대해 표시할 텍스트와 설명
     * 동적이 아닌경우 기본 AnAction 생성자 사용
     *
     * @param text        env type(환경 타입) local, pre, live
     * @param description 메뉴 설명
     * @param icon        menu icon(메뉴 아이콘)
     */
    constructor(text: String?, description: String?, icon: Icon?) : super(text, description, icon)

    companion object {
        /**
         * env_type 을 보내면 해당 내용값으로 메뉴를 생성한다.(팩토리메서드)
         * 이 생성자는 동적으로 추가된 메뉴 작업을 지원하는 데 사용
         * 메뉴 항목에 대해 표시할 텍스트와 설명
         * 동적이 아닌경우 기본 AnAction 생성자 사용
         * @param envType
         */
        fun makeSwitchMenu(envType: EnvType) = EnvSwitchAction(envType.name, envType.getDescription(), envType.getIcon())
    }

    /**
     * (동적 작업 메뉴를 선택시 알림창 띄우기)
     * 간단한 메시지 대화 상자를 표시합니다.
     * @param event 연결된 메뉴 항목을 선택시 이벤트
     * Local | Pre | Live 중 한개 누른 경우
     */
    override fun actionPerformed(event: AnActionEvent) {
        //
    }

    /**
     * Determines whether this menu item is available for the current context.
     * Requires a project to be open.
     *
     * @param e Event received when the associated group-id menu is chosen.
     */
    override fun update(e: AnActionEvent) {
        //
    }
}