package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class Point_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			Point instance) throws SerializationException
	{
		// no fields
	}

	public static Point instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
		final Coordinate coord = (Coordinate) streamReader.readObject();
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(), SRID);
		return gf.createPoint(coord);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			Point instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
		streamWriter.writeObject(instance.getCoordinate());
	}

}
