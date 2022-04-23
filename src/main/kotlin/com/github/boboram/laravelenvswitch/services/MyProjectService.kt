package com.github.boboram.laravelenvswitch.services

import com.intellij.openapi.project.Project
import com.github.boboram.laravelenvswitch.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
