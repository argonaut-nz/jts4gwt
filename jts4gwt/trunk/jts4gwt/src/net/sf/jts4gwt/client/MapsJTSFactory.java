package net.sf.jts4gwt.client;

import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.Overlay;
import com.google.gwt.maps.client.overlay.Polyline;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

public class MapsJTSFactory {
	public static Overlay overlayFromGeometry(Geometry geom)
	{
		if (geom instanceof Point) {
			Point point = (Point) geom;
			LatLng latLng = LatLng.newInstance(point.getCoordinate().y, point.getCoordinate().x);
			return new Marker(latLng);
			
		} else if (geom instanceof LineString) {
			LineString lineString = (LineString) geom;
			LatLng latLngArr[] = latLongArrFromGeometry(lineString);
			return new Polyline(latLngArr);
			
		} else if (geom instanceof com.vividsolutions.jts.geom.Polygon) {
			com.vividsolutions.jts.geom.Polygon polygon = (com.vividsolutions.jts.geom.Polygon) geom;
			LatLng [] latLngArr = latLongArrFromGeometry(polygon);
			return new com.google.gwt.maps.client.overlay.Polygon(latLngArr, "#000000", 2, 1.0, "#FFFFFF", 0.2); // polygon with black outline and white filling
		}
		throw new RuntimeException("Geometry conversion of " + geom + " not yet implemented");
	}
	
	static private LatLng [] latLongArrFromGeometry(Geometry geom)
	{
		final Coordinate[] coordinates = geom.getCoordinates();
		LatLng latLngArr[] = new LatLng[coordinates.length];
		for (int i = 0; i < coordinates.length; i++)
		{
			final Coordinate coord = coordinates[i];
			latLngArr[i] = LatLng.newInstance(coord.y, coord.x);
		}
		return latLngArr;
	}

}
