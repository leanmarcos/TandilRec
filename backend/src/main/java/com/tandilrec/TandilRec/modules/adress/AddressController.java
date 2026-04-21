package com.tandilrec.TandilRec.modules.adress;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")  // define el path base
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping()
    public AddressDTOResponse save(@RequestBody AddressDTO address) {
        System.out.println("llegó");
        return this.addressService.create(address);
    }

    @PutMapping("/{id}")
    public AddressDTOResponse update(@RequestBody AddressDTO address,
                                     @PathVariable("id") Long id) {
        return this.addressService.update(address, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.addressService.delete(id);
    }
}

