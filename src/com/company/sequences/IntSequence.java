package com.company.sequences;

//exercise 4 what need to do?
public class IntSequence implements Sequence<Integer> {

    private Element first;
    private Element end;
    private Element pointer;
    private int size;

    private class Element{
        private int x;
        private Element next;

        private Element(int x){
            this.x = x;
        }

        private int getX() {
            return x;
        }

        private void setNext(Element e){
            next = e;
        }
    }

    public void add(int x){
        if(first == null){
            first = new Element(x);
            pointer = end = first;
        } else {
            Element element = new Element(x);
            end.setNext(element);
            end = element;
        }
        size++;

    }

    public void pointerReset(){
        pointer = first;
    }

    @Override
    public String toString() {
        pointerReset();
        String result =  "IntSequence{";

        while (hasNext()){
            result += next();
            if(pointer != null){
                result += ",";
            }
        }

        result +="}";

        pointerReset();

        return result;
    }

    @Override
    public boolean hasNext(){
        if(pointer != null){
            if(pointer.next != null || pointer == end){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next(){
        int next = pointer.x;
        pointer = pointer.next;
        return next;
    }

    //utils
    public static IntSequence of(int... x){
        IntSequence seq = new IntSequence();

        for(int o : x){
            seq.add(o);
        }

        return seq;
    }

    public static IntSequence constant(int x){
        //infinity?
        IntSequence sequence = new IntSequence();
        //make x as border because heap was ended
        Addable add = (int x2)->{ while (sequence.size < x) sequence.add(x);};
        add.add(x);


        System.out.println(sequence);
        return sequence;
    }
}
