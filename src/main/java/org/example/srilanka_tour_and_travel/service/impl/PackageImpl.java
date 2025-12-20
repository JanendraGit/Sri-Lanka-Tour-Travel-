package org.example.srilanka_tour_and_travel.service.impl;

import org.example.srilanka_tour_and_travel.controller.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.controller.request.PackageRequest;

import java.util.List;

public interface PackageImpl {
    PackageRequest addPackage(PackageRequest packageRequest);
    void  updatePackage(Long id, PackageRequest packageRequest);
    void deletePackage(Long id);
    PackageDTO getPackageById(Long id);
    List<PackageDTO> getAllPackages();
}
