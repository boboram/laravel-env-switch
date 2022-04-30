package com.boboram.laravelenvswitch.constants


import com.intellij.openapi.util.IconLoader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import javax.swing.Icon

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TestEnvType {

    fun testEnvTypeData(): Array<Array<Any>>? {
        return arrayOf(
            arrayOf(
                EnvType.Local,
                "Local",
                IconLoader.getIcon("/icons/localIcon.svg", EnvType::class.java),
                "Local Env Switch"
            ),
            arrayOf(
                EnvType.Pre,
                "Pre",
                IconLoader.getIcon("/icons/preIcon.svg", EnvType::class.java),
                "Pre Env Switch"
            ),
            arrayOf(
                EnvType.Live,
                "Live",
                IconLoader.getIcon("/icons/liveIcon.svg", EnvType::class.java),
                "Live Env Switch"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testEnvTypeData")
    fun dataProvider(envType: EnvType, expectedName: String, expectedIcon: Icon, expectedDesc : String) {
        println(envType.name)
        assertEquals(expectedName, envType.name)
        assertEquals(expectedIcon, envType.getIcon())
        assertEquals(expectedDesc, envType.getDescription())
    }

    @Test
    fun testGetDescription() {
        val envType = EnvType.Local

        assertEquals("Local", envType.name)
    }
}