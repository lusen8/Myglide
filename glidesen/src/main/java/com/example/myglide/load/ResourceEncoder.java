package com.example.myglide.load;

/**
 * Created by lusen on 2017/5/3.
 */

import com.example.myglide.load.engine.Resource;

/**
 * An interface for writing data from a resource to some persistent data store (i.e. a local File
 * cache).
 *
 * @param <T> The type of the data contained by the resource.
 */
public interface ResourceEncoder<T> extends Encoder<Resource<T>> {
    // specializing the generic arguments
    EncodeStrategy getEncodeStrategy(Options options);
}
