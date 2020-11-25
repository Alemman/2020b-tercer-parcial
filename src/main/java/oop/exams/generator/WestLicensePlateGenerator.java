package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;

public class WestLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        StringBuilder plate = new StringBuilder();
        if(validateRegion(state)){
            plate.append("2");
            plate.append((int) Math.floor(Math.random() * 8 + 1));
            plate.append(state);
        }else throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
        return plate.toString();

    }

    private boolean validateRegion(String state){
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();

        try{
            return licensePlateRepository.getRegionByState(state) == Region.WEST;
        }catch (BadRegionException e){
            return false;
        }

    }
}
