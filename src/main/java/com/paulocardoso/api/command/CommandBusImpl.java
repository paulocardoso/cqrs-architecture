package com.paulocardoso.api.command;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CommandBusImpl implements CommandBus {

    private Set<CommandHandler> commandHandlers;

    public CommandBusImpl() {
        this.commandHandlers = new HashSet<>();
    }

    @Override
    public <C> void execute(C command) {
       findCommandHandler(command).handle(command);
    }

    @Override
    public <C extends Command<R>, R> R execute(C command) {
        return (R) findCommandHandler(command).handle(command);
    }

    @Override
    public <C extends Command<R>, R> void register(CommandHandler handler) {
        if (!commandHandlers.contains(handler))
             this.commandHandlers.add(handler);
    }

    private <C> CommandHandler<C, ?> findCommandHandler(C command) {
        Class<?> commandClazz = command.getClass();
        return this.commandHandlers.stream()
                .filter(handler -> this.canHandleCommand(handler.getClass(), commandClazz))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Do not handle " + commandClazz.getName()));
    }

    private boolean canHandleCommand(Class<? extends CommandHandler> handlerClazz, Class<?> commandClazz) {
        var genericInterfaces = handlerClazz.getGenericInterfaces();

        var handlerInterfaceType = Stream.of(genericInterfaces)
                .filter(t -> t instanceof ParameterizedType).findFirst();

        if(handlerInterfaceType.isPresent()){
            var type = (ParameterizedType) handlerInterfaceType.get();
            return commandClazz.equals(type.getActualTypeArguments()[0]);
        }

       return false;
    }
}
