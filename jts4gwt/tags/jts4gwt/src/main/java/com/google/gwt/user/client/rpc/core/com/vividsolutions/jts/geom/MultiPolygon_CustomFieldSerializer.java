package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.*;

public final class MultiPolygon_CustomFieldSerializer 
{
	public static void deserialize(SerializationStreamReader streamReader,
			MultiPolygon instance) throws SerializationException
	{
		// no fields
	}

	public static MultiPolygon instantiate(SerializationStreamReader streamReader)
										throws SerializationException {
		final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        Polygon[] polygonArr = new Polygon[nGeometries];
        for(int i=0; i<nGeometries; i++) {
            polygonArr[i] = Polygon_CustomFieldSerializer.instantiate(streamReader);
        }
		return geomFtry.createMultiPolygon(polygonArr);
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			MultiLineString instance) throws SerializationException
    {
		streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for( int i=0; i< instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            Polygon_CustomFieldSerializer.serialize(streamWriter,(Polygon)geo);
        }
    }

}
