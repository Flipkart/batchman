package com.flipkart.batching.data;

import com.flipkart.batching.Data;

/**
 * Created by kushal.sharma on 24/02/16.
 */
public class TagData extends Data {
    private final Tag tag;

    /**
     * Constructor for Data object. This constructor takes {@link Tag} and {@link Object} as
     * parameter and generates an eventId = (System.currentTimeMillis() + System.nanoTime())
     *
     * @param data data object
     */
    public TagData(Tag tag, Object data) {
        super(data);
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TagData) {
            return ((TagData) o).tag.equals(tag) && super.equals(o);
        }
        return false;
    }
}
