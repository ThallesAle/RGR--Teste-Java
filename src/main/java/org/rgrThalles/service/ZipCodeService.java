package org.rgrThalles.service;

import org.rgrThalles.model.AddressResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService {
    private final RestTemplate restTemplate;

    public ZipCodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AddressResponse getAddressByZipCode(String zipCode) {
        String url = "https://api.brasilaberto.com/v1/zipcode/" + zipCode;
        return restTemplate.getForObject(url, AddressResponse.class);
    }
}

