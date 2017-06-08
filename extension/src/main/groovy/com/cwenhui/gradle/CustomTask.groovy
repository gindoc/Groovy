package com.cwenhui.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Author: GIndoc on 2017/6/8 10:13
 * email : 735506583@qq.com
 * FOR   :
 */

public class CustomTask extends DefaultTask {
    String test

    @TaskAction
    void output() {
        println "param1 is ${project.pluginExt.param1}"
        println "param2 is ${project.pluginExt.param2}"
        println "param3 is ${project.pluginExt.param3}"
        println "nestparam1 is ${project.pluginExt.nestExt.nestParam1}"
        println "nestparam2 is ${project.pluginExt.nestExt.nestParam2}"
        println "nestparam3 is ${project.pluginExt.nestExt.nestParam3}"
    }
}
