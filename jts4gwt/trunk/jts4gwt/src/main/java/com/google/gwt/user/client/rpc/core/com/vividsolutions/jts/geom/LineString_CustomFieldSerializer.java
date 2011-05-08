package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.CoordinateSequence;
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
		final int SRID = streamReader.readInt();
		CoordinateSequence coordSeq = (CoordinateSequence) streamReader.readObject();
		GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
		return geomFtry.createLineString(coordSeq);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			LineString instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
		streamWriter.writeObject(instance.getCoordinateSequence());
    }

}
