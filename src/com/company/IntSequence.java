package com.company;

//exercise 4 what need to do?
public class IntSequence {

    Element first;
    Element end;

    private class Element{
        private int x;
        private Element next;
        Element(int x){
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setNext(Element e){
            next = e;
        }
    }

    public void add(int x){
        if(first == null){
            first = new Element(x);
            end = first;
        } else {
            
        }

    }

    public static void of(int... x){
        IntSequence seq = new IntSequence();

        for(int o : x){
            seq.add(o);
        }
    }
}
