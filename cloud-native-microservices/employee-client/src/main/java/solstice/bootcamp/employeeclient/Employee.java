package solstice.bootcamp.employeeclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Employee {

    @JsonProperty("firstName")
    private String first;
    @JsonProperty("lastName")
    private String last;
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private List<Address> addresses;

    public Employee() {}

    public Employee(String first, String last, String email, String password, List<Address> addresses) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee [first=" + first + ", last=" + last + ", email=" + email + ", password=" + password + "]";
    }
}
