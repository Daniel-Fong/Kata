package com.smt.kata.weather;

import java.io.IOException;
// JDK 11.x
import java.io.Serializable;
import java.util.Date;
import com.siliconmtn.io.http.SMTHttpConnectionManager;
import com.siliconmtn.io.http.SMTHttpConnectionManager.HttpConnectionType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/****************************************************************************
 * <b>Title:</b> SunriseSunsetCalculator.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> In this Kata, you will call out to a json api and format it into 
 * a data structure and return the data structure.  You will use the Gson json classes
 * to deserialize the response from a json object into a SunriseSunsetVO object
 * 
 * You may use the SMTHttpConnectionManager for the API calls
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 20, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SunriseSunsetCalculator {

	/**
	 * Base url for the sunrise sunset calculator
	 */
	public static final String SUNRISE_SUNSET_URL = "https://api.sunrise-sunset.org/json?";
	protected String status;
	SunriseSunsetVO results;
	
	/**
	 * 
	 */
	public SunriseSunsetCalculator() {
		super();
		
	}
	
	/**
	 * 
	 * @param date
	 * @param lat
	 * @param lng
	 * @throws IOException 
	 */
	public SunriseSunsetCalculator(Date date, double lat, double lng) {
		super();
		
		SMTHttpConnectionManager conn = new SMTHttpConnectionManager();
        String params = "date=" + date + "&lat=" + lat + "&lng="+lng;
        try {
            byte[] resp = conn.getRequestData(SUNRISE_SUNSET_URL+params, null, HttpConnectionType.GET);
            @SuppressWarnings("deprecation")
			JsonObject jsonObject = new JsonParser().parse(new String(resp)).getAsJsonObject();
            System.out.println(jsonObject);
            status = jsonObject.get("status").getAsString();
            Gson g = new Gson();
            results = g.fromJson(jsonObject.get("results"), SunriseSunsetVO.class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	public SunriseSunsetVO getResults() {
        return results;
    }

}

/**
 *  Inner Class data structure
 */
class SunriseSunsetVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1711126471696728890L;
	
	private String sunrise;
    private String sunset;
    private String solar_noon;
    private String day_length;
    private String civil_twilight_begin;
    private String civil_twilight_end;
    private String nautical_twilight_begin;
    private String nautical_twilight_end;
    private String astronomical_twilight_begin;
    private String astronomical_twilight_end;
    public String getAstronomicalTwilightEnd() {
        return astronomical_twilight_end;
    }
    public void setAstronomicalTwilightEnd(String astronomicalTwilightEnd) {
        this.astronomical_twilight_end = astronomicalTwilightEnd;
    }
    public String getAstronomicalTwilightBegin() {
        return astronomical_twilight_begin;
    }
    public void setAstronomicalTwilightBegin(String astronomicalTwilightBegin) {
        this.astronomical_twilight_begin = astronomicalTwilightBegin;
    }
    public String getNauticalTwilightEnd() {
        return nautical_twilight_end;
    }
    public void setNauticalTwilightEnd(String nauticalTwilightEnd) {
        this.nautical_twilight_end = nauticalTwilightEnd;
    }
    public String getNauticalTwilightBegin() {
        return nautical_twilight_begin;
    }
    public void setNauticalTwilightBegin(String nauticalTwilightBegin) {
        this.nautical_twilight_begin = nauticalTwilightBegin;
    }
    public String getCivilTwilightBegin() {
        return civil_twilight_begin;
    }
    public void setCivilTwilightBegin(String civilTwilightBegin) {
        this.civil_twilight_begin = civilTwilightBegin;
    }
    public String getDayLength() {
        return day_length;
    }
    public void setDayLength(String dayLength) {
        this.day_length = dayLength;
    }
    public String getSolarNoon() {
        return solar_noon;
    }
    public void setSolarNoon(String solarNoon) {
        this.solar_noon = solarNoon;
    }
    public String getSunset() {
        return sunset;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getSunrise() {
        return sunrise;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getCivilTwilightEnd() {
        return civil_twilight_end;
    }
    public void setCivilTwilightEnd(String civilTwilightEnd) {
        this.civil_twilight_end = civilTwilightEnd;
    }

}
