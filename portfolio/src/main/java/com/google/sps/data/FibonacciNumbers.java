package com.google.sps.data;

import java.math.BigInteger;

/** Class containing fibonnaci numbers. */
public final class FibonacciNumbers {

    private final BigInteger prevFib;
    private final BigInteger currFib;
    private final BigInteger nextFib;

    public FibonacciNumbers(BigInteger prevFib, BigInteger currFib, BigInteger nextFib){

        this.prevFib = prevFib;
        this.currFib = currFib;
        this.nextFib = nextFib;

    }

    public BigInteger getPrevFib() {
        return prevFib;
    }

    public BigInteger getCurrFib() {
        return currFib;
    }

    public BigInteger getNextFib() {
        return nextFib;
    }
   
    
}
