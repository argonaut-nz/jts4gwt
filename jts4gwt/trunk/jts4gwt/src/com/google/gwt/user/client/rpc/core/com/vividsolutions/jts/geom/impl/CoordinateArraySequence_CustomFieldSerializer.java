package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

public final class CoordinateArraySequence_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			CoordinateArraySequence instance) throws SerializationException
	{
		// no fields
	}

	public static CoordinateArraySequence instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int coordArrSize = streamReader.readInt();
		final Coordinate coordArr[] = new Coordinate[coordArrSize];
		for (int i = 0; i < coordArrSize; i++)
		{
			coordArr[i] = (Coordinate) streamReader.readObject();
		}
		return new CoordinateArraySequence(coordArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			CoordinateArraySequence instance) throws SerializationException
    {
		final Coordinate coordArr[] = instance.toCoordinateArray();
		final int coordArrLength = coordArr.length;
		streamWriter.writeInt(coordArrLength);
		for (int i = 0; i < coordArrLength; i++)
		{
			streamWriter.writeObject(coordArr[i]);
		}
	}

}
