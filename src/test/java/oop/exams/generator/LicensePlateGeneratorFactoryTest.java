package oop.exams.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import oop.exams.model.Region;
class LicensePlateGeneratorFactoryTest {

    private LicensePlateGeneratorFactory licensePlateGeneratorFactory;

    @BeforeEach
    public void setup(){
        licensePlateGeneratorFactory = new LicensePlateGeneratorFactory();
    }

    @Test
    public void givenANorthRegionState_whenGetInstance_thenNorthRegionGeneratorIsReturned() {
        // Given:
        String []northStates = {"BCN", "BCS", "CHH", "COA", "NLE", "SON", "TAM"};

        for(String state: northStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(NorthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenASouthRegionState_whenGetInstance_thenSouthRegionGeneratorIsReturned() {
        // Given:
        String []southStates = {"CHP", "GRO", "MIC", "OAX"};

        for(String state: southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(SouthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAEastRegionState_whenGetInstance_thenEastRegionGeneratorIsReturned() {
        // Given:
        String []southStates = {"CAM", "ROO", "TAB", "VER", "YUC"};

        for(String state: southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(EastLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAWestRegionState_whenGetInstance_thenWestRegionGeneratorIsReturned() {
        // Given:
        String []southStates = {"COL", "JAL", "NAY", "SIN"};

        for(String state: southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(WestLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenACenterRegionState_whenGetInstance_thenCenterGeneratorIsReturned() {
        // Given:
        String []centerStates = {"AGU", "CMX", "DUR", "GUA", "HID", "MEX", "PUE", "QUE", "SLP", "TLA", "ZAC"};

        for(String state: centerStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(DefaultLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenANorthRegion_whenGetInstance_thenNorthGeneratorIsReturned() {
        // Given:
        Region region = Region.NORTH;

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(region);

        // Then:
        assertThat(instance).isInstanceOf(NorthLicensePlateGenerator.class);

    }
    @Test
    public void givenASouthRegion_whenGetInstance_thenSouthGeneratorIsReturned() {
        // Given:
        Region region = Region.SOUTH;

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(region);

        // Then:
        assertThat(instance).isInstanceOf(SouthLicensePlateGenerator.class);

    }
    @Test
    public void givenAWestRegion_whenGetInstance_thenWestGeneratorIsReturned() {
        // Given:
        Region region = Region.WEST;

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(region);

        // Then:
        assertThat(instance).isInstanceOf(WestLicensePlateGenerator.class);

    }
    @Test
    public void givenAEastRegion_whenGetInstance_thenEastGeneratorIsReturned() {
        // Given:
        Region region = Region.EAST;

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(region);

        // Then:
        assertThat(instance).isInstanceOf(EastLicensePlateGenerator.class);

    }
    @Test
    public void givenACenterRegion_whenGetInstance_thenCenterGeneratorIsReturned() {
        // Given:
        Region region = Region.CENTER;

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(region);

        // Then:
        assertThat(instance).isInstanceOf(DefaultLicensePlateGenerator.class);

    }

}