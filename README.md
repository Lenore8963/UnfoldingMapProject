# UnfoldingMapProject

## The EarthquakeCityMap

The EarthquakeCityMap project is an interactive application that visualizes earthquake data on a map. It is developed using the Processing library in Java and the UnfoldingMaps library, which provides interactive maps and geo-spatial data handling.

### Here are the key components and functionalities of this application:

1, Map and Data Source: The application uses a map provided either by the Google Maps service or an offline map tile service. It fetches real-time earthquake data from the USGS website, specifically earthquakes of magnitude 2.5 and above that occurred in the last week. If the application is set to work offline, it uses locally stored earthquake data.

![1](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/e4aab225-4cde-425d-aada-6729baa54cf9)

2, Markers: The application uses different markers to represent cities, countries, and earthquakes. Each earthquake is classified as either a LandQuake (occurred on land) or an OceanQuake (occurred in the ocean). The classification process involves checking if the earthquake's location falls within any country's boundaries. City markers are triangle-shaped, whereas LandQuakes and OceanQuakes are represented by circles and squares, respectively.

![2](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/c758b783-f8a6-48d9-85cc-58f663cc89b4)

3, Interactive Features: The application provides interactive features such as highlighting markers when the mouse hovers over them. When an earthquake marker is clicked, it displays a threat circle representing the area potentially affected by the earthquake, and hides all the other earthquakes and cities that fall outside the threat circle. When a city marker is clicked, it hides all the other cities and earthquakes whose threat circles do not cover the city.

![3](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/18e4a947-1b8c-4a56-9db5-69d1fe3e2fa9)
![4](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/64359701-47b4-48b6-9607-ce7415415427)

4, Data Analysis and Display: The application performs an analysis of the earthquakes data, counting the number of earthquakes per country, and the number of earthquakes that occurred in the ocean. These statistics are printed out on the console. It also sorts the earthquakes based on some criteria and prints out a specified number of earthquakes.

5, Key for Understanding Markers: A key is provided in the GUI to help users understand what each marker represents. The size of the earthquake markers corresponds to the magnitude of the earthquakes, and their color represents the depth (Shallow, Intermediate, Deep). Earthquakes that have occurred in the past hour are represented by a marker with crossed lines.

This project is a great tool for visualizing, analyzing and understanding earthquake data. It allows users to interactively explore the spatial distribution of earthquakes and their potential impact on cities and countries.

## The AirportMap 

This airport project is a Java-based application that visualizes global airport and flight route data using an interactive map. It is implemented using Processing, a software sketchbook and language for learning how to code within the context of the visual arts, and the Unfolding Maps library, a library for creating interactive maps and geovisualizations.

### Here's a detailed explanation:

1, UnfoldingMap and Markers: The AirportMap class extends PApplet, which is the basic application type for Processing programs. It contains an instance of UnfoldingMap, which is used to display the map, and two Lists to store Marker objects representing airports and routes.

2, Setup Method: In the setup() method, the map is initialized with a size of 800x600 pixels, and default map interactions (such as panning and zooming) are enabled. It then parses data from "airports.dat" and "routes.dat" files, creating AirportMarker objects for each airport and SimpleLinesMarker objects for each route.

3, Airport and Route Parsing: For each airport, a PointFeature object is created. This object represents a geographical point and its associated properties, such as the airport's ID and location. The PointFeature is then used to create an AirportMarker, which is stored in airportList and added to the map. A similar process is followed for routes, creating ShapeFeature objects and then SimpleLinesMarker objects, which are stored in routeList and added to the map. Each route marker is initially hidden.

4, Canadian Routes Highlighting: The setup method then iterates over each route marker, checking if the source or destination airport is located in Canada. If so, it sets a property on the corresponding airport marker to indicate that the airport is connected with Canada.

5, Map Drawing: The draw() method, which is called continuously by Processing, clears the screen and redraws the map.

6, Mouse Interactions: Mouse interactions are also handled in this class. The mouseMoved() method checks if the mouse is hovering over any airport marker, and if so, it sets that marker as selected. The mouseClicked() method handles mouse clicks. If an airport marker is selected when the mouse is clicked, it displays all route markers originating from that airport.

In summary, this is an interactive map application that visualizes global airports and their connections. It provides a special highlight for airports that have connections with Canada and allows users to inspect individual airport connections through mouse interactions.
