package org.rgrThalles.controllers;

import org.rgrThalles.service.ZipCodeService;
import org.rgrThalles.model.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressWebController {

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping("/address/{cep}")
    public String getAddressDetails(@PathVariable("cep") String cep, Model model) {
        AddressResponse addressResponse = zipCodeService.getAddressByZipCode(cep);
        model.addAttribute("addressResponse", addressResponse);
        return "address";
    }
}
