package ru.leshaserver.blockchaintest;

import java.util.ArrayList;

public class Blockchain {

    private int numberOfBlocks;
    private static ArrayList<Block> blockchainArray;

    public Blockchain() {
        numberOfBlocks = 0;
        blockchainArray = new ArrayList<Block>();
        blockchainArray.add(new Block("Genesis", "0"));
        numberOfBlocks++;
    }

    public void addBlock(String data) {
        blockchainArray.add(new Block(data, blockchainArray.get(numberOfBlocks - 1).getHash()));
        numberOfBlocks++;
    }

    public Block getBlock(int position) {
        return blockchainArray.get(position);
    }
}
