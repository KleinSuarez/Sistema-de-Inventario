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
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduct")
	private Integer idProduct;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "product_name")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "id_product_type")
	private ProductType productType;
	
	@Column(name = "stock")
	private int stock;

	@Column(name = "is_active")
	private boolean active;
}
