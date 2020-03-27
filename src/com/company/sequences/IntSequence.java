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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntSequence that = (IntSequence) o;

        if(this.size != that.size){
            return false;
        }else{
            int x1;
            int x2;

            this.pointerReset();
            that.pointerReset();

            while (this.hasNext() && that.hasNext()){
                x1 = this.next();
                x2 = that.next();

                if(x1 != x2){
                    return false;
                }
            }
            return true;
        }

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (pointer != null ? pointer.hashCode() : 0);
        result = 31 * result + size;
        return result;
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
        //memory may end in infinity
        Addable addable = (int x2)->{ while (sequence.size < x) sequence.add(x);};
        addable.add(x);

        return sequence;
    }
}
