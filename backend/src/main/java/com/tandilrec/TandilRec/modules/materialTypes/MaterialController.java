package com.tandilrec.TandilRec.modules.materialTypes;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/material")
@RestController
public class MaterialController {

    private MaterialService service;

    public MaterialController() {
        this.service = new MaterialService();
    }

    @GetMapping("/types")
    public void getMaterialTypes(){
        System.out.println("getMaterialTypes");
    }

    @PutMapping("/types/{id}")
    public void editMaterialTypes(){

    }

    @DeleteMapping("/types/{id}")
    public void deleteMaterialTypes(@PathVariable String id){
    }

    @PostMapping("/types")
    public void createMaterialTypes(){
    }

}
