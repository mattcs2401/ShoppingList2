package mcssoft.com.shoppinglist2.utility;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    public XmlParser(InputStream inputStream) throws XmlPullParserException, IOException {
        nameSpace = null;
        parser = Xml.newPullParser();
        parser.setInput(inputStream, null);
        parser.nextTag();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
    }

    /**
     * Parse the feed xml into a list of objects that represent the feed elements.
     * @param element The part of the feed to read, e.g. Meeting, Race or Runner elements.
     * @return A list of objects representing the feed elements.
     * @throws XmlPullParserException
     * @throws IOException
     */
    public List parse(String element) throws XmlPullParserException, IOException {
        List list = null;
        switch(element) {
            case "ReferenceValues":
                list = parseForMeetings();
                break;
        }
        return list;
    }

    //<editor-fold defaultstate="collapsed" desc="Region: Meetings">
    /**
     * Parse the Xml for Meeting information.
     * Note: Based on https://tatts.com/pagedata/racing/YYYY/M(M)/D(D)/RaceDay.xml
     * @return A list of Meeting objects.
     * @throws XmlPullParserException
     * @throws IOException
     */
    private List parseForMeetings() throws XmlPullParserException, IOException {
        List entries = new ArrayList();

        parser.require(XmlPullParser.START_TAG, nameSpace, "ReferenceValues");
//        String date = parser.getAttributeValue(nameSpace,"RaceDayDate");
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("ShoppingItemTypes")) {
                String bp = "";
//                entries.add(readMeeting(date));
//                haveWeather = false;
            }
//            else if(name.equals("Race") && !haveWeather) {
//                entries = readMeetingWeather(entries);
//                haveWeather = true;
//            }
            else {
                skip();
            }
        }
        return entries;
    }

//    /**
//     * Read Meeting infor from the Xml.
//     * @param date A derived value from the RaceDayDate attribute of the RaceDay element.
//     * @return A Meeting object.
//     */
//    private Meeting readMeeting(String date) {
//        Meeting meeting = new Meeting();
//        if(date != null) {
//            meeting.setMeetingId(parser.getAttributeValue(nameSpace, "MtgId"));
//            // // date format YYYY-MM-DDT00:00:00 (only want date part).
//            meeting.setMeetingDate((date.split("T"))[0]);
//            meeting.setAbandoned(parser.getAttributeValue(nameSpace, "Abandoned"));
//            meeting.setVenueName(parser.getAttributeValue(nameSpace, "VenueName"));
//            meeting.setHiRaceNo(parser.getAttributeValue(nameSpace, "HiRaceNo"));
//            meeting.setMeetingCode(parser.getAttributeValue(nameSpace, "MeetingCode"));
//        }
//        return meeting;
//    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Region: Utility">
    /**
     * Ignore what we don't want.
     * @throws XmlPullParserException
     * @throws IOException
     */
    private void skip() throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        String name;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
    //</editor-fold>

    private String nameSpace;
    private XmlPullParser parser;
}
