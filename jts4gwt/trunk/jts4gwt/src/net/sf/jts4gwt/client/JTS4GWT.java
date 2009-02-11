package net.sf.jts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JTS4GWT implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Echo service.
   */
  private final EchoServiceAsync echoService = GWT.create(EchoService.class);
  private MapWidget map;
  private LineString lineString;
  private Point p;
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
		VerticalPanel vPanel = new VerticalPanel();
		map = new MapWidget();
		final int mapWidth = Window.getClientWidth();
		final int mapHeight = Window.getClientHeight()- 100;
		map.setSize(mapWidth + "px", mapHeight + "px");
		map.panTo(LatLng.newInstance(-23.0001157200236, -43.3657836914063));
		map.setZoomLevel(12);
		vPanel.add(map);
		RootPanel.get().add(vPanel);
		
		Coordinate coord1 = new Coordinate(-43.4358215332031, -23.0102283008291, 0);
		Coordinate coord2 = new Coordinate(-43.3657836914063, -23.0001157200236, 0);
		
		Coordinate [] coordArr = new Coordinate[2];
		coordArr[0] = coord1;
		coordArr[1] = coord2;
		
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(), 4326);
		lineString = gf.createLineString(new CoordinateArraySequence(coordArr));
		Coordinate c = new Coordinate(5.6,7.8, -3.2);
		
		p = gf.createPoint(c);
		
		map.addOverlay(MapsJTSFactory.overlayFromGeometry(lineString));
		map.addOverlay(MapsJTSFactory.overlayFromGeometry(p));
		
		Button b = new Button("Buffer", new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				final Geometry buffer = lineString.buffer(0.02);
//				map.addOverlay(MapsJTSFactory.overlayFromGeometry(buffer));
				
				echoService.echo(buffer, new AsyncCallback<Geometry>(){

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());
						
					}

					@Override
					public void onSuccess(Geometry result) {
						map.addOverlay(MapsJTSFactory.overlayFromGeometry(result));
						
					}});
			}});
		vPanel.add(b);
		
		LatLng ll1 = LatLng.newInstance(-23.0102283008291, -43.4358215332031);
		LatLng ll2 = LatLng.newInstance(-23.0001157200236, -43.3657836914063);
		LatLng ll3 = LatLng.newInstance(-24.0001157200236, -44.3657836914063);
		
		LatLng latLng[] = new LatLng[3];
		latLng[0] = ll1;
		latLng[1] = ll2;
		latLng[2] = ll3;
		
//		map.addOverlay(new Polygon(latLng, "#000000", 2, 1.0, "#FFFFFF", 1.0));
		
  }
}
