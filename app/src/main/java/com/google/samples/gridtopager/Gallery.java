/*
 * Copyright (C) 2018 Mobile Application Lab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.samples.gridtopager;

import android.net.Uri;

import net.mobileapplab.gallery.GalleryItem;

import java.util.ArrayList;

public class Gallery {
    public static final ArrayList<GalleryItem> beach = new ArrayList<>();
    public static final ArrayList<GalleryItem> beaches = new ArrayList<>();

    static {
        beach.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000741-7a7e6dc4-9e60-11e8-8423-c936b9606571.jpeg"), "transitionImage1"));

        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000741-7a7e6dc4-9e60-11e8-8423-c936b9606571.jpeg"), "transitionImage1"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000742-7aa1cda0-9e60-11e8-9c38-856dee927495.jpeg"), "transitionImage2"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000743-7ac798dc-9e60-11e8-9a57-73dd8279cd5a.jpeg"), "transitionImage3"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000744-7ae81904-9e60-11e8-9b5c-84f48cbe0969.jpeg"), "transitionImage4"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000745-7b0922f2-9e60-11e8-89b4-7e92d3c67384.jpeg"), "transitionImage5"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000746-7b2a6174-9e60-11e8-9d26-b132a16bcc12.jpeg"), "transitionImage6"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000747-7b4c5e46-9e60-11e8-8fb8-1ec8375a9774.jpeg"), "transitionImage7"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000748-7b6e5794-9e60-11e8-8b60-855c97b48fe0.jpeg"), "transitionImage8"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000749-7b908c7e-9e60-11e8-80ea-11b042fb0034.jpeg"), "transitionImage9"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000750-7bb10f6c-9e60-11e8-8436-4ba09e05b879.jpeg"), "transitionImage10"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000751-7bd1f45c-9e60-11e8-8bb5-00178233eeeb.jpeg"), "transitionImage11"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000752-7bf2c934-9e60-11e8-9491-5ebe8032273a.jpeg"), "transitionImage12"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000753-7c1346fa-9e60-11e8-8c1c-6298c4494947.jpeg"), "transitionImage13"));
        beaches.add(new GalleryItem(Uri.parse("https://user-images.githubusercontent.com/35882061/44000754-7c352428-9e60-11e8-944e-bdbf43710ce3.jpeg"), "transitionImage14"));
    }
}
