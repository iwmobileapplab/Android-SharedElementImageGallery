package com.google.samples.gridtopager.impl;

import android.support.annotation.NonNull;

import net.mobileapplab.gallery.GalleryItem;
import net.mobileapplab.gallery.gallery.ImagePagerAdapter;
import net.mobileapplab.gallery.gallery.AbstractImagePagerFragment;

import java.util.ArrayList;

public class ImagePagerFragment extends AbstractImagePagerFragment {
    public static ImagePagerFragment newInstance(@NonNull ArrayList<GalleryItem> gallery) {
        final ImagePagerFragment fragment = new ImagePagerFragment();
        fragment.setArguments(createArgsBundle(gallery));
        return fragment;
    }

    @Override
    public ImagePagerAdapter getAdapter(ArrayList<GalleryItem> list) {
        return new ImagePagerAdapter<ImageFragment>(this, list);
    }
}
