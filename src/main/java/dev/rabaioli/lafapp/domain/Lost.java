package dev.rabaioli.lafapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Lost implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String whoFind;
	private String local;
	private String userApp;
	private Date date;
	
	
	@ManyToMany
	@JoinTable(name = "LOST_CATEGORY",
	joinColumns = @JoinColumn(name="lost_id"),
	inverseJoinColumns = @JoinColumn(name="category_id")
	)
	private List<Category> categories = new ArrayList<>();
	
	public Lost() {}

	public Lost(Integer id, String description, String whoFind, String local, String userApp, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.whoFind = whoFind;
		this.local = local;
		this.userApp = userApp;
		this.date = date;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWhoFind() {
		return whoFind;
	}

	public void setWhoFind(String whoFind) {
		this.whoFind = whoFind;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUserApp() {
		return userApp;
	}

	public void setUserApp(String userApp) {
		this.userApp = userApp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
		Lost other = (Lost) obj;
		return Objects.equals(id, other.id);
	}


}
