package com.example.lab5.init

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import com.example.lab5.config.RootConfig
import com.example.lab5.config.WebConfig

class WebInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getServletMappings(): Array<String> = arrayOf("/")

    override fun getRootConfigClasses(): Array<Class<*>> = arrayOf(RootConfig::class.java)

    override fun getServletConfigClasses(): Array<Class<*>> = arrayOf(WebConfig::class.java)
}