package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "Article")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Article implements Serializable{

    private static final long serialVersionUID = 1L;
	
    private int id;
	 
	private int arcid;			//文章在门户的数据库中的id（为方便修改文章设定）
	
	private String arctype;		//文章的所属的栏目
	
	private String arctitle;	//文章的标题
	
	private String content;		//文章的内容
	
	private Date pubtime;		//文章发表的时间
	
 
	 	
	public Article(){
		super();
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArcid() {
		return arcid;
	}

	public void setArcid(int arcid) {
		this.arcid = arcid;
	}

	@Column(length=20)
	public String getArctype() {
		return arctype;
	}

	public void setArctype(String arctype) {
		this.arctype = arctype;
	}

	@Column(length=200)
	public String getArctitle() {
		return arctitle;
	}

	public void setArctitle(String arctitle) {
		this.arctitle = arctitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubtime() {
		return pubtime;
	}

	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}

	

}
