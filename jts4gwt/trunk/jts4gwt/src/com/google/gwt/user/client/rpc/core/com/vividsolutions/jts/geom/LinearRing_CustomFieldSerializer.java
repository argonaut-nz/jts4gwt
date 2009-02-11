package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class LinearRing_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			LinearRing instance) throws SerializationException
	{
		// no fields
	}

	public static LinearRing instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
		final int coordArrSize = streamReader.readInt();
		final Coordinate coordArr[] = new Coordinate[coordArrSize];
		for (int i = 0; i < coordArrSize; i++)
		{
			coordArr[i] = (Coordinate) streamReader.readObject();
		}
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(), SRID);
		return gf.createLinearRing(coordArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			LinearRing instance) throws SerializationException
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
