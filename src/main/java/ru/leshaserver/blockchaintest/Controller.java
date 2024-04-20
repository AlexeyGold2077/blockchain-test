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

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockchain));
        System.out.println(isChainValid());
    }

    private static Boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            if (!blockchain.get(i).getHash().equals(blockchain.get(i).calculateHash())) {
                return false;
            }
            if (!blockchain.get(i - 1).getHash().equals(blockchain.get(i).getPreviousHash())) {
                return false;
            }
        }
        return true;
    }
}
