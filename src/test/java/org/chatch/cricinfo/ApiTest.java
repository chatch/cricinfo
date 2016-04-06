package org.chatch.cricinfo;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;

import org.junit.Test;

public class ApiTest {
	@Test
	public void testSummary() throws MalformedURLException {
		Api api = new Api("http://www.espncricinfo.com/ci/engine/match/946787.json");
		assertNotNull(api.getSummary());
		assertNotNull(api.getCurrentWickets());
		assertNotNull(api.getCurrentRuns());
		System.out.println("runs: " + api.getCurrentRuns());
		System.out.println("wickets: " + api.getCurrentWickets());
		System.out.println("summary: "+ api.getSummary());
	}
}
