/*
 * Copyright 2018 Google LLC
 * Modified Copyright (C) 2018 Mobile Application Lab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.mobileapplab.gallery.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.mobileapplab.gallery.GalleryItem;

import java.util.ArrayList;

public class ImagePagerAdapter<T extends AbstractImageFragment> extends FragmentStatePagerAdapter {
    private final ArrayList<GalleryItem> list;

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public ImagePagerAdapter(Fragment fragment, @NonNull ArrayList<GalleryItem> list, T... t) {
        // Note: Initialize with the child fragment manager.
        super(fragment.getChildFragmentManager());
        this.list = list;
        clazz = (Class<T>) t.getClass().getComponentType();
        try {
            // check class condition
            clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("ImagePagerAdapter require bounded type parameter with generics.", e);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return getItemFragment(list.get(position));
    }

    private T getItemFragment(@NonNull GalleryItem item) {
        try {
            T target = clazz.newInstance();
            Bundle bundle = AbstractImageFragment.createArgsBundle(item);
            target.setArguments(bundle);
            return target;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("ImagePagerAdapter require bounded type parameter with generics.", e);
        }
    }
}
