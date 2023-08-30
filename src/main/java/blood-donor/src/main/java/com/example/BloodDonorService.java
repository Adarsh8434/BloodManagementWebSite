import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodDonorService {
    @Autowired
    private BloodDonorRepository bloodDonorRepository;

    public List<BloodDonor> findEligibleDonors(String location, String bloodGroup) {
        return bloodDonorRepository.findByLocationAndBloodGroup(location, bloodGroup);
    }
}
