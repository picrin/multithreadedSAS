/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 by Adam Kurkiewicz
 * You can contact me by e-mail at: adam /at\ kurkiewicz /dot\ pl
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software. 
 */


public class Coppersmith2005{
    public static void main(String[] args){
        DataGraph dg = GraphFactory.makeSanityCheckGraph();
        new UltimateRecurssion(DataGraph.threadPool, DataGraph.visitor, dg);
        synchronized (UltimateRecurssion.counter){
            while (UltimateRecurssion.counter.get() != 0){
                try {
                    UltimateRecurssion.counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        for(NodeHashMap nhm: UltimateRecurssion.solutions){
            Node[] array = new Node[nhm.size()];
            nhm.toArray(array);
            for(Node node: array){
                System.out.println("node: " + node.id + "belongs to" + node.graph);
            }
        }
    }
    /*public static void main(String[] args){
        DataGraph dg = GraphFactory.makeSanityCheckGraph();
        Node[] nodes = new Node[dg.remainder.size()];
        dg.remainder.toArray(nodes);
        for(Node node : nodes){
            System.out.println(node.id);
        }
    }*/
}



