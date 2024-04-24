package ru.leshaserver.blockchaintest;

import java.util.ArrayList;
import com.google.gson.*;

public class Controller {

    /*public static ArrayList<Block> blockchain = new ArrayList<Block>();*/

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(4);

        blockchain.addBlock("First data!");
        blockchain.addBlock("Second data!");

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockchain.getBlockchainArray()));
    }
}
