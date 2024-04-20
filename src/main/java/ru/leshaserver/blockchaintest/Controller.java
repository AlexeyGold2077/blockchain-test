package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import com.google.gson.*;

public class Controller {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        Integer difficulty = 10;

        blockchain.add(new Block("First", "0"));
        blockchain.get(0).mineBlock(difficulty);

        for (Integer i = 1; i < 10; i++) {
            blockchain.add(new Block(i.toString(), blockchain.get(i - 1).getHash()));
            blockchain.get(i).mineBlock(difficulty);
        }

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
