package com.rickwebstudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "YixinActionLog")
public class YixinActionLog {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "groupName")
	private String groupName;
	@Column(name = "typeName")
	private String typeName;
	@Column(name = "article")
	private String article;
	@Column(name = "createTime")
	private String createTime;
	@Column(name = "updateTime")
	private String updateTime;
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = com.rickwebstudy.entity.YixinUser.class)
	private YixinUser owner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public YixinUser getOwner() {
		return owner;
	}
	public void setOwner(YixinUser owner) {
		this.owner = owner;
	}
	
}
