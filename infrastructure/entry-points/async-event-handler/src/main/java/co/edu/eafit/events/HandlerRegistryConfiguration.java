package co.edu.eafit.events;

import co.edu.eafit.events.handlers.CommandsHandler;
import co.edu.eafit.events.handlers.EventsHandler;
import co.edu.eafit.events.handlers.QueriesHandler;
import co.edu.eafit.usecase.CheckWeatherUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableQueryListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, QueriesHandler queries) {
        return HandlerRegistry.register()
                //.handleCommand("some.command.name", commands::handleCommandA, Object.class/*change for proper model*/)
                .serveQuery("weather.query", queries::handleQueryA, WeatherQuery.class);
    }
}
