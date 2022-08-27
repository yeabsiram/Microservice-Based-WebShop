package CustomerService.service;

import CustomerService.domain.Address;
import CustomerService.domain.Customer;

public class AddressAdapter {

    public static Address fromDTO(AddressDTO dto){
        Address address = new Address(dto.getStreet(), dto.getCity(), dto.getZip());
        return address;
    }

    public static AddressDTO toDTO(Address address){
        AddressDTO addressDTO = new AddressDTO(address.getStreet(), address.getCity(), address.getZip());
        return addressDTO;
    }
}
