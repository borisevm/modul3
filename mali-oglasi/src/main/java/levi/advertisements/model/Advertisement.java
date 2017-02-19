package levi.advertisements.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import levi.advertisements.support.JsonDateSerializer;

@Entity
public class Advertisement {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(name="date_start", nullable=false)
//	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateStart;
	
	@Column(name="date_end", nullable=false)
//	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateEnd;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User author;

	public Advertisement() {
		super();
	}
	
	public Advertisement(String title, Date dateStart, Date dateEnd, String content) {
		super();
		this.title = title;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	
	//@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	

}
