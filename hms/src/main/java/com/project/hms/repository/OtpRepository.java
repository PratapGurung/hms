package com.project.hms.repository;

import com.project.hms.model.Customer;
import com.project.hms.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository  extends JpaRepository<Otp, String> {
    Optional<Otp> findOtpByUsername(String s);
}
