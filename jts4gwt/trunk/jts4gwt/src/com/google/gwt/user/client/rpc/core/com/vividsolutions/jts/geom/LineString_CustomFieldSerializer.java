package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class LineString_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			LineString instance) throws SerializationException
	{
		// no fields
	}

	public static LineString instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
//		Coordinate instance =  new Coordinate(streamReader.readDouble(), streamReader.readDouble(), streamReader.readDouble());
		final int SRID = streamReader.readInt();
//		final int SRID = 4326;
		final int coordArrSize = streamReader.readInt();
		final Coordinate coordArr[] = new Coordinate[coordArrSize];
		
		for (int i = 0; i < coordArrSize; i++)
		{
			coordArr[i] = (Coordinate) streamReader.readObject();
		}
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(), SRID);
		return gf.createLineString(coordArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			LineString instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
		final int coordArrSize = instance.getCoordinates().length;
		streamWriter.writeInt(coordArrSize);
		final Coordinate coordArr[] = instance.getCoordinates();
		for (int i = 0; i < coordArrSize; i++)
		{
			streamWriter.writeObject(coordArr[i]);
		}
	}

}
