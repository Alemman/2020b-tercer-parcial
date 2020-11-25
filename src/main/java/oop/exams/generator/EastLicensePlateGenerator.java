package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        StringBuilder plate = new StringBuilder();
        if(validateRegion(state)){
            plate.append("3");
            for (int i = 0; i < 2; i++)
                plate.append((int) Math.floor(Math.random() * 8 + 1));
            plate.append("Z");
        }else throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
        return plate.toString();

    }

    private boolean validateRegion(String state){
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();

        try{
            return licensePlateRepository.getRegionByState(state) == Region.EAST;
        }catch (BadRegionException e){
            return false;
        }

    }
}
