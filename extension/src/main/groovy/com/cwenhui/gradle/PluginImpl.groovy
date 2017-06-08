package com.cwenhui.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginImpl implements Plugin<Project> {

    void apply(Project project) {
        //每个Gradle的Project都维护了一个ExtenionContainer，我们可以通过project.extentions访问额外的Property和定义额外的Property
        project.extensions.create("pluginExt", PluginExtension)
        project.pluginExt.extensions.create('nestExt', PluginNestExtension)
        project.task('customTask', type: CustomTask)
    }

}