package utils;

import java.math.BigDecimal;

public class MathUtils {
    public static Double getScaleNumber(long dividend, int divisor) {
        return new BigDecimal((float) dividend / divisor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
