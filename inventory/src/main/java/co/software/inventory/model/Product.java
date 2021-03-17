package co.software.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
public class Product {
	@Id
	@Column(name = "reference", unique = true)
	private String reference;
	
	@Column(name = "poduct_name")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "id_product_type")
	private ProductType productType;
	
	@Column(name = "amount")
	private int	amount;
	
}
