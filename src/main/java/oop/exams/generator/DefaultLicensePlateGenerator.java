package oop.exams.generator;
import oop.exams.exception.BadRegionException;
import oop.exams.generator.*;
import oop.exams.model.Region;
import org.assertj.core.internal.bytebuddy.utility.RandomString;

import oop.exams.repository.*;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultLicensePlateGenerator implements LicensePlateGenerator  {

    @Override
    public String generate(String state)throws BadRegionException {
        StringBuilder plate = new StringBuilder();
        if(validateRegion(state)){
            plate.append("5");
                for (int i = 0; i < 7; i++)
                    plate.append((int) Math.floor(Math.random() * 8 + 1));

        }else throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
        return plate.toString();
    }

    private boolean validateRegion(String state){
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();

        try{
            return licensePlateRepository.getRegionByState(state) == Region.CENTER;
        }catch (BadRegionException e){
            return false;
        }
    }

}
