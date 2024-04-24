package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {

    private class Block {

        private String hash;
        private String previousHash;
        public String data;
        private String timeStamp;
        private Long nonce = 0L;

        public Block (String data, String previousHash) {
            this.data = data;
            this.previousHash = previousHash;
            this.timeStamp = Long.toString(new Date().getTime());
            this.hash = calculateHash();
        }

        public String calculateHash() {
            return Utils.SHA256(this.previousHash + this.timeStamp + this.data + nonce.toString());
        }

        public void mineBlock(Integer difficulty) {
            String target = new String(new char[difficulty]).replace('\0', '0');
            while (!calculateHash().substring(0, difficulty).equals(target)) {
                nonce++;
                this.hash = calculateHash();
            }
        }
    }

    private static ArrayList<Block> blockchainArray;
    private int difficulty;

    public Blockchain() {
        difficulty = 0;
        blockchainArray = new ArrayList<Block>();
        blockchainArray.add(new Block("Genesis", "0"));
        blockchainArray.get(blockchainArray.size() - 1).mineBlock(difficulty);
    }

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        blockchainArray = new ArrayList<Block>();
        blockchainArray.add(new Block("Genesis", "0"));
        blockchainArray.get(blockchainArray.size() - 1).mineBlock(difficulty);
    }

    public void addBlock(String data) {
        blockchainArray.add(new Block(data, blockchainArray.get(blockchainArray.size() - 1).hash));
        blockchainArray.get(blockchainArray.size() - 1).mineBlock(difficulty);
    }

    public Boolean isValid() {
        for (int i = 1; i < blockchainArray.size(); i++) {
            if (!blockchainArray.get(i).hash.equals(blockchainArray.get(i).calculateHash())) {
                return false;
            } if (!blockchainArray.get(i - 1).hash.equals(blockchainArray.get(i).previousHash)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Block> getBlockchainArray() {
        return blockchainArray;
    }

    public String getBlockHash(int position) {
        return blockchainArray.get(position).hash;
    }

    public String getBlockPreviousHash(int position) {
        return blockchainArray.get(position).previousHash;
    }

    public String getBlockData(int position) {
        return blockchainArray.get(position).data;
    }

    public String getBlockTimeStamp(int position) {
        return blockchainArray.get(position).timeStamp;
    }

    public Long getBlockNonce(int position) {
        return blockchainArray.get(position).nonce;
    }

    public Boolean setBlockchainDifficulty(int difficulty) {
        if (difficulty >= 0) {
            this.difficulty = difficulty;
            return true;
        } else {
            return false;
        }
    }
}
