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
		final Coordinate [] coordArr = (Coordinate []) streamReader.readObject();
		return new CoordinateArraySequence(coordArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			CoordinateArraySequence instance) throws SerializationException
    {
		streamWriter.writeObject(instance.toCoordinateArray());
	}

}
