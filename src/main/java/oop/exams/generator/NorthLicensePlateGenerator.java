package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        StringBuilder plate = new StringBuilder();
        if(validateRegion(state)){
            plate.append("1");
            plate.append(state);
            for (int i = 0; i < 2; i++)
                plate.append((int) Math.floor(Math.random() * 8 + 1));

        }else throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
        return plate.toString();
    }

    private boolean validateRegion(String state){
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();

        try{
            return licensePlateRepository.getRegionByState(state) == Region.NORTH;
        }catch (BadRegionException e){
            return false;
        }

    }
}
