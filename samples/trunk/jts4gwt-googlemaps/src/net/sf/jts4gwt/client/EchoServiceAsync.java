package net.sf.jts4gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

/**
 * The async counterpart of <code>EchoService</code>. 
 */
public interface EchoServiceAsync {
  void echo(Geometry input, AsyncCallback<Geometry> callback);
  
//  void echo(Coordinate c, AsyncCallback<Coordinate> callback);
}
