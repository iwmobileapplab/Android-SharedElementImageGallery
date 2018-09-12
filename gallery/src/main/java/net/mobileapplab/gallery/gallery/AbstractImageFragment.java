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

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import net.mobileapplab.gallery.GalleryItem;
import net.mobileapplab.gallery.R;
import net.mobileapplab.gallery.view.MultiTouchImageView;
import net.mobileapplab.gallery.view.SwipeToDismissTouchListener;

public abstract class AbstractImageFragment extends Fragment implements SwipeToDismissTouchListener.Callback {

    private static final String KEY_GALLERY_ITEM = "key.galleryItem";
    private MultiTouchImageView imageView;

    @NonNull
    public static Bundle createArgsBundle(@NonNull GalleryItem item) {
        Bundle argument = new Bundle();
        argument.putParcelable(KEY_GALLERY_ITEM, item);
        return argument;
    }

    public abstract void onRequestImage(@NonNull Uri uri, @NonNull ImageView imageView);

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_image, container, false);

        Bundle arguments = getArguments();
        GalleryItem item = arguments.getParcelable(KEY_GALLERY_ITEM);
        imageView = view.findViewById(R.id.image);

        // Just like we do when binding views at the grid, we set the transition name to be the string
        // value of the image res.
        SwipeToDismissTouchListener listener = SwipeToDismissTouchListener.createFromView(imageView, this);
        imageView.setOnTouchListener(listener);
        imageView.setTransitionName(item.getTransitionName());

        onRequestImage(item.getUri(), imageView);
        return view;
    }

    @CallSuper
    @Override
    public void onDismiss() {
        Fragment pf = getParentFragment();
        if (pf != null && !pf.isRemoving() && pf.getActivity() != null && !pf.getActivity().isFinishing() && !pf.getActivity().isDestroyed()) {
            pf.getActivity().onBackPressed();
        }
    }

    @Override
    public void onMove(float translationY) {
    }

    public final void onFinishImageLoading() {
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                imageView.isCompleteInitialPreDraw = true;
                getParentFragment().startPostponedEnterTransition();
                return true;
            }
        });
    }
}
