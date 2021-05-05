package co.software.apiinventory.command.transaction.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Transaction;
import co.software.apiinventory.service.transaction.consultation.TransactionConsultationService;

@RestController
@RequestMapping(value = "/v1/inventory/transations")
public class ControllerConsultationTransation {

	@Autowired
	private TransactionConsultationService consultationService;

	@Secured({"ROLE_ADMIN"})
	@GetMapping("products")
	Iterable<Transaction> listAllTransactions() {
		return consultationService.listAllTransactions();
	}
	
}
