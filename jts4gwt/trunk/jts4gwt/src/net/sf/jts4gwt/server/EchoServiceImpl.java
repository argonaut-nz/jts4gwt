package net.sf.jts4gwt.server;

import net.sf.jts4gwt.client.EchoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

/**
 * The server side implementation of the Rpc service.
 */
public class EchoServiceImpl extends RemoteServiceServlet implements
    EchoService {

  public String echo(String input) {
    return "Server says: " + input;
  }


  public Geometry echo(Geometry geo) {
	Geometry geo2 = (Geometry) geo.clone();
	return geo2;
}


//public Coordinate echo(Coordinate c) {
//	return c;
//}

}
