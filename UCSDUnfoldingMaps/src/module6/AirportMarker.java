package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;


/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
    // Color properties
    private int red = 255;
    private int green = 0;
    private int blue = 0;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
	    Boolean isConnectedWithCanada = Boolean.parseBoolean(String.valueOf(getProperty("isConnectedWithCanada")));

	    if (isConnectedWithCanada != null && isConnectedWithCanada) {
	        pg.fill(0, 0, 255); // Blue color
	    } else {
	        pg.fill(255, 0, 0); // Red color
	    }
	    pg.ellipse(x, y, 10, 10);
	}


		

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		// show rectangle with title
	    String title = getStringProperty("name") + ", " + getStringProperty("country");
	    
	    // You might want to make the font size and rectangle size dependent on the title's length
	    pg.pushStyle();
	    
	    pg.fill(255);
	    pg.textSize(12);
	    pg.rectMode(PConstants.CORNER);
	    pg.rect(x, y-14*3, Math.max(14*5, title.length()*6), 14*3);
	    pg.fill(0);
	    pg.textAlign(PConstants.LEFT, PConstants.TOP);
	    pg.text(title, x+3, y-14*3);
	    
	    pg.popStyle();
	}
    // Method to get the country of the airport
    public String getCountry() {
        return getStringProperty("country");
    }


}
