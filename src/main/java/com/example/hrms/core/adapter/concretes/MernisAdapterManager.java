package com.example.hrms.core.adapter.concretes;

import com.example.hrms.core.adapter.Mernis.TRDKPSPublicSoap12;
import com.example.hrms.core.adapter.abstracts.MernisAdapterService;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapterManager implements MernisAdapterService {

    @Override
    public boolean checkIfRealPerson(Candidates candidates) {
        return true;
    }

    @Override
    public boolean checkWithMernisRealPerson(Candidates candidates) throws Exception {
        TRDKPSPublicSoap12 client = new TRDKPSPublicSoap12();
        Long tc = Long.valueOf(candidates.getIdentityNumber());

        return client.TCKimlikNoDogrula(tc, candidates.getName(),candidates.getLastName(), candidates.getBirthDate().getYear());
    }
}
