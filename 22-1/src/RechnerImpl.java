package src;

public class RechnerImpl implements RechnerInterface {
    final private int MAX_WAIT_TIME = 5000;
    //private int secSincelastComputation = 0;
    private int ergebnisSpeicher = 0;
    private long milliSecSinceLastUse;

    public RechnerImpl() {
        milliSecSinceLastUse = System.currentTimeMillis();
    }

    @Override
    public int subtraktion(int minuent, int subrahend) throws Exception {

        long zeitDiff = System.currentTimeMillis() - milliSecSinceLastUse;

        if (zeitDiff > MAX_WAIT_TIME) {
            throw new IllegalStateException("to slow");
        }
        CheckForOverflow(minuent, subrahend);
        CheckForUnderflow(minuent, subrahend);
        this.ergebnisSpeicher = minuent - subrahend;
        milliSecSinceLastUse = System.currentTimeMillis();
        return this.ergebnisSpeicher;
        
    }


    @Override
    public int subtraktion(int subrahend) throws Exception {
        return this.subtraktion(this.ergebnisSpeicher, subrahend);
    }

    // minuet 2
    // subtrahend 3
    private void CheckForOverflow(int minuent, int subrahend) throws Exception {
        if (minuent < 0 && subrahend < 0 || minuent > 0 && subrahend < 0) {
            if (minuent - subrahend < minuent) {
                throw new Exception("ein ueberlauf ist passiert");
            }
        }
    }

    private void CheckForUnderflow(int minuent, int subrahend) throws Exception {
        if (minuent > 0 && subrahend > 0 || minuent < 0 && subrahend > 0) {
            if (minuent - subrahend > minuent) {
                throw new Exception("ein unterlauf ist passiert");
            }
        }
    }
}


