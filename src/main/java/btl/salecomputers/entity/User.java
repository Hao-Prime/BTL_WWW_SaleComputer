package btl.salecomputers.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private int enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private List<Authenticate> authenticates;

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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Authenticate> getAuthenticates() {
		return authenticates;
	}

	public void setAuthenticates(List<Authenticate> authenticates) {
		this.authenticates = authenticates;
	}

	public Authenticate getAuthenticate(int id) {
		if (authenticates != null) {
			for (Authenticate theAuthenticate : authenticates)
				if (theAuthenticate.getId() == id)
					return theAuthenticate;
		}
		return null;
	}

	public void addCreditCard(Authenticate theCreditCard) {
		if (authenticates == null) {
			authenticates = new ArrayList<>();
		}
		authenticates.add(theCreditCard);
	}

}
