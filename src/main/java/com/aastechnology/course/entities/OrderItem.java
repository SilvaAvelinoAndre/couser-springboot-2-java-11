package com.aastechnology.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aastechnology.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK(); // (ID composto) classe que identifica o pedido e os produtos, pois a classe OrderItem é uma classe intermediaria
	// entre a classe Product e Order, então para poder criar chaves de identificação pedido/produto é necessario usar uma
	//classe auxiliar no caso OrderItemPK, esta responsavel por associar pedido e produto com um id que e´a chave primaria.
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}

	/*
	 * Este construtor teve que ser implementado manualmente passando o Order order e o 
	 * Product product,para passar também o item do pedido(order) o produto(product), junto com as
	 * outras informações desta classe(quantidade, preço)
	 */
	public OrderItem(Order order, Product product,Integer quantity, Double price) {
		super();
		id.setOrder(order); // implementação manual - associação com id
		id.setProduct(product);// implementação manual - associação com id
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product product) {// informando um produto
		id.setProduct(product);//Pega o produto passado e inseri no id da classe OrderItemPK
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) { // informando um pedido
		id.setOrder(order); // Pega o numero do pedido e inseri no OrderItemPK id la em cima
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
