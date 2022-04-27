package com.boboram.laravelenvswitch.constants

/**
 * 스위칭 타입
 */
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