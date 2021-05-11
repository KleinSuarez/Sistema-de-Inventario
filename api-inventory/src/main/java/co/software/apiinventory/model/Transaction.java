package co.software.apiinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_product")
@Data
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction")
	private Integer idTransaction;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Column(name = "in_stock")
	private int inStock;
	
	@Column(name = "out_stock")
	private int outStock;
	
	@Column(name = "modification_date")
	private String modificationDate;

	public Transaction(Product product, int inStock, int outStock, String modificationDate) {
		this.product = product;
		this.inStock = inStock;
		this.outStock = outStock;
		this.modificationDate = modificationDate;
	}
}
