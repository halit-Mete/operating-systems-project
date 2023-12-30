package odev00;

public class Resource {
    private int availableUnits;

    public Resource(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    // Kaynağın mevcut olup olmadığını kontrol eder
    public boolean isAvailable(int unitsNeeded) {
        return availableUnits >= unitsNeeded;
    }

    // Kaynağı tahsis eder
    public void allocate(int unitsNeeded) {
        if (isAvailable(unitsNeeded)) {
            availableUnits -= unitsNeeded;
        }
    }

    // Kaynağı serbest bırakır
    public void release(int unitsReleased) {
        availableUnits += unitsReleased;
    }
}
