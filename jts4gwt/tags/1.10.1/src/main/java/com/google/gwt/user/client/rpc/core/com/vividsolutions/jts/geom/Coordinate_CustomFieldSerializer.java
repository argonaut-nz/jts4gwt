package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;

public final class Coordinate_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			Coordinate instance) throws SerializationException
	{
		// no fields
	}

	public static Coordinate instantiate(SerializationStreamReader streamReader)
										throws SerializationException {

		final double x = streamReader.readDouble();
		final double y = streamReader.readDouble();
		final double z = streamReader.readDouble();
		return new Coordinate(x, y, z);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			Coordinate instance) throws SerializationException
    {
		streamWriter.writeDouble(instance.x);
		streamWriter.writeDouble(instance.y);
		streamWriter.writeDouble(instance.z);
	}

}
