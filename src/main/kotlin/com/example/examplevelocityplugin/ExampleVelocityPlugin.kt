package com.example.examplevelocityplugin

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger
import java.nio.file.Path

@Plugin(
    id = "velocityexamplekotlin", // required unique ID for this plugin, this should not be changed later
    name = "Velocity Kotlin Example", // display name of the plugin
    version = "1.0.0-SNAPSHOT", // version string of the plugin
    dependencies = [], // string array of ids of plugins this plugin depends on
    url = "https://github.com/MicleBrick/ExampleKotlinVelocityPlugin", // url
    description = "An example plugin made in Kotlin for Velocity proxy servers.", // a short description
    authors = ["MicleBrick"] // string array of people who made the plugin
)
class ExampleVelocityPlugin {
    // The inject annotation makes certain types of classes injected into your plugin.
    // For a list of classes you can inject see here:
    // https://github.com/VelocityPowered/Velocity/blob/master/proxy/src/main/java/com/velocitypowered/proxy/plugin/loader/java/VelocityPluginModule.java

    // lateinit lets you bypass kotlin's null safety. Use it carefully.

    /**
     * Logger for this plugin to use to log information to the console
     */
    @Inject
    lateinit var log: Logger

    /**
     * Proxy server instance, other managers can be accessed from it like event manager
     */
    @Inject
    lateinit var proxy: ProxyServer

    /**
     * Data folder for this plugin to store its config etc in
     */
    @Inject
    @DataDirectory
    lateinit var dataFolderPath: Path

    // @Subscribe makes your method subscribe to an event, so calling that event
    // calls your method. Plugin classes are automatically registered for subscribers,
    // but if you want to have subscribers in a separate class,
    // you'll need to register it with the proxy.eventManager.register(/*...*/)

    @Subscribe
    fun onStart(event: ProxyInitializeEvent) {
        log.info("Hello World!")
    }

    @Subscribe
    fun onStop(event: ProxyShutdownEvent) {
        log.info("Goodbye, World.")
    }
}