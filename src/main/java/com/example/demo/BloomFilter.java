package com.example.demo;

import java.util.BitSet;

public class BloomFilter {
    private final int size;
    private final BitSet bitSet;
    private final int hashFunctionsCount;

    public BloomFilter(int size, int hashFunctionsCount) {
        this.size = size;
        this.hashFunctionsCount = hashFunctionsCount;
        this.bitSet = new BitSet(size);
    }

    public int getSize() {
        return size;
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public int getHashFunctionsCount() {
        return hashFunctionsCount;
    }

    // Simple hash function using different seeds
    public int getHash(String element, int seed) {
        return element.hashCode() ^ seed;
    }

}
