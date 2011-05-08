package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.*;

public final class MultiPoint_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			MultiPoint instance) throws SerializationException
	{
		// no fields
	}

	public static MultiPoint instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        Point[] pointArr = new Point[nGeometries];
        for (int i=0; i<nGeometries; i++) {
            pointArr[i] = Point_CustomFieldSerializer.instantiate(streamReader);
        }
		return geomFtry.createMultiPoint(pointArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			MultiPoint instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for (int i=0; i< instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            Point_CustomFieldSerializer.serialize(streamWriter,(Point)geo);
        }
    }

}
