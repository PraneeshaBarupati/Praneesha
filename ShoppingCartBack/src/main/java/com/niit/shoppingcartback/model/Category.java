package com.niit.shoppingcartback.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity // for table
@Table(name = "category") // name of table-->if table name and domain class name
@Component
public class Category {

	// it specifies the constraint type of Primary Key-->id,name,description are
	// fields in the  table

	@Id
	@Column(name = "myid")
	private String id;

	@Column(name = "name") // for change the field name
	private String name;

	@NotEmpty
	private String description;

	@Transient // (u don't want to store this field in db)then specify like
	// this.
	private String createdby;

	@Version
	private Timestamp tstamp;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "myid", updatable = false, insertable = false)
	private Category category;

	// getters + setters

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getTstamp() {
		return tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	public Category() {
	
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", createdby=" + createdby
				+ ", tstamp=" + tstamp + "]";
	}

}
