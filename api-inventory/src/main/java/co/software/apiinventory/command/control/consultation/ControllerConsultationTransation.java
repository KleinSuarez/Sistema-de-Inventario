package co.software.apiinventory.command.control.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Transaction;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.control.consultation.TransactionConsultationService;
import co.software.apiinventory.service.inventory.cosultation.InventoryConsultationService;

@RestController
@RequestMapping(value = "/v1/inventory/transations")
public class ControllerConsultationTransation {

	@Autowired
	private TransactionConsultationService consultationService;

	@GetMapping("products")
	Iterable<Transaction> listAllTransactions() {
		
		return consultationService.listAllTransactions();
	}
	
}
