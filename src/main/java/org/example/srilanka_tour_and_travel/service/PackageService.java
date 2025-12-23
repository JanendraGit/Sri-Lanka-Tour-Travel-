package org.example.srilanka_tour_and_travel.service;

import org.example.srilanka_tour_and_travel.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.dto.request.PackageRequest;

import java.util.List;

public interface PackageService {
    PackageRequest addPackage(PackageRequest packageRequest);
    void  updatePackage(Long id, PackageRequest packageRequest);
    void deletePackage(Long id);
    PackageDTO getPackageById(Long id);
    List<PackageDTO> getAllPackages();
}
