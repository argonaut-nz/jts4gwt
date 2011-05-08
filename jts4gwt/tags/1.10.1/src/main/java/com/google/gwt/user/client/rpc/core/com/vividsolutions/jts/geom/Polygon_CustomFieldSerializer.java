package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class Polygon_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			Polygon instance) throws SerializationException
	{
		// no fields
	}

	public static Polygon instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(), SRID);
		final LinearRing shell = gf.createLinearRing(((LineString) streamReader.readObject()).getCoordinateSequence());
		final int numInteriorRing = streamReader.readInt();
		LinearRing linearRingArr[] = new LinearRing[numInteriorRing]; 
		for (int i = 0; i < numInteriorRing; i++)
		{
			linearRingArr[i] = gf.createLinearRing(((LineString) streamReader.readObject()).getCoordinateSequence());
		}
		return gf.createPolygon(shell, linearRingArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			Polygon instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
		streamWriter.writeObject(instance.getExteriorRing());
		final int numInteriorRing = instance.getNumInteriorRing();
		streamWriter.writeInt(numInteriorRing);
		for (int i = 0; i < numInteriorRing; i++)
		{
			streamWriter.writeObject(instance.getInteriorRingN(i));
		}
	}

}
