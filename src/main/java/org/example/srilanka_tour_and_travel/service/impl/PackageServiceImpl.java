package org.example.srilanka_tour_and_travel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.srilanka_tour_and_travel.dto.PackageDTO;
import org.example.srilanka_tour_and_travel.dto.request.PackageRequest;
import org.example.srilanka_tour_and_travel.entity.Package;
import org.example.srilanka_tour_and_travel.exception.AdminNotFoundException;
import org.example.srilanka_tour_and_travel.exception.DestinationNotFoundException;
import org.example.srilanka_tour_and_travel.exception.HotelNotFoundException;
import org.example.srilanka_tour_and_travel.exception.PackageNotFoundException;
import org.example.srilanka_tour_and_travel.exception.TourGuideNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.PackageMapper;
import org.example.srilanka_tour_and_travel.repository.*;
import org.example.srilanka_tour_and_travel.service.PackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final DestinationRepository destinationRepository;
    private final AdminRepository adminRepository;
    private final TourGuideRepository tourGuideRepository;
    private final HotelRepository hotelRepository;
    private final PackageMapper packageMapper;

    @Override
    public PackageRequest addPackage(PackageRequest packageRequest) {
        log.info("Creating a new package: {}", packageRequest.getPackageName());
        Optional<Package> optionalPackage = packageRepository.findByPackageName(packageRequest.getPackageName());
        if(optionalPackage.isPresent()){
            throw new RuntimeException("Package with name " + packageRequest.getPackageName() + " already exists");
        }
        Package pack = packageMapper.toEntity(packageRequest);
        pack.setDestination(destinationRepository.findById(packageRequest.getDestinationId()).orElseThrow(() -> new DestinationNotFoundException("Destination not found with id: " + packageRequest.getDestinationId())));
        pack.setAdmin(adminRepository.findById(packageRequest.getAdminId()).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + packageRequest.getAdminId())));
        pack.setTourGuide(tourGuideRepository.findById(packageRequest.getTourGuideId()).orElseThrow(() -> new TourGuideNotFoundException("TourGuide not found with id: " + packageRequest.getTourGuideId())));
        pack.setHotel(hotelRepository.findById(packageRequest.getHotelId()).orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + packageRequest.getHotelId())));
        packageRepository.save(pack);
        log.info("Package created successfully with id: {}", pack.getPackageId());
        return packageRequest;
    }

    @Override
    public void updatePackage(Long id, PackageRequest packageRequest) {
        log.info("Updating package with id: {}", id);
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
        log.info("Package updated successfully with id: {}", package1.getPackageId());
    }

    @Override
    public void deletePackage(Long id) {
        log.info("Deleting package with id: {}", id);
        Package pack = packageRepository.findById(id)
                .orElseThrow(() -> new PackageNotFoundException("Package with id " + id + " not found"));
        packageRepository.delete(pack);
        log.info("Package deleted successfully with id: {}", id);
    }

    @Override
    public PackageDTO getPackageById(Long id) {
        log.info("Fetching package by id: {}", id);
        Package pack = packageRepository.findById(id)
                .orElseThrow(() -> new PackageNotFoundException("Package with id " + id + " not found"));
        return packageMapper.toDTO(pack);
    }

    @Override
    public List<PackageDTO> getAllPackages() {
        log.info("Fetching all packages");
        List<Package> packages = packageRepository.findAll();
        return packages.stream().map(packageMapper::toDTO).toList();
    }
}
