package com.boboram.laravelenvswitch.actions

import com.boboram.laravelenvswitch.constants.EnvType
import com.boboram.laravelenvswitch.constants.SwitchType
import com.boboram.laravelenvswitch.services.switchEnvFile
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import javax.swing.Icon

/**
 * Action class to demonstrate how to interact with the IntelliJ Platform.
 * The only action this class performs is to provide the user with a popup dialog as feedback.
 * Typically this class is instantiated by the IntelliJ Platform framework based on declarations
 * in the plugin.xml file. But when added at runtime this class is instantiated by an action group.
 * https://github.com/JetBrains/intellij-sdk-code-samples 자바로 돼있는 코드 참고하여 코틀린으로 변환후 플러그인에 필요한 메서드 구현함
 * 툴바 혹은 액션 클릭시 나오는 행위 구현
 * 해당 프로젝트에서는 메뉴 클릭시 환경파일 스위칭 되는 것을 구현
 */
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
        // project 는 플러그인을 사용중인 작업자의 프로젝트를 의미한다.
        val currentProject = event.project
        var type = event.presentation.text.lowercase()
        val dlgMsg = StringBuilder("Successful $type environment modification!")

        val switchType = switchEnvFile(currentProject, type)
        /**
         * 환경 파일이 있는 경우에만 copy file
         */
        if (switchType === SwitchType.Success) {
            Messages.showMessageDialog(
                currentProject,
                dlgMsg.toString(),
                event.presentation.description,
                Messages.getInformationIcon()
            )
        } else {
            /**
             * 파일이 존재하지 않아 생성하였습니다!
             * 추천
             * 1. 작업환경에 맞춰서 수정하기
             * 2. .gitignore 파일에 새로운 파일을 명시하기
             */
            Messages.showMessageDialog(
                currentProject,
                """File created because it does not exist!
                    
                   Recommendation
                   1. Modify according to the working environment
                   2. Specify new files in the .gitignore file
                   """.trimIndent(),
                "${switchType.getChangedFile(type)} file created!",
                Messages.getInformationIcon()
            )
        }
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