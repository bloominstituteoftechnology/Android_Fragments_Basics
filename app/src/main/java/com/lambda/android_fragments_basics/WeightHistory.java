package com.lambda.android_fragments_basics;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WeightHistory {
    String ITEMS;
    private Weight[] weight;
    /**
     * An array of sample (dummy) items.
     */

    /**
     * A map of sample (dummy) items, by ID.
     */

    private static final int COUNT = 25;

    public WeightHistory(){
        // Add some sample items.
        String[] strar= strInitialData.split( "\n" );
        for (int i = 1; i <= COUNT; i++) {
            weight[0]=new Weight(strar[i] );
 //           addItem( createDummyItem( i ) );
        }
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append( "Details about Item: " ).append( position );
        for (int i = 0; i < position; i++) {
            builder.append( "\nMore details information here." );
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
    final static String strInitialData="              2019-01-27 21:37:06 0 85.6 27.6                 \n" +
            "              2019-02-12 20:47:11 0 84.3 27.2                 \n" +
            "              2019-02-17 21:25:30 0 85.3 27.5                 \n" +
            "              2019-02-22 21:17:24 0 83.7 27.0                 \n" +
            "              2019-02-28 20:54:45 0 85.2 27.5                 \n" +
            "              2019-03-10 20:53:29 0 85.8 27.7                 \n" +
            "              2019-03-17 21:14:54 0 84.0 27.1                 \n" +
            "              2019-03-19 22:58:08 0 84.2 27.2                 \n" +
            "              2019-03-24 21:38:32 0 84.4 27.2                 \n" +
            "              2019-03-28 21:30:29 0 84.0 27.1                 \n" +
            "              2019-04-02 21:43:13 0 85.6 27.6                 \n" +
            "              2019-04-03 22:50:08 0 85.0 27.4                 \n" +
            "              2019-04-08 07:06:52 0 84.6 27.3                 \n" +
            "              2019-04-12 22:00:20 0 85.3 27.5  ";
}


