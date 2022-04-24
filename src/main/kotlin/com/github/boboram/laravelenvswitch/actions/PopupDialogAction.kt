package com.github.boboram.laravelenvswitch.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import javax.swing.Icon

/**
 * Action class to demonstrate how to interact with the IntelliJ Platform.
 * The only action this class performs is to provide the user with a popup dialog as feedback.
 * Typically this class is instantiated by the IntelliJ Platform framework based on declarations
 * in the plugin.xml file. But when added at runtime this class is instantiated by an action group.
 * https://github.com/JetBrains/intellij-sdk-code-samples 자바로 돼있는 코드 코틀린으로 변환만 하였음
 * 툴바 혹은 액션 클릭시 나오는 행위 구현
 */
class PopupDialogAction : AnAction {
    /**
     * This default constructor is used by the IntelliJ Platform framework to instantiate this class based on plugin.xml
     * declarations. Only needed in [PopupDialogAction] class because a second constructor is overridden.
     *
     * @see AnAction.AnAction
     */
    constructor() : super() {}

    /**
     * 이 생성자는 동적으로 추가된 메뉴 작업을 지원하는 데 사용
     * 메뉴 항목에 대해 표시할 텍스트와 설명
     * 동적이 아닌경우 기본 AnAction 생성자 사용
     *
     * @param text        메뉴에 표시되는 이름
     * @param description 메뉴 설명
     * @param icon        메뉴 아이콘
     */
    constructor(text: String?, description: String?, icon: Icon?) : super(text, description, icon) {}

    /**
     * (동적 작업 메뉴를 선택시 알림창 띄우기)
     * 간단한 메시지 대화 상자를 표시합니다.
     * @param event 연결된 메뉴 항목을 선택시 이벤트
     * Local | Pre | Live 중 한개 누른 경우
     */
    override fun actionPerformed(event: AnActionEvent) {
        // 이벤트를 사용하여 대화 상자 만들기 및 표시
        val currentProject = event.project
        val dlgMsg = StringBuilder(event.presentation.text + " Switching Success!")
        val dlgTitle = event.presentation.description
        // 편집기에서 요소를 선택한 경우 해당 요소에 대한 정보를 추가
        /*val nav = event.getData(CommonDataKeys.NAVIGATABLE)
        if (nav != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", nav.toString()))
        }*/
        //기본 제공 api
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon())
    }

    /**
     * Determines whether this menu item is available for the current context.
     * Requires a project to be open.
     *
     * @param e Event received when the associated group-id menu is chosen.
     */
    override fun update(e: AnActionEvent) {
        // Set the availability based on whether a project is open
        val project = e.project
        e.presentation.isEnabledAndVisible = project != null
    }
}