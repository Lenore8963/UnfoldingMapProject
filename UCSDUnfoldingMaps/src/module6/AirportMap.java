package module6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.data.ShapeFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.geo.Location;
import parsing.ParseFeed;
import processing.core.PApplet;

public class AirportMap extends PApplet {
	
	private static final long serialVersionUID = 1L;

    UnfoldingMap map;
    private List<Marker> airportList;
    List<Marker> routeList;

    private CommonMarker lastSelected;

    public void setup() {
        size(800,600, OPENGL);
        map = new UnfoldingMap(this, 50, 50, 750, 550);
        MapUtils.createDefaultEventDispatcher(this, map);

        List<PointFeature> features = ParseFeed.parseAirports(this, "airports.dat");
        airportList = new ArrayList<>();
        HashMap<Integer, Location> airports = new HashMap<>();
        HashMap<Integer, AirportMarker> airportMarkersMap = new HashMap<>();

        for(PointFeature feature : features) {
            AirportMarker m = new AirportMarker(feature);
            m.setRadius(5);
            m.setProperty("isConnectedWithCanada", false); // Initialize this property for all airports
            airportList.add(m);

            airports.put(Integer.parseInt(feature.getId()), feature.getLocation());
            airportMarkersMap.put(Integer.parseInt(feature.getId()), m);
        }

        List<ShapeFeature> routes = ParseFeed.parseRoutes(this, "routes.dat");
        routeList = new ArrayList<>();
        for(ShapeFeature route : routes) {
            int source = Integer.parseInt((String)route.getProperty("source"));
            int dest = Integer.parseInt((String)route.getProperty("destination"));

            if(airports.containsKey(source) && airports.containsKey(dest)) {
                route.addLocation(airports.get(source));
                route.addLocation(airports.get(dest));
            }

            SimpleLinesMarker sl = new SimpleLinesMarker(route.getLocations(), route.getProperties());
            routeList.add(sl);
        }

        map.addMarkers(airportList);
        map.addMarkers(routeList);

        for (Marker m : routeList) {
            m.setHidden(true);
        }

        // Iterate over each route marker
        for(Marker routeMarker : routeList) {
            SimpleLinesMarker slMarker = (SimpleLinesMarker) routeMarker;
            // Get source and destination airport ids
            int sourceAirportId = Integer.parseInt((String) slMarker.getProperty("source"));
            int destinationAirportId = Integer.parseInt((String) slMarker.getProperty("destination"));

            // Retrieve the corresponding AirportMarker objects
            AirportMarker sourceAirportMarker = airportMarkersMap.get(sourceAirportId);
            AirportMarker destinationAirportMarker = airportMarkersMap.get(destinationAirportId);

            // Check if either airport is on the route related with Canada
            if(sourceAirportMarker != null && destinationAirportMarker != null) {
                if(sourceAirportMarker.getCountry().equals("\"Canada\"") || destinationAirportMarker.getCountry().equals("\"Canada\"")) {
                    // If so, change color to blue
                    sourceAirportMarker.setProperty("isConnectedWithCanada", true);
                    destinationAirportMarker.setProperty("isConnectedWithCanada", true);
                }
            }
        }
    }


    public void draw() {
        background(0);
        map.draw();
    }

    @Override
    public void mouseMoved() {
        if (lastSelected != null) {
            lastSelected.setSelected(false);
            lastSelected = null;
        }
        selectMarkerIfHover(airportList);
    }

    private void selectMarkerIfHover(List<Marker> markers) {
        if (lastSelected != null) {
            return;
        }
        for (Marker m : markers) {
            CommonMarker marker = (CommonMarker)m;
            if (marker.isInside(map,  mouseX, mouseY)) {
                lastSelected = marker;
                marker.setSelected(true);
                return;
            }
        }
    }

    @Override
    public void mouseClicked() {
        // Deselect all routes initially
        for (Marker route : routeList) {
            route.setHidden(true);
        }

        // If an airport is selected, make only its routes visible
        if (lastSelected != null && lastSelected instanceof AirportMarker) {
            for (Marker route : routeList) {
                SimpleLinesMarker sl = (SimpleLinesMarker) route;
                if (sl.getLocations().get(0).equals(lastSelected.getLocation())) {
                    sl.setHidden(false);
                }
            }
        }
    }

}
