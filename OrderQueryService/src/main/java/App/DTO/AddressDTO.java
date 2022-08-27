package App.DTO;

public class AddressDTO {
    private String street;

    private String city;

    private String zip;

    public AddressDTO(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public AddressDTO() {
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }



    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
