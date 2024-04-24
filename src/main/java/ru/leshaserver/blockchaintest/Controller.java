package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import com.google.gson.*;

public class Controller {

    /*public static ArrayList<Block> blockchain = new ArrayList<Block>();*/

    public static void main(String[] args) {
        /*Integer difficulty = 5;

        blockchain.add(new Block("First", "0"));
        blockchain.get(0).mineBlock(difficulty);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockchain));
        System.out.println(isChainValid());*/

        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("First data!");
        blockchain.addBlock("Second data!");

        System.out.println(blockchain.getBlock(0).data);
        System.out.println(blockchain.getBlock(0).getHash());
        System.out.println(blockchain.getBlock(0).getPreviousHash());
        System.out.println(blockchain.getBlock(1).data);
        System.out.println(blockchain.getBlock(1).getHash());
        System.out.println(blockchain.getBlock(1).getPreviousHash());
        System.out.println(blockchain.getBlock(2).data);
        System.out.println(blockchain.getBlock(2).getHash());
        System.out.println(blockchain.getBlock(2).getPreviousHash());
    }

    /*private static Boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            if (!blockchain.get(i).getHash().equals(blockchain.get(i).calculateHash())) { return false; }
            if (!blockchain.get(i - 1).getHash().equals(blockchain.get(i).getPreviousHash())) { return false; }
        }
        return true;
    }*/
}
