package ru.leshaserver.blockchain;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {

    private static ArrayList<Block> blockchainArray;
    private int difficulty = 0;

    public Blockchain() {
        difficulty = 0;
        blockchainArray = new ArrayList<Block>();
        blockchainArray.add(new Block("Genesis", "0", difficulty));
    }

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        blockchainArray = new ArrayList<Block>();
        blockchainArray.add(new Block("Genesis", "0", difficulty));
    }

    public void addBlock(String data) {
        blockchainArray.add(new Block(data, blockchainArray.get(blockchainArray.size() - 1).hash, difficulty));
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

    public Integer getBlocksNumber() {
        return blockchainArray.size();
    }

    private class Block {

        private String data;
        private String previousHash;
        private Integer difficulty;
        private String timeStamp;
        private String hash;
        private Long nonce = 0L;

        public Block(String data, String previousHash, Integer difficulty) {
            this.data = data;
            this.timeStamp = Long.toString(new Date().getTime());
            this.previousHash = previousHash;
            this.difficulty = difficulty;
            this.mineBlock(difficulty);
        }

        public void mineBlock(Integer difficulty) {
            String target = new String(new char[difficulty]).replace('\0', '0');
            while (!Utils.SHA256(this.previousHash + this.timeStamp + this.data + this.nonce.toString())
                    .substring(0, difficulty).equals(target)) {
                nonce++;
                this.hash = Utils.SHA256(this.previousHash + this.timeStamp + this.data + this.nonce.toString());
            }
        }

        public String calculateHash() {
            return Utils.SHA256(this.data + this.previousHash +
                    this.difficulty.toString() + this.timeStamp + this.hash + this.nonce.toString());
        }

        public Integer getDifficulty() {
            return difficulty;
        }
    }
}
