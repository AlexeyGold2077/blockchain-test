package ru.leshaserver.blockchaintest;

import java.util.Date;

public class Block {

    private final String hash;
    private final String previousHash;
    public String data;
    private final String timeStamp;

    public Block (String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
		this.timeStamp = Long.toString(new Date().getTime());
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return Utils.SHA256(this.previousHash + this.timeStamp + this.data);
    }

    public String getHash() { return this.hash; }
    public String getData() { return this.data; }
    public String getPreviousHash() { return previousHash; }
    public String getTimeStamp() { return timeStamp; }
}
