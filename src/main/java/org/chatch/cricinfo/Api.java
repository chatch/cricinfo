package org.chatch.cricinfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Api {

	private JsonObject scores;
	
	public Api(String matchUrlStr) throws MalformedURLException {
		URL url = new URL(matchUrlStr);
		try (InputStream is = url.openStream(); JsonReader rdr = Json.createReader(is)) {
			this.scores = rdr.readObject();
		} catch (IOException e) {
			System.err.println("failed to get stream ... ");
			return;
		}
	}
	
	public String getSummary() {
		return scores.getJsonObject("match").getString("current_summary");
	}

	public String getCurrentWickets() {
		return getCurrentInnings().getString("wickets");
	}
	
	public String getCurrentRuns() {
		return getCurrentInnings().getString("runs");
	}

	public JsonObject getCurrentInnings() {
		return scores.getJsonObject("live").getJsonObject("innings");
	}

}
