package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class MultiPoint_CustomFieldSerializer extends CustomFieldSerializer<MultiPoint> {

    public static void serialize(SerializationStreamWriter streamWriter, MultiPoint instance) throws SerializationException {
        streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for (int i = 0; i < instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            Point_CustomFieldSerializer.serialize(streamWriter, (Point) geo);
        }
    }
    
    public static void deserialize(SerializationStreamReader reader, MultiPoint instance) {
        /* All handled by instantiate() */
    }
    
    public static MultiPoint instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        Point[] pointArr = new Point[nGeometries];
        for (int i = 0; i < nGeometries; i++) {
            pointArr[i] = Point_CustomFieldSerializer.instantiate(streamReader);
        }
        return geomFtry.createMultiPoint(pointArr);
    }
    
    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public MultiPoint instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, MultiPoint instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, MultiPoint instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
