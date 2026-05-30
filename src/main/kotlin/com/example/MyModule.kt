package com.example

import de.snenjih.velocloud.agent.Agent
import de.snenjih.velocloud.shared.events.definitions.service.ServiceChangeStateEvent
import de.snenjih.velocloud.shared.module.VelocloudModule
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

val logger: Logger = LogManager.getLogger()

class MyModule : VelocloudModule {

    override fun onEnable() {
        // Here you can add your module's initialization logic
        Agent.eventProvider().subscribe(ServiceChangeStateEvent::class.java) { event ->
            logger.info("[MyModule] Service '${event.service.name()}' changed his state to '${event.service.state}'")
        }
    }

    override fun onDisable() {
        // Here you can add your module's cleanup logic
        logger.info("[MyModule] Good bye!")
    }

}