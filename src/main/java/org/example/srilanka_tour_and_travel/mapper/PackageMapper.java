package org.example.srilanka_tour_and_travel.mapper;

import org.example.srilanka_tour_and_travel.controller.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.controller.request.PackageRequest;
import org.example.srilanka_tour_and_travel.entity.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageMapper {
    public Package toEntity(PackageRequest packageRequest){
        Package pack = new Package();
        pack.setPackageName(packageRequest.getPackageName());
        pack.setPackageDescription(packageRequest.getPackageDescription());
        pack.setPackageImage(packageRequest.getPackageImage());
        pack.setPackageCategory(packageRequest.getPackageCategory());
        pack.setPrice(packageRequest.getPrice());
        pack.setAvailability(packageRequest.getAvailability());
        pack.setDuration(packageRequest.getDuration());
        return pack;
    }

    public PackageDTO toDTO(Package pack){
        PackageDTO packageDTO = new PackageDTO();
        packageDTO.setPackageId(pack.getPackageId());
        packageDTO.setPackageName(pack.getPackageName());
        packageDTO.setPackageDescription(pack.getPackageDescription());
        packageDTO.setPackageImage(pack.getPackageImage());
        packageDTO.setPackageCategory(pack.getPackageCategory());
        packageDTO.setPrice(pack.getPrice());
        packageDTO.setAvailability(pack.getAvailability());
        packageDTO.setDuration(pack.getDuration());
        return packageDTO;
    }
}
