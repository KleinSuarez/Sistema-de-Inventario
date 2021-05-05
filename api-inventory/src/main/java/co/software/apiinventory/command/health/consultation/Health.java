package co.software.apiinventory.command.health.consultation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class Health {
    @GetMapping
    public String showStatus(){ return "It Works!"; }
}
