package Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Age must be 18 or older")
    private Integer age;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @Email(message = "Email should be valid")
    private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + ", email=" + email + "]";
	}

	public User(String id, @NotBlank(message = "Name is mandatory") String name,
			@NotNull(message = "Age is mandatory") @Min(value = 18, message = "Age must be 18 or older") Integer age,
			@NotBlank(message = "Country is mandatory") String country,
			@Email(message = "Email should be valid") String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.country = country;
		this.email = email;
	}

    
}
