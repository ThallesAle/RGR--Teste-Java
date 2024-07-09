package org.rgrThalles.controllers;

import jakarta.validation.Valid;
import org.rgrThalles.repository.AddressRepository;
import org.rgrThalles.service.ZipCodeService;
import org.rgrThalles.model.Address;
import org.rgrThalles.model.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private ZipCodeService zipCodeService;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @PostMapping
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            return ResponseEntity.ok().body(address.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(
            @PathVariable(value = "id") Long addressId,
            @Valid @RequestBody Address addressDetails
    ) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setAddress(addressDetails.getAddress());
            address.setNumber(addressDetails.getNumber());
            address.setComplement(addressDetails.getComplement());
            address.setPostalCode(addressDetails.getPostalCode());
            address.setCity(addressDetails.getCity());
            address.setState(addressDetails.getState());
            address.setCountry(addressDetails.getCountry());
            Address updatedAddress = addressRepository.save(address);
            return ResponseEntity.ok(updatedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(value = "id") Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/address/{cep}")
    public AddressResponse getAddressByZipCode(@PathVariable("cep") String cep) {
        return zipCodeService.getAddressByZipCode(cep);
    }
}
