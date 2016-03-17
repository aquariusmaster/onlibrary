package com.onlibrary.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import java.lang.Object;import java.lang.Override;import java.lang.String;import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	@Column(name="name")
	private String name;

	@Column(name="enabled")
	private boolean enabled = false;

	@Column(name="authority")
	private String authority;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name="users_books",
			joinColumns={@JoinColumn(name="username")},
			inverseJoinColumns={@JoinColumn(name="book_id")})
	private Set<Book> favBooks = new HashSet<Book>();

	
	public User() {
		
	}

	public User(String username, String name, String password, String email, boolean enabled,
				String authority) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public User(String username, String name, String password, String email, boolean enabled,
			String authority, Set<Book> favBooks) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
		this.favBooks = favBooks;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Set<Book> getFavBooks() {
		return favBooks;
	}

	public void setFavBooks(Set<Book> favBooks) {
		this.favBooks = favBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", name="
				+ name + ", enabled=" + enabled + ", authority=" + authority
				+ "]";
	}

	
	

}
