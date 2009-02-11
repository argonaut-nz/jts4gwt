package net.sf.jts4gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

/**
 * The client side stub for the Rpc service.
 */
@RemoteServiceRelativePath("echo")
public interface EchoService extends RemoteService {
  Geometry echo(Geometry geo);
  
//  Coordinate echo(Coordinate c);
}
