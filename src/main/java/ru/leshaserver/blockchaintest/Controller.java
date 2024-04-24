package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import com.google.gson.*;

public class Controller {

    /*public static ArrayList<Block> blockchain = new ArrayList<Block>();*/

    public static void main(String[] args) {
        Integer difficulty = 3;
        Blockchain blockchain = new Blockchain(6);

        blockchain.addBlock("First data!");
        blockchain.addBlock("Second data!");

        System.out.println("---------------------------------------------------------------");
        System.out.println(blockchain.getBlockData(0));
        System.out.println(blockchain.getBlockHash(0));
        System.out.println(blockchain.getBlockPreviousHash(0));
        System.out.println(blockchain.getBlockTimeStamp(0));
        System.out.println(blockchain.getBlockNonce(0));
        System.out.println("---------------------------------------------------------------");
        System.out.println(blockchain.getBlockData(1));
        System.out.println(blockchain.getBlockHash(1));
        System.out.println(blockchain.getBlockPreviousHash(1));
        System.out.println(blockchain.getBlockTimeStamp(1));
        System.out.println(blockchain.getBlockNonce(1));
        System.out.println("---------------------------------------------------------------");
        System.out.println(blockchain.getBlockData(2));
        System.out.println(blockchain.getBlockHash(2));
        System.out.println(blockchain.getBlockPreviousHash(2));
        System.out.println(blockchain.getBlockTimeStamp(2));
        System.out.println(blockchain.getBlockNonce(2));
        System.out.println("---------------------------------------------------------------");
        System.out.println(blockchain.isValid());

        //System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockchain.getBlock(0)));
    }
}
