package icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * enum class Icons : 메뉴 아이콘
 */
enum class Icons(
) {
    LOCAL, PRE, LIVE;

    fun getIcon() :Icon {
        val path :String

        path = when(this) {
            LOCAL -> "switch"
            PRE -> "switch"
            LIVE -> "switch"
        }

        return IconLoader.getIcon(
            "/icons/${path}.svg",
            Icons::class.java
        )
    }
}