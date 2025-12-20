package org.example.srilanka_tour_and_travel.service;

import lombok.RequiredArgsConstructor;
import org.example.srilanka_tour_and_travel.controller.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.controller.request.PackageRequest;
import org.example.srilanka_tour_and_travel.entity.Package;
import org.example.srilanka_tour_and_travel.exception.PackageNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.PackageMapper;
import org.example.srilanka_tour_and_travel.repository.*;
import org.example.srilanka_tour_and_travel.service.impl.PackageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PackageService implements PackageImpl {
    private final PackageRepository packageRepository;
    private final DestinationRepository destinationRepository;
    private final AdminRepository adminRepository;
    private final TourGuideRepository tourGuideRepository;
    private final HotelRepository hotelRepository;
    private final PackageMapper packageMapper;

    @Override
    public PackageRequest addPackage(PackageRequest packageRequest) {
        Optional<Package> optionalPackage = packageRepository.findByPackageName(packageRequest.getPackageName());
        if(optionalPackage.isPresent()){
            throw new RuntimeException("Package with name " + packageRequest.getPackageName() + " already exists");
        }
        Package pack = packageMapper.toEntity(packageRequest);
        pack.setDestination(destinationRepository.findById(packageRequest.getDestinationId()).orElseThrow(() -> new RuntimeException("Destination not found")));
        pack.setAdmin(adminRepository.findById(packageRequest.getAdminId()).orElseThrow(() -> new RuntimeException("Admin not found")));
        pack.setTourGuide(tourGuideRepository.findById(packageRequest.getTourGuideId()).orElseThrow(() -> new RuntimeException("TourGuide not found")));
        pack.setHotel(hotelRepository.findById(packageRequest.getHotelId()).orElseThrow(() -> new RuntimeException("Hotel not found")));
        packageRepository.save(pack);
        return packageRequest;
    }

    @Override
    public void updatePackage(Long id, PackageRequest packageRequest) {
        Package package1 = packageRepository.findById(id)
                .orElseThrow(() -> new PackageNotFoundException("Package with id " + id + " not found"));
        package1.setPackageName(packageRequest.getPackageName());
        package1.setPackageDescription(packageRequest.getPackageDescription());
        package1.setPackageImage(packageRequest.getPackageImage());
        package1.setPackageCategory(packageRequest.getPackageCategory());
        package1.setPrice(packageRequest.getPrice());
        package1.setAvailability(packageRequest.getAvailability());
        package1.setDuration(packageRequest.getDuration());
        packageRepository.save(package1);
    }

    @Override
    public void deletePackage(Long id) {
        Package pack = packageRepository.findById(id)
                .orElseThrow(() -> new PackageNotFoundException("Package with id " + id + " not found"));
        packageRepository.delete(pack);
    }

    @Override
    public PackageDTO getPackageById(Long id) {
        Package pack = packageRepository.findById(id)
                .orElseThrow(() -> new PackageNotFoundException("Package with id " + id + " not found"));
        return packageMapper.toDTO(pack);
    }

    @Override
    public List<PackageDTO> getAllPackages() {
        List<Package> packages = packageRepository.findAll();
        return packages.stream().map(packageMapper::toDTO).toList();
    }
}
