package com.github.greboreda.example.model.authorization.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.github.greboreda.example.model.ValueObject;
import com.github.greboreda.example.model.authorization.role.RoleVO;


@Entity
@Table(
		name = "UserApp",
		uniqueConstraints= @UniqueConstraint(columnNames={"username"})
		)
public class UserVO implements ValueObject {

	private static final long serialVersionUID = 8374124677255581487L;

	private Long id;
	private String username;
	private String password;
	private String salt;

	private List<RoleVO> roles = new ArrayList<RoleVO>();
	
	public UserVO() {
		
	}
	
	@Id
	@SequenceGenerator(name="UserIdGenerator", sequenceName="UserIdSequence")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="UserIdGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="UserRole",
		joinColumns = @JoinColumn(name="userId"),
		inverseJoinColumns = @JoinColumn(name="roleId")
    )
	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}
	

}
