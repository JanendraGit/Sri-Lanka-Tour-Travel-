package org.example.srilanka_tour_and_travel.controller;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.controller.request.PackageRequest;
import org.example.srilanka_tour_and_travel.service.PackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/packages")
public class PackageController {
    private final PackageService packageService;

    @PostMapping
    public ResponseEntity<PackageRequest> addPackage(@RequestBody PackageRequest packageRequest){
        PackageRequest savedPackage = packageService.addPackage(packageRequest);
        return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePackage(@PathVariable Long id, @RequestBody PackageRequest packageRequest){
        packageService.updatePackage(id, packageRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id){
        packageService.deletePackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageDTO> getPackageById(@PathVariable Long id){
        PackageDTO packageDTO = packageService.getPackageById(id);
        return new ResponseEntity<>(packageDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAllPackages(){
        List<PackageDTO> packages = packageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

}
