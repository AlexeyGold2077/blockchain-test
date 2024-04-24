package ru.leshaserver.blockchaintest;

import java.util.Date;

public class Block {

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

    public String getHash() { return this.hash; }
    public String getData() { return this.data; }
    public String getPreviousHash() { return previousHash; }
    public String getTimeStamp() { return timeStamp; }
}
