package com.example.myglide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.example.myglide.MyGlide;
import com.example.myglide.load.engine.Initializable;
import com.example.myglide.load.engine.Resource;
import com.example.myglide.load.engine.bitmap_recycle.BitmapPool;
import com.example.myglide.util.Preconditions;
import com.example.myglide.util.Util;

/**
 * Lazily allocates a {@link BitmapDrawable} from a given
 * {@link Bitmap} on the first call to {@link #get()}.
 */
public class LazyBitmapDrawableResource implements Resource<BitmapDrawable>,
    Initializable {

  private final Bitmap bitmap;
  private final Resources resources;
  private final BitmapPool bitmapPool;

  public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
    return obtain(context.getResources(), MyGlide.get(context).getBitmapPool(), bitmap);
  }

  public static LazyBitmapDrawableResource obtain(Resources resources, BitmapPool bitmapPool,
      Bitmap bitmap) {
    return new LazyBitmapDrawableResource(resources, bitmapPool, bitmap);
  }

  LazyBitmapDrawableResource(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
    this.resources = Preconditions.checkNotNull(resources);
    this.bitmapPool = Preconditions.checkNotNull(bitmapPool);
    this.bitmap = Preconditions.checkNotNull(bitmap);
  }

  @Override
  public Class<BitmapDrawable> getResourceClass() {
    return BitmapDrawable.class;
  }

  @Override
  public BitmapDrawable get() {
    return new BitmapDrawable(resources, bitmap);
  }

  @Override
  public int getSize() {
    return Util.getBitmapByteSize(bitmap);
  }

  @Override
  public void recycle() {
    bitmapPool.put(bitmap);
  }

  @Override
  public void initialize() {
    bitmap.prepareToDraw();
  }
}
