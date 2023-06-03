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

This project, in the Java programming language, utilizes the Unfolding Maps library for interactive maps and geovisualizations. Its primary purpose is to visualize and interact with global airport data, focusing specifically on airports that are connected with a selected country through airline routes. In the current implementation, the country of focus is Canada, which is set as a constant in the code.

![5](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/ae55bbab-0a67-4fc7-9d4f-442a9e2c370c)

The program reads from data files containing details about airports and their respective flight routes. This information is then used to create markers on a world map representing airports and the flight routes associated with them.

![8](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/4c45c7fd-e331-4f48-aaef-b5884c012143)

The AirportMap class is the primary class of this project. Its setup method reads in the airport and route data, creates markers for each airport, and determines whether each airport has a route to or from the target country, Canada, in this case. If an airport is connected to Canada, its marker is added to the map and the country of the airport is added to a list of countries connected with Canada. Only the airports connected with Canada are displayed on the map, highlighted with a distinct color.

![6](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/eaf7b098-826e-4dd2-a375-7535ea61a03b)

An interesting feature of this project is its interactivity. When the mouse hovers over an airport marker, it gets highlighted and displays the name and country of the airport. When a marker is clicked, it shows all flight routes originating from that airport. Furthermore, all countries connected with Canada by airport routes are printed out in the console.

![7](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/07758020-0773-49fd-b80a-5a222bd71c1a)

In summary, this project is a highly interactive data visualization tool that allows users to explore global airport connections with a focus on a specified country. It provides insights into global air traffic patterns and connectivity. It's designed with the flexibility that the target country can be easily changed for exploring connections with different countries.

### Apart from Canada, here is another example: Taiwan.

![tw1](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/f6fc3b56-8b34-44c9-abd1-1d59d04166ec)
![tw2](https://github.com/Lenore8963/UnfoldingMapProject/assets/118407314/00021e87-05f2-496c-acea-9eb58d5b1ae8)
