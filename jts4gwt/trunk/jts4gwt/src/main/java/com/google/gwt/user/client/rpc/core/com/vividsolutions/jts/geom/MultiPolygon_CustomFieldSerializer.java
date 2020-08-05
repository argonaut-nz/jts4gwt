package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class MultiPolygon_CustomFieldSerializer extends CustomFieldSerializer<MultiPolygon> {
    
    public static void serialize(SerializationStreamWriter streamWriter, MultiPolygon instance) throws SerializationException {
        streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for (int i = 0; i < instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            Polygon_CustomFieldSerializer.serialize(streamWriter, (Polygon) geo);
        }
    }

    public static void deserialize(SerializationStreamReader reader, MultiPolygon instance) {
        /* All handled by instantiate() */
    }

    public static MultiPolygon instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        Polygon[] polygonArr = new Polygon[nGeometries];
        for (int i = 0; i < nGeometries; i++) {
            polygonArr[i] = Polygon_CustomFieldSerializer.instantiate(streamReader);
        }
        return geomFtry.createMultiPolygon(polygonArr);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public MultiPolygon instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, MultiPolygon instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, MultiPolygon instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
