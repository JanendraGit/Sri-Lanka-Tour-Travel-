package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<Package,Long> {
    Optional<Package> findByPackageName(String packageName);
}
