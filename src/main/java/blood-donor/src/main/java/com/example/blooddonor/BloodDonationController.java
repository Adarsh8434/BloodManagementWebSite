package com.example.blooddonor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloodDonationController {
    @Autowired
    private BloodDonorService bloodDonorService;
    
    @Autowired
    private EmailNotificationService emailNotificationService;

    @PostMapping("/blood/request")
    public void sendBloodRequestNotification(@RequestBody BloodRequest bloodRequest) {
        // Assuming the BloodRequest class has location, bloodGroup, and other necessary details.
        List<BloodDonor> eligibleDonors = bloodDonorService.findEligibleDonors(bloodRequest.getLocation(), bloodRequest.getBloodGroup());
        for (BloodDonor donor : eligibleDonors) {
            String subject = "Blood Donation Request";
            String message = "Dear " + donor.getName() + ",\n\nYou are eligible to donate blood. Please consider donating for the following request:\n\n" +
                    "Requester Name: " + bloodRequest.getRequesterName() + "\nLocation: " + bloodRequest.getLocation() +
                    "\nBlood Group: " + bloodRequest.getBloodGroup() + "\n\nThank you for your support.";
            emailNotificationService.sendNotification(donor.getEmail(), subject, message);
        }
    }
}
