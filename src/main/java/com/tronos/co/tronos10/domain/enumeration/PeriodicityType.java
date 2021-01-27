package com.tronos.co.tronos10.domain.enumeration;
import com.tronos.co.tronos10.util.Utils;
/**
 * The PeriodicityType enumeration.
 */
public enum PeriodicityType {
    MENSUAL('M', new FinalPeriod(12)),
    BIMESTRAL('B', new FinalPeriod(6)),
    TRIMESTRAL('T', new FinalPeriod(4)),
    SEMESTRAL('S', new FinalPeriod(2)),
    ANUAL('A', new FinalPeriod(1));

    private char value;
    private FinalPeriod finalPeriod;

    PeriodicityType(char value, FinalPeriod finalPeriod) {
        this.value = value;
        this.finalPeriod = finalPeriod;
    }

    public static boolean exits(Character compare) {
        for (PeriodicityType item : PeriodicityType.values()) {
            if (0 == compare.compareTo(item.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static PeriodicityType find(Character compare) {
        for (PeriodicityType item : PeriodicityType.values()) {
            if (0 == compare.compareTo(item.getValue())) {
                return item;
            }
        }
        throw Utils.throwException("Exception.findPeriodicityType");
    }

    public char getValue() {
        return this.value;
    }

    public FinalPeriod getFinalPeriod() {
        return this.finalPeriod;
    }

}
