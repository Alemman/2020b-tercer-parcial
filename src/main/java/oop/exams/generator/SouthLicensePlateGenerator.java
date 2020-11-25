package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        StringBuilder plate = new StringBuilder();
        if(validateRegion(state)){
            plate.append("4");
            plate.append(state);
            for (int i = 0; i < 3; i++)
                plate.append((int) Math.floor(Math.random() * 8 + 1));

        }else throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
        return plate.toString();

    }

    private boolean validateRegion(String state){
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();

        try{
            return licensePlateRepository.getRegionByState(state) == Region.SOUTH;
        }catch (BadRegionException e){
            return false;
        }

    }
}
