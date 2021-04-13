package co.software.apiinventory.aplication.handle;


import org.springframework.transaction.annotation.Transactional;

public interface HandlerCommand <C> {
    @Transactional
    void execute (C command);
}
