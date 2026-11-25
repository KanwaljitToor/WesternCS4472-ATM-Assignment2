package bank.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TransferFeeTest {

    private final FeesCalculator calculator = new FeesCalculator();

    // Student transfer fee tests (P1-P8)
    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "P1, 50, 500, 500, 0.05",
        "P2, 50, 500, 2000, 0.025",
        "P3, 50, 2000, 500, 0.25",
        "P4, 50, 2000, 2000, 0.125",
        "P5, 200, 500, 500, 0.1",
        "P6, 200, 500, 2000, 0.05",
        "P7, 200, 2000, 500, 0.5",
        "P8, 200, 2000, 2000, 0.25"
    })
    public void testStudentTransferFees(
        String pathId,
        double amount,
        double fromBalance,
        double toBalance,
        double expectedFee) 
    {
        double actualFee = calculator.calculateTransferFee(amount, fromBalance, toBalance, true);
        assertEquals(expectedFee, actualFee, 0.0001,"Incorrect transfer fee for basis path " + pathId);
    }

    // Non-student transfer fee tests (P9-P16)
    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "P9, 50, 500, 500, 0.1",
        "P10, 50, 500, 2000, 0.05",
        "P11, 50, 2000, 500, 0.5",
        "P12, 50, 2000, 2000, 0.25",
        "P13, 200, 500, 500, 0.2",
        "P14, 200, 500, 2000, 0.1",
        "P15, 200, 2000, 500, 1.0",
        "P16, 200, 2000, 2000, 0.5"
    })
    public void testNonStudentTransferFees(
        String pathId,
        double amount,
        double fromBalance,
        double toBalance,
        double expectedFee) 
    {
        double actualFee = calculator.calculateTransferFee(amount, fromBalance, toBalance, false);
        assertEquals(expectedFee, actualFee, 0.0001,"Incorrect transfer fee for basis path " + pathId);
    }
}
