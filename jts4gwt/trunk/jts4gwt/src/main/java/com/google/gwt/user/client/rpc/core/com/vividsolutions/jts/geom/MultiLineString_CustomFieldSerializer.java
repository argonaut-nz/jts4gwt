package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.*;

public final class MultiLineString_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			MultiLineString instance) throws SerializationException
	{
		// no fields
	}

	public static MultiLineString instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        LineString[] lineStringArr = new LineString[nGeometries];
        for(int i=0; i<nGeometries; i++) {
            lineStringArr[i] = LineString_CustomFieldSerializer.instantiate(streamReader);
        }
		return geomFtry.createMultiLineString(lineStringArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			MultiLineString instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for( int i=0; i< instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            LineString_CustomFieldSerializer.serialize(streamWriter,(LineString)geo);
        }
    }

}
