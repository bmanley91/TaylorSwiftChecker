package main.groovy.TaylorChecker

import groovy.json.JsonSlurper

import java.util.regex.Pattern

/**
 * Created by BrianManley on 3/16/15.
 */
class SwiftyChecker {

    public static boolean checkForTaylor() {

        String baseUrl = 'https://api.spotify.com/v1/tracks/'
        String blankSpaceId = '1fscxlCZZpjzDnS8CSJmuL'
        String marketCode = 'US'

        // Form Spotify API url
        URL taylorUrl = new URL(baseUrl + blankSpaceId)

        try{
            // Get json from Spotify API
            InputStream urlStream = taylorUrl.openStream()
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream))
            JsonSlurper slurper = new JsonSlurper()
            def result = slurper.parse(reader)

            // Put results into map
            Map jsonResult = (Map) result

            // Get list of markets for track
            String marketList = jsonResult.album.available_markets

            // Check if track is available in market
            return checkTrackInMarket(marketList, marketCode)
        }
        catch(MalformedURLException exception) {
            exception.printStackTrace()

            // If we got an exception trying to connect to Spotify return null
            return false
        }

    }

    // Method to check if market code is in list of markets
    private static boolean checkTrackInMarket(String marketList, String marketCode) {
        Pattern match = ~/.*$marketCode.*/

        return marketList ==~ match
    }

}
