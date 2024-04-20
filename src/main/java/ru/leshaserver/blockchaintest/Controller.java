package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import com.google.gson.*;

public class Controller {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockchain.add(new Block("First", "0"));
        blockchain.add(new Block("Second", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Third", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Fifth", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Sixth", blockchain.get(blockchain.size()-1).getHash()));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);

        System.out.printf(blockchainJson);
    }
}
