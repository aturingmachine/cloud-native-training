package solstice.bootcamp.employeeclient;


public class Address {

    private String id;
    private String address;
    private String suite;
    private String state;
    private String zipcode;
    private String country;

    public Address() {};

    public Address(String address, String suite, String state, String zipcode, String country) {
        this.address = address;
        this.suite = suite;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
