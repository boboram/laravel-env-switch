package com.boboram.laravelenvswitch.constants

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SwitchTypeTest {

    fun dataProvider(): Array<Array<Any>>? {
        val type :String? = ""
        return arrayOf(
            arrayOf(
                SwitchType.Success,
                "Success",
                ".env",
                ""
            ),
            arrayOf(
                SwitchType.CreateEnv,
                "CreateEnv",
                ".env",
                ""
            ),
            arrayOf(
                SwitchType.CreateEnvToType,
                "CreateEnvToType",
                ".env.${type?:""}",
                "${type?:""}"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun testGetChangedFile(switchType: SwitchType, expectedName:String, expectedChangeFile:String, type:String? = "") {
        println(switchType.name)
        assertEquals(expectedName, switchType.name)
        assertEquals(expectedChangeFile, switchType.getChangedFile(type?:""))
    }
}

enum class SwitchType {
    Success, CreateEnv, CreateEnvToType;

    /**
     * 변경된 파일이 무엇인지 리턴
     * @param type
     */
    fun getChangedFile(type:String? = "") :String{
        return when(this) {
            Success, CreateEnv -> ".env"
            CreateEnvToType -> ".env.${type}"
        }
    }
}
