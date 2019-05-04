package com.example.marya.events;

import android.app.usage.UsageEvents;
import android.support.v4.util.Pair;
import android.util.EventLog;


import java.util.ArrayList;

public class Events {
    static ArrayList<EventLog.Event> events= new ArrayList<>();
    static ArrayList<String> id = new ArrayList<>();



    public static Pair<ArrayList<EventLog.Event>,ArrayList<String>> getEvents() {
        return new Pair<>(events, id);
    }


    public static void setEvents(EventLog.Event recivedevents, String recivedId ) {
        events.add(recivedevents);
        id.add(recivedId);
    }

    public static ArrayList<String> getId() {
        return id;
    }

    public static void setId(String recivedid) {
        id.add(recivedid);
    }

    public static void clear() {
        if (events.size() > 0) {
            events.clear();
            id.clear();
        }
    }
}