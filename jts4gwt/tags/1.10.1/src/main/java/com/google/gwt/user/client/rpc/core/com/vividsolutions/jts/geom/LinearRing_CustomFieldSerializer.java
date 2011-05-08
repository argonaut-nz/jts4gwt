package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.CoordinateSequence;
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
		CoordinateSequence coordSeq = (CoordinateSequence) streamReader.readObject();
		GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
		return geomFtry.createLinearRing(coordSeq);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			LinearRing instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
		streamWriter.writeObject(instance.getCoordinateSequence());
	}

}
