package io.annot8.impl.bounds;

import io.annot8.core.bounds.LinearBounds;

public class SimpleLinearBounds implements LinearBounds{

    private int begin;
    private int end;

    public SimpleLinearBounds(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public void setBegin(int begin) {
        this.begin = begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public void setEnd(int end) {
        this.end = end;
    }

}
