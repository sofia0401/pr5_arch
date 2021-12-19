package messagingstompwebsocket.Models;
import javax.persistence.*;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String lastname;

	public Users(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public Users() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	@Override
//	public String toString() {
//		return "User{" +
//				"id=" + id +
//				", name='" + name + '\'' +
//				", surname='" + surname + '\'' +
//				'}';
//	}
}
