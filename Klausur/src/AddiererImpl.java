package Klausur.src;

public class AddiererImpl implements AddiererInterface {

    @Override
    public int add(int operant1, int operant2) throws Exception {
        if (operant1 < 0 || operant2 < 0) {
            throw new IllegalArgumentException("Negative Zahlen sind nicht erlaubt");
        }
        CheckForOverflow(operant1, operant2);
        return operant1 + operant2;
        
    }

    private void CheckForOverflow(int minuent, int subrahend) throws Exception {
        if (minuent < 0 && subrahend < 0 || minuent > 0 && subrahend < 0) {
            if (minuent - subrahend < minuent) {
                throw new Exception("Es gab einen ueberlauf");
            }
        }
    }
}
