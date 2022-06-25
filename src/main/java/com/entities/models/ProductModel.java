package com.entities.models;

import com.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
	private Long id;
	@NotNull
	@NotBlank
	private String productName;
	private String description;
	@NotNull
	private String status;
	@NotNull
	private Double price;
	@NotNull
	private Long quantity;
	@NotNull
	private String image;
	@NotNull
	private Long category;
	@NotNull
	private Long brand;
	@NotNull
	private Long country;
	@NotNull
	private Long unit;
	@NotNull
	private Long weight;

	public static Product toEntity(ProductModel model) {
		if (model == null) throw new RuntimeException("ProductModel is null");
		return Product.builder()
				.id(model.getId())
				.productName(model.getProductName())
				.description(model.getDescription())
				.status(model.getStatus())
				.price(model.getPrice())
				.quantity(model.getQuantity())
				.image(model.getImage())
				.build();
	}

}
