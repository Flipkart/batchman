/*
 * Copyright 2016 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.batching.persistence;

import com.flipkart.batching.Batch;
import com.flipkart.batching.Data;
import com.flipkart.batching.tape.FileObjectQueue;

import java.io.IOException;
import java.io.OutputStream;

public class DataObjectConverter<E extends Data> implements FileObjectQueue.Converter<E> {
    private SerializationStrategy<E, ? extends Batch> serializationStrategy;

    public DataObjectConverter(SerializationStrategy<E, ? extends Batch> serializationStrategy) {
        this.serializationStrategy = serializationStrategy;
    }

    @Override
    public E from(byte[] bytes) throws IOException {
        return serializationStrategy.deserializeData(bytes);

    }

    @Override
    public void toStream(E data, OutputStream bytes) throws IOException {
        bytes.write(serializationStrategy.serializeData(data));
    }
}