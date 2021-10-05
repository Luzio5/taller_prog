package com.entrenamosuy.core;

public abstract class AbstractFacade {

    private AbstractRegistry registery;

    public void setRegistry(AbstractRegistry registry) {
        this.registery = registry;
    }

    public AbstractRegistry getRegistry() {
        return registery;
    }
}
