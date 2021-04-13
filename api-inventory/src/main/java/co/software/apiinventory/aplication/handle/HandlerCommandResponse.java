package co.software.apiinventory.aplication.handle;


import org.springframework.transaction.annotation.Transactional;

public interface HandlerCommandResponse <C, R> {
    @Transactional
    R execute(C command);
}
